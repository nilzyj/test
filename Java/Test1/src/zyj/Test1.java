package zyj;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
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
