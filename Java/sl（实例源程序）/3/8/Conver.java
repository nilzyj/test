package com.mingrisoft;

public class Conver{									//������
	public static void main(String[] args) {				//������
		byte mybyte = 127; 							//����byte�ͱ���mybyte������ֵ127
		int myint = 150; 							//����int�ͱ���myint������ֵ150
		float myfloat = 452.12f;						//����float�ͱ���myfloat������ֵ
		char mychar = 10;							//����char�ͱ���mychar������ֵ
		double mydouble = 45.46546; 					//����double�ͱ���������ֵ
		//����������� 
		System.out.println("127��452.12��ӵĺ��ǣ�" + (mybyte + myfloat));
		System.out.println("127��150��˵Ļ��ǣ�" + mybyte * myint);
		System.out.println("127��10�������ǣ�" + mybyte / mychar);
		System.out.println("45.46546��10��ӵĺ��ǣ�" + (mydouble + mychar));
	}
}

