package com.mingrisoft;

import java.util.StringTokenizer;                                   	//������
public class StringTo {
	public static void main(String[] args) {
		String text = "  We are students  ";			            	//��������ո���ַ���
		System.out.println("ԭ�ַ����ǣ�");
System.out.println(text);
		StringTokenizer st = new StringTokenizer(text," ");	   	//ʹ�ÿո����ָ��ַ���
		StringBuffer sb = new StringBuffer();			             	//�����ַ����������
		int i = 1; 
		while(st.hasMoreTokens()){				            	//�ж��ַ������Ƿ��пո�
			i++;	
			sb.append(st.nextToken());				        	//���ַ�����������׷������
		}
         	System.out.println("ȥ���ַ��������пո�֮����ַ����ǣ�");
		System.out.println(sb.toString());
 }
}

