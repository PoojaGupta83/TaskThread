package NewTask;

import java.util.LinkedList;
import java.util.Queue;

public class Test {

	public static void main(String[] args) {
		Queue<Character> queue = new LinkedList<Character>();
		Thread t1 = new Thread(new Publisher(queue));
		Thread t2 = new Thread(new Consumer(queue));
		t1.start();
		t2.start();
	}
}
