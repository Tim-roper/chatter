package au.myob.com.chatter.server;

import au.myob.com.chatter.message.Message;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ChatServer {

	public ChatServer() {
		ConcurrentLinkedQueue<Message> masterMessageQueue = new ConcurrentLinkedQueue<>();
		try {
			new ClientManager(5, 53921, masterMessageQueue).run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
