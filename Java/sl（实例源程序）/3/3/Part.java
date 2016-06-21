package com.mingrisoft;

public class Part {											//新建类Part
	static final double PI = 3.14;								//声明常量PI
	static int age = 23;										//声明int型变量age并进行赋值
	public static void main(String[] args) {						//主方法
		final int number; 									//声明int型常量number
		number = 1235;									//对常量进行赋值
		age = 22;											//再次对变量进行赋值
		System.out.println("常量PI的值为：" + PI);				//将PI的值输出
		System.out.println("赋值后number的值为:" + number);		//将number的值输出
		System.out.println("int型变量age的值为：" + age);			//将age的值输出
	}
}
