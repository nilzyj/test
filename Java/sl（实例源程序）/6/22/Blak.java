package com.mingrisoft;

public class Blak {
	public static void main(String[] args) {
		String text = " we are students ";                 //定义字符串text，前后各一空格
		String s = "";                                  //定义空字符串s
		for (int i = 0; i < text.length(); i++) {               //遍历字符串每个字符
			char c = text.charAt(i);                     //定义字符变量c
			if (c == ' ')                                //如果c是空格
				continue;                            //终止本次操作
			else                                     //如果c不是空格
				s = s + c;                            //将c连接到字符串s中
		}
		System.out.println(s);                           //输出s
	}
}

