package com.mingrisoft;

public class InsertSort {
	public static void main(String[] args) {
		int[] array=new int[]{20,40,90,30,80,70,50};
		System.out.println("排序前：");
		for (int i = 0; i < array.length; i++) {				// 初始化数组元素
			System.out.print(array[i]+" ");				// 输出数组元素
		}
		int tmp;									// 定义临时变量
		int j;
		for (int i = 1; i < array.length; i++) {
			tmp = array[i];							// 保存临时变量
			for (j = i - 1; j >= 0 && array[j] > tmp; j--) {
				array[j + 1] = array[j];					// 数组元素交换
			}
			array[j + 1] = tmp;						// 在排序位置插入数据
		}
		System.out.println("\n排序后：");
		for (int i = 0; i < array.length; i++) {				// 初始化数组元素
	 		System.out.print(array[i]+" ");				// 输出数组元素
		}
	}
}
