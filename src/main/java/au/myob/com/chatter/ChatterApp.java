package au.myob.com.chatter;

import au.myob.com.chatter.server.ChatServer;

public class ChatterApp {

	public static void main(String args[]) {
		if(args[0].equals(Constants.InputArgs.START_SERVER_MODE)) {
			ChatServer server = new ChatServer();
		}
	}

}
