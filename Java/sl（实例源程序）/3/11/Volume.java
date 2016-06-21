package com.mingrisoft;

import java.util.Scanner;										//声明包
public class Volume {										//声明类
	public static void main(String[] args) {						//主方法
		Scanner scan = new Scanner(System.in);					//扫描器
		System.out.println("请输入球形的半径：");
		double r = scan.nextDouble();							//接收数据
		final double PI = 3.1415926;							//定义常量PI
		double volume = 4.0/3.0 * PI * r * r * r;					//求球形的体积
		System.out.println("球形的半径是：" + r);					//输出球的半径
		System.out.println("圆周率是：" + PI);					//输出圆周率
		System.out.println("球形的体积是：" + volume);			//输出球的体积
	}
}

