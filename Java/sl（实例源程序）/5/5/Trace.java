package com.mingrisoft;

public class Trace {											// ������
	public static void main(String[] args) {
		int arr[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };		// ����2ά����
		int tr = 0;
		System.out.println("����arr[][]�ǣ�");
		for (int i = 0; i < arr.length; i++) {						// ��������
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");					// �������Ԫ��
			}
			System.out.println();
		}
		for (int i = 0; i < arr.length; i++) {
			tr += arr[i][i];
		}
		System.out.println("����arr[][]�ļ��ǣ�"+tr);
	}
}
