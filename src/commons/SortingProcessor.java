package commons;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.List;

public class SortingProcessor implements SentenceProcessor {
	private TreeSet<String> sentences = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
	private SentenceProcessorDelegate delegate;
	
	@Override
	public void processData(String input) {
		sentences.add(input);
	}
	
	@Override
	public void setDelegate(SentenceProcessorDelegate delegate) {
		this.delegate = delegate;
	}
	
	public List<String> getSentences() {
		return new ArrayList<String>(sentences);
	}
	
	@Override
	public void flush() {
		for(String sentence: sentences) {
			delegate.processorDidFinishProcessing(this, sentence);
		}
	}

}
