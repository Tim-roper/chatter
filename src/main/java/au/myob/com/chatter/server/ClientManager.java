package au.myob.com.chatter.server;

import au.myob.com.chatter.message.Message;
import au.myob.com.chatter.server.exception.ClientHandshakeException;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientManager implements Runnable {

	private final ExecutorService pool;
	private final ServerSocket serverSocket;
	private ConcurrentLinkedQueue<Message> masterQueue;
	private List<ClientWorker> clientWorkers;

	ClientManager(int maxClients, int serverPort, ConcurrentLinkedQueue<Message> masterMessageQueue) throws IOException {
		pool = Executors.newFixedThreadPool(maxClients);
		serverSocket = new ServerSocket(serverPort);
		clientWorkers = new LinkedList<>();
		masterQueue = masterMessageQueue;
	}

	@Override
	public void run() {
		try {
			Socket newSocket = serverSocket.accept();
			try {
				ClientWorker newClient = new ClientWorker(masterQueue, newSocket);
				pool.execute(newClient);
				clientWorkers.add(newClient);
			} catch (ClientHandshakeException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			pool.shutdown();
		}
	}

	public void broadCast(Message message) {
		this.clientWorkers.forEach(clientWorker -> clientWorker.addMessage(message));
	}

}
