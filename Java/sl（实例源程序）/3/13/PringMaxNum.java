package com.mingrisoft;

public class PringMaxNum {
	public static void main(String[]args){
		int num1 = 34;
		int num2 = 89;
		boolean b = num1>num2;
		int maxNum = num1>num2?num1:num2;
		System.out.println("数字1是："+num1);
		System.out.println("数字2是："+num2);
		System.out.println("两数是否相等："+b);
		System.out.println("两数中较大的是："+maxNum);
	}

}
