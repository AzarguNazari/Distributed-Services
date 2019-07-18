package de.uniba.searchservice.jaxws;

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
import java.io.IOException;
import javax.xml.ws.Endpoint;

import de.uniba.searchservice.jaxws.resources.SearchTicketResource;

public class SearchServiceServer {

    public static void main(String[] args) throws IOException {

		Endpoint.publish("http://localhost:9999/search", new SearchTicketResource());

    	
    }
}
