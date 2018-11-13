package day20;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

public class T01
{
	public static void main(String[] args) throws IOException
	{
		FileOutputStream out = new FileOutputStream("test1.txt");
		out.write("床前明月光\r\n".getBytes("GBK"));
		out.write("疑是地上光\r\n".getBytes("GBK"));
		out.write("举头望明月\r\n".getBytes("GBK"));
		out.write("低头思故乡\r\n".getBytes("GBK"));
		out.close();
		BufferedReader br = new BufferedReader(new FileReader("test1.txt"));
		String line = null;
		Stack<String> stack = new Stack<String>();
		while ((line = br.readLine()) != null)
		{
			stack.push(line);
		}
		PrintWriter pw = new PrintWriter("test2.txt", "UTF-8");
		while (!stack.isEmpty())
			pw.println(stack.pop());
		pw.close();
		br.close();
	}
}
