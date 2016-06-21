package leetcode;

class ListNode {
	int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class test2 {	
	public static void main(String[] args) {
		ListNode node1=new ListNode(1);
		//ListNode node2=new ListNode(0);
		//ListNode node3=new ListNode(0);
		ListNode node4=new ListNode(9);
		ListNode node5=new ListNode(9);
		//ListNode node6=new ListNode(9);
		node1.next=null;
		//node2.next=null;
		//node3.next=null;
		node4.next=node5;
		node5.next=null;
		//node6.next=null;
		ListNode noderesult=addTwoNumbers(node1,node4);
		while(noderesult!=null)
		{
			System.out.println(noderesult.val);
			noderesult=noderesult.next;
		}
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node=new ListNode(0);//新结点
		ListNode nodetemp=node;//保存头结点
		node.next=null;
		int flag=0;//flag 进位标志;
		while(l1!=null || l2!=null)//有结点不为null
		{
			if(l1!=null && l2!=null)//都不为null
			{
				node.next=new ListNode((l1.val+l2.val+flag)%10);//结点相加，作为新结点
				flag=(l1.val+l2.val+flag)/10;//判断是否进位
				node=node.next;
				l1=l1.next;//计算l1下一个结点
				l2=l2.next;//计算l2下一个结点
			}
			if(l1!=null && l2==null)//都不为null的结点计算结束后，计算l1中不为null的结点
			{
				node.next=new ListNode((l1.val+flag)%10);//l1+进位作为新结点
				flag=(l1.val+flag)/10;
				node=node.next;
				l1=l1.next;
			}
			if(l1==null && l2!=null)//都不为null的结点计算结束后，计算l2中不为null的结点
			{
				node.next=new ListNode((l2.val+flag)%10);//l2+进位作为新结点
				flag=(l2.val+flag)/10;
				node=node.next;
				l2=l2.next;
			}
			if(flag==1)
			{
				node.next=new ListNode(1);//计算结束后若还有进位则增加一个新结点
			}
		}
		return nodetemp.next;
//		while(l1!=null && l2!=null)
//		{
//			if(flag>=1)
//			{
//				l1.val=l1.val+l2.val+1;
//				if(l1.val<10)
//				{
//					flag--;
//				}
//				else
//				{
//					l1.val=l1.val%10;//大于10时取余
//					flag++;
//				}
//			}
//			else
//				l1.val=l1.val+l2.val;
//			if(l1.val>=10)
//			{
//				l1.val=l1.val%10;
//				flag++;
//			}
//			nodetemp=l1;
//			l1=l1.next;
//			l2=l2.next;
//		}
//		temp=flag;
//		if(l1!=null || l2!=null)
//			same=1;
//		if(l1!=null && temp==0)
//		{
//			nodetemp.next=l1;
//		}
//		else
//			while(l1!=null && temp>0)
//			{
//				l1.val++;
//				nodetemp.next=l1;
//				temp--;
//			}
//		if(l2!=null && temp==0)
//		{
//			nodetemp.next=l2;
//		}
//		else 
//			while(l2!=null && temp>0)
//			{
//				l2.val++;
//				nodetemp.next=l2;
//				temp--;
//			}
//		if(same==1)
//			while(flag>0)
//			{
//				ListNode nodeend=new ListNode(1);
//				nodeend.next=null;
//				nodetemp.next=nodeend;
//				flag--;
//			}
//		return node;
	}
}