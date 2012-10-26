
package com.jverstry.Controller;

import com.jverstry.Configuration.JpaTestConfig;
import com.jverstry.Configuration.TestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.server.MockMvc;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;
import org.springframework.test.web.server.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ JpaTestConfig.class, TestConfig.class })
public class MyControllerTest {
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		
		mockMvc = MockMvcBuilders
			.annotationConfigSetup(JpaTestConfig.class, TestConfig.class)
				.build();
	}
  
	@Test
	public void testHome() throws Exception {
	
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("WEB-INF/pages/index.jsp"));
		
	}
	
	@Test
	public void testPersistenceStatus() throws Exception {
	
		mockMvc.perform(get("/roundtrip"))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("WEB-INF/pages/roundtrip.jsp"))
			.andExpect(model().attributeExists("RoundTrip"));
		
	}
	
}
