package com.mingrisoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CollectionDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();	 		// ����List���϶���
        list.add("apple");	 						 	// �򼯺������Ԫ��
        list.add("pear");
        list.add("banana");
        list.add("apple");
        Set<String> set = new HashSet<String>(); 	 		// ����List���϶���
        set.addAll(list);							 	// ��List������ӵ�Set������
        Iterator<String> it = set.iterator();			 		// ����Set���ϵ�����
        System.out.println("�����е�Ԫ���ǣ�");
        while (it.hasNext()) {
        	System.out.print(it.next()+"\t");
        }
    }
}

