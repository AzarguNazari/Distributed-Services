package de.uniba.searchservice.jaxws.exceptions;

import javax.xml.ws.WebFault;

@WebFault(name = "SearchTicketFault")
public class SearchTicketFault extends Exception {
	
    /** Java type that goes as soapenv:Fault detail element. */
    private String faultInfo;

    public SearchTicketFault(String message, String faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    public SearchTicketFault(String message, String faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    public String getFaultInfo() {
        return faultInfo;
    }	
}