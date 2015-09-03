package repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import main.KWIC;
import commons.CapitalizerProcessor;
import commons.CircularShiftProcessor;
import commons.NoiseWordProcessor;

/*
 * @author: Andhieka Putra (A0113672L)
 */
public class RepositoryKWIC implements KWIC {
	private TreeSet<String> sentences = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
	private NoiseWordProcessor noiseWordProcessor = new NoiseWordProcessor();
	private CircularShiftProcessor circularShiftProcessor = new CircularShiftProcessor();
	private CapitalizerProcessor capitalizerProcessor = new CapitalizerProcessor();
	
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
		capitalizeSentences();
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
	
	private void capitalizeSentences() {
		Iterator<String> it = sentences.iterator();
		ArrayList<String> capitalizedSentences = new ArrayList<String>();
		while(it.hasNext()) {
			String sentence = it.next();
			it.remove();
			capitalizedSentences.add(capitalizerProcessor.capitalizeSentence(sentence));
		}
		sentences.addAll(capitalizedSentences);
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
