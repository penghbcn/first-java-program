

public class ������ϰ
{
	public static final double CM_PER_INCH = 2.54;/*ʹ��"static final"�����ೣ��
													*λ��main�����ⲿ
													*����һ��ȫ����д
													*public��ʾ������Ҳ����ʹ�øó���
													**/
	public static void main(String[] args)
	{
		double paperWidth = 8.5;
		double paperHeight = 11;
		System.out.println("Paper size in centimeters:"
			+ paperWidth*CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);
	
		final double CM_PER_INCH1 = 3.54;//���ó������ؼ���final��
		double paperWidth1 = 8.5;
		double paperHeight1 = 11;
		System.out.println("Paper size in centimeters:"
			+ paperWidth1*CM_PER_INCH1 + " by " + paperHeight1 * CM_PER_INCH1);
		System.out.println("Paper size in centimeters:"
				+ paperWidth1*CM_PER_INCH + " by " + paperHeight1 * CM_PER_INCH1);
	}
}

