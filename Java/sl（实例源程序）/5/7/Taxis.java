package com.mingrisoft;

import java.util.Arrays;								//����java.util.Arrays��
public class Taxis {									//������
	public static void main(String[] args) {				//������
		int arr[] = new int[] { 23, 42, 12, 8,5,10 };			//��������
		System.out.println("ԭһά�����ǣ�");
		for (int i = 0; i < arr.length; i++) {				//ѭ����������
			System.out.print(arr[i]+"  ");				//���ԭ������
		}
		Arrays.sort(arr);							//�������������
		System.out.println("\n�������к�������ǣ�");
		for (int i = 0; i < arr.length; i++) {				//ѭ����������������
			System.out.print(arr[i]+"  ");				//������������еĸ���Ԫ�����
		}
	}
}
