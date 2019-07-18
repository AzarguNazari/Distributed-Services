
package backend.rz.uniba.de;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import entities.rz.uniba.de.Ticket;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WSticketService", targetNamespace = "de.uniba.rz.backend")
@XmlSeeAlso({
    backend.rz.uniba.de.ObjectFactory.class,
    entities.rz.uniba.de.ObjectFactory.class
})
public interface WSticketService {


    /**
     * 
     * @param id
     * @return
     *     returns entities.rz.uniba.de.Ticket
     */
    @WebMethod
    @WebResult(name = "Ticket", targetNamespace = "")
    @RequestWrapper(localName = "rejectTicket", targetNamespace = "de.uniba.rz.backend", className = "backend.rz.uniba.de.RejectTicket")
    @ResponseWrapper(localName = "rejectTicketResponse", targetNamespace = "de.uniba.rz.backend", className = "backend.rz.uniba.de.RejectTicketResponse")
    @Action(input = "de.uniba.rz.backend/WSticketService/rejectTicketRequest", output = "de.uniba.rz.backend/WSticketService/rejectTicketResponse")
    public Ticket rejectTicket(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @return
     *     returns java.util.List<entities.rz.uniba.de.Ticket>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllTickets", targetNamespace = "de.uniba.rz.backend", className = "backend.rz.uniba.de.GetAllTickets")
    @ResponseWrapper(localName = "getAllTicketsResponse", targetNamespace = "de.uniba.rz.backend", className = "backend.rz.uniba.de.GetAllTicketsResponse")
    @Action(input = "de.uniba.rz.backend/WSticketService/getAllTicketsRequest", output = "de.uniba.rz.backend/WSticketService/getAllTicketsResponse")
    public List<Ticket> getAllTickets();

    /**
     * 
     * @param topic
     * @param description
     * @param reporter
     * @param type
     * @param priority
     * @return
     *     returns entities.rz.uniba.de.Ticket
     * @throws TicketException_Exception
     */
    @WebMethod
    @WebResult(name = "Ticket", targetNamespace = "")
    @RequestWrapper(localName = "createNewTicket", targetNamespace = "de.uniba.rz.backend", className = "backend.rz.uniba.de.CreateNewTicket")
    @ResponseWrapper(localName = "createNewTicketResponse", targetNamespace = "de.uniba.rz.backend", className = "backend.rz.uniba.de.CreateNewTicketResponse")
    @Action(input = "de.uniba.rz.backend/WSticketService/createNewTicketRequest", output = "de.uniba.rz.backend/WSticketService/createNewTicketResponse", fault = {
        @FaultAction(className = TicketException_Exception.class, value = "de.uniba.rz.backend/WSticketService/createNewTicket/Fault/TicketException")
    })
    public Ticket createNewTicket(
        @WebParam(name = "reporter", targetNamespace = "")
        String reporter,
        @WebParam(name = "topic", targetNamespace = "")
        String topic,
        @WebParam(name = "description", targetNamespace = "")
        String description,
        @WebParam(name = "type", targetNamespace = "")
        String type,
        @WebParam(name = "priority", targetNamespace = "")
        String priority)
        throws TicketException_Exception
    ;

    /**
     * 
     * @param id
     * @return
     *     returns entities.rz.uniba.de.Ticket
     */
    @WebMethod
    @WebResult(name = "Ticket", targetNamespace = "")
    @RequestWrapper(localName = "getTicketById", targetNamespace = "de.uniba.rz.backend", className = "backend.rz.uniba.de.GetTicketById")
    @ResponseWrapper(localName = "getTicketByIdResponse", targetNamespace = "de.uniba.rz.backend", className = "backend.rz.uniba.de.GetTicketByIdResponse")
    @Action(input = "de.uniba.rz.backend/WSticketService/getTicketByIdRequest", output = "de.uniba.rz.backend/WSticketService/getTicketByIdResponse")
    public Ticket getTicketById(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param id
     * @return
     *     returns entities.rz.uniba.de.Ticket
     */
    @WebMethod
    @WebResult(name = "Ticket", targetNamespace = "")
    @RequestWrapper(localName = "acceptTicket", targetNamespace = "de.uniba.rz.backend", className = "backend.rz.uniba.de.AcceptTicket")
    @ResponseWrapper(localName = "acceptTicketResponse", targetNamespace = "de.uniba.rz.backend", className = "backend.rz.uniba.de.AcceptTicketResponse")
    @Action(input = "de.uniba.rz.backend/WSticketService/acceptTicketRequest", output = "de.uniba.rz.backend/WSticketService/acceptTicketResponse")
    public Ticket acceptTicket(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param id
     * @return
     *     returns entities.rz.uniba.de.Ticket
     */
    @WebMethod
    @WebResult(name = "Ticket", targetNamespace = "")
    @RequestWrapper(localName = "closeTicket", targetNamespace = "de.uniba.rz.backend", className = "backend.rz.uniba.de.CloseTicket")
    @ResponseWrapper(localName = "closeTicketResponse", targetNamespace = "de.uniba.rz.backend", className = "backend.rz.uniba.de.CloseTicketResponse")
    @Action(input = "de.uniba.rz.backend/WSticketService/closeTicketRequest", output = "de.uniba.rz.backend/WSticketService/closeTicketResponse")
    public Ticket closeTicket(
        @WebParam(name = "id", targetNamespace = "")
        int id);

}