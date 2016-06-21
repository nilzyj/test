package com.mingrisoft;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Example_07 {
	private FileReader read=null;			// 声明FileReader对象read
	public void readFileInfo(){				// 定义方法
		try{
			try {
				read=new FileReader("src/com/mingrisoft/Example_07.java");// 创建FileReader对象read
				System.out.println("找到指定的文件，创建IO对象成功！");
			} catch (FileNotFoundException e) {
				e.printStackTrace();		// 输出践踪迹
			}
		}finally{
			if (read!=null){
				try{
					read.close();			// 关闭FileReader对象read，释放资源
					System.out.println("关闭IO对象！");
				}catch(IOException ioe){
					ioe.printStackTrace();				// 输出践踪迹
					System.out.println("关闭IO对象发生异常。");
				}
			}
		}
	}
	public static void main(String[] args) {
		Example_07 ex=new Example_07();				// 创建对象
		ex.readFileInfo();								// 调用readFileInfo()方法
	}

}
