package au.myob.com.chatter.server.protocol;

public class CommandMessage implements Message{

	String command;

	public CommandMessage(String input) {

	}

	@Override public boolean parse() {
		return false;
	}

	@Override public ChatterProtocolCommand getCommand() {
		return null;
	}

}
