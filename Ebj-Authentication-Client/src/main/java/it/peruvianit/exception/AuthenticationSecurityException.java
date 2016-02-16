package it.peruvianit.exception;

import it.peruvianit.commons.exception.IException;

public class AuthenticationSecurityException extends Exception implements IException<AuthenticationSecurityException> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4064605798689582965L;

	public AuthenticationSecurityException() {
	}

	public AuthenticationSecurityException(final String message) {
		super(message);
	}

	public AuthenticationSecurityException(final Throwable cause) {
		super(cause);
	}

	public AuthenticationSecurityException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public AuthenticationSecurityException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
