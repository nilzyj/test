package com.mingrisoft;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class FormatNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);								// 创建输入流扫描器
        System.out.println("请输入一个数字：");
        double number = scan.nextDouble();									// 获取用户输入数字
        System.out.println("Locale类的常量作为构造参数获得不同的货币格式：");
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA); 	// 创建格式化对象
        System.out.println("Locale.CHINA：" + format.format(number)); 			// 输出格式化的货币
        format = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Locale.US：" + format.format(number));
        format = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
        System.out.println("Locale.ENGLISH：" + format.format(number));
        format = NumberFormat.getCurrencyInstance(Locale.TAIWAN);
        System.out.println("Locale.TAIWAN：" + format.format(number));
    }	
}

