package Threadtask;

import java.util.LinkedList;
import java.util.Queue;

class Consumer extends Thread {
	private CP cp;

	public Consumer(CP c) {
		cp = c;

	}

	public void run() {
		String str = "Hello";
		Queue<Character> queue = new LinkedList<Character>();

		for (int i = 0; i < str.length(); i++) {
			queue.add(str.charAt(i));
		}
		Character str3;
		
		while (queue.peek() != null) {
			str3 = queue.remove();
			
		    System.out.println("Consumer Thread #" + " remove value "+str3+" "+ "from: " + "Queue=" + queue);
		}
		try {
			sleep(1000);
		} catch (Exception e) {
		}
	}
}
