package com.mingrisoft;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollectionDemo {
    public static void main(String[] args) {
        String a = "A", b = "B", c = "C", d = "D", e = "E";			// 定义要插入集合的字符串对象
        List<String> list = new LinkedList<String>();				// 创建List集合
        list.add(a);										// 向集合中添加元素
        list.add(e);
        list.add(d);
        Iterator<String> fristIterator = list.iterator();				// 创建集合的迭代器
        System.out.println("修改前集合中的元素是：");			// 输出信息
        while (fristIterator.hasNext()) {						// 遍历集合中元素
            System.out.print(fristIterator.next() + " ");
        }
        list.set(1, b);									// 将索引位置为1的对象修改为对象b
        list.add(2, c);									// 将对象c添加到索引位置为2的位置
        Iterator<String> it = list.iterator();						// 创建将集合对象修改之后的迭代器对象
        System.out.println();
        System.out.println("修改后集合中的元素是：");
        while (it.hasNext()) {								// 循环获取集合中元素
            System.out.print(it.next() + " ");
        }
    }
}
