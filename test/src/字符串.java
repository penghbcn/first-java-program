
public class �ַ���
{
	public static void main(String[] args)//"String"����ʾ�ַ���
	{
		//String e = "";//һ�����ַ���
		
		String greeting = "Hello";
		String s = greeting.substring(0,3);/*���"Hel"
											*��ȡ�Ӵ�
											*"()"�ڵĵڶ���ֵΪ���븴�Ƶĵ�һ��λ��
											*����"3"��ʾ��0��ʼ����3Ϊֹ����������3
											*/
		System.out.println(s);
		
		int age = 13;
		String rating = "PG" + age;//"rating=PG13"
		System.out.println("The rating is " + rating);//�ַ�����ƴ��
		
		String all = String.join("/", "s","rating","e");//��̬join
		System.out.println(all);
		
		greeting = greeting.substring(0,3) + "p!";//"greeting"��"Hello"��Ϊ"Help!"
		System.out.println(greeting);
		String t = s + "p!";
		System.out.println(t);
		
		"Hello".equals(greeting);//����ַ����Ƿ����
		"Hello".equalsIgnoreCase("hello");//�����ִ�Сд
		
		/*if (str !=null && str.length() != 0);/*"str"��ʾĳ���ַ�����Ӧ�ã�
											  *"null"����մ�
											  *Ҫ�ȼ��"str"�Ƿ�Ϊ"null"
											  *"str.equals("")"Ҳ��ʾ�մ�
		 	  								  */
		
		int n = greeting.length();//���ظ����ַ����Ĵ��뵥Ԫ����
		System.out.println(n);
		int cpCount = greeting.codePointCount(0, greeting.length());//�õ�ʵ�ʵĳ��ȣ����������
		System.out.println(cpCount);
		char first = greeting.charAt(0);//"str.charAt(n)"������λ��n�Ĵ��뵥Ԫ����λ�ô�0��ʼ����
		char last = greeting.charAt(cpCount - 1);//����ĩβ�ĵ�Ԫ
		System.out.println("The first is " + first + ",and the last is " + last);
		
		int index = greeting.offsetByCodePoints(0, 3);//����112��ʲô��˼������
		int cp = greeting.codePointAt(index);//�õ����������
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
