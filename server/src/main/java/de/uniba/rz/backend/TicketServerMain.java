package de.uniba.rz.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

public class TicketServerMain {

	public static void main(String[] args) throws IOException, NamingException {
		
		
		// Storage, updation, receiving system for tickets from clients
		TicketStore simpleTestStore = new SimpleTicketStore();

		// If we implement List of UdpAccess and JMS both
		List<RemoteAccess> remoteAccessImplementations = getAvailableRemoteAccessImplementations(args);

		// Starting remote access implementations:
		for (RemoteAccess implementation : remoteAccessImplementations) {
			
			// This method is for preparing the envirnment of JMS or UDP
			implementation.prepareStartup(simpleTestStore);
			
			// starting new thread for each one
			new Thread(implementation).start();
		}

		// for shutting down
		try (BufferedReader shutdownReader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Press enter to shutdown system.");
			shutdownReader.readLine();
			System.out.println("Shutting down...");
	
			// Shuttung down all remote access implementations
			for (RemoteAccess implementation : remoteAccessImplementations) {
				implementation.shutdown();
			}
			System.out.println("completed. Bye!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static List<RemoteAccess> getAvailableRemoteAccessImplementations(String[] args) {
		List<RemoteAccess> implementations = new ArrayList<>();
		
		
		// TODO Add your implementations of the RemoteAccess interface
		// e.g.:
		//implementations.add(new UdpAccessRemote(args[0],Integer.parseInt(args[1])));
		//implementations.add(new JmsRemoteAccess());
		//int port = Integer.valueOf(args[1]);
		
		// For now just want to see the work of gRPC's
		
		
		int port = Integer.parseInt(args[0]);
		implementations.add(new GRPCRemoteAccess(port));

		// impplemenations.add(new JmsAccessRemote(address, ports));
		
		return implementations;
	}
}
