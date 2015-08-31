package pipes_and_filters;

import java.util.ArrayList;

public class CircularShiftProcessor implements SentenceProcessor {
	private StringBuilder stringBuilder;
	private SentenceProcessorDelegate delegate;
	
	public CircularShiftProcessor() {
		this.stringBuilder = new StringBuilder();
	}

	@Override
	public void processData(String input) {
		ArrayList<String> stringResults = permutationsOfSentence(input);
		for(String result: stringResults) {
			delegate.processorDidFinishProcessing(this, result);
		}
	}
	
	public ArrayList<String> permutationsOfSentence(String input) {
		// Separate each word in the sentence into array
		String[] listOfWords = input.split(" ");
		ArrayList<String> stringResults = new ArrayList<String>();
		for (int i = 0; i < listOfWords.length; i++) {
			for (int j = 0; j < listOfWords.length; j++) {
				// Build the string based on the starting point of index i wrapped around
				stringBuilder.append(listOfWords[(i+j) % listOfWords.length]);
				if (j < listOfWords.length - 1)  {
					stringBuilder.append(" ");
				}
			}
			// Pass the data to outgoing pipe
			stringResults.add(stringBuilder.toString());
			// Clear the string builder
			stringBuilder.setLength(0);
		}
		return stringResults;	
	}

	@Override
	public void setDelegate(SentenceProcessorDelegate delegate) {
		this.delegate = delegate;
	}
	
}
