package com.mingrisoft;

public class Example_02 {

	/**
	 * @param args
	 */
		int[] number={ 100, 80, 50, 70, 20, 60};			// ��������ʼ������6��Ԫ�ص�����
		public void setNum(int index,int value){			// ��������ֵindexΪ����Ԫ�ظ�ֵvalue�ķ���
			number[index]=value;						// Ϊ����������ֵindex����Ԫ�ظ�ֵvalue
		}
		public int getNum(int index){					// ��������ֵindex��������ж�ӦԪ��ֵ�ķ���
			return number[index];						// �������������ֵindex����Ԫ��ֵ
		}
		public static void main(String[] args) {
			Example_02 ex=new Example_02();			// �������ʵ��
			// ���÷����������������ֵ0����Ԫ��ֵ������һ��Ԫ�ص�ֵ100
			int value=ex.getNum(0);
			System.out.println(value);					// �����һ��Ԫ�ص�ֵ100
			// ����ֵ6�����������±�ķ�Χ����˽������쳣�����³�����ֹ������Ĵ��뽫���ᱻִ��
			value=ex.getNum(6);	
			System.out.println(value);
			// ������������һ��Ԫ�ص�ֵ60
			value=ex.getNum(5);							
			System.out.println(value);		// ������һ��Ԫ��ֵ60
		}

}
