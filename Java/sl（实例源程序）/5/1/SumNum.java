package com.mingrisoft;

public class SumNum {
	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; 				// ��������ʼ��һά����num
		int sum = 0; 									// �����ۼ���͵ı���sum
		System.out.println("һά�����и�Ԫ�صĺ��ǣ�");
		for (int i = 0; i < 10; i++) { 							// ͨ��forѭ����������
			if (i == 9) {									// �ж�������±��Ƿ�Ϊ9
				System.out.print(num[i] + "=");				// ����Ԫ�ص��±���9������Ⱥ�
			} else {
				System.out.print(num[i] + "+");				// ����Ԫ�ص��±겻��9������Ӻ�
			}
			sum = sum + num[i];							// �����ۼ����
		}
		System.out.println(sum);							// �����
	}
}
