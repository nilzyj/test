package com.mingrisoft;

public class Example_09 {
	final static double PI=3.14;								// 圆周率
	public void computeArea(double r) throws Exception{		// 根据半径计算圆面积的方法
		if (r<=20.0){ 
			throw new Exception("程序异常：\n半径为 ："+r+"\n半径不能小于20。");// 使用throw语句抛出异常
		}else{
			double circleArea=PI*r*r;						// 计算圆的面积
			System.out.println("半径是"+r+"的圆面积是："+circleArea);
		}
	}
	public static void main(String[] args) {
		Example_09 ex=new Example_09();					// 创建对象
		try {
			ex.computeArea(10);						// 调用方法
		} catch (Exception e) {
			System.out.println(e.getMessage());			// 输出异常信息
		}
	}
}

