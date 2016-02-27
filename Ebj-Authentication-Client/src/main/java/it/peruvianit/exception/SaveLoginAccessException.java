package it.peruvianit.exception;

import it.peruvianit.commons.exception.IException;

public class SaveLoginAccessException extends Exception implements IException<SaveLoginAccessException> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4064605798689582965L;

	public SaveLoginAccessException() {
	}

	public SaveLoginAccessException(final String message) {
		super(message);
	}

	public SaveLoginAccessException(final Throwable cause) {
		super(cause);
	}

	public SaveLoginAccessException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public SaveLoginAccessException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
