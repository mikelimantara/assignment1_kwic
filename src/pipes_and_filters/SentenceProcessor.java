package pipes_and_filters;

public interface SentenceProcessor {
	public void processData(String input); 
	public void setDelegate(SentenceProcessorDelegate delegate);
}

