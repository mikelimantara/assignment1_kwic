package commons;

/*
 * @author: Michael Limantara (A0094022R)
 */
public class CapitalizerProcessor implements SentenceProcessor {

	private SentenceProcessorDelegate delegate;
	
	@Override
	public void processData(String input) {
		String result = capitalizeSentence(input);
		delegate.processorDidFinishProcessing(this, result);
	}
	
	public String capitalizeSentence(String input) {
		String result = null;
		if (input.indexOf(" ") < 0) {
			result = input.toUpperCase();
		} else {
			int firstWordEndPosition = input.indexOf(" ");
			result = input.substring(0, firstWordEndPosition).toUpperCase() +
					input.substring(firstWordEndPosition).toLowerCase();
		}
		
		return result;
	}
	
	@Override
	public void setDelegate(SentenceProcessorDelegate delegate) {
		this.delegate = delegate;	
	}
		
}
