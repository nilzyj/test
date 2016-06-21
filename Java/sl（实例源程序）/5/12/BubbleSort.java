package com.mingrisoft;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array=new int[]{63,4,24,1,3,13};				//声明并初始化一维数组
		System.out.println("冒泡排序法的过程是：");
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < array.length - i; j++) {			// 比较相邻两个元素，较大的数往后冒泡
				if (array[j] > array[j + 1]) {
				int temp = array[j];					// 把第一个元素值保持到临时变量中
				array[j] = array[j + 1];					// 把第二个元素值保存到第一个元素单元中
				array[j + 1] = temp;					// 把第一个元素原值保存到第二个元素中
				}
				System.out.print(array[j] + "  ");		// 把排序后的数组元素显示到文本域中
			}
			System.out.print("【");
			for (int j = array.length - i; j < array.length; j++) {
			System.out.print(array[j] + "  ");			// 把排序后的数组元素显示到文本域中
			}
			System.out.println("】");
		}
	}
}
