package au.myob.com.chatter.server;

import au.myob.com.chatter.protocol.ChatterProtocol;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

public class ChatServerMasterTests {

	@Test
	public void shouldAcceptClientConnection() throws IOException {
		//given
		int port = 43829;
		int maxClients = 1;
		ChatServerMaster chatServerMaster = new ChatServerMaster(maxClients, port);
		Thread serverThread = new Thread(chatServerMaster);
		serverThread.start();
		Socket socket = new Socket("localhost", port);
		PrintWriter socketWriter = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//When
		socketWriter.println(ChatterProtocol.CLIENT_CONNECT_REQUEST);

		//Then
		String response = socketReader.readLine();
		assertEquals(response, ChatterProtocol.SERVER_ACCEPT);
	}
}
