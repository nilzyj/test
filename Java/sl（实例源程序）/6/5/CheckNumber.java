package com.mingrisoft;

public class CheckNumber {
	public static void main(String[] args) {
		String s = "12312312"; 							//��ȡ�ַ���
		if (CheckNumber.IsNumber(s)) {					//���÷����жϣ��������true
			System.out.println(s + " �����ָ�ʽ");             	//��������ָ�ʽ
		} else {										//����
			System.out.println(s + " �������ָ�ʽ");
		}
	}
	public static boolean IsNumber(String str) {
		char[] c = str.toCharArray();						//���ַ�����ָ����ַ�����
		for (int i = 0; i < c.length; i++) {						//����ÿһ���ַ�
			if (Character.isDigit(c[i])) {						//��������֣�����ѭ��
			} else {									//����
				return false;							//ֱ�ӷ���false
			}
		}
		return true;									//���������򷵻�true
	}
}

