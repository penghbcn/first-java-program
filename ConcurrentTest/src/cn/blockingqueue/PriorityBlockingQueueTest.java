package cn.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTest {
	public static void main(String[] args) throws Exception {
		BlockingQueue<String> queue = new PriorityBlockingQueue<>();
		queue.put("aaa");
		queue.put("abb");
		queue.put("aab");
		queue.put("aba");
		System.out.println(queue.size());
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			System.out.println(queue.take());

		}
	}
}
