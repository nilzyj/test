package com.mingrisoft;

public class Judge {								     	//新建类
	public static void main(String[] args) {			     	//主方法
		String regex = "\\w{0,}\\@\\w{0,}\\.{1}\\w{0,}";   		//正则表达式，定义邮箱格式
		String str1 = "aaa@";					     	//定义字符串str1
		String str2 = "aaaa";						    		//定义字符串str2
		String str3 = "aaaaa@111.com";			     	//定义字符串str3
		  if(str1.matches(regex)){					    		//判断字符串是否与正则表达式匹配
			 System.out.println(str1+" 是一个E_mail地址格式");		//输出信息
		  }
		  if(str2.matches(regex)){					    		//判断字符串str2是否与正则表达式匹配
			 System.out.println(str2+" 是一个E_mail地址格式");		//输出信息
		  }
		  if(str3.matches(regex)){					    		//判断字符串str3是否与正则表达式匹配
			 System.out.println(str3+" 是一个E_mail地址格式");		//输出信息
		  }
		  else{										//如果与正则表达式都不匹配
			 System.out.println("都不是E_mail地址格式");			     //输出信息
		  }
	 }
}

