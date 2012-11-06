
package com.jverstry.ErrorHandling;

public class CustomizedException2 extends Exception {
	
	private String specialMsg2 = "";
	
    public CustomizedException2() {
	    super();
    }

    public CustomizedException2(String message) {
	    this.specialMsg2 = "PREFIX: " + message;
    }	
	
	public String getSpecialMsg2() {
		return specialMsg2;
	}

	public void setSpecialMsg2(String specialMsg2) {
		this.specialMsg2 = "PREFIX: " + specialMsg2;
	}	
	
	@Override
	public String getMessage() {
		return this.specialMsg2;
	}
	
}