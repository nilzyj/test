
public class Example {
	private class InExample{
		int sum=0;
		public int getSum(int a){
			for (int i=1;i<=a;i++){
				sum=sum+i;
			}
			return sum;
		}
	}
	public void printSum(int x){
		InExample in=new InExample();
		int s=in.getSum(x);
		System.out.println("1~"+x+"µÄºÍÊÇ£º"+s);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example ex=new Example();
		ex.printSum(10);
	}

}
