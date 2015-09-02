package pipes_and_filters;

import java.util.ArrayList;

import main.KWIC;
import commons.CapitalizerProcessor;
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
	private Pipe p5 = new CPipe();
	private CFilter circularShiftFilter = new CFilter();
	private CFilter capitalizerFiler = new CFilter();
	private CFilter noiseWordFilter = new CFilter();
	private CFilter sortingFilter = new CFilter();
	private CircularShiftProcessor circularShiftProcessor = new CircularShiftProcessor();
	private CapitalizerProcessor capitalizerProcessor = new CapitalizerProcessor();
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
		
		capitalizerFiler.setIncomingPipe(p2);
		capitalizerFiler.setOutgoingPipe(p3);
		capitalizerFiler.setSentenceProcessor(capitalizerProcessor);
		
		noiseWordFilter.setIncomingPipe(p3);
		noiseWordFilter.setOutgoingPipe(p4);
		noiseWordFilter.setSentenceProcessor(noiseWordProcessor);
		
		sortingFilter.setIncomingPipe(p4);
		sortingFilter.setOutgoingPipe(p5);
		sortingFilter.setSentenceProcessor(sortingProcessor);
		
		dataSink.setIncomingPipe(p5);
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
		capitalizerFiler.start();
		noiseWordFilter.start();
		sortingFilter.start();
		dataSink.start();
	}
}
