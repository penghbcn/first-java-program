/**
 * 基本格式： public class ClassName { public static void main(String[] args) {
 * program statements } }
 */
public class FirstSample // class后紧跟类名
{// 匹配的大括号上下对齐
	public static void main(String[] args)// void表示没有返回值，如果需要，则需调用System.exit方法
	{
		System.out.println("We will not use\n 'Hello World'");// "\n"表示换行
		/*
		 * （）内为字符串参数，使用""分隔字符串 没有字符串参数时也需要（）
		 */
		/*
		 * println在输出后换行 print在输出后不换行
		 */

		System.out.println();

		System.out.print("test001");

		System.out.println("bye");
	}
}