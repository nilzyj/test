package com.mingrisoft;

public class StringB {
	public static void main(String[] args) {
		String str1 = "盐飞乱蝶舞，花落飘粉奁，奁粉飘落花，舞蝶乱飞盐"; 	//获取字符串
		StringBuilder str2 = new StringBuilder(str1);                   //将字符串添加到字符串生成器
		str2.reverse();                                				//字符串生成器中字符串反转
		int count = 0;										    	//定义变量
		for (int i = 0; i < str1.length(); i++) {					 		//两字符串同索引处字符比较
			if (str1.charAt(i) != str2.charAt(i)) {						//有一个不相等
				System.out.println("这首《咏雪》不是回文诗！");				//输出不是回文诗
				break;                     						//跳出循环
			}
			if (str1.charAt(i) == str2.charAt(i)) { 						//如果相等
				count++;       								//count自加
			}
		}
		if (count == str1.length()) {  								//count和str1长度相等
			System.out.println("这首《咏雪》是回文诗！"); 						//返回是回文诗
		}
	}
}
