public class StaticInnerClass {
	static int x=100;
	static class Inner{
		static void doitInner(){
			System.out.println("�ⲿ��ĳ�Ա����"+x);				//�����ⲿ��ĳ�Ա����x
		}
		public static void main(String args[]){
			doitInner();
		}

	}
}
