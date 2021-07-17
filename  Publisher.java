package Threadtask;

import java.util.LinkedList;
import java.util.Queue;

class Publisher extends Thread {
	@SuppressWarnings("unused")
	private CP cpp;
	
	public Publisher(CP c) {

		cpp = c;

	}

	public void run() {
		String str = "Hello";
     	Queue<Character> queue = new LinkedList<Character>();

		for (int i = 0; i < str.length(); i++) {
			queue.add(str.charAt(i));
		}
	
		System.out.println("Publisher Thread #" + " put value into : " + "Queue=" + queue);

		try {
			sleep(1000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
