
package com.jverstry.Configuration.Service;

public class MyServiceImpl implements MyService {

	@Override
	public long getCurrentTimeInMilliseconds() {
		return System.currentTimeMillis();
	}
	
}
