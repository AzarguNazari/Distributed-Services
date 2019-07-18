package de.uniba.rz.app;

import java.util.ArrayList;
import java.util.List;

import backend.rz.uniba.de.WSticketService;
import backend.rz.uniba.de.WSticketServiceService;
import de.uniba.rz.entities.Priority;
import de.uniba.rz.entities.Status;
import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketException;
import de.uniba.rz.entities.Type;
import resources.jaxws.searchservice.uniba.de.SOAPException_Exception;
import resources.jaxws.searchservice.uniba.de.SearchTicketResource;
import resources.jaxws.searchservice.uniba.de.SearchTicketResourceService;

//..............................................................................................................
//.WWWW..WWWWW...WWWS.SSSSSSS....DDDDDDDDD....LLLL..............CCCCCCC....llll.iiii.......................ttt..
//.WWWW..WWWWW..WWWW.SSSSSSSSS...DDDDDDDDDD...LLLL.............CCCCCCCCC...llll.iiii......................tttt..
//.WWWW..WWWWWW.WWWW.SSSSSSSSSS..DDDDDDDDDDD..LLLL............CCCCCCCCCCC..llll...........................tttt..
//.WWWW.WWWWWWW.WWWWSSSSS..SSSS..DDDD...DDDD..LLLL............CCCC...CCCCC.llll.iiii..eeeeee...nnnnnnnn.nttttt..
//.WWWW.WWWWWWW.WWWWSSSSS........DDDD....DDDD.LLLL...........CCCC.....CCC..llll.iiii.eeeeeeee..nnnnnnnnnnttttt..
//..WWWWWWWWWWW.WWW..SSSSSSS.....DDDD....DDDD.LLLL...........CCCC..........llll.iiiieeee.eeee..nnnn.nnnnn.tttt..
//..WWWWWWW.WWWWWWW...SSSSSSSSS..DDDD....DDDD.LLLL...........CCCC..........llll.iiiieeee..eeee.nnnn..nnnn.tttt..
//..WWWWWWW.WWWWWWW.....SSSSSSS..DDDD....DDDD.LLLL...........CCCC..........llll.iiiieeeeeeeeee.nnnn..nnnn.tttt..
//..WWWWWWW.WWWWWWW........SSSSS.DDDD....DDDD.LLLL...........CCCC.....CCC..llll.iiiieeeeeeeeee.nnnn..nnnn.tttt..
//..WWWWWWW.WWWWWWW.SSSS....SSSS.DDDD...DDDDD.LLLL............CCCC...CCCCC.llll.iiiieeee.......nnnn..nnnn.tttt..
//...WWWWW...WWWWW..SSSSSSSSSSSS.DDDDDDDDDDD..LLLLLLLLLL......CCCCCCCCCCC..llll.iiiieeee..eeee.nnnn..nnnn.tttt..
//...WWWWW...WWWWW...SSSSSSSSSS..DDDDDDDDDD...LLLLLLLLLL.......CCCCCCCCCC..llll.iiii.eeeeeeee..nnnn..nnnn.tttt..
//...WWWWW...WWWWW....SSSSSSSS...DDDDDDDDD....LLLLLLLLLL........CCCCCCC....llll.iiii..eeeeee...nnnn..nnnn.tttt..
//..............................................................................................................

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



public class WSDLticketManagement implements TicketManagementBackend, TicketSearchBackend {

	WSticketServiceService server;
	WSticketService service;

	SearchTicketResourceService searchService;
	SearchTicketResource searchResource;

	public WSDLticketManagement() {
		server = new WSticketServiceService();
		service = server.getWSticketServicePort();
		searchService = new SearchTicketResourceService();
		searchResource = searchService.getSearchTicketResourcePort();
	}

	@Override
	public void triggerShutdown() {
		// TODO Auto-generated method stub

	}

	@Override
	public Ticket createNewTicket(String reporter, String topic, String description, Type type, Priority priority)
			throws TicketException {
		// TODO Auto-generated method stub
		try {
			entities.rz.uniba.de.Ticket ticket = service.createNewTicket(reporter, topic, description, type.toString(),
					priority.toString());
			return new Ticket(ticket.getId(), ticket.getReporter(), ticket.getTopic(), ticket.getDescription(),
					Type.valueOf(ticket.getType().toString()), Priority.valueOf(ticket.getPriority().toString()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		throw new TicketException("Sorry, ticket is not created on servers");
	}

	@Override
	public List<Ticket> getAllTickets() throws TicketException {
		// TODO Auto-generated method stub

		List<Ticket> allTickets = new ArrayList<>();
		service.getAllTickets().stream()
				.map(ticket -> {
					Ticket tempTicket = new Ticket(ticket.getId(), ticket.getReporter(), ticket.getTopic(),
							ticket.getDescription(), Type.valueOf(ticket.getType().toString()),
							Priority.valueOf(ticket.getPriority().toString()));
					tempTicket.setStatus(Status.valueOf(ticket.getStatus().toString()));
					return tempTicket;
				})
				.forEach(allTickets::add);
		;
		return allTickets;
	}

	@Override
	public Ticket getTicketById(int id) throws TicketException {
		// TODO Auto-generated method stub

		entities.rz.uniba.de.Ticket ticket = service.getTicketById(id);

		if (ticket == null) {
			throw new TicketException("Sorry, there's no such ticket with this " + id + " ID");
		} else {
			Ticket tempTicket = new Ticket(ticket.getId(), ticket.getReporter(), ticket.getTopic(), ticket.getDescription(),
					Type.valueOf(ticket.getType().toString()), Priority.valueOf(ticket.getPriority().toString()));
			tempTicket.setStatus(Status.valueOf(ticket.getStatus().toString()));
			System.out.println(tempTicket);
			return tempTicket;
		}

	}

	@Override
	public Ticket acceptTicket(int id) throws TicketException {
		// TODO Auto-generated method stub
		entities.rz.uniba.de.Ticket ticket = service.acceptTicket(id);

		if (ticket == null) {
			throw new TicketException("Sorry, there's no such ticket with this " + id + " ID");
		} else {
			Ticket tempTicket = new Ticket(ticket.getId(), ticket.getReporter(), ticket.getTopic(), ticket.getDescription(),
					Type.valueOf(ticket.getType().toString()), Priority.valueOf(ticket.getPriority().toString()));
			tempTicket.setStatus(Status.valueOf(ticket.getStatus().toString()));
			System.out.println(tempTicket);
			return tempTicket;
		}
	}

	@Override
	public Ticket rejectTicket(int id) throws TicketException {
		// TODO Auto-generated method stub
		entities.rz.uniba.de.Ticket ticket = service.rejectTicket(id);

		if (ticket == null) {
			throw new TicketException("Sorry, there's no such ticket with this " + id + " ID");
		} else {
			Ticket tempTicket = new Ticket(ticket.getId(), ticket.getReporter(), ticket.getTopic(), ticket.getDescription(),
					Type.valueOf(ticket.getType().toString()), Priority.valueOf(ticket.getPriority().toString()));
			tempTicket.setStatus(Status.valueOf(ticket.getStatus().toString()));
			System.out.println(tempTicket);
			return tempTicket;
		}
	}

	@Override
	public Ticket closeTicket(int id) throws TicketException {
		// TODO Auto-generated method stub
		entities.rz.uniba.de.Ticket ticket = service.closeTicket(id);

		if (ticket == null) {
			throw new TicketException("Sorry, there's no such ticket with this " + id + " ID");
		} else {
			Ticket tempTicket = new Ticket(ticket.getId(), ticket.getReporter(), ticket.getTopic(), ticket.getDescription(),
					Type.valueOf(ticket.getType().toString()), Priority.valueOf(ticket.getPriority().toString()));
			tempTicket.setStatus(Status.valueOf(ticket.getStatus().toString()));
			System.out.println(tempTicket);
			return tempTicket;
		}
	}

	@Override
	public List<Ticket> getTicketsByName(String name) throws TicketException {
		// TODO Auto-generated method stub

		List<Ticket> allTickets = new ArrayList<>();
		try {
			searchResource
					.getTicketsByName(name)
					.stream()
					.map(ticket -> new Ticket(ticket.getId(), ticket.getReporter(), ticket.getTopic(), ticket.getDescription(), Type.valueOf(ticket.getType().toString()), Priority.valueOf(ticket.getPriority().toString())))
					.forEach(allTickets::add);
		} catch (SOAPException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allTickets;
	}

	@Override
	public List<Ticket> getTicketsByNameAndType(String name, Type type) throws TicketException {
		List<Ticket> allTickets = new ArrayList<>();
		try {
			searchResource
					.getTicketsByNameAndType(name, resources.jaxws.searchservice.uniba.de.Type.valueOf(type.toString()))
					.stream()
					.map(ticket -> new Ticket(ticket.getId(), ticket.getReporter(), ticket.getTopic(), ticket.getDescription(), Type.valueOf(ticket.getType().toString()), Priority.valueOf(ticket.getPriority().toString())))
					.forEach(allTickets::add);
		} catch (SOAPException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allTickets;
	}

}
