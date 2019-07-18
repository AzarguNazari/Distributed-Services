
package resources.jaxws.searchservice.uniba.de;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import entities.rz.uniba.de.Ticket;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the resources.jaxws.searchservice.uniba.de package. 
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

    private final static QName _SOAPException_QNAME = new QName("de.uniba.searchservice.jaxws.resources", "SOAPException");
    private final static QName _Ticket_QNAME = new QName("de.uniba.searchservice.jaxws.resources", "Ticket");
    private final static QName _GetTicketsByName_QNAME = new QName("de.uniba.searchservice.jaxws.resources", "getTicketsByName");
    private final static QName _GetTicketsByNameAndType_QNAME = new QName("de.uniba.searchservice.jaxws.resources", "getTicketsByNameAndType");
    private final static QName _GetTicketsByNameAndTypeResponse_QNAME = new QName("de.uniba.searchservice.jaxws.resources", "getTicketsByNameAndTypeResponse");
    private final static QName _GetTicketsByNameResponse_QNAME = new QName("de.uniba.searchservice.jaxws.resources", "getTicketsByNameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: resources.jaxws.searchservice.uniba.de
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SOAPException }
     * 
     */
    public SOAPException createSOAPException() {
        return new SOAPException();
    }

    /**
     * Create an instance of {@link GetTicketsByName }
     * 
     */
    public GetTicketsByName createGetTicketsByName() {
        return new GetTicketsByName();
    }

    /**
     * Create an instance of {@link GetTicketsByNameAndType }
     * 
     */
    public GetTicketsByNameAndType createGetTicketsByNameAndType() {
        return new GetTicketsByNameAndType();
    }

    /**
     * Create an instance of {@link GetTicketsByNameAndTypeResponse }
     * 
     */
    public GetTicketsByNameAndTypeResponse createGetTicketsByNameAndTypeResponse() {
        return new GetTicketsByNameAndTypeResponse();
    }

    /**
     * Create an instance of {@link GetTicketsByNameResponse }
     * 
     */
    public GetTicketsByNameResponse createGetTicketsByNameResponse() {
        return new GetTicketsByNameResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SOAPException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SOAPException }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.searchservice.jaxws.resources", name = "SOAPException")
    public JAXBElement<SOAPException> createSOAPException(SOAPException value) {
        return new JAXBElement<SOAPException>(_SOAPException_QNAME, SOAPException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ticket }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Ticket }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.searchservice.jaxws.resources", name = "Ticket")
    public JAXBElement<Ticket> createTicket(Ticket value) {
        return new JAXBElement<Ticket>(_Ticket_QNAME, Ticket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTicketsByName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTicketsByName }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.searchservice.jaxws.resources", name = "getTicketsByName")
    public JAXBElement<GetTicketsByName> createGetTicketsByName(GetTicketsByName value) {
        return new JAXBElement<GetTicketsByName>(_GetTicketsByName_QNAME, GetTicketsByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTicketsByNameAndType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTicketsByNameAndType }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.searchservice.jaxws.resources", name = "getTicketsByNameAndType")
    public JAXBElement<GetTicketsByNameAndType> createGetTicketsByNameAndType(GetTicketsByNameAndType value) {
        return new JAXBElement<GetTicketsByNameAndType>(_GetTicketsByNameAndType_QNAME, GetTicketsByNameAndType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTicketsByNameAndTypeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTicketsByNameAndTypeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.searchservice.jaxws.resources", name = "getTicketsByNameAndTypeResponse")
    public JAXBElement<GetTicketsByNameAndTypeResponse> createGetTicketsByNameAndTypeResponse(GetTicketsByNameAndTypeResponse value) {
        return new JAXBElement<GetTicketsByNameAndTypeResponse>(_GetTicketsByNameAndTypeResponse_QNAME, GetTicketsByNameAndTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTicketsByNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTicketsByNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "de.uniba.searchservice.jaxws.resources", name = "getTicketsByNameResponse")
    public JAXBElement<GetTicketsByNameResponse> createGetTicketsByNameResponse(GetTicketsByNameResponse value) {
        return new JAXBElement<GetTicketsByNameResponse>(_GetTicketsByNameResponse_QNAME, GetTicketsByNameResponse.class, null, value);
    }

}
