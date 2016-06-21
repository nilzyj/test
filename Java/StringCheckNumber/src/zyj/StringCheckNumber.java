package zyj;

public class StringCheckNumber {

	public static void main(String[] args) {
		String s = "12312312";
		if(StringCheckNumber.IsNumber(s))
		{
			System.out.println(s + " 是数字格式");
		}
		else
		{
			System.out.println(s + " 不是数字格式");
		}
	}
	public static boolean IsNumber(String str)
	{
		char[] c = str.toCharArray();//将字符串转换为字符数组
		for(int i = 0;i < c.length;i++)
		{
			if(Character.isDigit(c[i])){}//判断字符是否是数字，是则继续循环
			else 
			{
				return false;
			}
		}
		return true;//都是数字则返回true
	}
}
