package com.mingrisoft;

public class ArrayRowColumnSwap { // 创建类
	public static void main(String[] args) {
		int arr[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };		// 创建2维数组
		System.out.println("转置前的矩阵是：");
		printArray(arr); 									// 输出2维数组
		int arr2[][] = new int[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {						// 调整数组行列数据
			for (int j = 0; j < arr[i].length; j++) {
				arr2[j][i] = arr[i][j];
			}
		}
		System.out.println("转置后的矩阵是：");
		printArray(arr2); 								// 输出2维数组
	}

	private static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {					// 遍历数组
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");				// 输出数组元素
			}
			System.out.println();
		}
	}
}
