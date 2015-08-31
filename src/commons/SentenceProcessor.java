package commons;


public interface SentenceProcessor {
	public void processData(String input); 
	public void setDelegate(SentenceProcessorDelegate delegate);
}

