package pipes_and_filters;

import java.util.ArrayList;

public class CircularShiftFilter implements Filter {
	
	private Pipe incomingPipe;
	private Pipe outgoingPipe;
	private StringBuilder stringBuilder;
	
	public CircularShiftFilter() {
		this.stringBuilder = new StringBuilder();
	}
	
	@Override
	public void setOutgoingPipe(Pipe outgoingPipe) {
		this.outgoingPipe = outgoingPipe;
	}

	@Override
	public void processDataAndPushResult(String input) {
		// Separate each word in the sentence into array
		String[] listOfWords = input.split(" ");
		
		for (int i = 0; i < listOfWords.length; i++) {
			for (int j = 0; j < listOfWords.length; j++) {
				// Build the string based on the starting point of index i wrapped around
				stringBuilder.append(listOfWords[(i+j) % listOfWords.length]);
				if (j < listOfWords.length - 1)  {
					stringBuilder.append(" ");
				}
			}
			
			// Pass the data to outgoing pipe
			outgoingPipe.addData(stringBuilder.toString());
			
			// Clear the string builder
			stringBuilder.setLength(0);
		}
	}
	
	public ArrayList<String> processDataAndReturnResult(String input) {
		String[] listOfWords = input.split(" ");
		ArrayList<String> stringResults = new ArrayList<String>();
		for (int i = 0; i < listOfWords.length; i++) {
			for (int j = 0; j < listOfWords.length; j++) {
				stringBuilder.append(listOfWords[(i+j) % listOfWords.length]);
				if (j < listOfWords.length - 1)  {
					stringBuilder.append(" ");
				}
			}
			stringResults.add(stringBuilder.toString());
			stringBuilder.setLength(0);
		}
		
		return stringResults;	
	}
}
