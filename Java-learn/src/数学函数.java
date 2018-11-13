import static java.lang.Math.*;//需要加在顶部
public class 数学函数 

{
	public static void main(String[] args)
	{
		double x = 4;
		double y = Math.sqrt(x);
		System.out.println(y);
		System.out.println("The square root of \u03C0 is " + sqrt(PI));//"PI"前不必再加"Math."
		
		int n = 123456789;
		float f = n;
		System.out.println(f); //失去了一定精度
		
		System.out.println(f+n);/*计算时，会先转换为同一种类型，优先级如下：
								 *double>float>long>int
								 *后面的会默认转为前面的
		 						 */
		double a = 9.997;
		int na = (int) a;/*强制转换
		    			  *默认通过强制截断后面的小数来实现
		    			  */
		System.out.println(na);
		
		int nb = (int) Math.round(a);/*舍入运算
		 							  *"round"返回的结果为"long"类型，所以仍需"（int）"强制转换
		 							  */
		System.out.println(nb);
		//需注意转换时目标类型的取值范围，如超过则会截断为完全不同的值。如"（byte）300"的值为"44"
	}
}


