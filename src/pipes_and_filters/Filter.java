package pipes_and_filters;

public interface Filter {
	public void processDataAndPushResult(String input);
	public void setOutgoingPipe(Pipe outgoingPipe);
}
