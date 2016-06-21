package com.mingrisoft;

public class CheckIPAddress {
    public static void main(String[] args) {
         String ip = "192.168.1.1";									//创建判定的IP
         System.out.println(matches(ip));
    }
    public static String matches(String text) {
         if (text != null && !text.isEmpty()) {                              // 定义正则表达式
             String regex =  "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                            + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                            + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                            + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
         if (text.matches(regex)) {                                     // 判断ip地址是否匹配
             return text + "\n是一个合法的IP地址！";            
          } else {
              return text + "\n不是一个合法的IP地址！";
          }
    }
    return "请输入要验证的IP地址！";
}}

