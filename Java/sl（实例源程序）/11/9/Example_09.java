package com.mingrisoft;

public class Example_09 {
	final static double PI=3.14;								// Բ����
	public void computeArea(double r) throws Exception{		// ���ݰ뾶����Բ����ķ���
		if (r<=20.0){ 
			throw new Exception("�����쳣��\n�뾶Ϊ ��"+r+"\n�뾶����С��20��");// ʹ��throw����׳��쳣
		}else{
			double circleArea=PI*r*r;						// ����Բ�����
			System.out.println("�뾶��"+r+"��Բ����ǣ�"+circleArea);
		}
	}
	public static void main(String[] args) {
		Example_09 ex=new Example_09();					// ��������
		try {
			ex.computeArea(10);						// ���÷���
		} catch (Exception e) {
			System.out.println(e.getMessage());			// ����쳣��Ϣ
		}
	}
}

