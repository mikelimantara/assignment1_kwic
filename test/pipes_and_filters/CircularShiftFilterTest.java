package pipes_and_filters;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CircularShiftFilterTest {
	
	CircularShiftFilter filter;
	
	@Before
	public void init() {
		filter = new CircularShiftFilter();
	}
	
	@After
	public void destroy() {
		filter = null;
	}
	
	@Test
	public void testCircularShift() throws Exception {
		String input = "The quick brown fox jumps over the lazy dog";
		String[] expectedStrings = {
				"The quick brown fox jumps over the lazy dog", 
				"quick brown fox jumps over the lazy dog The",
				"brown fox jumps over the lazy dog The quick",
				"fox jumps over the lazy dog The quick brown",
				"jumps over the lazy dog The quick brown fox",
				"over the lazy dog The quick brown fox jumps",
				"the lazy dog The quick brown fox jumps over",
				"lazy dog The quick brown fox jumps over the",
				"dog The quick brown fox jumps over the lazy"
		};
		
		ArrayList<String> stringResults = filter.processDataAndReturnResult(input);
		
		boolean isCorrect = true;
		
		for (String expected: expectedStrings) {
			isCorrect = isCorrect && stringResults.contains(expected);
		}
		
		assertTrue(isCorrect);
	}

}
