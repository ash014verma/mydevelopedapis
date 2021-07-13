package com.ashish.apps.urlshortener.exception;

public class UrlShortenerException extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7423017645704123420L;
	
	public UrlShortenerException() {
		
	}
	public UrlShortenerException(String message) {
		super(message);
	}
	public UrlShortenerException(Throwable th) {
		super(th);
	}
	public UrlShortenerException(String message, Throwable th) {
		super(message, th);
	}
}
