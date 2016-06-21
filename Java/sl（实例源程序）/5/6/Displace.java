package com.mingrisoft;

import java.util.Arrays;									//导入java.util.Arrays类
public class Displace {									//创建类
	public static void main(String[] args) {					//主方法
		int arr[] = new int[] { 45, 12, 2, 10,1};					//定义并初始化int型数组arr
		Arrays.fill(arr, 1, 3, 8);							//使用fill方法对数组进行初始化
		for (int i = 0; i < arr.length; i++) {					//循环遍历数组中元素
			System.out.println("第" + i + "个元素是：" + arr[i]);	//将数组中的每个元素输出
		}
	}
}
