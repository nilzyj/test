package com.mingrisoft;

import java.util.Arrays;									//����java.util.Arrays��
public class Displace {									//������
	public static void main(String[] args) {					//������
		int arr[] = new int[] { 45, 12, 2, 10,1};					//���岢��ʼ��int������arr
		Arrays.fill(arr, 1, 3, 8);							//ʹ��fill������������г�ʼ��
		for (int i = 0; i < arr.length; i++) {					//ѭ������������Ԫ��
			System.out.println("��" + i + "��Ԫ���ǣ�" + arr[i]);	//�������е�ÿ��Ԫ�����
		}
	}
}
