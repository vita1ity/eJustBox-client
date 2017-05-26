package org.crama.ejustbox.error;

import org.crama.ejustbox.model.consultation.SystemErrorType;

public class EJustBoxClientException extends Exception {

	private static final long serialVersionUID = -5563785126868455160L;

	private SystemErrorType systemError;

	public EJustBoxClientException(SystemErrorType systemError) {
		super();
		this.systemError = systemError;
	}

	public SystemErrorType getSystemError() {
		return systemError;
	}

	public void setSystemError(SystemErrorType systemError) {
		this.systemError = systemError;
	}
	
	
	
}
