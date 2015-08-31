package pipes_and_filters;

import commons.SentenceProcessor;

public interface Filter {
	public void setOutgoingPipe(Pipe outgoingPipe);
	public void setIncomingPipe(Pipe incomingPipe);
	public void setSentenceProcessor(SentenceProcessor sentenceProcessor);
}
