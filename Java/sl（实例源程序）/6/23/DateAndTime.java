package com.mingrisoft;

import java.util.Date;									    //����java.util.Date��
public class DateAndTime {							    //������
	public static void main(String[] args) {				    //������
		Date date = new Date();						    //����Date����date
		String time = String.format("%tc", date);		         //��date��ʽ��
		String form = String.format("%tF", date);
		System.out.println("ȫ����ʱ����Ϣ�ǣ�" + time); 	    //����ʽ���������ʱ�����
		System.out.println("��-��-�ո�ʽ��"+form);
	}
}

