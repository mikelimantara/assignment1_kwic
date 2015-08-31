package pipes_and_filters;


public class NoiseWordFilter implements Filter, SentenceProcessorDelegate {
	private Pipe incomingPipe;
	private Pipe outgoingPipe;
	private SentenceProcessor noiseWordProcessor;
	
	@Override
	public void setIncomingPipe(Pipe incomingPipe) {
		this.incomingPipe = incomingPipe;
	}
	
	@Override
	public void setOutgoingPipe(Pipe outgoingPipe) {
		this.outgoingPipe = outgoingPipe;
	}
	
	@Override
	public void processorDidFinishProcessing(SentenceProcessor processor,
			String result) {
		outgoingPipe.addData(result);
	}

}
