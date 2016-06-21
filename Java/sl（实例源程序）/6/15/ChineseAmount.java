package com.mingrisoft;

import java.util.regex.Pattern;
public class ChineseAmount {
	public static void main(String[] args) {
		String text = "明日科技soft";					// 获取用户输入
		int amount = 0;								// 创建汉字数量计数器
		for (int i = 0; i < text.length(); i++) {				// 遍历字符串每一个字符
												// 使用正则表达式判断字符是否属于汉字编码
			boolean matches = Pattern.matches("^[\u4E00-\u9FA5]{0,}$", ""
							+ text.charAt(i));
			if (matches) {							// 如果是汉字
				amount++;						// 累加计数器
			}
		}
		System.out.println("明日科技soft" + "中有几个汉字："+ amount + "个");
	}
}

