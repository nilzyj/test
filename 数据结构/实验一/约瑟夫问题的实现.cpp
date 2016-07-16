#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#define NULL 0
#define OK 1
#define ERROR 0
#define OVERFLOW -2
typedef int Status;
typedef int Elemtype;
typedef struct Cnode
{
	Elemtype data;
	struct Cnode *next;
}CNode;
CNode *joseph;
Status Create_clist(CNode *clist,int n)
{
	CNode *p,*q;
	int i;
	clist=NULL;
	for(i=n;i>=1;i--)
	{
		p=(CNode *)malloc(sizeof(CNode));
		if(p==NULL)
			return OVERFLOW;
		p->data=i;
		p->next=clist;
		clist=p;
		if(i==n)
			q=p;
	}
	q->next=clist;
	joseph=clist;
	return OK;
}
Status Joseph(CNode *clist,int m,int n,int k)
{
	int i;
	CNode *p,*q;
	if(m>n)
		return ERROR;
	if(!Create_clist(clist,n))
		return ERROR;
	p=joseph;
	for(i=1;i<m;i++)
		p=p->next;
	while(p)
	{
		for(i=1;i<k-1;i++)
			q=p->next;
		printf("%d",q->data);
		if(q->next==p)
			p=NULL;
		else
		{
			p->next=q->next;
			p=p->next;
			free(q);
		}
	}
	clist=NULL;
}
void main()
{
	int m,n,k,i;
	CNode *clist;
	clist=NULL;
	printf("\n请输入围坐在圆桌周围的人数n:");
	scanf("%d",&n);
	printf("\n请输入第一次开始报数人的位置m:");
	scanf("%d",&m);
	printf("\n你希望报数到第几个人数的人出列k:");
	scanf("%d",&k);
	Create_clist(clist,n);
	printf("\n出列的顺序如下:\n");
	Joseph(clist,m,n,k);
	getch();
}
