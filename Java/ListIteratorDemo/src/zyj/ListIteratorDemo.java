package zyj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class ListIteratorDemo {
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();//����ArrayList
		Collections.addAll(array, 1,2,3,4,5,6);
		ListIterator<Integer> iterator = array.listIterator();//��ȡListIterator����
		System.out.print("arraylist�е�Ԫ�أ�");
		while(iterator.hasNext())//�ж��Ƿ���������Ƿ���Ԫ�ؿ��Ե���
		{
			System.out.print(iterator.next()+" ");//����������е�Ԫ��
		}
	}
}
