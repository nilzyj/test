package com.mingrisoft;

public class Blak {
	public static void main(String[] args) {
		String text = " we are students ";                 //�����ַ���text��ǰ���һ�ո�
		String s = "";                                  //������ַ���s
		for (int i = 0; i < text.length(); i++) {               //�����ַ���ÿ���ַ�
			char c = text.charAt(i);                     //�����ַ�����c
			if (c == ' ')                                //���c�ǿո�
				continue;                            //��ֹ���β���
			else                                     //���c���ǿո�
				s = s + c;                            //��c���ӵ��ַ���s��
		}
		System.out.println(s);                           //���s
	}
}

