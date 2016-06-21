public class StaticInnerClass {
	static int x=100;
	static class Inner{
		static void doitInner(){
			System.out.println("外部类的成员变量"+x);				//调用外部类的成员变量x
		}
		public static void main(String args[]){
			doitInner();
		}

	}
}
