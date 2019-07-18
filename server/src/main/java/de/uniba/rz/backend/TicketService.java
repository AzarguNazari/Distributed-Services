package de.uniba.rz.backend;


import java.util.List;

import javax.jws.WebService;

import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Status;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketException;
import de.uniba.rz.entities.Type;

/**
 * Defines the actions the GUI is calling to create, list and modify
 * {@link Ticket}s
 */
@WebService
public interface TicketService {

	Ticket createNewTicket(String reporter, String topic, String description, String type, String priority)
			throws TicketException;

	List<Ticket> getAllTickets();

	Ticket getTicketById(int id);

	Ticket acceptTicket(int id);

	Ticket rejectTicket(int id);

	Ticket closeTicket(int id);

}
