package au.myob.com.chatter.message;

public class Message {

	private MessageType type;
	private MessageContent content;

	public Message(MessageType type, MessageContent content) {
		this.type = type;
		this.content = content;
	}

	public MessageType getType() {
		return type;
	}

	public MessageContent getContent() {
		return this.content;
	}

	public boolean isProtocolCommand() {
		return this.type.equals(MessageType.PROTOCOL_COMMAND);
	}
}

