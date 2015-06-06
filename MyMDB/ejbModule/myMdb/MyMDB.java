package myMdb;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.ejb.ActivationConfigProperty;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "providerAdapterJNDI", propertyValue = "WSIBMMQJMSProvider"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "MyRemoteQueue"),
		@ActivationConfigProperty(propertyName = "useDLQ", propertyValue = "false"),
		@ActivationConfigProperty(propertyName = "reconnectAttempts", propertyValue = "60"),
		@ActivationConfigProperty(propertyName = "reconnectInterval", propertyValue = "10") })
public class MyMDB implements MessageListener {

	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.println("\n\n\t Message Received by MDB : "
					+ textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
