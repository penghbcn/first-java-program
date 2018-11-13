package test;

public class Animal {
	private int age;
	private String color;
	int c = 2;

	protected Animal(int age, String color) {
		this.age = age;
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public String getColor() {
		return color;
	}

	public void eat() {
		System.out.println("Animal eat");
	}

}
