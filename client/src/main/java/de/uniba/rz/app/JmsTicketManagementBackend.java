package de.uniba.rz.app;

import com.sun.messaging.QueueConnectionFactory;
import de.uniba.rz.entities.*;
import de.uniba.rz.entities.QueueSender;

import javax.jms.*;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class JmsTicketManagementBackend implements TicketManagementBackend  {


    HashMap<Integer, Ticket> localTicketStore = new HashMap<>();

    AtomicInteger nextId;

    public JmsTicketManagementBackend() {
        nextId = new AtomicInteger(1);
    }

    @Override
    public void triggerShutdown() {
        // local implementation is in memory only - no need to close connections
        // and free resources

    }

    @Override
    public Ticket createNewTicket(String reporter, String topic, String description, Type type, Priority priority) {

        Ticket newTicket = new Ticket(nextId.getAndIncrement(), reporter, topic, description, type, priority);
        localTicketStore.put(newTicket.getId(), newTicket);
        System.out.println(newTicket.getId()+" iddd");


        try {

            Hashtable<String, String> contextParams = new Hashtable<>();

            // For use with the File System JNDI Service Provider
            contextParams.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");

            // TODO adjust this line if you have not set the storage to
            // "file:///C:/TEMP/Object_Store_Output"

            contextParams.put(Context.PROVIDER_URL, "file:///C://Object_Store_Output");

            // Create Context for JNDI lookup
            Context ctx = new InitialContext(contextParams);

            // Create QueueSender (see class implementation)
            QueueSender sender = new QueueSender(ctx, "myQueueConnectionFactory", "queueObject");

            System.out.println("Sending some message to Queue " + "myQueueConnectionFactory");
            sender.sendMessage("Hallo Server!, I am connected to you and sending ticket information.");
            // create packet
            //here all the data of new ticket will be send to the server
            for(Map.Entry m:localTicketStore.entrySet()) {
                String content = String.valueOf(m.getValue());

                sender.sendMessage(content);
            }

            System.out.println("Finished sending.");

        } catch (NamingException e) {
            System.out.println("JNDI Problem. Check used hostname and/or " + "Glassfish configuration.");
            e.printStackTrace();
        }

        return (Ticket) newTicket;

    }

    @Override
    public List<Ticket> getAllTickets() throws TicketException {
        return localTicketStore.entrySet().stream().map(entry -> (Ticket) entry.getValue().clone())
                .collect(Collectors.toList());
    }

    @Override
    public Ticket getTicketById(int id) throws TicketException {
        if (!localTicketStore.containsKey(id)) {
            throw new TicketException("Ticket ID is unknown");
        }

        return (Ticket) getTicketByIdInteral(id).clone();
    }

    private Ticket getTicketByIdInteral(int id) throws TicketException {
        if (!localTicketStore.containsKey(id)) {
            throw new TicketException("Ticket ID is unknown");
        }

        return localTicketStore.get(id);
    }

    @Override
    public Ticket acceptTicket(int id) throws TicketException {

        Ticket ticketToModify = getTicketByIdInteral(id);
        if (ticketToModify.getStatus() != Status.NEW) {
            throw new TicketException(
                    "Can not accept Ticket as it is currently in status " + ticketToModify.getStatus());
        }

        ticketToModify.setStatus(Status.ACCEPTED);
        return (Ticket) ticketToModify.clone();
    }

    @Override
    public Ticket rejectTicket(int id) throws TicketException {

        Ticket ticketToModify = getTicketByIdInteral(id);
        if (ticketToModify.getStatus() != Status.NEW) {
            throw new TicketException(
                    "Can not reject Ticket as it is currently in status " + ticketToModify.getStatus());
        }

        ticketToModify.setStatus(Status.REJECTED);
        return (Ticket) ticketToModify.clone();
    }

    @Override
    public Ticket closeTicket(int id) throws TicketException {

        Ticket ticketToModify = getTicketByIdInteral(id);
        if (ticketToModify.getStatus() != Status.ACCEPTED) {
            throw new TicketException(
                    "Can not close Ticket as it is currently in status " + ticketToModify.getStatus());
        }

        ticketToModify.setStatus(Status.CLOSED);
        return (Ticket) ticketToModify.clone();
    }
}

