package pipes_and_filters;

import java.util.Arrays;

public class CircularShiftFilter {
	public static void main(String[] args) {
		MyThread thread1 = new MyThread(1);
		MyThread thread2 = new MyThread(2);
		MyThread thread3 = new MyThread(3);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
//		String a = "ABCDEF";
//		String b = "abcdef";
//		
//		String[] s = {a,b};
//		Arrays.sort(s);
//		System.out.println(s[0] + " " + s[1]);
	}
}
