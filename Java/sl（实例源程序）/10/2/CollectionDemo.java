package com.mingrisoft;

import java.util.ArrayList;
import java.util.List;

public class CollectionDemo {
    public static void main(String[] args) {
        String a = "a", b = "b", c = "c", d = "d", apple = "apple";		// Ҫ��ӵ������еĶ���
        List<String> list = new ArrayList<String>();				// ����List���϶���
        list.add(a);										// ����a������λ��Ϊ 0
        list.add(apple);									// ����apple������λ��Ϊ 1
        list.add(b);										// ����b������λ��Ϊ 2
        list.add(apple);									// ����apple������λ��Ϊ 3
        list.add(c);										// ����c������λ��Ϊ 4
        list.add(apple);									// ����apple������λ��Ϊ 5
        list.add(d);										// ����d������λ��Ϊ 6
        System.out.println(list);							// ����б��е�ȫ��Ԫ��
        System.out.println("apple��һ�γ��ֵ�����λ���ǣ�"+list.indexOf(apple));	 
   System.out.println("apple���һ�γ��ֵ�����λ���ǣ�"+list.lastIndexOf(apple));
        System.out.println("b��һ�γ��ֵ�����λ���ǣ�"+list.indexOf(b));
        System.out.println("b���һ�γ��ֵ�����λ���ǣ�"+list.lastIndexOf(b));
    }
}
