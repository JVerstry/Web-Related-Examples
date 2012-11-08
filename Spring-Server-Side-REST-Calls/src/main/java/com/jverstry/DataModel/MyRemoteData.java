
package com.jverstry.DataModel;

public class MyRemoteData {
	
	private String data = "";
	
	public MyRemoteData() { }
	
	public MyRemoteData(String message) {
        this.data = message;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
