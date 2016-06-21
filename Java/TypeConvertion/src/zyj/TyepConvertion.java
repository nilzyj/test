package zyj;

public class TyepConvertion {

	public static void main(String[] args) {
		int intNum = 4;
		float floatNum = 9.5F;
		
		floatNum /= intNum;
		System.out.println("9.5/4="+floatNum);
		
		double numx = 4.88;
		double numy = 78.83;
		int numz = (int)numx + (int)numy;
		System.out.println("4.88+78.83=(int)"+numz);
		
		char charVar = 'T';
		int intVar = (int)charVar;
		System.out.println("T to int :"+intVar);
		
		int num1 = 34;
		double num2 = (double)num1/3;
		System.out.println("34/3="+num2);
	}

}
