package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import main.ParserResult.Mode;
import pipes_and_filters.PipeAndFilterKWIC;
import repository.RepositoryKWIC;

public class KWICApp {
	private ArrayList<String> inputSentences = new ArrayList<String>();
	private ArrayList<String> noiseWords = new ArrayList<String>();
	private KWIC kwicSolver;
	private Parser parser = new Parser();
	
	public static void main(String[] args) {
		KWICApp app = new KWICApp();
		app.run(args);
	}
	
	public void run(String[] args) {
		try {
			ParserResult parserResult = parser.parse(args);
			if (parserResult.isValid()) {
				setSolveMode(parserResult.getMode());
				readInputSentences(parserResult.getInputFile());
				readNoiseWords(parserResult.getNoiseWordsFile());
				startSolver();	
			} else {
				printError();
				printHelp();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Input file is not found");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("There is an error reading the file");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void setSolveMode(Mode mode) throws Exception {
		if (mode == Mode.PIPE_AND_FILTER) {
			kwicSolver = new PipeAndFilterKWIC();
		} else if (mode == Mode.SHARED_REPOSITORY) {
			kwicSolver = new RepositoryKWIC();
		} else {
			throw new Exception("ERROR: Invalid mode!");
		}
	}
	
	private void readInputSentences(String fileName) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		while(br.ready()) {
			String line = br.readLine();
			line = line.trim();
			if (!line.isEmpty()) {
				inputSentences.add(line);
			}
		}
		br.close();
	}
	
	private void readNoiseWords(String fileName) throws FileNotFoundException, IOException {
		if (fileName == null) return;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		while(br.ready()) {
			String line = br.readLine();
			line = line.trim();
			if (!line.isEmpty()) {
				noiseWords.add(line);
			}
		}
		br.close();
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
	
	private void printError() {
		System.out.println("ERROR: Invalid Input");
	}
}
