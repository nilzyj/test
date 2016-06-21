package com.mingrisoft;

public class CheckIPAddress {
    public static void main(String[] args) {
         String ip = "192.168.1.1";									//�����ж���IP
         System.out.println(matches(ip));
    }
    public static String matches(String text) {
         if (text != null && !text.isEmpty()) {                              // ����������ʽ
             String regex =  "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                            + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                            + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                            + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
         if (text.matches(regex)) {                                     // �ж�ip��ַ�Ƿ�ƥ��
             return text + "\n��һ���Ϸ���IP��ַ��";            
          } else {
              return text + "\n����һ���Ϸ���IP��ַ��";
          }
    }
    return "������Ҫ��֤��IP��ַ��";
}}

