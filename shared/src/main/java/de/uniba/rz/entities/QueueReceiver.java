package de.uniba.rz.entities;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.NamingException;

public class QueueReceiver extends Thread {
	private ConnectionFactory connFactory;
	private Destination destination;

	private boolean active;

	public QueueReceiver(Context ctx, String connFactoryName, String queueName)
			throws NamingException {

		// Look up the connection factory object in the JNDI context provided
		connFactory = (ConnectionFactory) ctx.lookup(connFactoryName);

		// Look up the Destination in the JNDI context
		destination = (Destination) ctx.lookup(queueName);
	}

	private void startServer() {
		System.out.println("\t [RECEIVER]: Start waiting for messages");
		active = true;
		// Create JMS Context
		try (JMSContext jmsContext = connFactory.createContext()) {
			// Create a JMSConsumer to receive message
			JMSConsumer consumer = jmsContext.createConsumer(destination);
			while (active) {
				// Receive a TextMessage (-> String.class)
				// blocks for 5000ms
				String message = consumer.receiveBody(String.class, 5000);
				// if no message is received with 5 secs messsage == null
				if (message != null) {
					System.out.println("\t [RECEIVER]: >Received: " + message);
				}
			}
		}
		System.out.println("\t [RECEIVER]: Stopped.");
	}

	public void stopServer() {
		active = false;
		System.out.println("\t [RECEIVER]: Stopping to listen for messages.");
	}

	@Override
	public void run() {
		startServer();
	}
}
