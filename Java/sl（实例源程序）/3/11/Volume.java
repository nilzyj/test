package com.mingrisoft;

import java.util.Scanner;										//������
public class Volume {										//������
	public static void main(String[] args) {						//������
		Scanner scan = new Scanner(System.in);					//ɨ����
		System.out.println("���������εİ뾶��");
		double r = scan.nextDouble();							//��������
		final double PI = 3.1415926;							//���峣��PI
		double volume = 4.0/3.0 * PI * r * r * r;					//�����ε����
		System.out.println("���εİ뾶�ǣ�" + r);					//�����İ뾶
		System.out.println("Բ�����ǣ�" + PI);					//���Բ����
		System.out.println("���ε�����ǣ�" + volume);			//���������
	}
}

