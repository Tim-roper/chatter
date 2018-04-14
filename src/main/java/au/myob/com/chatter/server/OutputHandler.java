package au.myob.com.chatter.server;

import au.myob.com.chatter.message.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OutputHandler implements Runnable {

	private ObjectOutputStream outputStream;
	private ConcurrentLinkedQueue<Message> outQueue;

	OutputHandler(ObjectOutputStream outputStream, ConcurrentLinkedQueue<Message> outQueue) {
		this.outputStream = outputStream;
		this.outQueue = outQueue;
	}

	@Override
	public void run() {
		do {
			try {
				outputStream.writeObject(outQueue.poll());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while(!outQueue.isEmpty());
	}

}
