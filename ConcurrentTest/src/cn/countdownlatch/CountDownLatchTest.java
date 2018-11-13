package cn.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);

		new Thread(new Waiter(latch)).start();
		new Thread(new Other(latch)).start();
	}
}

class Waiter implements Runnable {

	private CountDownLatch latch = null;

	public Waiter(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Waiter.run()");
	}

}

class Other implements Runnable {

	private CountDownLatch latch = null;

	public Other(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			latch.countDown();
			System.out.println("countDown 1");
			Thread.sleep(1000);
			latch.countDown();
			System.out.println("countDown 2");
			Thread.sleep(1000);
			latch.countDown();
			System.out.println("countDown 3");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}