package main;

import java.util.ArrayList;

import pipes_and_filters.CFilter;
import pipes_and_filters.CPipe;
import pipes_and_filters.DataSink;
import pipes_and_filters.DataSource;
import pipes_and_filters.Pipe;
import commons.CircularShiftProcessor;
import commons.NoiseWordProcessor;
import commons.SortingProcessor;

public class KeyWordInContext {	
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
		
		Pipe p1 = new CPipe();
		Pipe p2 = new CPipe();
		Pipe p3 = new CPipe();
		Pipe p4 = new CPipe();
		CFilter f1 = new CFilter();
		CFilter f2 = new CFilter();
		CFilter f3 = new CFilter();
		
		CircularShiftProcessor circularShiftProcessor = new CircularShiftProcessor();
		NoiseWordProcessor noiseWordProcessor = new NoiseWordProcessor();
		noiseWordProcessor.setNoiseWordList(noiseWords);
		SortingProcessor sortingProcessor = new SortingProcessor();
		
		DataSource dataSource = new DataSource(p1, initialInput);
		f1.setIncomingPipe(p1);
		f1.setOutgoingPipe(p2);
		f1.setSentenceProcessor(circularShiftProcessor);
		
		f2.setIncomingPipe(p2);
		f2.setOutgoingPipe(p3);
		f2.setSentenceProcessor(noiseWordProcessor);
		
		f3.setIncomingPipe(p3);
		f3.setOutgoingPipe(p4);
		f3.setSentenceProcessor(sortingProcessor);
		DataSink dataSink = new DataSink(p4);
				
		dataSource.start();
		f1.start();
		f2.start();
		f3.start();
		dataSink.start();
		
	}
}
