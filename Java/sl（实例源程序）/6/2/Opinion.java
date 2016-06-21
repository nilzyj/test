package com.mingrisoft;

public class Opinion {									//创建类
	public static void main(String args[]) {		         		//主方法
		String s1 = new String("I am a student");           		//声明字符踹s1
		String s2 = new String("I am a student");           		//声明字符踹s2
		String s3 = new String("I AM A STUDENT");   	    		//声明字符踹s3
		String s4 = s1;                                 		//将s1的值赋给s4
	    
		boolean b1 = (s1 == s2);                        	//用“==”比较s1和s2
		boolean b2 = (s1 == s4);                        	//用“==”比较s1和s4
		boolean b3 = s1.equals(s2);                     	//用equals()比较s1和s2 
		boolean b4 = s1.equals(s3);                     	//用equals()比较s1和s3
		boolean b5 = s1.equalsIgnoreCase(s2);            	//用equalsIgnoreCase()比较s1和s2
		boolean b6 = s1.equalsIgnoreCase(s3);           	//用equalsIgnoreCase()比较s1和s3
       
	    	System.out.println("s1 == s2:"+b1);               	 	//输出b1 
         	System.out.println("s1 == s4:"+b2);                	//输出b2
         	System.out.println("s1 equals s2:"+b3);            		//输出b3
         	System.out.println("s1 equals s3:"+b4);            		//输出b4
         	System.out.println("s1 equalsIgnoreCase s2:"+b5);  	//输出b5
         	System.out.println("s1 equalsIgnoreCase s3:"+b6);  	//输出b6
	}
}

