
public class Example {
	public void printChenJi(double a,double b){
		class InExample{
			public double getChenJi(double x,double y){
				return x*y;
			}
		}
		InExample in=new InExample();
		double v=in.getChenJi(a, b);
		System.out.println(a+"乘以"+b+"的值是："+v);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example ex=new Example();
		ex.printChenJi(20,50);
	}

}
