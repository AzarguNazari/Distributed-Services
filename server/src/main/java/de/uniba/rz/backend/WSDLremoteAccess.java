package de.uniba.rz.backend;



import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.xml.ws.Endpoint;

import de.uniba.rz.backend.RemoteAccess;
import de.uniba.rz.backend.TicketStore;

//.............................................................................................................................
//.WWWW..WWWWW...WWWS.SSSSSSS....DDDDDDDDD....LLLL.............SSSSSSS...............................iiii......................
//.WWWW..WWWWW..WWWW.SSSSSSSSS...DDDDDDDDDD...LLLL............SSSSSSSSS..............................iiii......................
//.WWWW..WWWWWW.WWWW.SSSSSSSSSS..DDDDDDDDDDD..LLLL............SSSSSSSSSS.......................................................
//.WWWW.WWWWWWW.WWWWSSSSS..SSSS..DDDD...DDDD..LLLL...........SSSSS..SSSS...eeeeee..errrrrrrvvv..vvvv.iiii..cccccc....eeeeee....
//.WWWW.WWWWWWW.WWWWSSSSS........DDDD....DDDD.LLLL...........SSSSS........eeeeeeee.errrrrrrvvv..vvvv.iiii.cccccccc..eeeeeeee...
//..WWWWWWWWWWW.WWW..SSSSSSS.....DDDD....DDDD.LLLL............SSSSSSS....eeee.eeee.errrr..rvvv.vvvv..iiiiicccc.ccccceee.eeee...
//..WWWWWWW.WWWWWWW...SSSSSSSSS..DDDD....DDDD.LLLL.............SSSSSSSSS.eeee..eeeeerrr....vvvvvvvv..iiiiiccc..ccc.ceee..eeee..
//..WWWWWWW.WWWWWWW.....SSSSSSS..DDDD....DDDD.LLLL...............SSSSSSS.eeeeeeeeeeerrr....vvvvvvvv..iiiiiccc......ceeeeeeeee..
//..WWWWWWW.WWWWWWW........SSSSS.DDDD....DDDD.LLLL..................SSSSSeeeeeeeeeeerrr....vvvvvvv...iiiiiccc......ceeeeeeeee..
//..WWWWWWW.WWWWWWW.SSSS....SSSS.DDDD...DDDDD.LLLL...........SSSS....SSSSeeee......errr.....vvvvvv...iiiiiccc..ccc.ceee........
//...WWWWW...WWWWW..SSSSSSSSSSSS.DDDDDDDDDDD..LLLLLLLLLL.....SSSSSSSSSSSSeeee..eeeeerrr.....vvvvvv...iiiiicccc.ccccceee..eeee..
//...WWWWW...WWWWW...SSSSSSSSSS..DDDDDDDDDD...LLLLLLLLLL......SSSSSSSSSS..eeeeeeee.errr.....vvvvv....iiii.ccccccccc.eeeeeeee...
//...WWWWW...WWWWW....SSSSSSSS...DDDDDDDDD....LLLLLLLLLL.......SSSSSSSS....eeeeee..errr......vvvv....iiii..cccccc....eeeeee....
//.............................................................................................................................
/*
 * 							Developed By Group #14 
 */

/*
 
   _    _                        _____       _   _   _                     _ 
 | |  | |                      / ____|     | | | \ | |                   (_)
 | |__| | __ _ ______ _ _ __  | |  __ _   _| | |  \| | __ _ ______ _ _ __ _ 
 |  __  |/ _` |_  / _` | '__| | | |_ | | | | | | . ` |/ _` |_  / _` | '__| |
 | |  | | (_| |/ / (_| | |    | |__| | |_| | | | |\  | (_| |/ / (_| | |  | |
 |_|  |_|\__,_/___\__,_|_|     \_____|\__,_|_| |_| \_|\__,_/___\__,_|_|  |_|
                                                                            
 
 */

public class WSDLremoteAccess implements RemoteAccess{
	
	
	public static TicketStore ticketStore;
	private Endpoint endpoint;					// For storing the Endpoint
	
	public WSDLremoteAccess() {}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		endpoint = Endpoint.publish("http://localhost:8888/ticketService", new WSticketService());
		endpoint.setExecutor(Executors.newFixedThreadPool(4));
	}

	@Override
	public void prepareStartup(TicketStore ticketStore) {
		WSDLremoteAccess.ticketStore = ticketStore;
	}

	@Override
	public void shutdown() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		endpoint.stop();
	}

}
