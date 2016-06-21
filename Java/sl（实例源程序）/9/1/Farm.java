
public class Farm {

	public static void main(String[] args) {
		System.out.println("调用Apple类的harvest()方法的结果：");
		Apple apple=new Apple();           //声明Apple类的一个对象apple，并为其分配内存
		apple.harvest();                    //调用Apple类的harvest()方法
		System.out.println("调用Orange类的harvest()方法的结果：");
		Orange orange=new Orange();        //声明Orange类的一个对象orange，并为其分配内存
		orange.harvest();                   //调用Orange类的harvest()方法

	}

}
