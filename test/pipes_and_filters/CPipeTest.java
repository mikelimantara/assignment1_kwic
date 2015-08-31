package pipes_and_filters;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CPipeTest {
	private CPipe pipe;
	
	@Before
	public void init() {
		pipe = new CPipe();
	}
	
	@After
	public void destroy() {
		pipe = null;
	}
	
	@Test
	public void testAppendingData() throws Exception {
		String[] testData = {"One", "Two", "Three"};
		
		for (int i = 0; i < testData.length; i++) {
			pipe.addData(testData[i]);
			assertEquals(testData[i], pipe.getDataAtPosition(i));
			assertEquals(i+1, pipe.getDataBufferSize());
		}
	}

}
