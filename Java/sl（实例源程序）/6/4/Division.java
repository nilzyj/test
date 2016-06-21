package com.mingrisoft;

public class Division {							     			//创建类
	public static void main(String args[]) {			     			//主方法
		String s =  "无言独上西楼，月如钩，寂寞梧桐深院锁清秋。" +
	 		      "剪不断、理还乱、是离愁，别是一般滋味在心头。";
System.out.println("原字符串的长度是："+s.length());
		String[] news = s.split("，|。");				         		//split()方法拆分字符串
		for (int i = 0; i < news.length; i++) {			     			//使用for循环遍历字符数组
		System.out.println(news[i]);			          			//输出字符数组
		}
		System.out.println("分行后字符串数组的长度是："+news.length);	//输出字符数组长度
	}
}

