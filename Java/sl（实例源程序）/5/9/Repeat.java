package com.mingrisoft;

import java.util.Arrays;
public class Repeat {											//������
	public static void main(String[] args) {						//������
		int arr[] = new int[] { 23, 42, 12, 84, 10 };					//��������
		System.out.println("ԭ���������ǣ�");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"  ");						//���ԭ��������
		}
		int newarr[] = Arrays.copyOfRange(arr, 0, 3);				//��������
		System.out.println("\n�������±�0~3���Ƶ��������У�");
		for (int i = 0; i < newarr.length; i++) {						//ѭ���������ƺ��������
			System.out.print(newarr[i]+"  ");					//���������е�ÿ��Ԫ�����
		}
	}
}
