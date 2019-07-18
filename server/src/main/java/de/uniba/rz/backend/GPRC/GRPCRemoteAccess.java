//package GPRC;
//
//import java.io.IOException;
//import java.util.LinkedHashMap;
//import java.util.LinkedHashSet;
//
//import com.google.protobuf.ByteString;
//
//import de.uniba.rz.backend.RemoteAccess;
//import de.uniba.rz.backend.TicketStore;
//import de.uniba.rz.entities.Priority;
//import de.uniba.rz.entities.Status;
//import de.uniba.rz.entities.Ticket;
//import de.uniba.rz.entities.Type;
//import de.uniba.rz.entities.Util;
//import io.grpc.Server;
//import io.grpc.ServerBuilder;
//import io.grpc.stub.StreamObserver;
//
///*
//
//
//                  $$$$$$$\  $$$$$$$\   $$$$$$\         $$$$$$\                                                    
//                  $$  __$$\ $$  __$$\ $$  __$$\       $$  __$$\                                                   
//         $$$$$$\  $$ |  $$ |$$ |  $$ |$$ /  \__|      $$ /  \__| $$$$$$\   $$$$$$\ $$\    $$\  $$$$$$\   $$$$$$\  
//        $$  __$$\ $$$$$$$  |$$$$$$$  |$$ |            \$$$$$$\  $$  __$$\ $$  __$$\\$$\  $$  |$$  __$$\ $$  __$$\ 
//        $$ /  $$ |$$  __$$< $$  ____/ $$ |             \____$$\ $$$$$$$$ |$$ |  \__|\$$\$$  / $$$$$$$$ |$$ |  \__|
//        $$ |  $$ |$$ |  $$ |$$ |      $$ |  $$\       $$\   $$ |$$   ____|$$ |       \$$$  /  $$   ____|$$ |      
//        \$$$$$$$ |$$ |  $$ |$$ |      \$$$$$$  |      \$$$$$$  |\$$$$$$$\ $$ |        \$  /   \$$$$$$$\ $$ |      
//         \____$$ |\__|  \__|\__|       \______/        \______/  \_______|\__|         \_/     \_______|\__|      
//        $$\   $$ |                                                                                                
//        \$$$$$$  |                                                                                                
//         \______/                                                                                                        
//			
//			          Created by Group Members #14
//			 
//  
//  
//  
// */
//
//
//public class GRPCRemoteAccess implements RemoteAccess {
//
//	
//	//---------------------------- Properties -------------
//	private int port;
//	private Server server;
//	private static TicketStore allTickets;
//	
//	// Constructor
//	public GRPCRemoteAccess(int port) {
//		this.port = port;
//		this.server = ServerBuilder.forPort(port).addService(new TicketManagementImpl()).build();
//	}
//		
//	@Override
//	public void run() {
//		
//		// TODO Auto-generated method stub
//		
//		/*
//		 
//		 
//				 _____                _         
//				|  ___|              | |        
//				| |__ _ __ ___  _ __ | |_ _   _ 
//				|  __| '_ ` _ \| '_ \| __| | | |
//				| |__| | | | | | |_) | |_| |_| |
//				\____/_| |_| |_| .__/ \__|\__, |
//				               | |         __/ |
//				               |_|        |___/ 
//	
//		 */
//	}
//	
//	
//
//	@Override
//	public void prepareStartup(TicketStore ticketStore) {
//		
//		allTickets = ticketStore;
//
//		// Starting Server
//		try {
//			this.server.start();
//			System.out.println("Server started and listened on port " + this.port);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Runtime.getRuntime().addShutdownHook(new Thread() {
//			@Override
//			public void run() {
//				// Use stderr here since the logger may have been reset by its JVM shutdown
//				// hook.
//				System.err.println("*** shutting down gRPC server since JVM is shutting down");
//			
//				try {
//					
//					GRPCRemoteAccess.this.server.shutdown().awaitTermination();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//	
//				System.err.println("*** server shut down");
//			}
//		});
//
//	}
//
//	@Override
//	public void shutdown() throws IOException, InterruptedException {
//		// TODO Auto-generated method stub
//
//		
//		if (this.server != null) {
//			this.server.shutdown();
//		}
//		
//	}
//
//	
//	private static class TicketManagementImpl extends TicketRPCImplBase {
//		
//		private static LinkedHashSet<StreamObserver<TicketList>> observers = new LinkedHashSet<>();
//		
//		@Override
//		public void closeTicket(TicketId request, StreamObserver<TicketResponse> responseObserver) {
//
//				
//			long ticketId = Long.valueOf(request.getTicketId());
//
//			allTickets.getAllTickets().forEach(ticket -> {
//				if (ticket.getId() == ticketId) {
//					ticket.setStatus(Status.CLOSED);
//
//					TicketResponse ticketResponse = TicketResponse.newBuilder()
//												.setDesciption(ticket.getDescription())
//												.setTicketid(ticket.getId())
//												.setPriority(ticket.getPriority().toString())
//												.setType(ticket.getType().toString())
//												.setReporter(ticket.getReporter())
//												.setTopic(ticket.getTopic())
//												.setStatus(ticket.getStatus().toString())
//												.build();
//					
//					responseObserver.onNext(ticketResponse);
//					responseObserver.onCompleted();
//
//					return;
//				}
//			});
//				
//
//		}
//
//		@Override
//		public void createTicket(TicketRequest request, StreamObserver<TicketResponse> responseObserver) {
//			
//			Ticket createdTicket = allTickets.storeNewTicket(request.getReporter(),
//															request.getTopic(),
//															request.getDesciption(), 
//															Type.valueOf(request.getType()),
//															Priority.valueOf(request.getPriority()));
//			
//			TicketResponse ticketResponse = TicketResponse.newBuilder()
//										  .setDesciption(createdTicket.getDescription())
//										  .setTicketid(createdTicket.getId())
//										  .setTopic(createdTicket.getTopic())
//										  .setType(createdTicket.getType().toString())
//										  .setPriority(createdTicket.getPriority().toString())
//										  .setReporter(createdTicket.getReporter())
//										  .setStatus(createdTicket.getStatus().toString())
//										  .build();
//			
//			responseObserver.onNext(ticketResponse);
//			responseObserver.onCompleted();
//
//		}
//
//		@Override
//		public void getTicketById(TicketId request, StreamObserver<TicketResponse> responseObserver) {
//			
//			long ticketId = Long.valueOf(request.getTicketId());
//
//			allTickets.getAllTickets().forEach(ticket -> {
//				if (ticket.getId() == ticketId) {
//
//					TicketResponse ticketResponse = TicketResponse.newBuilder()
//							  .setDesciption(ticket.getDescription())
//							  .setTicketid(ticket.getId())
//							  .setTopic(ticket.getTopic())
//							  .setType(ticket.getType().toString())
//							  .setPriority(ticket.getPriority().toString())
//							  .setReporter(ticket.getReporter())
//							  .setStatus(ticket.getStatus().toString())
//							  .build();
//
//					responseObserver.onNext(ticketResponse);
//					responseObserver.onCompleted();
//
//					return;
//				}
//			});
//		}
//
//		@Override
//		public void getAllTickets(Empty request, StreamObserver<TicketList> responseObserver) {
//			
//			TicketList allTicketResponse = TicketList
//													.newBuilder()
//													.setAllTickets(ByteString.copyFrom(Util.objectToStream(allTickets.getAllTickets())))
//													.build();
//			
//			responseObserver.onNext(allTicketResponse);
//			responseObserver.onCompleted();
//		}
//
//		@Override
//		public void rejectTicket(TicketId request, StreamObserver<TicketResponse> responseObserver) {
//			
//			long ticketId = Long.valueOf(request.getTicketId());
//
//			allTickets.getAllTickets().forEach(ticket -> {
//				if (ticket.getId() == ticketId) {
//			
//					ticket.setStatus(Status.REJECTED);
//
//					TicketResponse ticketResponse = TicketResponse.newBuilder()
//																  .setDesciption(ticket.getDescription())
//																  .setTicketid(ticket.getId())
//																  .setTopic(ticket.getTopic())
//																  .setType(ticket.getType().toString())
//																  .setPriority(ticket.getPriority().toString())
//																  .setReporter(ticket.getReporter())
//																  .setStatus(ticket.getStatus().toString())
//																  .build();
//
//					responseObserver.onNext(ticketResponse);
//					responseObserver.onCompleted();
//
//					return;
//				}
//			});
//		}
//		
//		@Override
//		public StreamObserver<AutoNewTicketRequest> streamNewTicket(StreamObserver<TicketList> responseObserver) {
//			// TODO Auto-generated method stub
//			
//			observers.add(responseObserver);
//			
//			return new StreamObserver<AutoNewTicketRequest>() {
//				
//				@Override
//				public void onNext(AutoNewTicketRequest value) {
//					// TODO Auto-generated method stub
//					
//					TicketList allTkets = TicketList.newBuilder().setAllTickets(ByteString.copyFrom(Util.objectToStream(allTickets.getAllTickets())))
//					.build();
//					
//					observers.forEach(o -> o.onNext(allTkets));
//					
//				}
//				
//				@Override
//				public void onError(Throwable t) {
//					// TODO Auto-generated method stub
//
//					System.out.println("Error on the Server Observer");
//
//					observers.remove(responseObserver);
//				}
//				
//				@Override
//				public void onCompleted() {
//					// TODO Auto-generated method stub
//					
//					System.out.println("Streaming is finished");
//					
//					observers.remove(responseObserver);
//				}
//			};
//		}
//
//		@Override
//		public void acceptTicket(TicketId request, StreamObserver<TicketResponse> responseObserver) {
//			long ticketId = Long.valueOf(request.getTicketId());
//
//			allTickets.getAllTickets().forEach(ticket -> {
//				if (ticket.getId() == ticketId) {
//					
//					ticket.setStatus(Status.ACCEPTED);
//
//					TicketResponse ticketResponse = TicketResponse.newBuilder()
//																  .setDesciption(ticket.getDescription())
//																  .setTicketid(ticket.getId())
//																  .setTopic(ticket.getTopic())
//																  .setType(ticket.getType().toString())
//																  .setPriority(ticket.getPriority().toString())
//																  .setReporter(ticket.getReporter())
//																  .setStatus(ticket.getStatus().toString())
//																  .build();
//
//					responseObserver.onNext(ticketResponse);
//					responseObserver.onCompleted();
//					
//					return;
//				}
//			});
//		}
//	
//	}
//
//
//	
//	 public void start() throws IOException {
//	        
//		 	server.start();
//	        System.out.println("Server started and listened on port " + this.port);
//
//	        Runtime.getRuntime().addShutdownHook(new Thread() {
//	            @Override
//	            public void run() {
//	                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
//	                System.err.println("*** shutting down gRPC server since JVM is shutting down");
//	                try {
//						GRPCRemoteAccess.this.shutdown();
//					} catch (IOException | InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//	                System.err.println("*** server shut down");
//	            }
//	        });
//	    }
//
//}
