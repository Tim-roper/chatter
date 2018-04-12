package au.myob.com.chatter.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServerMaster implements Runnable{

	private final ExecutorService pool;
	private final ServerSocket serverSocket;

	public ChatServerMaster(int maxClients, int serverPort) throws IOException {
		pool = Executors.newFixedThreadPool(maxClients);
		serverSocket = new ServerSocket(serverPort);
	}

	@Override
	public void run() {
		try {
			Socket newSocket = serverSocket.accept();
			pool.execute(new ChatServerWorker(newSocket));
		} catch (IOException e) {
			pool.shutdown();
		}
	}
}
