package com.mingrisoft;

public class OneArrayMemory {
	public static void main(String[] args) {
		int num1 = 1024 * 1024 * 2; 						// ������Ԫ�صĸ���
		int[] arr1 = new int[num1]; 						// ����int��һά����
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = i; 								// Ϊ����Ԫ�ظ�ֵ
		}
		// ���ռ���ڴ�������������λת��ΪM
		long memory1 = Runtime.getRuntime().totalMemory() / 1024 / 1024;
		System.out.println("ռ���ڴ�����Ϊ��" + memory1);
		int num2 = 1024 * 1024; 							// ������Ԫ�صĸ���
		int[][] arr2 = new int[num2][2]; 						// ����int�Ͷ�ά����
		for (int i = 0; i < arr2.length; i++) {
			arr2[i][0] = i; 								// Ϊ����Ԫ�ظ�ֵ
			arr2[i][1] = i; 								// Ϊ����Ԫ�ظ�ֵ
		}
		// ���ռ���ڴ�������������λת��ΪM
		long memory2 = Runtime.getRuntime().totalMemory() / 1024 / 1024;
		System.out.println("ռ���ڴ�����Ϊ��" + memory2);
	}
}
