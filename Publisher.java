package NewTask;

import java.util.Queue;

class Publisher implements Runnable {
	Queue<Character> queue = null;
	final int size = 5;

	public Publisher(Queue<Character> queue) {
		super();

		this.queue = queue;
	}

	public void run() {
		while (true) {
			try {
				put();
			}

			catch (Exception e) {
				System.out.println(e);

			}
		}

	}

	public void put() throws Exception {
		synchronized (queue) {
			while (queue.size() == size) {
				System.out.println("Publisher thread is full waiting for consumer to retrieve");
				queue.wait();
			}
			String str = "Hello";
			for (int i = 0; i < str.length(); i++) {
				queue.add(str.charAt(i));
			}
			System.out.println("Publisher Thread #" + " put value into : " + "Queue=" + queue);
			Thread.sleep(1000);
			queue.notify();

		}
	}
}
