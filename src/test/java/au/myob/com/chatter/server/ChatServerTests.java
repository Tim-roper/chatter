package au.myob.com.chatter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ChatServerTests {

	private ChatServer chatServer;

	@Before
	public void setUp() throws Exception {
		chatServer = new ChatServer();
	}

	@Test
	public void ServerStarts() {
		assertTrue(chatServer.isOnline());
	}

	@Test
	public void ServerAcceptsClientConnection() {

	}

	@Test
	public void ServerRegistersClient() {

	}

	@Test
	public void ServerShutsDown() {
	}
}
