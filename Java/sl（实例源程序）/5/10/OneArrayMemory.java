package com.mingrisoft;

public class OneArrayMemory {
	public static void main(String[] args) {
		int num1 = 1024 * 1024 * 2; 						// 数组中元素的个数
		int[] arr1 = new int[num1]; 						// 创建int型一维数组
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = i; 								// 为数组元素赋值
		}
		// 获得占用内存总数，并将单位转换为M
		long memory1 = Runtime.getRuntime().totalMemory() / 1024 / 1024;
		System.out.println("占用内存总量为：" + memory1);
		int num2 = 1024 * 1024; 							// 数组中元素的个数
		int[][] arr2 = new int[num2][2]; 						// 创建int型二维数组
		for (int i = 0; i < arr2.length; i++) {
			arr2[i][0] = i; 								// 为数组元素赋值
			arr2[i][1] = i; 								// 为数组元素赋值
		}
		// 获得占用内存总数，并将单位转换为M
		long memory2 = Runtime.getRuntime().totalMemory() / 1024 / 1024;
		System.out.println("占用内存总量为：" + memory2);
	}
}
