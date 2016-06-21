package com.mingrisoft;

import java.util.Arrays;								//导入java.util.Arrays类
public class Taxis {									//创建类
	public static void main(String[] args) {				//主方法
		int arr[] = new int[] { 23, 42, 12, 8,5,10 };			//声明数组
		System.out.println("原一维数组是：");
		for (int i = 0; i < arr.length; i++) {				//循环遍历数组
			System.out.print(arr[i]+"  ");				//输出原来数组
		}
		Arrays.sort(arr);							//将数组进行排序
		System.out.println("\n升序排列后的数组是：");
		for (int i = 0; i < arr.length; i++) {				//循环遍历排序后的数组
			System.out.print(arr[i]+"  ");				//将排序后数组中的各个元素输出
		}
	}
}
