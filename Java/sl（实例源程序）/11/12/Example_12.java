package com.mingrisoft;

public class Example_12 {
	public static void showArea(double r) throws NewException {		// ������Բ����ķ���
		if (r <= 20) {
			throw new NewException(r);	// �׳��쳣
		}
		double area = 3.14 * r * r;						// ����Բ�����
		System.out.println("Բ������ǣ�" + area);		// ���Բ�����
	}
	public static void main(String[] args) {
		try {
			showArea(10);							// ����showArea()���������ݰ뾶10
		} catch (NewException ex) {
			System.out.println(ex);					// ����쳣��Ϣ
		}
	}
	
	

}
