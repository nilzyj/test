package com.mingrisoft;

public class MinNum {
	public static void main(String[] args) {
		int[] num = { 8, 3, 4, 1, 6, 10 }; 							// ��������ʼ��һά����num
		System.out.println("���һά���飺");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + "  ");						//���һά����
		}
		int max = num[0];
		for (int j = 0; j < num.length - 1; j++) { 					// ͨ��forѭ����������
			if (max < num[j + 1]) {
				max = num[j + 1];
			}
		}
		System.out.println("\nһά��������ֵ�ǣ�" + max); 		// �����������ֵ
	}
}
