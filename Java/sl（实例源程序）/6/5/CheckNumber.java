package com.mingrisoft;

public class CheckNumber {
	public static void main(String[] args) {
		String s = "12312312"; 							//获取字符串
		if (CheckNumber.IsNumber(s)) {					//调用方法判断，如果返回true
			System.out.println(s + " 是数字格式");             	//输出是数字格式
		} else {										//否则
			System.out.println(s + " 不是数字格式");
		}
	}
	public static boolean IsNumber(String str) {
		char[] c = str.toCharArray();						//将字符串拆分赋给字符数组
		for (int i = 0; i < c.length; i++) {						//遍历每一个字符
			if (Character.isDigit(c[i])) {						//如果是数字，继续循环
			} else {									//否则
				return false;							//直接返回false
			}
		}
		return true;									//都是数字则返回true
	}
}

