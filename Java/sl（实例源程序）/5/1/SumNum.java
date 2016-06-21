package com.mingrisoft;

public class SumNum {
	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; 				// 创建并初始化一维数组num
		int sum = 0; 									// 进行累加求和的变量sum
		System.out.println("一维数组中各元素的和是：");
		for (int i = 0; i < 10; i++) { 							// 通过for循环遍历数组
			if (i == 9) {									// 判断数组的下标是否为9
				System.out.print(num[i] + "=");				// 数组元素的下标是9，输出等号
			} else {
				System.out.print(num[i] + "+");				// 数组元素的下标不是9，输出加号
			}
			sum = sum + num[i];							// 进行累加求和
		}
		System.out.println(sum);							// 输出和
	}
}
