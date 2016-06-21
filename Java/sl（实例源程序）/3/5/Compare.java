package com.mingrisoft;

public class Compare {									//创建类
	public static void main(String[] args) {
		int number1 = 4;								//声明int型变量number1
		int number2 = 5;								//声明int型变量number2
		//依次将变量number1与变量number2的比较结果输出
		System.out.println("4>5是否成立：" + (number1 > number2));
		System.out.println("4<5是否成立：" + (number1 < number2));
		System.out.println("4==5是否成立：" + (number1 == number2));
		System.out.println("4!=5是否成立：" + (number1 != number2));
		System.out.println("4>=5是否成立：" + (number1 >= number2));
		System.out.println("4<=5是否成立：" + (number1 <= number2));
	}
}
