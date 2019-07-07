package de.uniba.rz.backend;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import de.uniba.rz.entities.QueueReceiver;

import java.util.Hashtable;
import java.util.Scanner;

public class JmsRemoteAccess implements  RemoteAccess{

    public Context ctx;
    public Hashtable<String, String> contextParams;
    public JmsRemoteAccess(){

    }

    @Override

    public void shutdown(){

    }


    @Override
    public void run(){

        try{

            // Create Context for JNDI lookup
            ctx = new InitialContext(contextParams);

            // Create QueueReceiver (see class implementation)
            QueueReceiver server = new QueueReceiver(ctx, "myQueueConnectionFactory", "queueObject");
            // as QueueReceiver extends Thread, the Thread should be started
            server.start();

            // Wait for Input to shutdown the Server properly
            Scanner scanner = new Scanner(System.in);
            System.out.println("Hit Enter to stop the server.");
            scanner.nextLine();
            scanner.close();
            server.stopServer();
        } catch (NamingException e) {
            System.out.println("JNDI Problem. Check used hostname and/or "
                    + "Glassfish configuration.");
            e.printStackTrace();
        }

    }
    @Override
    public  void prepareStartup(TicketStore ticketStore){

        this.contextParams = new Hashtable<>();

        // For use with the File System JNDI Service Provider
        contextParams.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.fscontext.RefFSContextFactory");
        // TODO adjust this line if you have not set the storage to "file:///C:/TEMP/JndiStorage"
        contextParams.put(Context.PROVIDER_URL, "file:///C:/Object_Store_Output");


    }
}
