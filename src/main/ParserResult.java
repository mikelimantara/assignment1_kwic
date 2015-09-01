package main;

public class ParserResult {
	enum Mode {
		PIPE_AND_FILTER, SHARED_REPOSITORY
	}
	
	enum CommandType {
		KWIC, HELP
	}

	private boolean isValid;
	private Mode mode;
	private String inputFile;
	private String noiseWordsFile;
	
	public Mode getMode() {
		return mode;
	}
	
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	
	public String getInputFile() {
		return inputFile;
	}
	
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}
	
	public String getNoiseWordsFile() {
		return noiseWordsFile;
	}
	
	public void setNoiseWordsFile(String noiseWordsFile) {
		this.noiseWordsFile = noiseWordsFile;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}	
}
