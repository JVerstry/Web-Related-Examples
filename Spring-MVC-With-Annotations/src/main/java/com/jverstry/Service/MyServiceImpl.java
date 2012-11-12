
package com.jverstry.Service;

public class MyServiceImpl implements MyService {

	@Override
	public long getCurrentTimeInMilliseconds() {
		return System.currentTimeMillis();
	}
	
}
