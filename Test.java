package Threadtask;

public class Test {

	public static void main(String[] args) {
		CP c = new CP();
		Publisher p1 = new Publisher(c);
		Consumer c1 = new Consumer(c);
		p1.start();
		c1.start();
	}
}

class CP {

	private boolean available = false;

	public synchronized void get() {
		while (available == false) {
			try {
				wait();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		available = false;
		notify();

	}

	public synchronized void put() {
		while (available == true) {
			try {
				wait();
			} catch (Exception e) {
			}
		}

		available = true;
		notify();

	}
}
