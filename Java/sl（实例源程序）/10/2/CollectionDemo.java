package com.mingrisoft;

import java.util.ArrayList;
import java.util.List;

public class CollectionDemo {
    public static void main(String[] args) {
        String a = "a", b = "b", c = "c", d = "d", apple = "apple";		// 要添加到集合中的对象
        List<String> list = new ArrayList<String>();				// 创建List集合对象
        list.add(a);										// 对象a的索引位置为 0
        list.add(apple);									// 对象apple的索引位置为 1
        list.add(b);										// 对象b的索引位置为 2
        list.add(apple);									// 对象apple的索引位置为 3
        list.add(c);										// 对象c的索引位置为 4
        list.add(apple);									// 对象apple的索引位置为 5
        list.add(d);										// 对象d的索引位置为 6
        System.out.println(list);							// 输出列表中的全部元素
        System.out.println("apple第一次出现的索引位置是："+list.indexOf(apple));	 
   System.out.println("apple最后一次出现的索引位置是："+list.lastIndexOf(apple));
        System.out.println("b第一次出现的索引位置是："+list.indexOf(b));
        System.out.println("b最后一次出现的索引位置是："+list.lastIndexOf(b));
    }
}
