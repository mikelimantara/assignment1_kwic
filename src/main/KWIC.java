package main;

import java.util.ArrayList;

public interface KWIC {
	public void setInputSentences(ArrayList<String> sentences);
	public void setNoiseWords(ArrayList<String> noiseWords);
	public void solve();
}
