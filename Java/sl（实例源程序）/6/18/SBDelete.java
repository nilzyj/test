package com.mingrisoft;

public class SBDelete {
	public static void main(String[]args){
		String s = "命运如同海风——吹着青春的舟，飘摇的，曲折的，渡过了时间的海！";
		StringBuilder sb = new StringBuilder(s);					//创建字符串生成器并赋值
		System.out.println("原来的字符串是："+sb);					//输出原字符串
		System.out.println("原来的字符串长度是："+sb.length());			//输出原字符串长度
		for (int i=0;i<sb.length();i++){
			for (int j=i+1;j<sb.length();j++){							//每个字符和其后的进行比较
				if (sb.charAt(i)==sb.charAt(j)){						//如果字符相同
					sb.deleteCharAt(j);							//将后面的删除
				}
			}
		}
		System.out.println("现在的字符串是："+sb);					//输出新字符串
		System.out.println("现在的字符串长度是："+sb.length());			//输出新字符串长度
	}
}

