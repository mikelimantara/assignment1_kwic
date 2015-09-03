package commons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @author: Andhieka Putra (A0113672L)
 */
public class NoiseWordProcessor implements SentenceProcessor {
	private ArrayList<String> noiseWords = new ArrayList<String>();
	private SentenceProcessorDelegate delegate = null;
	
	@Override
	public void processData(String input) {
		boolean isBlocked = beginsWithNoiseWord(input);
		if (!isBlocked) {
			delegate.processorDidFinishProcessing(this, input);	
		}
	}

	public boolean beginsWithNoiseWord(String input) {
		// get first word
		int firstSpaceIndex = input.indexOf(' ');
		if (firstSpaceIndex < 0) {
			firstSpaceIndex = input.length();
		}
		String firstWord = input.substring(0, firstSpaceIndex);

		// standardize format
		firstWord = standardFormat(firstWord);
		int insertIndex = Collections.binarySearch(noiseWords, firstWord);

		if (insertIndex >= 0 && insertIndex < noiseWords.size() && noiseWords.get(insertIndex).equals(firstWord)) {
			return true;
		}
		return false;
	}
	
	@Override
	public void setDelegate(SentenceProcessorDelegate delegate) {
		this.delegate = delegate;
	}

	public void setNoiseWordList(List<String> noiseWords) {
		for (String word: noiseWords) {
			this.noiseWords.add(standardFormat(word));
		}
		Collections.sort(this.noiseWords);
	}
	
	private String standardFormat(String word) {
		word = word.trim();
		word = word.toLowerCase();
		return word;
	}
}
