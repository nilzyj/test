public class Zoo {
	public static void main(String[] args) {
		Dog dog=new Dog();                    //创建Dog类的对象并为其分配内存
		System.out.println("执行dog.cry();语句时的输出结果：");
		dog.cry();
		Cat cat=new Cat();                      //创建Cat类的对象并为其分配内存
		System.out.println("执行cat.cry();语句时的输出结果：");
		cat.cry();
		Sheep sheep=new Sheep();                //创建Sheep类的对象并为其分配内存
		System.out.println("执行sheep.cry();语句时的输出结果：");
		sheep.cry();		
	}
}
