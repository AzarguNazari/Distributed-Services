package de.uniba.searchservice.jaxws.resources;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.soap.SOAPFaultException;
import backend.rz.uniba.de.WSticketService;
import backend.rz.uniba.de.WSticketServiceService;
import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Status;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.Type;
import de.uniba.searchservice.interfaces.SearchService;
import de.uniba.searchservice.jaxws.exceptions.SearchTicketFault;

/**
 * Developed by Team Members of #14
 */

/*
 
   _    _                        _____       _   _   _                     _ 
 | |  | |                      / ____|     | | | \ | |                   (_)
 | |__| | __ _ ______ _ _ __  | |  __ _   _| | |  \| | __ _ ______ _ _ __ _ 
 |  __  |/ _` |_  / _` | '__| | | |_ | | | | | | . ` |/ _` |_  / _` | '__| |
 | |  | | (_| |/ / (_| | |    | |__| | |_| | | | |\  | (_| |/ / (_| | |  | |
 |_|  |_|\__,_/___\__,_|_|     \_____|\__,_|_| |_| \_|\__,_/___\__,_|_|  |_|
                                                                            
 
 */

@WebService(targetNamespace = "de.uniba.searchservice.jaxws.resources")
public class SearchTicketResource implements SearchService {

	public SearchTicketResource() {
	}
	
	@WebMethod
	@Override
	public List<Ticket> getTicketsByName(String name) throws SOAPFaultException, SOAPException {
		// TODO Auto-generated method stub
		
		if(name == null || name.trim().length() == 0) {
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault("No ticket found", new QName("de.uniba.searchservice.jaxws.resources")));
		}
		

		List<Ticket> foundTickets = new ArrayList<>();
		WSticketServiceService server = new WSticketServiceService();
		WSticketService service = server.getWSticketServicePort();
		try {
			
			foundTickets.addAll(service.getAllTickets()
					.stream()
					.filter(tick -> tick.getDescription().contains(name) || tick.getReporter().contains(name) || tick.getTopic().contains(name))
					.map(tick -> 
						new Ticket(tick.getId(), tick.getReporter(), tick.getTopic(), tick.getDescription(), Type.valueOf(tick.getType().toString()), Priority.valueOf(tick.getPriority().toString()))
					)
					.sorted((Ticket ticket1, Ticket ticket2) -> {
						if(ticket1.getPriority() == Priority.CRITICAL) return 1;
						else if(ticket1.getPriority() == Priority.MAJOR) {
							if(ticket2.getPriority() == Priority.CRITICAL) return -1;
							if(ticket2.getPriority() == Priority.MINOR) return 1;
							else return 0;
						}
						else {
							if(ticket2.getPriority() == Priority.CRITICAL || ticket2.getPriority() == Priority.MAJOR) return -1;
							else return 0;
						}
					})
					.collect(Collectors.toList()));
			
			Collections.reverse(foundTickets);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return foundTickets;
	}


	@WebMethod
	@Override
	public List<Ticket> getTicketsByNameAndType(String name, Type type) throws SOAPFaultException, SOAPException {

		if(type == null || type.toString().trim().length() == 0) {
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault("No ticket Type", new QName("de.uniba.searchservice.jaxws.resources")));
		}
		
		List<Ticket> foundTickets = new ArrayList<>();
		WSticketServiceService server = new WSticketServiceService();
		WSticketService service = server.getWSticketServicePort();
		try {
			
			foundTickets.addAll(service.getAllTickets()
					.stream()
					.filter(tick -> (tick.getDescription().contains(name) || tick.getReporter().contains(name) || tick.getTopic().contains(name)) && tick.getType().toString().equals(type.toString()))
					.map(tick -> {
						Ticket tempTick = new Ticket(tick.getId(), tick.getReporter(), tick.getTopic(), tick.getDescription(), Type.valueOf(tick.getType().toString()), Priority.valueOf(tick.getPriority().toString()));
						tempTick.setStatus(Status.valueOf(tick.getStatus().toString()));
						return tempTick;
					})
					.sorted((Ticket ticket1, Ticket ticket2) -> {
						if(ticket1.getPriority() == Priority.CRITICAL) return 1;
						else if(ticket1.getPriority() == Priority.MAJOR) {
							if(ticket2.getPriority() == Priority.CRITICAL) return -1;
							if(ticket2.getPriority() == Priority.MINOR) return 1;
							else return 0;
						}
						else {
							if(ticket2.getPriority() == Priority.CRITICAL || ticket2.getPriority() == Priority.MAJOR) return -1;
							else return 0;
						}
					})
					.collect(Collectors.toList()));
			
			if(foundTickets.size() == 0) {
				throw new SearchTicketFault("Not found", "Sorry, there's no ticket with " + type.toString() + " type");
			}
			
			Collections.reverse(foundTickets);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return foundTickets;
	}
}
