package com.mingrisoft;

public class CheckHandSetNum {
    public static void main(String[] args) {
         String telephone1 = "11024588795";						// 定义要验证的号码
         String telephone2 = "15044268138";
         System.out.println(check(telephone1));
         System.out.println(check(telephone2));
    }
    public static String check(String handset) {
         String regex = "1[3,5,8]\\d{9}$";		                       // 定义正则表达式
         if (handset.matches(regex)) {							    	// 测试匹配结果
             return handset + "\n是合法的手机号";			         // 提示合法手机号码
         } else {
             return handset + "\n不是合法的手机号";			         // 提示非法手机号码
         }
    }
}

