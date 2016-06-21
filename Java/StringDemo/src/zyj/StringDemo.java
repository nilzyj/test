package zyj;

import java.util.StringTokenizer;

public class StringDemo {

	public static void main(String[] args) {
		String a = new String();//String()
		a=" hello world";
		char cha[] = {'h','e','l','l','o'};
		String b = new String(cha);//等价于String b = String("hello");
		String c = new String(cha,2,3);//等价于String c = String("llo");
		//字符串连接用"+"
		System.out.println("字符串长度："+a.length());//获取字符串长度
		System.out.println("搜索字符串，返回首次出现的位置："+a.indexOf("el"));
		System.out.println("搜索字符串，返回最后出现位置："+a.indexOf("el"));
		System.out.println("获取指定索引位置的字符："+a.charAt(3));
		System.out.println("trim()取出前导，尾部空格："+a.trim());
		StringTokenizer st = new StringTokenizer(a," ");//按空格分割字符串
		StringBuffer sb = new StringBuffer();
		int i = 1;
		while(st.hasMoreElements())//判断是否还有空格，还可以用st.hasMoreToken()
		{
			i++;
			sb.append(st.nextToken());
		}
		System.out.println("StringTokennizer去除空格："+sb.toString());
		
		System.out.println("replaceAll()去除空格："+a.replaceAll(" ", ""));
		
		System.out.println("replace()字符串替换："+a.replace("world", "ml"));
		
		System.out.println("replaceFirst()替换第一个出现的字符串："+a.replaceFirst("world", "ml"));
		
		if(a.equals("hello world"))//严格区分大小写，equalsIgnoreCase()不区分大小写
		{
			System.out.println("字符串相等");
		}
		else
		{
			System.out.println("字符串不相等");
		}
		
		if(a.startsWith("hello"))//判断字符串是否以参数指定的字符串开始，endsWith()判断是否以参数指定的字符串结尾
		{
			System.out.println("以hello开头");
		}
		else
		{
			System.out.println("不以hello开头");
		}
		
		System.out.println("转换成小写："+a.toLowerCase());
		System.out.println("转换成大写："+a.toUpperCase());
		
		String news[] = a.split(" ");//split(String sign)方法
		System.out.print("分割后的字符串：");
		for(int j = 0;j < news.length;j++)
		{
			System.out.print(news[j]);
		}
		System.out.print("\n");
		news = a.split(" ", 1);//split(String sign,int limit)limit:限制的分割份数
		System.out.print("分割一次后的字符串：");
		for(int j = 0;j < news.length;j++)
		{
			System.out.print(news[j]);
		}
		
		//format格式化方法
	}
}
