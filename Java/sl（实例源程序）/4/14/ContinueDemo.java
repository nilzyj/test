package com.mingrisoft;

public class ContinueDemo{
	public static void main(String[] args) {
		int i = 0;									// 定义循环增量
		System.out.println("十以内的全部奇数是：");
		while (i < 10) {
			i++;									// 累加i的值
			if (i % 2 == 0) {							// 当i的值能被2整除，表示该数不是奇数
				continue; 							// 进行下一次循环
			}
			System.out.print(i + "  ");					// 输出i的值
		}
	}
}

