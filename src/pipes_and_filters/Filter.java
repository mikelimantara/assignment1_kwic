package pipes_and_filters;

public interface Filter {
	public void processDataAndPushResult(String input);
	public String processDataAndReturnResult(String input);
}
