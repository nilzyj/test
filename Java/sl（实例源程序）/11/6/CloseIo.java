package com.mingrisoft;

import java.io.FileInputStream;
import java.io.IOException;

public class CloseIo {

	private FileInputStream in=null;			// 声明FileInputStream对象in
	public void readInfo(){				// 定义方法
		try{
			// 创建FileInputStream对象in
			in=new FileInputStream("src/com/mingrisoft/CloseIo.java");
			System.out.println("创建IO流，分配内存资源。");
		}catch(IOException io){
			io.printStackTrace();			// 输出践踪迹
			System.out.println("创建IO对象发生异常。");
		}finally{
			if (in!=null){
				try{
					in.close();			// 关闭FileInputStream对象in，释放资源
					System.out.println("关闭IO流，释放内存资源。");
				}catch(IOException ioe){
					ioe.printStackTrace();				// 输出践踪迹
					System.out.println("关闭IO对象发生异常。");
				}
			}
		}
	}
	public static void main(String[] args) {
		CloseIo ex=new CloseIo();				// 创建对象
		ex.readInfo();								// 调用readInfo()方法
	}


}
