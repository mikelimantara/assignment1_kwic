package pipes_and_filters;

import java.util.ArrayList;

public class CPipe implements Pipe {
	
	public ArrayList<String> dataBuffer;
	public Filter outgoingFilter;
	
	public CPipe() {
		dataBuffer = new ArrayList<String>();
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
		
		return dataBuffer.get(0);
	}
}
