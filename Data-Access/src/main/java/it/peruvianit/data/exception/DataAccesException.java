package it.peruvianit.data.exception;

import it.peruvianit.commons.exception.IException;

public class DataAccesException extends Exception implements IException<DataAccesException> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4064605798689582965L;

	public DataAccesException() {
	}

	public DataAccesException(final String message) {
		super(message);
	}

	public DataAccesException(final Throwable cause) {
		super(cause);
	}

	public DataAccesException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public DataAccesException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
