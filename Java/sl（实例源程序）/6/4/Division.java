package com.mingrisoft;

public class Division {							     			//������
	public static void main(String args[]) {			     			//������
		String s =  "���Զ�����¥�����繳����į��ͩ��Ժ�����" +
	 		      "�����ϡ����ҡ���������һ����ζ����ͷ��";
System.out.println("ԭ�ַ����ĳ����ǣ�"+s.length());
		String[] news = s.split("��|��");				         		//split()��������ַ���
		for (int i = 0; i < news.length; i++) {			     			//ʹ��forѭ�������ַ�����
		System.out.println(news[i]);			          			//����ַ�����
		}
		System.out.println("���к��ַ�������ĳ����ǣ�"+news.length);	//����ַ����鳤��
	}
}

