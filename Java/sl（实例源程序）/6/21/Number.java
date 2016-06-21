package com.mingrisoft;

public class Number {
	public static void main(String[]args){
		String s = "mingrikejijavabu";
		char c = 'i';
		int count = 0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==c){
				count++;
			}
		}
		System.out.println("字符串s中i出现了"+count+"次。");
	}

}
