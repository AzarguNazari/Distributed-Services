package de.uniba.rz.entities;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.NamingException;

public class QueueSender {

	ConnectionFactory connFactory;
	Destination destination;

	public QueueSender(Context ctx, String connFactoryName, String queueName)
			throws NamingException {

		// Look up the connection factory object in the JNDI context provided
		connFactory = (ConnectionFactory) ctx.lookup(connFactoryName);
		
		// Look up the Destination in the JNDI context
		destination = (Destination) ctx.lookup(queueName);
	}

	public void sendMessage(String message) {
		// Create JMSContext
		try (JMSContext jmsContext = connFactory.createContext()) {
			System.out.println("\t [SENDER]: Sending Message '"+message+"'");
			// Create a Producer and use it to send a TextMessage
			jmsContext.createProducer().send(destination, message);
		}
	}
	
	public void sendAnEvilMessage() {
		// Create JMSContext
		try (JMSContext jmsContext = connFactory.createContext()) {
			System.out.println("\t [SENDER]: Sending 'evil' ObjectMessage");
			// Create a Producer to send a ObjectMessage
			jmsContext.createProducer().send(destination, new Integer(0));
		}
	}

}
