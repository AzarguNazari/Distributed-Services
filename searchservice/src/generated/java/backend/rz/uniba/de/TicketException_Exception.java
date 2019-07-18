
package backend.rz.uniba.de;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "TicketException", targetNamespace = "de.uniba.rz.backend")
public class TicketException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private TicketException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public TicketException_Exception(String message, TicketException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public TicketException_Exception(String message, TicketException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: backend.rz.uniba.de.TicketException
     */
    public TicketException getFaultInfo() {
        return faultInfo;
    }

}