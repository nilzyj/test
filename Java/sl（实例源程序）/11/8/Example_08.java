package com.mingrisoft;

import java.io.FileReader;							// 引用java.io包中的FileReader类
import java.io.IOException;						// 引用java.io包中的IOException类
public class Example_08 {
	private FileReader read=null;					// 声明FileReader对象read
	public void createFile() throws Exception{			// 定义方法，使用throws抛出Exception异常
		read=new FileReader("src/com/mingrisoft/Example_08.java");	// 创建FileReader对象read
		System.out.println("分配内存资源。");
	}
	public void test(){
		try{
			createFile();						// 调用createFile()方法，使用try-catch-finally处理异常
		}catch(Exception ex){
			ex.printStackTrace();					// 输出践踪迹
			System.out.println("创建IO对象异常。");
		}finally{
			if (read!=null){
				try {
					read.close();				// 关闭IO流
					System.out.println("释放内存资源。");
				} catch (IOException e) {
					e.printStackTrace();			// 输出践踪迹
					System.out.println("关闭IO对象异常。");
				}
			}
		}
	}
	public static void main(String[] args) {
		Example_08 ex=new Example_08();			// 创建对象
		ex.test();								// 调用test()方法
	}
}
