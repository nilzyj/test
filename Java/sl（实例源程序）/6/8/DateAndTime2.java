package com.mingrisoft;

import java.util.Date;
public class DateAndTime2 {
	public static void main(String[] args) {
		Date date=new Date();
		System.out.println("Ĭ�ϵ�����ʱ���ʽ��"+date);
		System.out.println("24Сʱ�Ƶ�ʱ�䣬����ʽ��ΪСʱ�ͷ��� ��"+String.format("%tR", date));
		System.out.println("24Сʱ�Ƶ�ʱ�䣬����ʽ��ΪСʱ�����Ӻ��룺"+String.format("%tT", date));
		System.out.println("12Сʱ�Ƶ�ʱ�䣬����ʽ��Ϊ��"+String.format("%tr", date));
		System.out.println("���ڱ���ʽ��Ϊ��"+String.format("%tD", date));
		System.out.println("ISO 8601��ʽ���������ڣ�����ʽ��Ϊ��"+String.format("%tF", date));
		System.out.println("���ں�ʱ�䱻��ʽ��Ϊ��"+String.format("%tc", date));
	}
}

