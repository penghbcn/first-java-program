package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

import org.junit.Test;

public class TestClass {
	Object values;

	@Test
	public void test1() {
		Manager[] managers = new Manager[10];
		Employee[] staff = managers;
		staff[0] = new Employee("zzz", 0, 1990, 05, 03);
		Manager boss = (Manager) staff[1];
		System.out.println(staff[0]);
		System.out.println(managers[0]);
		managers[0].setBonus(0);
	}

	@Test
	public void test2() {
		Animal a = new Cat(1, "a", 3);
		a.eat();
		Object obj = null;
		obj.equals(obj);

	}

	// ��дequals����
	// public boolean equals(Object otherObj) {
	// if (this == otherObj) {
	// return true;
	// }
	// if (otherObj == null) {
	// return false;
	// }
	// if (this.getClass() != otherObj.getClass()) {
	// return false;
	// }
	// String other = (String) otherObj; // ʾ��
	//
	// return Objects.equals(this.values, other.values);
	// }

	// ��дhashCode����

	public int hashCode() {
		return Objects.hash(values);
	}

	@Test
	public void cp() throws Exception {
		String fileIn = "";
		String fileOut = "";
		String A = "E:\\[philosophy-raws][Cowboy Bebop]\\[philosophy-raws][Cowboy Bebop][";
		String B = "][BDRIP][Hi10P FLAC][1440X1080].mkv";
		for (int i = 1; i < 27; i++) {
			if (i < 10) {
				fileIn = A + "0" + i + B;
				fileOut = "E:\\[philosophy-raws][Cowboy Bebop]\\[Cowboy Bebop][0" + i + "].mkv";
			} else {
				fileIn = A + i + B;
				fileOut = "E:\\[philosophy-raws][Cowboy Bebop]\\[Cowboy Bebop][" + i + "].mkv";
			}
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileIn));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileOut));
			int len = -1;
			while ((len = bis.read()) != -1) {
				bos.write(len);
			}
			bos.flush();
			bos.close();
			bis.close();
		}
	}

	@Test
	public void cp1() throws Exception {
		String fileIn = "";
		String fileOut = "";
		String A = "E:\\[philosophy-raws][Cowboy Bebop]\\[MGRT][BDrip]COWBOY BEBOP Session #";
		String B = " (1440x1080_x264Hi10P_flac).ass";
		for (int i = 2; i < 27; i++) {
			fileIn = A + i + B;
			if (i < 10)
				fileOut = "E:\\[philosophy-raws][Cowboy Bebop]\\[Cowboy Bebop][0" + i + "].ass";
			else
				fileOut = "E:\\[philosophy-raws][Cowboy Bebop]\\[Cowboy Bebop][" + i + "].ass";

			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileIn));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileOut));
			int len = -1;
			while ((len = bis.read()) != -1) {
				bos.write(len);
			}
			bos.flush();
			bos.close();
			bis.close();
		}
	}
}
