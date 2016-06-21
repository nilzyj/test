package com.mingrisoft;

import java.util.Arrays;
public class Cope {										//创建类
	public static void main(String[] args) {					//主方法
		int arr[] = new int[] { 23, 42, 12 };					//定义数组
		System.out.println("复制后的数组是：");
		for (int i = 0; i < arr.length; i++) {					//循环遍历数组
			System.out.print(arr[i]+"  ");					//将原来数组输出
		}
		int newarr[] = Arrays.copyOf(arr, 5);					//复制数组arr
		System.out.println("\n复制后的数组是：");
		for (int i = 0; i < newarr.length; i++) {					//循环变量复制后的新数组
			System.out.print(newarr[i]+"  ");				//将新数组输出
		}
	}
}
