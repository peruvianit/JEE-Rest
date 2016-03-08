package it.peruvianit.commons.exception;

import it.peruvianit.commons.exception.IException;

public class CommonsException extends Exception implements IException<CommonsException> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4064605798689582965L;

	public CommonsException() {
	}

	public CommonsException(final String message) {
		super(message);
	}

	public CommonsException(final Throwable cause) {
		super(cause);
	}

	public CommonsException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public CommonsException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
