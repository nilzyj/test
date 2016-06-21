package com.mingrisoft;

public class Compound {
	public static void main(String args[]) {
		{
			int y = 40;
			System.out.println("输出y的值："+y);
			int z = 245;
			boolean b;
		{
				b = y > z;
				System.out.println("y>z成立吗："+b);	//复合语句
			}
		}
		String word = "hello java";
		System.out.println("输出字符串："+word);
	}
}

