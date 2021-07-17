package NewTask;

import java.util.Queue;

class Consumer implements Runnable {
	Queue<Character> queue = null;
	final int size = 5;

	public Consumer(Queue<Character> queue) {
		super();
		this.queue = queue;
	}

	public void run() {
		while (true) {
			try {
				get();

			} catch (Exception e) {
				System.out.println(e);

			}
		}
	}

	public void get() throws Exception {
		synchronized (queue) {
			while (queue.isEmpty()) {
				System.out.println("Consumer thread is empty waiting for publisher to put value");
				queue.wait();
			}

			Character str3;
			while (queue.peek() != null) {
				str3 = queue.remove();
				System.out.println("Consumer Thread " + " remove value " + str3 + " " + "from: " + "Queue=" + queue);
			}
		}

		Thread.sleep(1000);
		queue.notify();

	}
}
