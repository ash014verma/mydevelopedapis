package com.ashish.design.system.project.lms;

public class LMSSystemException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LMSSystemException() {
		super();
	}
	public LMSSystemException(String message) {
		super(message);
	}
	public LMSSystemException(Throwable t) {
		super(t);
	}
	public LMSSystemException(String message, Throwable t) {
		super(message, t);
	}
}
