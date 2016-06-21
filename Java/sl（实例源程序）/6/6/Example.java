package com.mingrisoft;

import java.util.Date;                                                 	//包声明
import java.util.Locale;
public class Example {
public static void main(String[] args) {
         Date today = new Date();
    		String a = String.format(Locale.US, "%tb", today); 		 	// 格式化为月份的英文缩写
  		String b = String.format(Locale.US, "%tB", today); 	       	// 格式化为月份的英文全写
  		String c = String.format("%ta", today); 				     	// 格式化为星期简称
String d = String.format("%tA", today); 				   	// 格式化为星期全称
String e = String.format("%tY", today); 				  	// 格式化为4位的年份值
String f = String.format("%ty", today); 				 		// 格式化为2位的年份值
         	String g = String.format("%tm", today); 					// 格式化为2位的月份值
         	String h = String.format("%td", today); 					// 格式化为2位的日期值
String i = String.format("%te", today); 				      	// 格式化为1位的日期值

         System.out.println("格式化后的字符串为月份的英文缩写: " + a);
         System.out.println("格式化后的字符串为月份的英文缩写: " + b);
         System.out.println("月格式化后的字符串为星期: " + c);
         System.out.println("格式化后的字符串为星期: " + d);
         System.out.println("格式化后的字符串为4位的年份值: " + e);
         System.out.println("格式化后的字符串为2位的年份值: " + f);
         System.out.println("格式化后的字符串为2位的月份值: " + g);
         System.out.println("格式化后的字符串为2位的日期值: " + h);
         System.out.println("格式化后的字符串为1位的日期值: " + i);
    }
}

