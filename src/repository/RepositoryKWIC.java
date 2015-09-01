package repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import main.KWIC;

import commons.CircularShiftProcessor;
import commons.NoiseWordProcessor;

public class RepositoryKWIC implements KWIC {
	private TreeSet<String> sentences = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
	private NoiseWordProcessor noiseWordProcessor = new NoiseWordProcessor();
	private CircularShiftProcessor circularShiftProcessor = new CircularShiftProcessor();
	
	@Override
	public void setInputSentences(ArrayList<String> sentences) {
		for (String sentence: sentences) {
			this.sentences.add(sentence);
		}
	}

	@Override
	public void setNoiseWords(ArrayList<String> noiseWords) {
		noiseWordProcessor.setNoiseWordList(noiseWords);
	}

	@Override
	public void solve() {
		generateCircularShift();
		removeSentencesBeginningWithNoiseWords();
		sortSentences();
		printResult();
	}
	
	
	private void generateCircularShift() {
		ArrayList<String> allPermutations = new ArrayList<String>();
		for (String sentence: sentences) {
			List<String> permutations = circularShiftProcessor.permutationsOfSentence(sentence);
			allPermutations.addAll(permutations);
		}
		sentences.addAll(allPermutations);
	}
	
	private void removeSentencesBeginningWithNoiseWords() {
		Iterator<String> it = sentences.iterator();
		while(it.hasNext()) {
			String sentence = it.next();
			if (noiseWordProcessor.beginsWithNoiseWord(sentence)) {
				it.remove();
			}
		}
	}
	
	private void sortSentences() {
		// do nothing since TreeSet is already sorted
	}
	
	private void printResult() {
		for (String sentence: sentences) {
			System.out.println(sentence);
		}
	}
	
}
