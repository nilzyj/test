package com.mingrisoft;

public class CheckHandSetNum {
    public static void main(String[] args) {
         String telephone1 = "11024588795";						// ����Ҫ��֤�ĺ���
         String telephone2 = "15044268138";
         System.out.println(check(telephone1));
         System.out.println(check(telephone2));
    }
    public static String check(String handset) {
         String regex = "1[3,5,8]\\d{9}$";		                       // ����������ʽ
         if (handset.matches(regex)) {							    	// ����ƥ����
             return handset + "\n�ǺϷ����ֻ���";			         // ��ʾ�Ϸ��ֻ�����
         } else {
             return handset + "\n���ǺϷ����ֻ���";			         // ��ʾ�Ƿ��ֻ�����
         }
    }
}

