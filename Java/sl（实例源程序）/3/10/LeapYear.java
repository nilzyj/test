package com.mingrisoft;

import java.util.Scanner;											//声明包
public class LeapYear {											//声明类
    public static void main(String[] args) {								//主方法
        Scanner scan = new Scanner(System.in);						//扫描器
        System.out.println("请输入一个年份：");
        long year = scan.nextLong();								// 接收用户输入
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) { 			// 判断是否是闰年
            System.out.print(year + "年是闰年！");						// 输出是闰年
        } else {												
            System.out.print(year + "年不是闰年！");					// 输出不是闰年
        }
    }
}
