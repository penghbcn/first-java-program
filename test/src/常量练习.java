

public class 常量练习
{
	public static final double CM_PER_INCH = 2.54;/*使用"static final"设置类常量
													*位于main方法外部
													*常量一般全部大写
													*public表示其他类也可以使用该常量
													**/
	public static void main(String[] args)
	{
		double paperWidth = 8.5;
		double paperHeight = 11;
		System.out.println("Paper size in centimeters:"
			+ paperWidth*CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);
	
		final double CM_PER_INCH1 = 3.54;//设置常量（关键字final）
		double paperWidth1 = 8.5;
		double paperHeight1 = 11;
		System.out.println("Paper size in centimeters:"
			+ paperWidth1*CM_PER_INCH1 + " by " + paperHeight1 * CM_PER_INCH1);
		System.out.println("Paper size in centimeters:"
				+ paperWidth1*CM_PER_INCH + " by " + paperHeight1 * CM_PER_INCH1);
	}
}

