package pipes_and_filters;

public class DataSink extends Thread {
	private Pipe incomingPipe;
		
	public DataSink(Pipe incomingPipe) {
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
