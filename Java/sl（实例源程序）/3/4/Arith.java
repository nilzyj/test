package com.mingrisoft;

public class Arith {													//������
	public static void main(String[] args) {								//������
		float number1 = 45.56f;										//����float�ͱ�������ֵ
		int number2 = 152;											//����int�ͱ�������ֵ
		System.out.println("45.56f��152�ĺ�Ϊ��" + number1 + number2); 	//���������֮�����
		System.out.println("45.56f��152�Ĳ�Ϊ��" + (number2 - number1));	//���������֮�����
		System.out.println("45.56f��152�Ļ�Ϊ��" + number1 * number2); 	//��������˵Ļ����
		System.out.println("45.56f��152����Ϊ��" + number1 / number2);		//����������������
	}
}

