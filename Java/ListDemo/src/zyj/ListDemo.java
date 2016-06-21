package zyj;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		String a = "A",b = "B",c = "C",d = "D",e = "E";
		List<String> list = new LinkedList<String>();//创建List集合
		list.add(a);
		list.add(e);
		list.add(d);
		Iterator<String> fristIterator = list.iterator();//创建集合的迭代器
		System.out.println("修改前：");
		while (fristIterator.hasNext()) {
			System.out.println(fristIterator.next()+" ");
		}
		list.set(1, b);
		list.add(2, c);
		Iterator<String> it = list.iterator();//创建将集合对象修改后的迭代器对象
		System.out.println();
		System.out.println("修改后：");
		while(it.hasNext())
		{
			System.out.println(it.next() + " ");
		}
	}

}
