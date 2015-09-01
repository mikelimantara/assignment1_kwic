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

public class PipeAndFilterKWIC implements KWIC {
	private ArrayList<String> inputSentences = new ArrayList<String>();
	private ArrayList<String> noiseWords = new ArrayList<String>();
	private Pipe p1 = new CPipe();
	private Pipe p2 = new CPipe();
	private Pipe p3 = new CPipe();
	private Pipe p4 = new CPipe();
	private CFilter circularShiftFilter = new CFilter();
	private CFilter noiseWordFilter = new CFilter();
	private CFilter sortingFilter = new CFilter();
	private CircularShiftProcessor circularShiftProcessor = new CircularShiftProcessor();
	private NoiseWordProcessor noiseWordProcessor = new NoiseWordProcessor();
	private SortingProcessor sortingProcessor = new SortingProcessor();
	private DataSource dataSource = new DataSource();
	private DataSink dataSink = new DataSink();
	
	public PipeAndFilterKWIC() {
		setupPipeline();
	}
	
	private void setupPipeline() {
		dataSource.setOutgoingPipe(p1);
		circularShiftFilter.setIncomingPipe(p1);
		circularShiftFilter.setOutgoingPipe(p2);
		circularShiftFilter.setSentenceProcessor(circularShiftProcessor);
		
		noiseWordFilter.setIncomingPipe(p2);
		noiseWordFilter.setOutgoingPipe(p3);
		noiseWordFilter.setSentenceProcessor(noiseWordProcessor);
		
		sortingFilter.setIncomingPipe(p3);
		sortingFilter.setOutgoingPipe(p4);
		sortingFilter.setSentenceProcessor(sortingProcessor);
		
		dataSink.setIncomingPipe(p4);
	}

	@Override
	public void setInputSentences(ArrayList<String> sentences) {
		this.inputSentences = sentences;
	}

	@Override
	public void setNoiseWords(ArrayList<String> noiseWords) {
		this.noiseWords = noiseWords;
	}

	@Override
	public void solve() {
		noiseWordProcessor.setNoiseWordList(noiseWords);
		dataSource.setInputSentences(inputSentences);
		
		dataSource.start();
		circularShiftFilter.start();
		noiseWordFilter.start();
		sortingFilter.start();
		dataSink.start();
	}
}
