package pipes_and_filters;

import java.util.ArrayList;

/*
 * @author: Michael Limantara (A0094022R)
 */
public class DataSource extends Thread {
	private Pipe outgoingPipe;
	private ArrayList<String> initialInput;
		
	public void setOutgoingPipe(Pipe outgoingPipe) {
		this.outgoingPipe = outgoingPipe;
	}
	
	public void setInputSentences(ArrayList<String> inputSentences) {
		this.initialInput = inputSentences;
	}
	
	@Override
	public void run() {
		for (String input: initialInput) {
			outgoingPipe.addData(input);
		}
		outgoingPipe.addData("END");
	}
}
