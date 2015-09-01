package main;

import java.util.ArrayList;

import pipes_and_filters.PipeAndFilterKWIC;
import repository.RepositoryKWIC;

public class KWICApp {
	private ArrayList<String> inputSentences = new ArrayList<String>();
	private ArrayList<String> noiseWords = new ArrayList<String>();
	private KWIC kwicSolver;
	
	public static void main(String[] args) {
		KWICApp app = new KWICApp();
//		app.run();
		printHelp();
	}
	
	public void run() {
		setSolveMode(1);
		readInputSentences("filename");
		readNoiseWords("filename");
		startSolver();
	}
	
	private void setSolveMode(int mode) {
		if (mode == 0) {
			kwicSolver = new PipeAndFilterKWIC();
		} else if (mode == 1) {
			kwicSolver = new RepositoryKWIC();
		}
	}
	
	private void readInputSentences(String fileName) {
		inputSentences.add("The Day after Tomorrow");
		inputSentences.add("Fast and Furious");
		inputSentences.add("Man of Steel");
	}
	
	private void readNoiseWords(String fileName) {
		noiseWords.add("is");
		noiseWords.add("the");
		noiseWords.add("of");
		noiseWords.add("and");
		noiseWords.add("as");
		noiseWords.add("a");
		noiseWords.add("after");
	}
	
	private void startSolver() {
		kwicSolver.setInputSentences(inputSentences);
		kwicSolver.setNoiseWords(noiseWords);
		kwicSolver.solve();
	}
	
	private static void printHelp() {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Usage Instruction:");
		System.out.println();
		System.out.println("Command format: KWICApp -m <MODE> -i <INPUT FILE> -n <NOISE WORDS FILE>");
		System.out.println("OPTIONS:");
		System.out.println("<MODE> - choose the architecture to solve KWIC [pipe OR repo]");
		System.out.println("<INPUT FILE> - provide filename containing list of sentences to be indexed");
		System.out.println("<NOISE WORDS FILE> - provide filename containing list of words to be ignored");
		System.out.println("----------------------------------------------------------------------------");
	}
	
}
