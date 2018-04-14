package au.myob.com.chatter.server;

import au.myob.com.chatter.message.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.ConcurrentLinkedQueue;

public class InputHandler implements Runnable{

	private ObjectInputStream inputStream;
	private ConcurrentLinkedQueue<Message> masterQueue;

	InputHandler(ObjectInputStream inputStream, ConcurrentLinkedQueue<Message> masterQueue) {
		this.inputStream = inputStream;
		this.masterQueue = masterQueue;
	}

	@Override
	public void run() {
		do {
			try {
				Message inputMessage = (Message) inputStream.readObject();
				masterQueue.add(inputMessage);
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} while (!shouldExit());
	}

	private boolean shouldExit() {
		return false;
	}

}
