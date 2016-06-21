package com.mingrisoft;

public class Example_02 {

	/**
	 * @param args
	 */
		int[] number={ 100, 80, 50, 70, 20, 60};			// 创建并初始化具有6个元素的数组
		public void setNum(int index,int value){			// 根据索引值index为数组元素赋值value的方法
			number[index]=value;						// 为数组中索引值index处的元素赋值value
		}
		public int getNum(int index){					// 根据索引值index获得数组中对应元素值的方法
			return number[index];						// 获得数组中索引值index处的元素值
		}
		public static void main(String[] args) {
			Example_02 ex=new Example_02();			// 创建类的实例
			// 调用方法获得数组中索引值0处的元素值，即第一个元素的值100
			int value=ex.getNum(0);
			System.out.println(value);					// 输出第一个元素的值100
			// 索引值6超出了数组下标的范围，因此将发生异常，导致程序终止，下面的代码将不会被执行
			value=ex.getNum(6);	
			System.out.println(value);
			// 获得数组中最后一个元素的值60
			value=ex.getNum(5);							
			System.out.println(value);		// 输出最后一个元素值60
		}

}
