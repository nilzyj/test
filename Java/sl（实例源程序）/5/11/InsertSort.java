package com.mingrisoft;

public class InsertSort {
	public static void main(String[] args) {
		int[] array=new int[]{20,40,90,30,80,70,50};
		System.out.println("����ǰ��");
		for (int i = 0; i < array.length; i++) {				// ��ʼ������Ԫ��
			System.out.print(array[i]+" ");				// �������Ԫ��
		}
		int tmp;									// ������ʱ����
		int j;
		for (int i = 1; i < array.length; i++) {
			tmp = array[i];							// ������ʱ����
			for (j = i - 1; j >= 0 && array[j] > tmp; j--) {
				array[j + 1] = array[j];					// ����Ԫ�ؽ���
			}
			array[j + 1] = tmp;						// ������λ�ò�������
		}
		System.out.println("\n�����");
		for (int i = 0; i < array.length; i++) {				// ��ʼ������Ԫ��
	 		System.out.print(array[i]+" ");				// �������Ԫ��
		}
	}
}
