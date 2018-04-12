package au.myob.com.chatter.protocol;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ChatterProtocol {

	public static final String CLIENT_CONNECT_REQUEST = "CONNECT-REQUEST";
	public static final String SERVER_ACCEPT = "CONNECT-ACCEPT";

	private static final String[] COMMAND_VALUES = new String[] {
			CLIENT_CONNECT_REQUEST,
			SERVER_ACCEPT
	};

	private static final Set<String> protocolCommands = new HashSet<>(Arrays.asList(COMMAND_VALUES));

	public static boolean isValidCommand(String command) {
		return protocolCommands.contains(command);
	}
}
