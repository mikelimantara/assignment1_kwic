package pipes_and_filters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoiseWordFilter implements Filter {
	private ArrayList<String> noiseWords = new ArrayList<String>();
	private Pipe outgoingPipe;
	
	public NoiseWordFilter(Pipe outgoingPipe) {
		this.outgoingPipe = outgoingPipe;
	}
	
	@Override
	public void processDataAndPushResult(String input) {
		String stringToPush = processDataAndReturnResult(input);
		if (stringToPush != null) {
			outgoingPipe.addData(stringToPush);
		}
	}

	public String processDataAndReturnResult(String input) {
		// get first word
		int firstSpaceIndex = input.indexOf(' ');
		String firstWord = input.substring(0, firstSpaceIndex);
		
		// standardize format
		firstWord = standardFormat(firstWord);
		int insertIndex = Collections.binarySearch(noiseWords, firstWord);
		
		if (!noiseWords.get(insertIndex).equals(firstWord)) {
			return input;
		} else {
			return null;
		}
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
