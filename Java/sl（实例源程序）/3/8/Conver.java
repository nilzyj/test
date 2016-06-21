package com.mingrisoft;

public class Conver{									//创建类
	public static void main(String[] args) {				//主方法
		byte mybyte = 127; 							//定义byte型变量mybyte，并赋值127
		int myint = 150; 							//定义int型变量myint，并赋值150
		float myfloat = 452.12f;						//定义float型变量myfloat，并赋值
		char mychar = 10;							//定义char型变量mychar，并赋值
		double mydouble = 45.46546; 					//定义double型变量，并赋值
		//将运算结果输出 
		System.out.println("127与452.12相加的和是：" + (mybyte + myfloat));
		System.out.println("127与150相乘的积是：" + mybyte * myint);
		System.out.println("127被10除的商是：" + mybyte / mychar);
		System.out.println("45.46546和10相加的和是：" + (mydouble + mychar));
	}
}

