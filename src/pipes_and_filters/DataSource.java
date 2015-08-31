package pipes_and_filters;

import java.util.ArrayList;

public class DataSource extends Thread {
	private Pipe outgoingPipe;
	private ArrayList<String> initialInput;
		
	public DataSource(Pipe outgoingPipe, ArrayList<String> initialInput) {
		this.outgoingPipe = outgoingPipe;
		this.initialInput = initialInput;
	}
	
	@Override
	public void run() {
		for (String input: initialInput) {
			outgoingPipe.addData(input);
		}
		outgoingPipe.addData("END");
	}
}
