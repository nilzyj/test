package com.mingrisoft;

public class ContinueDemo{
	public static void main(String[] args) {
		int i = 0;									// ����ѭ������
		System.out.println("ʮ���ڵ�ȫ�������ǣ�");
		while (i < 10) {
			i++;									// �ۼ�i��ֵ
			if (i % 2 == 0) {							// ��i��ֵ�ܱ�2��������ʾ������������
				continue; 							// ������һ��ѭ��
			}
			System.out.print(i + "  ");					// ���i��ֵ
		}
	}
}

