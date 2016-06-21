package zyj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class ListIteratorDemo {
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();//创建ArrayList
		Collections.addAll(array, 1,2,3,4,5,6);
		ListIterator<Integer> iterator = array.listIterator();//获取ListIterator对象
		System.out.print("arraylist中的元素：");
		while(iterator.hasNext())//判断是否迭代器中是否有元素可以迭代
		{
			System.out.print(iterator.next()+" ");//输出迭代器中的元素
		}
	}
}
