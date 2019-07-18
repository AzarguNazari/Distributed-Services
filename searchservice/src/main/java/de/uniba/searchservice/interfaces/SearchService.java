package de.uniba.searchservice.interfaces;


import java.util.List;

import javax.jws.WebService;
import javax.xml.soap.SOAPException;
import javax.xml.ws.soap.SOAPFaultException;

import de.uniba.rz.entities.Ticket;
import de.uniba.rz.entities.TicketException;
import de.uniba.rz.entities.Type;



@WebService
public interface SearchService {
	/**
	 * Method to search for a Ticket based on the provided information
	 * 
	 * @param name The name of the ticket to be searched
	 * @return a list of {@link Ticket} that fulfill the requested attributes
	 * @throws TicketException if something failed
	 */
	List<Ticket> getTicketsByName(String name)  throws SOAPFaultException, SOAPException;

	/**
	 * Method to search for a Ticket based on the provided information
	 * 
	 * @param name The name of the ticket to be searched
	 * @param type The {@link Type} of the ticket to be searched
	 * @return a list of {@link Ticket} that fulfill the requested attributes
	 * @throws TicketException if something failed
	 */
	 List<Ticket> getTicketsByNameAndType(String name, Type type)  throws SOAPFaultException, SOAPException;
}