package pipes_and_filters;

import commons.SentenceProcessor;
import commons.SentenceProcessorDelegate;


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
		sentenceProcessor.setDelegate(this);
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
				sentenceProcessor.flush();
				
				outgoingPipe.addData("END");
				
				break;
			} 
			
			if (inputData != null) {
//				String id = sentenceProcessor.getClass().getName();
//				System.out.println(id + ": " + inputData);
				sentenceProcessor.processData(inputData);
			}
		}
	}
}
