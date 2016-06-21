package com.mingrisoft;

import java.util.StringTokenizer;                                   	//包声明
public class StringTo {
	public static void main(String[] args) {
		String text = "  We are students  ";			            	//定义包含空格的字符串
		System.out.println("原字符串是：");
System.out.println(text);
		StringTokenizer st = new StringTokenizer(text," ");	   	//使用空格来分割字符串
		StringBuffer sb = new StringBuffer();			             	//定义字符串缓存对象
		int i = 1; 
		while(st.hasMoreTokens()){				            	//判断字符串中是否还有空格
			i++;	
			sb.append(st.nextToken());				        	//向字符串生成器中追加内容
		}
         	System.out.println("去掉字符串中所有空格之后的字符串是：");
		System.out.println(sb.toString());
 }
}

