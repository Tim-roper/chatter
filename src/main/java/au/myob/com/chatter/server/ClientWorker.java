package au.myob.com.chatter.server;

import au.myob.com.chatter.message.Message;
import au.myob.com.chatter.server.exception.ClientHandshakeException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ClientWorker implements Runnable {

	private String userName;
	private InputHandler inputHandler;
	private OutputHandler outputHandler;
	private ConcurrentLinkedQueue<Message> outQueue;

	ClientWorker(ConcurrentLinkedQueue<Message> masterQueue, Socket socket)
			throws IOException, ClientHandshakeException {
		this.outQueue = new ConcurrentLinkedQueue<>();
		this.inputHandler = new InputHandler(new ObjectInputStream(socket.getInputStream()), masterQueue);
		this.outputHandler = new OutputHandler(new ObjectOutputStream(socket.getOutputStream()), outQueue);
		clientHandshake();
	}

	@Override public void run() {
		this.inputHandler.run();
		this.outputHandler.run();
	}

	void addMessage(Message message) {
		this.outQueue.add(message);
	}

	public String getUserName() {
		return userName;
	}

	private void clientHandshake() throws ClientHandshakeException {
		//todo carry out handshake process and set userName
	}
}