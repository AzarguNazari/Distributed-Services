package de.uniba.rz.app;

import java.util.*;
import java.util.concurrent.TimeUnit;

import de.uniba.rz.entities.*;
import de.uniba.rz.io.rpc.*;
import de.uniba.rz.io.rpc.TicketRPCGrpc.TicketRPCBlockingStub;
import de.uniba.rz.io.rpc.TicketRPCGrpc.TicketRPCStub;
import de.uniba.rz.ui.swing.MainFrame;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

/*
	
	
          $$$$$$$\  $$$$$$$\   $$$$$$\         $$$$$$\  $$\ $$\                      $$\     
          $$  __$$\ $$  __$$\ $$  __$$\       $$  __$$\ $$ |\__|                     $$ |    
 $$$$$$\  $$ |  $$ |$$ |  $$ |$$ /  \__|      $$ /  \__|$$ |$$\  $$$$$$\  $$$$$$$\ $$$$$$\   
$$  __$$\ $$$$$$$  |$$$$$$$  |$$ |            $$ |      $$ |$$ |$$  __$$\ $$  __$$\\_$$  _|  
$$ /  $$ |$$  __$$< $$  ____/ $$ |            $$ |      $$ |$$ |$$$$$$$$ |$$ |  $$ | $$ |    
$$ |  $$ |$$ |  $$ |$$ |      $$ |  $$\       $$ |  $$\ $$ |$$ |$$   ____|$$ |  $$ | $$ |$$\ 
\$$$$$$$ |$$ |  $$ |$$ |      \$$$$$$  |      \$$$$$$  |$$ |$$ |\$$$$$$$\ $$ |  $$ | \$$$$  |
 \____$$ |\__|  \__|\__|       \______/        \______/ \__|\__| \_______|\__|  \__|  \____/ 
$$\   $$ |                                                                                   
\$$$$$$  |                                                                                   
 \______/                                                                                    


						Developed by Team Members #14


*/

public class GRPCTicketMangementBackend extends TicketRPCGrpc.TicketRPCImplBase implements TicketManagementBackend {

	// ---------------- Properties --------------

	private TicketRPCBlockingStub syncStub;
	private TicketRPCStub asyncStub;
	private ManagedChannel channel;



	
	// Constructors
	public GRPCTicketMangementBackend(String host, int port) {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
	}

	public GRPCTicketMangementBackend(ManagedChannelBuilder<?> channelBuilder) {
		this.channel = channelBuilder.build();
		this.syncStub = TicketRPCGrpc.newBlockingStub(this.channel);
		this.asyncStub = TicketRPCGrpc.newStub(this.channel);
	}


	
	
	@Override
	public void triggerShutdown() {
		// local implementation is in memory only - no need to close connections
		// and free resources

		if (!this.channel.isShutdown()) {

			try {
				this.channel.shutdown().awaitTermination(500, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				System.err.println("Cant shutdown client. Check log");
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
	}

	
	
	@Override
	public Ticket createNewTicket(String reporter, String topic, String description, Type type, Priority priority) {

		TicketRequest ticketRequest = TicketRequest.newBuilder().setDesciption(description)
				.setPriority(priority.toString()).setType(type.toString()).setReporter(reporter).setTopic(topic)
				.build();

		TicketResponse ticketResponse = this.syncStub.createTicket(ticketRequest);

		Ticket createdTicket = storeBackTicket(ticketResponse);

		broadcastReceiver();

		return createdTicket;

	}

	
	
	@Override
	public List<Ticket> getAllTickets() throws TicketException {

		// Creating an empty request
		Empty emptyRequest = Empty.newBuilder().build();

		// Receiving all the tickets from server
		TicketList ticketResponse = this.syncStub.getAllTickets(emptyRequest);

		return (List<Ticket>) Util.byteStreamToObject(ticketResponse.getAllTickets().toByteArray());
	}

	@Override
	public Ticket getTicketById(int id) throws TicketException {

		TicketId ticketIdRequest = TicketId.newBuilder().setTicketId(id).build();

		TicketResponse response = this.syncStub.getTicketById(ticketIdRequest);

		Ticket createdTicket = storeBackTicket(response);

		return createdTicket;

	}
	
	private Ticket storeBackTicket(TicketResponse response) {
		Ticket tempTicket = new Ticket();
		tempTicket.setId(response.getTicketid());
		tempTicket.setReporter(response.getReporter());
		tempTicket.setType(Type.valueOf(response.getType()));
		tempTicket.setPriority(Priority.valueOf(response.getPriority()));
		tempTicket.setStatus(Status.valueOf(response.getStatus()));
		tempTicket.setTopic(response.getTopic());
		tempTicket.setDescription(response.getDesciption());
		return tempTicket;
	}

	@Override
	public Ticket acceptTicket(int id) throws TicketException {

		TicketId ticketIdRequest = TicketId.newBuilder().setTicketId(id).build();

		TicketResponse response = this.syncStub.acceptTicket(ticketIdRequest);

		Ticket acceptTicket = storeBackTicket(response);

		broadcastReceiver();

		return acceptTicket;
	}

	@Override
	public Ticket rejectTicket(int id) throws TicketException {

		TicketId ticketIdRequest = TicketId.newBuilder().setTicketId(id).build();

		TicketResponse response = this.syncStub.rejectTicket(ticketIdRequest);

		Ticket rejectTicket = storeBackTicket(response);

		broadcastReceiver();

		return rejectTicket;
	}

	@Override
	public Ticket closeTicket(int id) throws TicketException {

		TicketId ticketIdRequest = TicketId.newBuilder().setTicketId(id).build();

		TicketResponse response = this.syncStub.closeTicket(ticketIdRequest);

		Ticket closedTicket = storeBackTicket(response);

		broadcastReceiver();

		return closedTicket;
	}

	/*
	 * Block that will be responsible to run
	 */
	public void broadcastReceiver() {

		new AutoUpdateFields(this.asyncStub).start();

	}
}

class AutoUpdateFields extends Thread {

	private final TicketRPCStub asycStub;

	public AutoUpdateFields(TicketRPCStub asycStub) {
		this.asycStub = asycStub;
	}

	@Override
	public void run() {
		StreamObserver<AutoNewTicketRequest> observer = this.asycStub.streamNewTicket(new StreamObserver<TicketList>() {

			@Override
			public void onNext(TicketList response) {
				// TODO Auto-generated method stub

				System.out.println("Got Something");
				List<Ticket> ticketList = (List<Ticket>) Util
						.byteStreamToObject(response.getAllTickets().toByteArray());

				for (Ticket t : ticketList) {
					System.out.println("Ticket Creater: " + t.getReporter());
				}

				Main.mf.updateTable(ticketList);

			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("Error to retrive auto list from client end.");

			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("Got the ticket list Autoupdate");

			}
		});

		observer.onNext(AutoNewTicketRequest.newBuilder().setTicketid(1).build());

	}
	
	

}
