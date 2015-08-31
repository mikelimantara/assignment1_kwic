package pipes_and_filters;

public class MyThread extends Thread {
	int number;
	
	MyThread(int i) {
		number = i;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread " + number + " running for " + i );
		}
	}
}
