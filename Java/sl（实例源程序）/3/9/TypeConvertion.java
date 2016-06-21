package com.mingrisoft;

public class TypeConvertion {									//声明类
	public static void main(String[]args){							//主方法
		int intNum = 4;										//定义变量
		float floatNum = 9.5F;
		
		floatNum /= intNum;									//自动类型转换成float型
		System.out.println("9.5F除以4的商是："+floatNum);
		
		double numX = 4.88;
		double numY = 78.83;
		int numZ = (int)numX+(int)numY;						//将double型强制转换成int型
		System.out.println("4.88和78.83转换成int型相加的和是： "+numZ);
		
		char charVar = 'T';
		int intVar = (int)charVar;								//将char型强制转换成int型
		System.out.println("将字符T转换成int型变量是："+intVar);
		
		int num1 = 34;
		double num2 = (double)num1/3;						//将int型强制转换成double型
		System.out.println("34的三分之一是： "+num2);
	}
}
