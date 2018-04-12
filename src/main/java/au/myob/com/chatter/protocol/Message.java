package au.myob.com.chatter.server.protocol;

public interface Message {
	boolean parse();
	ChatterProtocolCommand getCommand();
}
