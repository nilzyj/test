package com.mingrisoft;

public class Opinion {									//������
	public static void main(String args[]) {		         		//������
		String s1 = new String("I am a student");           		//�����ַ���s1
		String s2 = new String("I am a student");           		//�����ַ���s2
		String s3 = new String("I AM A STUDENT");   	    		//�����ַ���s3
		String s4 = s1;                                 		//��s1��ֵ����s4
	    
		boolean b1 = (s1 == s2);                        	//�á�==���Ƚ�s1��s2
		boolean b2 = (s1 == s4);                        	//�á�==���Ƚ�s1��s4
		boolean b3 = s1.equals(s2);                     	//��equals()�Ƚ�s1��s2 
		boolean b4 = s1.equals(s3);                     	//��equals()�Ƚ�s1��s3
		boolean b5 = s1.equalsIgnoreCase(s2);            	//��equalsIgnoreCase()�Ƚ�s1��s2
		boolean b6 = s1.equalsIgnoreCase(s3);           	//��equalsIgnoreCase()�Ƚ�s1��s3
       
	    	System.out.println("s1 == s2:"+b1);               	 	//���b1 
         	System.out.println("s1 == s4:"+b2);                	//���b2
         	System.out.println("s1 equals s2:"+b3);            		//���b3
         	System.out.println("s1 equals s3:"+b4);            		//���b4
         	System.out.println("s1 equalsIgnoreCase s2:"+b5);  	//���b5
         	System.out.println("s1 equalsIgnoreCase s3:"+b6);  	//���b6
	}
}

