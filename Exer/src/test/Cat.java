package test;

import java.util.ArrayList;
import java.util.List;

public class Cat extends Animal {
	int cat2;

	protected Cat(int age, String color, int cat2) {
		super(age, color);
		this.cat2 = cat2;
	}

	public void eat() {
		int j = super.c;
		super.eat();
		List<String> list = new ArrayList<>();
		list.add("abc");
		System.out.println(list.get(0));
		Integer i = Integer.valueOf(2);
		System.out.println("animal.c is" + j);
	}

	public static void main(String[] args) {
		int j = 0x90000000;
		System.out.println(j);
		Cat cat = new Cat(2, "a", 3);
		cat.eat();
	}

	public void max(double... args) {
		double largest = Double.NEGATIVE_INFINITY;
		int i = Integer.MIN_VALUE;
		for (double d : args)
			if (d > largest)
				largest = d;
		int j = 0x90000000;
		System.out.println(j);

	}
}
