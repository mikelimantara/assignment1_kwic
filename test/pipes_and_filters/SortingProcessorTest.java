package pipes_and_filters;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import commons.SortingProcessor;

import org.junit.Before;
import org.junit.After;

public class SortingProcessorTest {
	SortingProcessor processor;

	@Before
	public void init() throws Exception {
		processor = new SortingProcessor();
	}
	
	@After
	public void destroy() throws Exception {
		processor = null;
	}
	
	
	@Test
	public void testOne() {
		processor.processData("Hello world");
		processor.processData("The quick brown fox");
		processor.processData("Michael");
		processor.processData("Andhieka");
		List<String> output = processor.getSentences();
		
		assertEquals(output.get(0), "Andhieka");
		assertEquals(output.get(1), "Hello world");
		assertEquals(output.get(2), "Michael");
		assertEquals(output.get(3), "The quick brown fox");
	}

}
