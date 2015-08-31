package pipes_and_filters;

import commons.SentenceProcessor;
import commons.SentenceProcessorDelegate;
import commons.SortingProcessor;


public class CFilter extends Thread implements Filter, SentenceProcessorDelegate {
	private Pipe incomingPipe;
	private Pipe outgoingPipe;
	private SentenceProcessor sentenceProcessor;
	
	@Override
	public void setIncomingPipe(Pipe incomingPipe) {
		this.incomingPipe = incomingPipe;
	}
	
	@Override
	public void setOutgoingPipe(Pipe outgoingPipe) {
		this.outgoingPipe = outgoingPipe;
	}
	
	@Override
	public void setSentenceProcessor(SentenceProcessor sentenceProcessor) {
		this.sentenceProcessor = sentenceProcessor;
	}
	
	@Override
	public void processorDidFinishProcessing(SentenceProcessor processor,
			String result) {
		outgoingPipe.addData(result);
	}
	
	@Override
	public void run() {
		while (true) {
			String inputData = incomingPipe.getData();
		
			if (inputData == "END") {
				if (sentenceProcessor instanceof SortingProcessor) {
					sentenceProcessor.flush();
				}
				
				outgoingPipe.addData("END");
				
				break;
			} 
			
			if (inputData != null) {
//				System.out.println(id + ": " + inputData);
				sentenceProcessor.processData(inputData);
			}
		}
	}
}
