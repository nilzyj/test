package com.mingrisoft;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array=new int[]{63,4,24,1,3,13};				//��������ʼ��һά����
		System.out.println("ð�����򷨵Ĺ����ǣ�");
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < array.length - i; j++) {			// �Ƚ���������Ԫ�أ��ϴ��������ð��
				if (array[j] > array[j + 1]) {
				int temp = array[j];					// �ѵ�һ��Ԫ��ֵ���ֵ���ʱ������
				array[j] = array[j + 1];					// �ѵڶ���Ԫ��ֵ���浽��һ��Ԫ�ص�Ԫ��
				array[j + 1] = temp;					// �ѵ�һ��Ԫ��ԭֵ���浽�ڶ���Ԫ����
				}
				System.out.print(array[j] + "  ");		// ������������Ԫ����ʾ���ı�����
			}
			System.out.print("��");
			for (int j = array.length - i; j < array.length; j++) {
			System.out.print(array[j] + "  ");			// ������������Ԫ����ʾ���ı�����
			}
			System.out.println("��");
		}
	}
}
