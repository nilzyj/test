package com.mingrisoft;

public class CharacterUnicode{
	public static void main(String[] args) {
		String text = "����soft"; 							// ��ȡ�û�������ַ���
		char[] charArray = text.toCharArray(); 				// ��ȡ�ַ������ַ�����
		StringBuilder builder = new StringBuilder();			// �����ַ���������
		for (char c : charArray) { 							// �����ַ�����
			builder.append((int) c + " "); 					// ת����Unicode�벢׷�ӵ�builder��
		}
   		System.out.println("������soft����Unicode���ǣ�");
		System.out.println(builder.toString());			 	// ���������ı���
	}
}

