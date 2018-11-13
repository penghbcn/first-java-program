package cn.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerTest {
	public static void main(String[] args) {

		Exchanger<String> exc = new Exchanger<>();

		new Thread(new ExcRunner(exc, "A")).start();
		new Thread(new ExcRunner(exc, "B")).start();
	}
}

class ExcRunner implements Runnable {

	private Exchanger<String> exc = null;
	private String str = null;

	public ExcRunner(Exchanger<String> exc, String str) {
		this.exc = exc;
		this.str = str;
	}

	@Override
	public void run() {
		try {
			String str = this.str;
			this.str = exc.exchange(this.str);
			System.out.println(Thread.currentThread().getName() + ": " + str + " > " + this.str);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
