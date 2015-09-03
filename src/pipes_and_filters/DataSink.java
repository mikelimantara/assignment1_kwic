package pipes_and_filters;

/*
 * @author: Michael Limantara (A0094022R)
 */
public class DataSink extends Thread {
	private Pipe incomingPipe;
	
	public void setIncomingPipe(Pipe incomingPipe) {
		this.incomingPipe = incomingPipe;
	}
	
	@Override
	public void run() {
		do {
			String processedData = incomingPipe.getData();
			
			if (processedData == "END") {
				break;
			} 
			
			if (processedData != null) {
				System.out.println(processedData);
			}
			
		} while (true);
	}
}
