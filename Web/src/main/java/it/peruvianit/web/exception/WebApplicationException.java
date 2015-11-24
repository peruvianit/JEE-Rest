package it.peruvianit.web.exception;

import it.peruvianit.commons.exception.IException;

public class WebApplicationException extends Exception implements IException<WebApplicationException> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4064605798689582965L;

	public WebApplicationException() {
	}

	public WebApplicationException(final String message) {
		super(message);
	}

	public WebApplicationException(final Throwable cause) {
		super(cause);
	}

	public WebApplicationException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public WebApplicationException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
