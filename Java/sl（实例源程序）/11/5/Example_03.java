package com.mingrisoft;

public class Example_03 {
	public void printBugInfo(){				// 定义成员方法
		try{
			int x=100;					// 定义局部变量x
			int y=0;					// 定义局部变量y
			int z=x / y;					// 计算x除以y的商
			// 输出计算结果
			System.out.println(x+"除以"+y+"的商是："+z);
		}catch(Exception ex){
			ex.printStackTrace();				// 输出异常到标准错误流
			// 使用getMessage方法输出异常信息
			System.out.println("getMessage方法：   "+ex.getMessage());
			// 使用getLocalizedMessage方法输出异常信息
			System.out.println("getLocalizedMessage方法：   "+ex.getLocalizedMessage());
			// 使用toString方法输出异常信息
			System.out.println("toString方法：   "+ex.toString());			
		}
	}
	public static void main(String[] args) {
		Example_03 ex=new Example_03();		// 创建类的实例
		ex.printBugInfo();					// 调用方法
	}
}

