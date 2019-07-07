package de.uniba.rz.entities;

import java.util.Hashtable;
import java.util.Properties;

import javax.annotation.Resource;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.Queue;
import com.sun.messaging.jms.Connection;
import com.sun.messaging.jms.Session;
public class MessageSender {
	

	@Resource(mappedName = "jms/myConnectionFactory")
	private static ConnectionFactory connectionFactory;
	@Resource(mappedName = "jms/subQueue")
	private static Queue queue;

	public void produceMessages() throws NamingException {
		MessageProducer messageProducer;
		TextMessage textMessage;
		try {

//			Properties props = new Properties();
//			props.put("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
//			props.put("java.naming.factory.state", "com.sun.enterprise.naming");
//			Context initialContext = new InitialContext(props);
		    
			Connection connection = (Connection) connectionFactory.createConnection();
			
			Session session = (Session) connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			messageProducer = session.createProducer(queue);

			textMessage = session.createTextMessage();
			textMessage.setText("Testing, 1, 2, 3. Can you hear me?");

			System.out.println("Sending the following message: " + textMessage.getText());

			messageProducer.send(textMessage);
			textMessage.setText("Do you copy?");
			System.out.println("Sending the following message: " + textMessage.getText());
			messageProducer.send(textMessage);
			textMessage.setText("Good bye!");
			System.out.println("Sending the following message: " + textMessage.getText());
			messageProducer.send(textMessage);
			messageProducer.close();
			session.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws NamingException {
		new MessageSender().produceMessages();
	}
}