package com.mingrisoft;

import java.util.Date;
public class DateAndTime2 {
	public static void main(String[] args) {
		Date date=new Date();
		System.out.println("默认的日期时间格式："+date);
		System.out.println("24小时制的时间，被格式化为小时和分钟 ："+String.format("%tR", date));
		System.out.println("24小时制的时间，被格式化为小时、分钟和秒："+String.format("%tT", date));
		System.out.println("12小时制的时间，被格式化为："+String.format("%tr", date));
		System.out.println("日期被格式化为："+String.format("%tD", date));
		System.out.println("ISO 8601格式的完整日期，被格式化为："+String.format("%tF", date));
		System.out.println("日期和时间被格式化为："+String.format("%tc", date));
	}
}

