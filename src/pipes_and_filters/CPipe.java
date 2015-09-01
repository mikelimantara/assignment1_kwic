package pipes_and_filters;

import java.util.ArrayList;
import java.util.LinkedList;

public class CPipe implements Pipe {
	
	public LinkedList<String> dataBuffer;
	public Filter outgoingFilter;
	
	public CPipe() {
		dataBuffer = new LinkedList<String>();
	}

	@Override
	public void addData(String data) {
		dataBuffer.add(data);
	}
	
	@Override
	public String getData() {
		if (dataBuffer.isEmpty()) {
			return null;
		}
		
		return dataBuffer.remove(0);
	}
	
	public String getDataAtPosition(int position) {
		if (position < 0 && position >= dataBuffer.size()) {
			return null;
		}
		
		return dataBuffer.get(position);
	}
	
	public int getDataBufferSize() {
		return dataBuffer.size();
	}
}
