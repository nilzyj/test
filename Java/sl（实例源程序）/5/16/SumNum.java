package com.mingrisoft;

public class SumNum {
	public static void main(String[] args) {
		int[][] num = {{ 1, 2, 3},{ 4, 5, 6}, {7, 8, 9, 10} }; 				// ��������ʼ����ά����num
		int sum = 0; 									// �����ۼ���͵ı���sum
		System.out.println("��ά�����и�Ԫ�صĺ��ǣ�");
		for (int i = 0; i < num.length; i++) { 							// ͨ��forѭ����������
			for(int j = 0;j<num[i].length;j++){		
			sum = sum + num[i][j];							// �����ۼ����
			}
		}	
		System.out.println(sum);							// �����
	}
}
