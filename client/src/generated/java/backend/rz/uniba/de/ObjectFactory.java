
package backend.rz.uniba.de;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import entities.rz.uniba.de.Ticket;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the backend.rz.uniba.de package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Ticket_QNAME = new QName("de.uniba.rz.backend", "Ticket");
    private final static QName _TicketException_QNAME = new QName("de.uniba.rz.backend", "TicketException");
    private final static QName _AcceptTicket_QNAME = new QName("de.uniba.rz.backend", "acceptTicket");
    private final static QName _AcceptTicketResponse_QNAME = new QName("de.uniba.rz.backend", "acceptTicketResponse");
    private final static QName _CloseTicket_QNAME = new QName("de.uniba.rz.backend", "closeTicket");
    private final static QName _CloseTicketResponse_QNAME = new QName("de.uniba.rz.backend", "closeTicketResponse");
    private final static QName _CreateNewTicket_QNAME = new QName("de.uniba.rz.backend", "createNewTicket");
    private final static QName _CreateNewTicketResponse_QNAME = new QName("de.uniba.rz.backend", "createNewTicketResponse");
    private final static QName _GetAllTickets_QNAME = new QName("de.uniba.rz.backend", "getAllTickets");
    private final static QName _GetAllTicketsResponse_QNAME = new QName("de.uniba.rz.backend", "getAllTicketsResponse");
    private final static QName _GetTicketById_QNAME = new QName("de.uniba.rz.backend", "getTicketById");
    private final static QName _GetTicketByIdResponse_QNAME = new QName("de.uniba.rz.backend", "getTicketByIdResponse");
    private final static QName _RejectTicket_QNAME = new QName("de.uniba.rz.backend", "rejectTicket");
    private final static QName _RejectTicketResponse_QNAME = new QName("de.uniba.rz.backend", "rejectTicketResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: backend.rz.uniba.de
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TicketException }
     * 
     */
    public TicketException createTicketException() {
        return new TicketException();
    }

    /**
     * Create an instance of {@link AcceptTicket }
     * 
     */
    public AcceptTicket createAcceptTicket() {
        return new AcceptTicket();
    }

    /**
     * Create an instance of {@link AcceptTicketResponse }
     * 
     */
    public AcceptTicketResponse createAcceptTicketResponse() {
        return new AcceptTicketResponse();
    }

    /**
     * Create an instance of {@link CloseTicket }
     * 
     */
    public CloseTicket createCloseTicket() {
        return new CloseTicket();
    }

    /**
     * Create an instance of {@link CloseTicketResponse }
     * 
     */
    public CloseTicketResponse createCloseTicketResponse() {
        return new CloseTicketResponse();
    }

    /**
     * Create an instance of {@link CreateNewTicket }
     * 
     */
    public CreateNewTicket createCreateNewTicket() {
        return new CreateNewTicket();
    }

    /**
     * Create an instance of {@link CreateNewTicketResponse }
     * 
     */
    public CreateNewTicketResponse createCreateNewTicketResponse() {
        return new CreateNewTicketResponse();
    }

    /**
     * Create an instance of {@link GetAllTickets }
     * 
     */
    public GetAllTickets createGetAllTickets() {
        return new GetAllTickets();
    }

    /**
     * Create an instance of {@link GetAllTicketsResponse }
     * 
     */
    public GetAllTicketsResponse createGetAllTicketsResponse() {
        return new GetAllTicketsResponse();
    }

    /**
     * Create an instance of {@link GetTicketById }
     * 
     */
    public GetTicketById createGetTicketById() {
        return new GetTicketById();
    }

    /**
     * Create an instance of {@link GetTicketByIdResponse }
     * 
     */
    public GetTicketByIdResponse createGetTicketByIdResponse() {
        return new GetTicketByIdResponse();
    }

    /**
     * Create an instance of {@link RejectTicket }
     * 
     */
    public RejectTicket createRejectTicket() {
        return new RejectTicket();
    }

    /**
     * Create an instance of {@link RejectTicketResponse }
     * 
     */
    public RejectTicketResponse createRejectTicketResponse() {
        return new RejectTicketResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ticket }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Ticket }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.rz.backend", name = "Ticket")
    public JAXBElement<Ticket> createTicket(Ticket value) {
        return new JAXBElement<Ticket>(_Ticket_QNAME, Ticket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TicketException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TicketException }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.rz.backend", name = "TicketException")
    public JAXBElement<TicketException> createTicketException(TicketException value) {
        return new JAXBElement<TicketException>(_TicketException_QNAME, TicketException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcceptTicket }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AcceptTicket }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.rz.backend", name = "acceptTicket")
    public JAXBElement<AcceptTicket> createAcceptTicket(AcceptTicket value) {
        return new JAXBElement<AcceptTicket>(_AcceptTicket_QNAME, AcceptTicket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcceptTicketResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AcceptTicketResponse }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.rz.backend", name = "acceptTicketResponse")
    public JAXBElement<AcceptTicketResponse> createAcceptTicketResponse(AcceptTicketResponse value) {
        return new JAXBElement<AcceptTicketResponse>(_AcceptTicketResponse_QNAME, AcceptTicketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseTicket }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CloseTicket }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.rz.backend", name = "closeTicket")
    public JAXBElement<CloseTicket> createCloseTicket(CloseTicket value) {
        return new JAXBElement<CloseTicket>(_CloseTicket_QNAME, CloseTicket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseTicketResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CloseTicketResponse }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.rz.backend", name = "closeTicketResponse")
    public JAXBElement<CloseTicketResponse> createCloseTicketResponse(CloseTicketResponse value) {
        return new JAXBElement<CloseTicketResponse>(_CloseTicketResponse_QNAME, CloseTicketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewTicket }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateNewTicket }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.rz.backend", name = "createNewTicket")
    public JAXBElement<CreateNewTicket> createCreateNewTicket(CreateNewTicket value) {
        return new JAXBElement<CreateNewTicket>(_CreateNewTicket_QNAME, CreateNewTicket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewTicketResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateNewTicketResponse }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.rz.backend", name = "createNewTicketResponse")
    public JAXBElement<CreateNewTicketResponse> createCreateNewTicketResponse(CreateNewTicketResponse value) {
        return new JAXBElement<CreateNewTicketResponse>(_CreateNewTicketResponse_QNAME, CreateNewTicketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllTickets }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllTickets }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.rz.backend", name = "getAllTickets")
    public JAXBElement<GetAllTickets> createGetAllTickets(GetAllTickets value) {
        return new JAXBElement<GetAllTickets>(_GetAllTickets_QNAME, GetAllTickets.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllTicketsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllTicketsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.rz.backend", name = "getAllTicketsResponse")
    public JAXBElement<GetAllTicketsResponse> createGetAllTicketsResponse(GetAllTicketsResponse value) {
        return new JAXBElement<GetAllTicketsResponse>(_GetAllTicketsResponse_QNAME, GetAllTicketsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTicketById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTicketById }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.rz.backend", name = "getTicketById")
    public JAXBElement<GetTicketById> createGetTicketById(GetTicketById value) {
        return new JAXBElement<GetTicketById>(_GetTicketById_QNAME, GetTicketById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTicketByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTicketByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.rz.backend", name = "getTicketByIdResponse")
    public JAXBElement<GetTicketByIdResponse> createGetTicketByIdResponse(GetTicketByIdResponse value) {
        return new JAXBElement<GetTicketByIdResponse>(_GetTicketByIdResponse_QNAME, GetTicketByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RejectTicket }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RejectTicket }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.rz.backend", name = "rejectTicket")
    public JAXBElement<RejectTicket> createRejectTicket(RejectTicket value) {
        return new JAXBElement<RejectTicket>(_RejectTicket_QNAME, RejectTicket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RejectTicketResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RejectTicketResponse }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.rz.backend", name = "rejectTicketResponse")
    public JAXBElement<RejectTicketResponse> createRejectTicketResponse(RejectTicketResponse value) {
        return new JAXBElement<RejectTicketResponse>(_RejectTicketResponse_QNAME, RejectTicketResponse.class, null, value);
    }

}
