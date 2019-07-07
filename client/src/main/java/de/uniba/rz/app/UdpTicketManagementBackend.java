package de.uniba.rz.app;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import de.uniba.rz.entities.PacketWrapper;
import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketException;
import de.uniba.rz.entities.Type;
import de.uniba.rz.entities.Util;

/**
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @author Team Members 27
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

public class UdpTicketManagementBackend implements TicketManagementBackend {

	/************** Properties **************/

	AtomicInteger nextId;
	String host;
	int port;
	DatagramSocket serverSocket;
	byte[] receivedBuff, sendBuff;

	public UdpTicketManagementBackend(String host, int port) {

		this.host = host;
		this.port = port;

		try {
			serverSocket = new DatagramSocket();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		nextId = new AtomicInteger(1);
	}

	@Override
	public void triggerShutdown() {
		// TODO Auto-generated method stub

		serverSocket.close();

	}

	@Override
	public Ticket createNewTicket(String reporter, String topic, String description, Type type, Priority priority)
			throws TicketException {

		/**
		 * 
		 * In this method, the new created Ticket will be wrapped inside a wrapper class
		 * (PacketWrapper) for the sake of easiness on the server side
		 * 
		 */

		Ticket tempTicket = new Ticket(nextId.getAndIncrement(), reporter, topic, description, type, priority);

		PacketWrapper packetWrapper = new PacketWrapper("createNewTicket", tempTicket);

		try {

			sendPacket(packetWrapper);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return (Ticket) tempTicket.clone();
	}

	@Override
	public List<Ticket> getAllTickets() throws TicketException {
		// TODO Auto-generated method stub

		/**
		 *
		 * In this method, we just ask the server to retreive all the listed Tickets
		 *
		 *
		 */

		PacketWrapper wrapper = new PacketWrapper("getAllTickets", null);

		List<Ticket> allTickets = new ArrayList<>();

		try {

			sendPacket(wrapper);

			List<Ticket> received = (List<Ticket>) receivePacket();
			System.out.println(received.size());
			
			return received;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return allTickets;
	}

	@Override
	public Ticket getTicketById(int id) throws TicketException {
		// TODO Auto-generated method stub

		/**
		 * 
		 * A request of getTicketById is sent to server and server search for that
		 * specific id and return ticket
		 * 
		 * 
		 */

		PacketWrapper wrapper = new PacketWrapper("getTicketById", new Integer(id));
		Ticket ticket = null;

		try {

			// Sending Packet to server
			sendPacket(wrapper);


			// Received Ticket from server
			ticket = (Ticket) receivePacket();

			return ticket;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ticket;
	}

	@Override
	public Ticket acceptTicket(int id) throws TicketException {

		/**
		 * 
		 * Send the id of ticket to server and server changes the status as soon as it
		 * receives the ticket id
		 * 
		 */

		PacketWrapper wrapper = new PacketWrapper("acceptTicket", id);
		Ticket ticket = null;
		try {

			// Sending packet to server
			sendPacket(wrapper);

			// receiving back from server
			ticket = (Ticket) receivePacket();

			return ticket;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ticket;
	}

	@Override
	public Ticket rejectTicket(int id) throws TicketException {
		// TODO Auto-generated method stub

		/**
		 * 
		 * Send the id to the server and do the remaining things there
		 * 
		 */

		PacketWrapper wrapper = new PacketWrapper("rejectTicket", id);
		Ticket ticket = null;
		try {

			// Sending Packet
			sendPacket(wrapper);
			
			// Receiving Packet
			ticket = (Ticket) receivePacket();

			return ticket;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ticket;
	}

	@Override
	public Ticket closeTicket(int id) throws TicketException {
		// TODO Auto-generated method stub

		/**
		 * 
		 * Send the id to the server and do the remaining things on the serer
		 * 
		 * 
		 */

		String request = "closeTicket";
		PacketWrapper wrapper = new PacketWrapper(request, id);
		Ticket ticket = null;
		try {

			// Send Packet
			sendPacket(wrapper);

			// Receive Packet
			ticket = (Ticket) receivePacket();

			return ticket;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ticket;
	}

	/**
	 * 
	 * @param wrapper
	 * 
	 * This method is for sending the packet to server
	 */
	private void sendPacket(PacketWrapper wrapper) {
		try {
			sendBuff = Util.objectToStream(wrapper);
			DatagramPacket packet = new DatagramPacket(sendBuff, sendBuff.length, InetAddress.getByName(host), port);
			serverSocket.send(packet);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * @return Response Object form servers
	 * 
	 * This method is for receiving the packet from server
	 */
	private Object receivePacket() {
		try {
			receivedBuff = new byte[10024];
			DatagramPacket receivePacket = new DatagramPacket(receivedBuff, receivedBuff.length);
			serverSocket.receive(receivePacket);
			return Util.byteStreamToObject(receivePacket.getData());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
