package com.mingrisoft;

public class NewException extends Exception {			// 创建自定义异常类
	public NewException(Double r) {					// 有一个Double类型形参的构造方法
		System.out.println("发生异常： 圆的半径不能小于20");
		System.out.println("圆的半径为: "+r);
	}
}