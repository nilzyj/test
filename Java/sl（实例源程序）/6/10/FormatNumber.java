package com.mingrisoft;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class FormatNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);								// ����������ɨ����
        System.out.println("������һ�����֣�");
        double number = scan.nextDouble();									// ��ȡ�û���������
        System.out.println("Locale��ĳ�����Ϊ���������ò�ͬ�Ļ��Ҹ�ʽ��");
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA); 	// ������ʽ������
        System.out.println("Locale.CHINA��" + format.format(number)); 			// �����ʽ���Ļ���
        format = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Locale.US��" + format.format(number));
        format = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
        System.out.println("Locale.ENGLISH��" + format.format(number));
        format = NumberFormat.getCurrencyInstance(Locale.TAIWAN);
        System.out.println("Locale.TAIWAN��" + format.format(number));
    }	
}

