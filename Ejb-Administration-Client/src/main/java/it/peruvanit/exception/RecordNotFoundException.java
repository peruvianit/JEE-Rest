package it.peruvanit.exception;

import it.peruvianit.commons.exception.IException;

public class RecordNotFoundException extends Exception implements IException<RecordNotFoundException> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 371706989445400114L;

	public RecordNotFoundException() {
	}

	public RecordNotFoundException(final String message) {
		super(message);
	}

	public RecordNotFoundException(final Throwable cause) {
		super(cause);
	}

	public RecordNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public RecordNotFoundException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
