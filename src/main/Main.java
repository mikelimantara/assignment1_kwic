package main;

import java.util.ArrayList;

import pipes_and_filters.PipeAndFilterKWIC;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> initialInput = new ArrayList<String>();
		initialInput.add("The Day after Tomorrow");
		initialInput.add("Fast and Furious");
		initialInput.add("Man of Steel");
		
		ArrayList<String> noiseWords = new ArrayList<String>();
		noiseWords.add("is");
		noiseWords.add("the");
		noiseWords.add("of");
		noiseWords.add("and");
		noiseWords.add("as");
		noiseWords.add("a");
		noiseWords.add("after");
	
		PipeAndFilterKWIC pipeAndFilterKWIC = new PipeAndFilterKWIC();
		pipeAndFilterKWIC.setInputSentences(initialInput);
		pipeAndFilterKWIC.setNoiseWords(noiseWords);
		pipeAndFilterKWIC.solve();
	}
}
