package com.mingrisoft;

public class StringB {
	public static void main(String[] args) {
		String str1 = "�η��ҵ��裬����Ʈ���ƣ��Ʒ�Ʈ�仨������ҷ���"; 	//��ȡ�ַ���
		StringBuilder str2 = new StringBuilder(str1);                   //���ַ�����ӵ��ַ���������
		str2.reverse();                                				//�ַ������������ַ�����ת
		int count = 0;										    	//�������
		for (int i = 0; i < str1.length(); i++) {					 		//���ַ���ͬ�������ַ��Ƚ�
			if (str1.charAt(i) != str2.charAt(i)) {						//��һ�������
				System.out.println("���ס�ӽѩ�����ǻ���ʫ��");				//������ǻ���ʫ
				break;                     						//����ѭ��
			}
			if (str1.charAt(i) == str2.charAt(i)) { 						//������
				count++;       								//count�Լ�
			}
		}
		if (count == str1.length()) {  								//count��str1�������
			System.out.println("���ס�ӽѩ���ǻ���ʫ��"); 						//�����ǻ���ʫ
		}
	}
}
