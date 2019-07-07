package de.uniba.rz.entities;

import java.io.Serializable;

public class PacketWrapper implements Serializable {

	private static final long serialVersionUID = -6979364632920616228L;
	
	private String messageType;
	
	private Object message;
	
	public PacketWrapper(String messageType, Object message) {
		this.messageType = messageType;
		this.message = message;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public String getMessageType() {
		return messageType;
	}
	
}
