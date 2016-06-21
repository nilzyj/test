package com.mingrisoft;

public class CharacterUnicode{
	public static void main(String[] args) {
		String text = "明日soft"; 							// 获取用户输入的字符串
		char[] charArray = text.toCharArray(); 				// 获取字符串的字符数组
		StringBuilder builder = new StringBuilder();			// 创建字符串生成器
		for (char c : charArray) { 							// 遍历字符数组
			builder.append((int) c + " "); 					// 转换成Unicode码并追加到builder中
		}
   		System.out.println("“明日soft”的Unicode码是：");
		System.out.println(builder.toString());			 	// 结果输出到文本框
	}
}

