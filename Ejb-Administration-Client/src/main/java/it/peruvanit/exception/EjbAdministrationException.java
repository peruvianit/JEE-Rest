package it.peruvanit.exception;

import it.peruvianit.commons.exception.IException;

public class EjbAdministrationException extends Exception implements IException<EjbAdministrationException> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 371706989445400114L;

	public EjbAdministrationException() {
	}

	public EjbAdministrationException(final String message) {
		super(message);
	}

	public EjbAdministrationException(final Throwable cause) {
		super(cause);
	}

	public EjbAdministrationException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public EjbAdministrationException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
