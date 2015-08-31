package pipes_and_filters;

public interface SentenceProcessorDelegate {
	public void processorDidFinishProcessing(SentenceProcessor processor, String result);
}
