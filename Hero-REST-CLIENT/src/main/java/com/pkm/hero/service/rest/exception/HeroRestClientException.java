package com.pkm.hero.service.rest.exception;

public class HeroRestClientException extends Exception {

	/** Serial Version UID */
	private static final long serialVersionUID = -2464955620744822179L;

	/**
	 * Default Constructor
	 */
	public HeroRestClientException() {
		super();
	}

	/**
	 * Constructor with message
	 * 
	 * @param message
	 */
	public HeroRestClientException(String message) {
		super(message);
	}

	/**
	 * Constructor with throwable
	 * 
	 * @param cause
	 */
	public HeroRestClientException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor with message and throwable
	 * 
	 * @param message
	 * @param cause
	 */
	public HeroRestClientException(String message, Throwable cause) {
		super(message, cause);
	}
}
