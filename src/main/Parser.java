package main;

import main.ParserResult.Mode;

public class Parser {
	
	public ParserResult parse(String[] args) {
		
		ParserResult parserResult = new ParserResult();
		
		int index = 0;
		
		while (index < args.length) {
			if (args[index].equals("-m") || args[index].equals("--mode")) {
				if (index + 1 < args.length) {
					if (args[index + 1].toLowerCase().equals("pipe")) {
						parserResult.setMode(Mode.PIPE_AND_FILTER);
					} else if (args[index + 1].toLowerCase().equals("repo")) {
						parserResult.setMode(Mode.SHARED_REPOSITORY);
					} else {
						parserResult.setValid(false);
						break;
					}
				} else {
					parserResult.setValid(false);
					break;
				}
				
				index++;
				
			} else if (args[index].equals("-i") || args[index].equals("--input")) {
				if (index + 1 < args.length) {
					if (args[index + 1].toLowerCase().equals("pipe")) {
						parserResult.setMode(Mode.PIPE_AND_FILTER);
					} else if (args[index + 1].toLowerCase().equals("repo")) {
						parserResult.setMode(Mode.SHARED_REPOSITORY);
					} else {
						parserResult.setValid(false);
						break;
					}
				} else {
					parserResult.setValid(false);
					break;
				}
				
				index++;
				
			}
			
			
			index++;
		}
				
		return parserResult;
	}
	
	
	
}
