package com.mingrisoft;

import java.util.Arrays;
public class Repeat {											//创建类
	public static void main(String[] args) {						//主方法
		int arr[] = new int[] { 23, 42, 12, 84, 10 };					//定义数组
		System.out.println("原来的数组是：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"  ");						//输出原来的数组
		}
		int newarr[] = Arrays.copyOfRange(arr, 0, 3);				//复制数组
		System.out.println("\n将数组下标0~3复制到新数组中：");
		for (int i = 0; i < newarr.length; i++) {						//循环遍历复制后的新数组
			System.out.print(newarr[i]+"  ");					//将新数组中的每个元素输出
		}
	}
}
