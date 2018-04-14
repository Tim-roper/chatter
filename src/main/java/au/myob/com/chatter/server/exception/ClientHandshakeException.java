package au.myob.com.chatter.server.exception;

public class ClientHandshakeException extends Exception {
	private String reason;

	public ClientHandshakeException(String reason) {
		this.reason = reason;
	}
}
