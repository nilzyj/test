package com.mingrisoft;

public class SBDelete {
	public static void main(String[]args){
		String s = "������ͬ���硪�������ഺ���ۣ�Ʈҡ�ģ����۵ģ��ɹ���ʱ��ĺ���";
		StringBuilder sb = new StringBuilder(s);					//�����ַ�������������ֵ
		System.out.println("ԭ�����ַ����ǣ�"+sb);					//���ԭ�ַ���
		System.out.println("ԭ�����ַ��������ǣ�"+sb.length());			//���ԭ�ַ�������
		for (int i=0;i<sb.length();i++){
			for (int j=i+1;j<sb.length();j++){							//ÿ���ַ������Ľ��бȽ�
				if (sb.charAt(i)==sb.charAt(j)){						//����ַ���ͬ
					sb.deleteCharAt(j);							//�������ɾ��
				}
			}
		}
		System.out.println("���ڵ��ַ����ǣ�"+sb);					//������ַ���
		System.out.println("���ڵ��ַ��������ǣ�"+sb.length());			//������ַ�������
	}
}

