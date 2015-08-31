package pipes_and_filters;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import commons.NoiseWordProcessor;


public class NoiseWordProcessorTest {
	NoiseWordProcessor processor;
	String[] testSentences = {
			"Hello world",
			"The quick brown fox jumps over the lazy dog",
			"andhieka@icloud.com is my email",
			"Mike123 Limantara"
	};
	
	@Before
	public void init() throws Exception {
		processor = new NoiseWordProcessor();
	}
	
	@After
	public void destroy() throws Exception {
		processor = null;
	}
	
	@Test
	public void testWithoutNoiseWord() {
		for (String sentence: testSentences) {
			boolean isBlocked = processor.beginsWithNoiseWord(sentence);
			assertFalse(isBlocked);
		}
	}

	@Test
	public void testPassAllInput() {
		String[] noiseWords = {
				"Unicorn ", "Michael", "Halo"
		};
		processor.setNoiseWordList(Arrays.asList(noiseWords));
		for (String sentence: testSentences) {
			boolean isBlocked = processor.beginsWithNoiseWord(sentence);
			assertFalse(isBlocked);
		}
	}
	
	@Test
	public void testBlockAllInput() {
		String[] noiseWords = {
				"hello ", "MIKE123", "tHe  ", " andhieka@iclOud.com "
		};
		processor.setNoiseWordList(Arrays.asList(noiseWords));
		
		for (String sentence: testSentences) {
			boolean isBlocked = processor.beginsWithNoiseWord(sentence);
			assertTrue(isBlocked);
		}
	}
}
