package com.mingrisoft;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollectionDemo {
    public static void main(String[] args) {
        String a = "A", b = "B", c = "C", d = "D", e = "E";			// ����Ҫ���뼯�ϵ��ַ�������
        List<String> list = new LinkedList<String>();				// ����List����
        list.add(a);										// �򼯺������Ԫ��
        list.add(e);
        list.add(d);
        Iterator<String> fristIterator = list.iterator();				// �������ϵĵ�����
        System.out.println("�޸�ǰ�����е�Ԫ���ǣ�");			// �����Ϣ
        while (fristIterator.hasNext()) {						// ����������Ԫ��
            System.out.print(fristIterator.next() + " ");
        }
        list.set(1, b);									// ������λ��Ϊ1�Ķ����޸�Ϊ����b
        list.add(2, c);									// ������c��ӵ�����λ��Ϊ2��λ��
        Iterator<String> it = list.iterator();						// ���������϶����޸�֮��ĵ���������
        System.out.println();
        System.out.println("�޸ĺ󼯺��е�Ԫ���ǣ�");
        while (it.hasNext()) {								// ѭ����ȡ������Ԫ��
            System.out.print(it.next() + " ");
        }
    }
}
