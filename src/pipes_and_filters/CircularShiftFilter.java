package pipes_and_filters;

public class CircularShiftFilter implements Filter {
	
	private Pipe outgoingPipe;
	private StringBuilder stringBuilder;
	
	public CircularShiftFilter(Pipe outgoingPipe) {
		this.outgoingPipe = outgoingPipe;
		this.stringBuilder = new StringBuilder();
	}

	@Override
	public void processDataAndPushResult(String input) {
		String[] listOfWords = input.split(" ");
		for (int i = 0; i < listOfWords.length; i++) {
			for (int j = 0; j < listOfWords.length; j++) {
				stringBuilder.append(listOfWords[(i+j) % listOfWords.length]);
				if (j < listOfWords.length - 1)  {
					stringBuilder.append(" ");
				}
			}
			System.out.println(stringBuilder.toString());
			stringBuilder.setLength(0);
		}
	}
}
