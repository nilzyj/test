public class ImpInterTest {
	public void showInfo(InterTest t){
		t.printInfo();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImpInterTest imp=new ImpInterTest();
		imp.showInfo(new InterTest(){
			public void printInfo(){
				System.out.println("这里是使用匿名内部实现了接口中的方法。");
			}
		});
	}

}
