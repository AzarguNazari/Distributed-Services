package de.uniba.rz.backend;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import de.uniba.rz.backend.SimpleTicketStore;
import de.uniba.rz.backend.TicketStore;
import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Status;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketException;
import de.uniba.rz.entities.Type;

@WebService(targetNamespace = "de.uniba.rz.backend")
public class WSticketService implements TicketService{

	
	public WSticketService() {

	}

	@WebMethod
	@WebResult(name="Ticket")
	@Override
	public Ticket createNewTicket(@WebParam(name = "reporter") String reporter, @WebParam(name = "topic") String topic, @WebParam(name = "description") String description, @WebParam(name = "type") String type, @WebParam(name = "priority") String priority)
			throws TicketException {
		// TODO Auto-generated method stub
		
		Ticket tempTicket = WSDLremoteAccess.ticketStore.storeNewTicket(reporter, topic, description, Type.valueOf(type), Priority.valueOf(priority));
		
		System.out.println("New Tickete creawted");
		
		return tempTicket;
	}

	@WebMethod
	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub

		return WSDLremoteAccess.ticketStore.getAllTickets();
	}

	@WebMethod
    @WebResult(name="Ticket")
	@Override
	public Ticket getTicketById(@WebParam(name = "id") int id) {
		// TODO Auto-generated method stub
		
		for(Ticket ticket : WSDLremoteAccess.ticketStore.getAllTickets()) {
			if(ticket.getId() == id) {
				return ticket;
			}
		}
		
		return null;
	}

	@WebMethod
    @WebResult(name="Ticket")
	@Override
	public Ticket acceptTicket(@WebParam(name = "id") int id) {
		// TODO Auto-generated method stub
		for(Ticket ticket : WSDLremoteAccess.ticketStore.getAllTickets()) {
			if(ticket.getId() == id) {
				ticket.setStatus(Status.ACCEPTED);
				return ticket;
			}
		}
		
		return null;
	}

	@WebMethod
    @WebResult(name="Ticket")
	@Override
	public Ticket rejectTicket(@WebParam(name = "id") int id) {
		// TODO Auto-generated method stub
		for(Ticket ticket : WSDLremoteAccess.ticketStore.getAllTickets()) {
			if(ticket.getId() == id) {
				ticket.setStatus(Status.REJECTED);
				return ticket;
			}
		}
		
		return null;
	}

	@WebMethod
    @WebResult(name="Ticket")
	@Override
	public Ticket closeTicket(@WebParam(name = "id") int id) {
		// TODO Auto-generated method stub
		for(Ticket ticket : WSDLremoteAccess.ticketStore.getAllTickets()) {
			if(ticket.getId() == id) {
				ticket.setStatus(Status.CLOSED);
				return ticket;
			}
		}
		
		return null;
	}
	
}
