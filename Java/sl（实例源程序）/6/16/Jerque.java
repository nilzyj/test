package com.mingrisoft;

public class Jerque {										//�½���
	public static void main(String[] args) {					//������
		String str = "";									//�������ַ���
		long starTime = System.currentTimeMillis();			//����ִ�в�������ʼʱ��
		for(long i = 0;i<1000000;i++){						//forѭ��ִ��1000000�β���
			str = str+i;									//ѭ��׷���ַ���
		}
		long endTime = System.currentTimeMillis();			//������ַ����������ʱ��
		long time = endTime - starTime;					//����ִ�в�����ʱ��
		System.out.println("Sting����ʱ�䣺"+time);			//��ִ�е�ʱ�����
		StringBuilder builder = new StringBuilder("");		//�����ַ���������
		starTime= System.currentTimeMillis();				//�������ִ��ǰ��ʱ��		
		for(long j = 0;j<1000000;j++){						//����forѭ�����в���
			builder.append(j);							//ѭ��׷���ַ�
		}
		endTime = System.currentTimeMillis();				//����������ʱ��	
		time = endTime - starTime;						//׷�Ӳ���ִ�е�ʱ��
		System.out.println("StringBuilder����ʱ�䣺"+time);	//������ʱ�����
	}
}
