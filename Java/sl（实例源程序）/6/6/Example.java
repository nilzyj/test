package com.mingrisoft;

import java.util.Date;                                                 	//������
import java.util.Locale;
public class Example {
public static void main(String[] args) {
         Date today = new Date();
    		String a = String.format(Locale.US, "%tb", today); 		 	// ��ʽ��Ϊ�·ݵ�Ӣ����д
  		String b = String.format(Locale.US, "%tB", today); 	       	// ��ʽ��Ϊ�·ݵ�Ӣ��ȫд
  		String c = String.format("%ta", today); 				     	// ��ʽ��Ϊ���ڼ��
String d = String.format("%tA", today); 				   	// ��ʽ��Ϊ����ȫ��
String e = String.format("%tY", today); 				  	// ��ʽ��Ϊ4λ�����ֵ
String f = String.format("%ty", today); 				 		// ��ʽ��Ϊ2λ�����ֵ
         	String g = String.format("%tm", today); 					// ��ʽ��Ϊ2λ���·�ֵ
         	String h = String.format("%td", today); 					// ��ʽ��Ϊ2λ������ֵ
String i = String.format("%te", today); 				      	// ��ʽ��Ϊ1λ������ֵ

         System.out.println("��ʽ������ַ���Ϊ�·ݵ�Ӣ����д: " + a);
         System.out.println("��ʽ������ַ���Ϊ�·ݵ�Ӣ����д: " + b);
         System.out.println("�¸�ʽ������ַ���Ϊ����: " + c);
         System.out.println("��ʽ������ַ���Ϊ����: " + d);
         System.out.println("��ʽ������ַ���Ϊ4λ�����ֵ: " + e);
         System.out.println("��ʽ������ַ���Ϊ2λ�����ֵ: " + f);
         System.out.println("��ʽ������ַ���Ϊ2λ���·�ֵ: " + g);
         System.out.println("��ʽ������ַ���Ϊ2λ������ֵ: " + h);
         System.out.println("��ʽ������ַ���Ϊ1λ������ֵ: " + i);
    }
}

