import static java.lang.Math.*;//��Ҫ���ڶ���
public class ��ѧ���� 

{
	public static void main(String[] args)
	{
		double x = 4;
		double y = Math.sqrt(x);
		System.out.println(y);
		System.out.println("The square root of \u03C0 is " + sqrt(PI));//"PI"ǰ�����ټ�"Math."
		
		int n = 123456789;
		float f = n;
		System.out.println(f); //ʧȥ��һ������
		
		System.out.println(f+n);/*����ʱ������ת��Ϊͬһ�����ͣ����ȼ����£�
								 *double>float>long>int
								 *����Ļ�Ĭ��תΪǰ���
		 						 */
		double a = 9.997;
		int na = (int) a;/*ǿ��ת��
		    			  *Ĭ��ͨ��ǿ�ƽضϺ����С����ʵ��
		    			  */
		System.out.println(na);
		
		int nb = (int) Math.round(a);/*��������
		 							  *"round"���صĽ��Ϊ"long"���ͣ���������"��int��"ǿ��ת��
		 							  */
		System.out.println(nb);
		//��ע��ת��ʱĿ�����͵�ȡֵ��Χ���糬�����ض�Ϊ��ȫ��ͬ��ֵ����"��byte��300"��ֵΪ"44"
	}
}


