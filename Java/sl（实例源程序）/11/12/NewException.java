package com.mingrisoft;

public class NewException extends Exception {			// �����Զ����쳣��
	public NewException(Double r) {					// ��һ��Double�����βεĹ��췽��
		System.out.println("�����쳣�� Բ�İ뾶����С��20");
		System.out.println("Բ�İ뾶Ϊ: "+r);
	}
}