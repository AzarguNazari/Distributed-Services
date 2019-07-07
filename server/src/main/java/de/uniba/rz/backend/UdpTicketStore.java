package de.uniba.rz.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Status;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.Type;

public class UdpTicketStore implements TicketStore {

	HashMap<Integer, Ticket> tickets = new HashMap<>();
	private AtomicInteger nextId;

	public UdpTicketStore() {
		nextId = new AtomicInteger(1);
	}

	@Override
	public Ticket storeNewTicket(String reporter, String topic, String description, Type type, Priority priority) {
		// TODO Auto-generated method stub

		Ticket newTicket = new Ticket(nextId.getAndIncrement(), reporter, topic, description, type, priority);
		tickets.put(newTicket.getId(), newTicket);

		System.out.println("New Ticket of " + newTicket.getReporter() + " is created");

		return (Ticket) newTicket.clone();
	}

	@Override
	public void updateTicketStatus(int ticketId, Status newStatus)
			throws UnknownTicketException, IllegalStateException {
		// TODO Auto-generated method stub

		tickets.forEach((key, value) -> {

			if (key == ticketId) {
				System.out.println("Ticket with " + key + " id is updated");
				value.setStatus(newStatus);
			}
		});

	}

	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub

		List<Ticket> tempTicket = new ArrayList<>();
		tickets.forEach((key, value) -> tempTicket.add(value));
		System.out.println("Ticket list with size of " + tempTicket.size());
		return tempTicket;
	}

}
