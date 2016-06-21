package com.mingrisoft;

import java.util.Date;
public class GetTime {
public static void main(String[] args) {
		 Date date=new Date();
	      System.out.println("默认时间格式："+date);
		 System.out.println("两位24小时制的小时："+String.format("%tH", date));
		 System.out.println("两位12小时制的小时："+String.format("%tI", date));
		 System.out.println("24小时制的小时："+String.format("%tk", date));
		 System.out.println("12小时制的小时："+String.format("%tl", date));
		 System.out.println("两位小时中的分钟："+String.format("%tM", date));
		 System.out.println("两位分钟中的秒："+String.format("%tS", date));
		 System.out.println("表示时区缩写形式的字符串："+String.format("%tZ", date));
System.out.println("上午还是下午："+String.format("%tp", date));
	}
}

