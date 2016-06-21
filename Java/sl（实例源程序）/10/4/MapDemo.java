package com.mingrisoft;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>(); 			// 创建Map集合
		map.put("1", "apple");										// 向集合添加对象
		map.put("2", "pear");
		map.put("3", "orange");
		for (int i = 1; i <= 3; i++) {
			System.out.println("第"+i+"元素是："+map.get("" + i + ""));			// 输出对应位置元素值
		}
	}
}
