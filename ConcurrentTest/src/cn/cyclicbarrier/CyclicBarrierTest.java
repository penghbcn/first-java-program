package cn.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		CyclicBarrier cyc1 = new CyclicBarrier(2, new Runnable() {

			@Override
			public void run() {
				System.out.println("cyc1 executed");
			}
		});

		CyclicBarrier cyc2 = new CyclicBarrier(2, new Runnable() {

			@Override
			public void run() {
				System.out.println("cyc2 executed");
			}
		});

		new Thread(new CBRunner(cyc1, cyc2)).start();
		new Thread(new CBRunner(cyc1, cyc2)).start();
	}
}

class CBRunner implements Runnable {

	CyclicBarrier cyc1 = null;
	CyclicBarrier cyc2 = null;

	public CBRunner(CyclicBarrier cyc1, CyclicBarrier cyc2) {
		this.cyc1 = cyc1;
		this.cyc2 = cyc2;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " waiting at cyc1");
			this.cyc1.await();

			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " waiting at cyc2");
			this.cyc2.await();

			System.out.println(Thread.currentThread().getName() + " done!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
