package com.mingrisoft;

public class SumNum {
	public static void main(String[] args) {
		int[][] num = {{ 1, 2, 3},{ 4, 5, 6}, {7, 8, 9, 10} }; 				// 创建并初始化二维数组num
		int sum = 0; 									// 进行累加求和的变量sum
		System.out.println("二维数组中各元素的和是：");
		for (int i = 0; i < num.length; i++) { 							// 通过for循环遍历数组
			for(int j = 0;j<num[i].length;j++){		
			sum = sum + num[i][j];							// 进行累加求和
			}
		}	
		System.out.println(sum);							// 输出和
	}
}
