package it.peruvianit.exception;

import it.peruvianit.commons.exception.IException;

public class IncorrectCredentialsException extends Exception implements IException<IncorrectCredentialsException> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4064605798689582965L;

	public IncorrectCredentialsException() {
	}

	public IncorrectCredentialsException(final String message) {
		super(message);
	}

	public IncorrectCredentialsException(final Throwable cause) {
		super(cause);
	}

	public IncorrectCredentialsException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public IncorrectCredentialsException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
