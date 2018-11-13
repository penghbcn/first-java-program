
public class 字符串
{
	public static void main(String[] args)//"String"即表示字符串
	{
		//String e = "";//一个空字符串
		
		String greeting = "Hello";
		String s = greeting.substring(0,3);/*输出"Hel"
											*提取子串
											*"()"内的第二个值为不想复制的第一个位置
											*这里"3"表示从0开始，到3为止，但不包括3
											*/
		System.out.println(s);
		
		int age = 13;
		String rating = "PG" + age;//"rating=PG13"
		System.out.println("The rating is " + rating);//字符串的拼接
		
		String all = String.join("/", "s","rating","e");//静态join
		System.out.println(all);
		
		greeting = greeting.substring(0,3) + "p!";//"greeting"由"Hello"变为"Help!"
		System.out.println(greeting);
		String t = s + "p!";
		System.out.println(t);
		
		"Hello".equals(greeting);//检测字符串是否相等
		"Hello".equalsIgnoreCase("hello");//不区分大小写
		
		/*if (str !=null && str.length() != 0);/*"str"表示某个字符串（应该）
											  *"null"串与空串
											  *要先检查"str"是否为"null"
											  *"str.equals("")"也表示空串
		 	  								  */
		
		int n = greeting.length();//返回给定字符串的代码单元数量
		System.out.println(n);
		int cpCount = greeting.codePointCount(0, greeting.length());//得到实际的长度，即码点数量
		System.out.println(cpCount);
		char first = greeting.charAt(0);//"str.charAt(n)"将返回位置n的代码单元。该位置从0开始计算
		char last = greeting.charAt(cpCount - 1);//返回末尾的单元
		System.out.println("The first is " + first + ",and the last is " + last);
		
		int index = greeting.offsetByCodePoints(0, 3);//返回112是什么意思。。。
		int cp = greeting.codePointAt(index);//得到第三个码点
		System.out.println(cp);
		System.out.println(index);
		
		/*String sentence = "\uD835+\uDD46 is the set of octonions";
		char ch = sentence.charAt(1);
		System.out.println(sentence);*/
		
		StringBuilder builder = new StringBuilder();
		builder.append("Hi");
		builder.append(rating);
		builder.append(greeting);
		String completedString = builder.toString();
		System.out.println(completedString);
	
		builder.append("1");
		System.out.println(completedString);
	}
}
