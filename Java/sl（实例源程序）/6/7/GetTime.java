package com.mingrisoft;

import java.util.Date;
public class GetTime {
public static void main(String[] args) {
		 Date date=new Date();
	      System.out.println("Ĭ��ʱ���ʽ��"+date);
		 System.out.println("��λ24Сʱ�Ƶ�Сʱ��"+String.format("%tH", date));
		 System.out.println("��λ12Сʱ�Ƶ�Сʱ��"+String.format("%tI", date));
		 System.out.println("24Сʱ�Ƶ�Сʱ��"+String.format("%tk", date));
		 System.out.println("12Сʱ�Ƶ�Сʱ��"+String.format("%tl", date));
		 System.out.println("��λСʱ�еķ��ӣ�"+String.format("%tM", date));
		 System.out.println("��λ�����е��룺"+String.format("%tS", date));
		 System.out.println("��ʾʱ����д��ʽ���ַ�����"+String.format("%tZ", date));
System.out.println("���绹�����磺"+String.format("%tp", date));
	}
}

