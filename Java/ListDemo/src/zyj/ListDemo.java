package zyj;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		String a = "A",b = "B",c = "C",d = "D",e = "E";
		List<String> list = new LinkedList<String>();//����List����
		list.add(a);
		list.add(e);
		list.add(d);
		Iterator<String> fristIterator = list.iterator();//�������ϵĵ�����
		System.out.println("�޸�ǰ��");
		while (fristIterator.hasNext()) {
			System.out.println(fristIterator.next()+" ");
		}
		list.set(1, b);
		list.add(2, c);
		Iterator<String> it = list.iterator();//���������϶����޸ĺ�ĵ���������
		System.out.println();
		System.out.println("�޸ĺ�");
		while(it.hasNext())
		{
			System.out.println(it.next() + " ");
		}
	}

}
