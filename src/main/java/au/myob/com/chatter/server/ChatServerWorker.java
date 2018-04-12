package au.myob.com.chatter.server;

import au.myob.com.chatter.protocol.ChatterProtocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatServerWorker implements Runnable {

	private final Socket socket;

	ChatServerWorker(Socket socket) {
		this.socket = socket;
	}

	@Override public void run() {
		try {
			InputStreamReader socketReader = new InputStreamReader(socket.getInputStream());
			BufferedReader inputBuff = new BufferedReader(socketReader);
			String input = inputBuff.readLine();
			if (input.contentEquals(ChatterProtocol.CLIENT_CONNECT_REQUEST)) {
				PrintWriter outWriter = new PrintWriter(socket.getOutputStream(), true);
				outWriter.println(ChatterProtocol.SERVER_ACCEPT);
			}
		} catch (IOException e) {

		}
	}
}
