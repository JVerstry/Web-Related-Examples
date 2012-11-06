
package com.jverstry.ErrorHandling;

public class Customized4ExceptionHandler extends Exception {
	
	private String specialMsg = "";
	
    public Customized4ExceptionHandler() {
	    super();
    }

    public Customized4ExceptionHandler(String message) {
	    this.specialMsg = "EXC.HAND.: " + message;
    }	
	
	public String getSpecialMsg() {
		return specialMsg;
	}

	public void setSpecialMsg(String specialMsg) {
		this.specialMsg = "EXC.HAND.: " + specialMsg;
	}	
	
	@Override
	public String getMessage() {
		return this.specialMsg;
	}
	
}

