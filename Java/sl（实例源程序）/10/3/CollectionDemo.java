package com.mingrisoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CollectionDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();	 		// 创建List集合对象
        list.add("apple");	 						 	// 向集合中添加元素
        list.add("pear");
        list.add("banana");
        list.add("apple");
        Set<String> set = new HashSet<String>(); 	 		// 创建List集合对象
        set.addAll(list);							 	// 将List集合添加到Set集合中
        Iterator<String> it = set.iterator();			 		// 创建Set集合迭代器
        System.out.println("集合中的元素是：");
        while (it.hasNext()) {
        	System.out.print(it.next()+"\t");
        }
    }
}

