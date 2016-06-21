package com.mingrisoft;

public class Example_01 {
	private int num=10;							// 成员变量
	public int getNum() {							// 成员方法
		return num;							// 返回成员变量的值
	}
	public void setNum(int num) {					// 成员方法
		this.num = num;							// 设置成员变量的值
	}
	public Example_01(){							// 类的构造方法
		try {
			Class.forName("com.mingrisoft.Test");		// 装载zzk.jdbc包中的Test类
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		System.out.println("测试。");				// 在控制台输出“测试。”
	}
	public static void main(String[] args) {
		Example_01 exam=new Example_01();		// 创建类的实例
		exam.setNum(888);						// 调用setNum()方法设置成员变量num的值为888
		System.out.println(exam.getNum());			// 调用getNum()方法输出成员变量的值888
	}
}

