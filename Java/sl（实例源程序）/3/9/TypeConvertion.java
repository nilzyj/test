package com.mingrisoft;

public class TypeConvertion {									//������
	public static void main(String[]args){							//������
		int intNum = 4;										//�������
		float floatNum = 9.5F;
		
		floatNum /= intNum;									//�Զ�����ת����float��
		System.out.println("9.5F����4�����ǣ�"+floatNum);
		
		double numX = 4.88;
		double numY = 78.83;
		int numZ = (int)numX+(int)numY;						//��double��ǿ��ת����int��
		System.out.println("4.88��78.83ת����int����ӵĺ��ǣ� "+numZ);
		
		char charVar = 'T';
		int intVar = (int)charVar;								//��char��ǿ��ת����int��
		System.out.println("���ַ�Tת����int�ͱ����ǣ�"+intVar);
		
		int num1 = 34;
		double num2 = (double)num1/3;						//��int��ǿ��ת����double��
		System.out.println("34������֮һ�ǣ� "+num2);
	}
}
