package com.mingrisoft;

import java.util.Arrays;
public class Cope {										//������
	public static void main(String[] args) {					//������
		int arr[] = new int[] { 23, 42, 12 };					//��������
		System.out.println("���ƺ�������ǣ�");
		for (int i = 0; i < arr.length; i++) {					//ѭ����������
			System.out.print(arr[i]+"  ");					//��ԭ���������
		}
		int newarr[] = Arrays.copyOf(arr, 5);					//��������arr
		System.out.println("\n���ƺ�������ǣ�");
		for (int i = 0; i < newarr.length; i++) {					//ѭ���������ƺ��������
			System.out.print(newarr[i]+"  ");				//�����������
		}
	}
}
