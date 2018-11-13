package cn.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new SynchronousQueue<>();
		Producer prod = new Producer(queue);
		Consumer cons = new Consumer(queue);

		new Thread(prod).start();
		new Thread(cons).start();
	}
}

class Producer implements Runnable {

	private BlockingQueue<String> queue = null;

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			System.out.println("put 'a' begin");
			queue.put("a");
			System.out.println("put 'a' end");
			System.out.println("put 'b' begin");
			queue.put("b");
			System.out.println("put 'b' end");
			System.out.println("put 'c' begin");
			queue.put("c");
			System.out.println("put 'c' end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class Consumer implements Runnable {

	private BlockingQueue<String> queue = null;

	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			System.out.println(queue.take());
			Thread.sleep(1000);
			System.out.println(queue.take());
			Thread.sleep(1000);
			System.out.println(queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
