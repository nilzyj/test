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
	printf("\n������Χ����Բ����Χ������n:");
	scanf("%d",&n);
	printf("\n�������һ�ο�ʼ�����˵�λ��m:");
	scanf("%d",&m);
	printf("\n��ϣ���������ڼ����������˳���k:");
	scanf("%d",&k);
	Create_clist(clist,n);
	printf("\n���е�˳������:\n");
	Joseph(clist,m,n,k);
	getch();
}
