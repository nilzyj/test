package com.mingrisoft;

public class Trace {											// 创建类
	public static void main(String[] args) {
		int arr[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };		// 创建2维数组
		int tr = 0;
		System.out.println("方阵arr[][]是：");
		for (int i = 0; i < arr.length; i++) {						// 遍历数组
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");					// 输出数组元素
			}
			System.out.println();
		}
		for (int i = 0; i < arr.length; i++) {
			tr += arr[i][i];
		}
		System.out.println("方阵arr[][]的迹是："+tr);
	}
}
