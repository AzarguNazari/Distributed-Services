package de.uniba.rz.backend.UDP;
import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import de.uniba.rz.entities.PacketWrapper;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.backend.RemoteAccess;
import de.uniba.rz.backend.TicketStore;
import de.uniba.rz.entities.*;

public class UdpAccessRemote implements RemoteAccess {

	private String address;
	private int port;
	private DatagramSocket serverSocket;
	private TicketStore tickets;
	private byte[] receiveData;
	private byte[] sendData;

	public UdpAccessRemote(String address, int port) {
		this.address = address;
		this.port = port;
		try {
			serverSocket = new DatagramSocket(port, InetAddress.getByName(address));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void run() {

		// for running thread
		while (true) {

			new Thread(){

				public void run(){


					try {

						receiveData = new byte[1024];
						DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
						serverSocket.receive(receivePacket);

						PacketWrapper receivedPacket = (PacketWrapper) Util.byteStreamToObject(receivePacket.getData());

						// Process the received packet

						switch (receivedPacket.getMessageType()) {

							case "createNewTicket":

								Ticket receivedNewTicket = (Ticket) receivedPacket.getMessage();
								Ticket storedTicket = tickets.storeNewTicket(receivedNewTicket.getReporter(),
										receivedNewTicket.getTopic(), receivedNewTicket.getDescription(),
										receivedNewTicket.getType(), receivedNewTicket.getPriority());

								break;

							case "getAllTickets":

								List<Ticket> allTickets = tickets.getAllTickets();
								byte[] objToBytes = Util.objectToStream(allTickets);
								DatagramPacket sendPacket = new DatagramPacket(objToBytes, objToBytes.length, receivePacket.getAddress(),
										receivePacket.getPort());
								serverSocket.send(sendPacket);



								break;

							case "getTicketById":

								int receivedTicketId = (Integer) receivedPacket.getMessage();

								for (Ticket t : tickets.getAllTickets()) {
									if (t.getId() == receivedTicketId) {

										sendData = Util.objectToStream(t);
										sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(),
												receivePacket.getPort());
										serverSocket.send(sendPacket);

									}
								}

								break;

							case "acceptTicket":

								receivedTicketId = (int) receivedPacket.getMessage();

								for (Ticket t : tickets.getAllTickets()) {
									if (t.getId() == receivedTicketId) {

										t.setStatus(Status.ACCEPTED);

										sendData = Util.objectToStream(t);
										sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(),
												receivePacket.getPort());
										serverSocket.send(sendPacket);

									}
								}

								break;

							case "rejectTicket":

								receivedTicketId = (int) receivedPacket.getMessage();

								for (Ticket t : tickets.getAllTickets()) {
									if (t.getId() == receivedTicketId) {

										t.setStatus(Status.REJECTED);

										sendData = Util.objectToStream(t);
										sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(),
												receivePacket.getPort());
										serverSocket.send(sendPacket);

									}
								}

								break;

							case "closeTicket":

								receivedTicketId = (int) receivedPacket.getMessage();

								for (Ticket t : tickets.getAllTickets()) {
									if (t.getId() == receivedTicketId) {

										t.setStatus(Status.CLOSED);

										sendData = Util.objectToStream(t);
										sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(),
												receivePacket.getPort());
										serverSocket.send(sendPacket);

									}
								}

								break;

						}

					} catch (IOException ex) {
						ex.printStackTrace();
					}

				}

			}.run();


		}

	}

	@Override
	public void prepareStartup(TicketStore ticketStore) {
		this.tickets = ticketStore;
	}

	@Override
	public void shutdown() {
		serverSocket.close();
	}

}
