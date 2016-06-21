package com.mingrisoft;

public class MinNum {
	public static void main(String[] args) {
		int[] num = { 8, 3, 4, 1, 6, 10 }; 							// 创建并初始化一维数组num
		System.out.println("输出一维数组：");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + "  ");						//输出一维数组
		}
		int max = num[0];
		for (int j = 0; j < num.length - 1; j++) { 					// 通过for循环遍历数组
			if (max < num[j + 1]) {
				max = num[j + 1];
			}
		}
		System.out.println("\n一维数组的最大值是：" + max); 		// 输出数组的最大值
	}
}
