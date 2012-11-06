
package com.jverstry.ErrorHandling;

public class CustomizedException1 extends Exception {
	
	private String specialMsg;
	
    public CustomizedException1() {
	    super();
    }

    public CustomizedException1(String message) {
	    this.specialMsg = System.currentTimeMillis()
			+ ": " + message; 
    }	

	public String getSpecialMsg() {
		return specialMsg;
	}

	public void setSpecialMsg(String specialMsg) {
		this.specialMsg = System.currentTimeMillis()
			+ ": " + specialMsg;
	}

	@Override
	public String getMessage() {
		return this.specialMsg;
	}
	
}

