import java.util.Queue;
import java.util.LinkedList;
import java.lang.Object;
import java.util.Scanner;
public class test
{
	public static void main(String args[])
	{
		String active="1";
		Queue<String> ready=new LinkedList<String>();
		Queue<String> wait=new LinkedList<String>();
		for(int i=2;i<9;++i)
		{
			String m=String.valueOf(i);
			ready.offer(m);
		}
		for(int j=9;j<16;++j)
		{
			String n=String.valueOf(j);
			wait.offer(n);
		}
		while(true)
		{
			//1.进程调度 2.时间片完 3.I/O请求 4.I/O完成
			if(ready.peek()==null || wait.peek()==null)
			{
				System.out.println("ready or wait is null");
				break;
			}
			System.out.println("1. 2. 3. 4. 5.exit");
			System.out.println("active: "+active);
			System.out.println("ready: "+ready);
			System.out.println("wait: "+wait);
			Scanner sc=new Scanner(System.in);
			String choose=sc.nextLine();
			if(Integer.parseInt(choose) == 5)
			{
				System.out.println("exit");
				break;
			}
			switch(choose)
			{
				case "1": System.out.println("thread is running!");break;
				case "2":
					ready.offer(active);
					active=ready.poll();
					break;
				case "3":
					wait.offer(active);
					active=ready.poll();
					break;
				case "4":					
					ready.offer(wait.poll());
					break;
				default: 
					break;
			}
		}
	}
}

/*public class test
{
	public static void main(String args[])
	{
		for(int h=1;h<=4;++h)
		{
			for(int j=0;j<4-h;++j)
				System.out.print(" ");
			for(int i=0;i<2*h-1;++i)
				System.out.print("*");
			System.out.print("\n");
		}
	}
}*/

/*import java.lang.Object;
import java.util.Scanner;
public class test
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//String num=new String();
		//num = "341122199606060037";
		System.out.println("Input:");
		//num=br.readLine();
		String num=sc.nextLine();
		if(num.length()!=18)
		{
			System.out.println("length error");
		}
		else
		{
			//sheng
			String a=new String();
			a=num.substring(0,2);
			int i=Integer.parseInt(a);
			if(i<1 || i>79)
			{
				System.out.println("shengfeng error");
			}
			String b=new String();
			b=num.substring(6,14);
			//year
			String b1=new String();
			b1=b.substring(0,4);
			int i1=Integer.parseInt(b1);
			if(i1<0 || i1>2015)
			{
				System.out.println("year error");
			}
			//month
			String b2=new String();
			b2=b.substring(4,6);
			int i2=Integer.parseInt(b2);
			if(i2<1 || i2>12)
			{
				System.out.println("month error");
			}
			//day
			String b3=new String();
			b3=b.substring(6,8);
			int i3=Integer.parseInt(b3);
			if(i3<1 || i3>31)
			{
				System.out.println("day error");
			}
			else
			{
				if((i2==1 || i2==3 || i2==5 || i2==7 || i2==8 || i2==10 || i2==12) && i3==31)
				{
					System.out.println("day error");
				}
				else if((i2==4 || i2==6 || i2==9 || i2==11) && i1%4==0 && i3==30)
				{
					System.out.println("day error");
				}
				else if((i2==4 || i2==6 || i2==9 || i2==11) && i1%4!=0 && (i3==30 || i3==29))
				{
					System.out.println("day error");
				}
				else if(i2==2 && i1%4==0 && i3>29)
				{
					System.out.println("day error");
				}
				else if(i2==2 && i1%4!=0 && i3>28)
				{
					System.out.println("day error");
				}
			}
		}
	}
}*/