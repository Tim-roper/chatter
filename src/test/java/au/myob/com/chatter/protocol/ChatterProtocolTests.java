package au.myob.com.chatter.protocol;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChatterProtocolTests {

	@Test
	public void checksCommandIsValid() {
		String validCommand = ChatterProtocol.CLIENT_CONNECT_REQUEST;
		assertTrue(ChatterProtocol.isValidCommand(validCommand));
	}

	@Test
	public void checksCommandIsInvalid() {
		String validCommand = "InNoWayIsThisValid";
		assertFalse(ChatterProtocol.isValidCommand(validCommand));
	}
}
