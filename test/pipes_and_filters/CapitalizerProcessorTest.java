package pipes_and_filters;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import commons.CapitalizerProcessor;

public class CapitalizerProcessorTest {
	private CapitalizerProcessor processor;

	@Before
	public void init() {
		processor = new CapitalizerProcessor();
	}
	
	@After
	public void destroy() {
		processor = null;
	}
	
	
	@Test
	public void testCapitalizeKeyword() {
		String testSentence = "aBcd e F G h";
		String expected = "ABCD e f g h";	
		String output = processor.capitalizeSentence(testSentence);
		assertEquals(expected, output);
	}
	
	@Test
	public void testOneWord() {
		String testWord = "Nothing";
		String expected = "NOTHING";
		String output = processor.capitalizeSentence(testWord);
		assertEquals(expected, output);
	}
	
}
