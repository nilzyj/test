package com.mingrisoft;

public class Part {											//�½���Part
	static final double PI = 3.14;								//��������PI
	static int age = 23;										//����int�ͱ���age�����и�ֵ
	public static void main(String[] args) {						//������
		final int number; 									//����int�ͳ���number
		number = 1235;									//�Գ������и�ֵ
		age = 22;											//�ٴζԱ������и�ֵ
		System.out.println("����PI��ֵΪ��" + PI);				//��PI��ֵ���
		System.out.println("��ֵ��number��ֵΪ:" + number);		//��number��ֵ���
		System.out.println("int�ͱ���age��ֵΪ��" + age);			//��age��ֵ���
	}
}
