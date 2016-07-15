//#include <stdio.h>
//
//typedef struct student
//{
//	int pla;
//	int num;
//	int score;
//}student;
//
//int main()
//{
//	student stu[100];
//	int n, i, j, tempnum, tempscore, pos;
//	scanf("%d", &n);
//	for (i = 0; i < n; i++)
//	{
//		stu[i].num = i + 1;
//		scanf("%d", &stu[i].score);
//	}
//	for (i = 0; i < n; i++)
//	{
//		tempscore = stu[i].score;
//		tempnum = stu[i].num;
//		pos = i;
//		for (j = i + 1; j < n; j++)
//		{
//			if (tempscore < stu[j].score)
//			{
//				tempscore = stu[j].score;
//				tempnum = stu[j].num;
//				pos = j;
//			}
//		}
//		stu[pos].num = stu[i].num;
//		stu[i].num = tempnum;
//		stu[pos].score = stu[i].score;
//		stu[i].score = tempscore;
//		stu[i].pla = i + 1;
//		if (i > 0 && stu[i].score == stu[i - 1].score)
//		{
//			stu[i].pla = stu[i - 1].pla;
//		}
//	}
//	for (i = 0; i < n; i++)
//	{
//		printf("%d : %d, %d\n", stu[i].pla, stu[i].num, stu[i].score);
//	}
//	return 0;
//}


//#include"stdio.h"
//#define N 20
//struct stuinf
//{
//    char stid[N];
//    int score;
//}stu[N];
//int main()
//{
//    struct stuinf *ptemp,*p[N];
//    int i,j,n;
//    scanf("%d",&n);
//    getchar();
//    for(i=0;i<n;i++)
//    {
//        scanf("%[^,],%d",stu[i].stid,&stu[i].score);
//        getchar();
//        p[i]=&stu[i];
//    }
//    for(j=1;j<n;j++)
//        for(i=0;i<n-j;i++)
//            if(p[i]->score<p[i+1]->score)
//            {
//                ptemp=p[i];
//                p[i]=p[i+1];
//                p[i+1]=ptemp;
//            }
//    for(i=0;i<n;i++)
//        printf("%s,%d\n",&(*p[i]).stid,(*p[i]).score);
//    return 0;
//}



//#include<stdio.h>
//int main()
//{
//    struct student
//    {
//        char a[20];
//        int grade;
//    }mess[30];
//    mess[]={zyj,23,asdf,234,we,43};
//
//    return 0;
//}



//#include<stdio.h>
//#include<stdlib.h>
//#define NULL 0
//#define OK 1
//#define ERROR 0
//#define OVERFLOW -2
//typedef int Status;
//typedef int Elemtype;
////链表结点
//typedef struct Cnode
//{
//	Elemtype data;
//	struct Cnode *next;
//}CNode;
//CNode *king;
//
////建立循环链表
//Status Create_clist(CNode *clist,int n)
//{
//	CNode *p,*q;
//	int i;
//	clist=NULL;
//	for(i=n;i>=1;i--)
//	{
//		p=(CNode *)malloc(sizeof(CNode));
//		if(p==NULL)
//			return OVERFLOW;
//		p->data=i;
//		p->next=clist;
//		clist=p;
//		if(i==n)
//			q=p;//q指向尾结点
//	}
//	q->next=clist;//将尾结点指针域指向第一个结点，构成循环链表
//	king=clist;
//	return OK;
//}
//
////选猴王
//Status King(CNode *clist,int n)
//{
//	int i,k;
//	int m=13;
//	CNode *p,*q;
//
//	if(!Create_clist(clist,n))//循环链表创建失败
//		return ERROR;
//	p=king;
//	while(p)
//	{
//		for(i=1;i<m-1;++i)//报数
//		{
//			p=p->next;
//		}
//		q=p->next;
//		if(q==p)//剩下一只猴子时返回data
//		{
//			k=p->data;
//			break;
//		}
//		else//出列
//		{
//			p->next=q->next;
//			p=p->next;
//			free(q);
//			m=m-1;
//		}
//		if(m==0)
//			m=13;
//
//	}
//	clist=NULL;
//
//	return k;
//}
////
//void main()
//{
//	int n,k;
//	CNode *clist;
//	clist=NULL;
//	printf("\n请输入猴子的个数n:");
//	scanf("%d",&n);
//	Create_clist(clist,n);
//	k=King(clist,n);
//	printf("\n猴王是第%d只猴子\n",k);
//}





#include<stdio.h>
#include<stdlib.h>
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

Status Create_clist(CNode *clist,int n)//创建链表
{
	CNode *p,*q;
	int i;
	clist->next=NULL;
	for(i=n;i>=1;i--)
	{
		p=(CNode *)malloc(sizeof(CNode));//分配空间
		if(p==NULL)//创建失败
			return OVERFLOW;
		p->data=i;//标号
		p->next=clist->next;
		clist->next=p;
		if(i==n)//头结点赋给q
			q=p;
	}
	q->next=clist->next;//指向第一个节点，形成循环链表
	joseph=clist;//循环链表表头指针赋给全局变量
	return OK;
}

Status Monky(CNode *clist,int n,int k)//求出猴王
{
	int i;
	CNode *p,*q;
	if(!Create_clist(clist,n))//创建失败
		return ERROR;
	p=joseph;
	if(1==n)
	{
        p->data=1;
        printf("1");
        return 0;
	}
	while(p)
	{
		if(1==k)//报数为1时
		{
			k=13;
			q=p->next;
            p->next=q->next;
		}
		if(k>1)//报数大于1时
        {
            for(i=0;i<k-1;i++)
            {
                p=p->next;
            }
            q=p->next;
            p->next=q->next;
            --k;
        }

        if(p==p->next)
        {
            printf("%d\n",p->data);
            free(p);
            break;
        }
	}
	return OK;
}

int main()
{
	int n,k=13;//n节点数,k计数
	CNode *clist;//
	clist=(CNode *)malloc(sizeof(CNode));
	clist->next=NULL;
	printf("猴子数目为：");
	scanf("%d",&n);
	Create_clist(clist,n);//创建一个有n个节点的循环链表clist
	printf("\n猴王为：");
	Monky(clist,n,k);
	free(clist);
	return 0;
}






//#include <stdio.h>
//#include <stdlib.h>
//#include <conio.h>
//#define OK 1
//#define OVERFLOW -2
//typedef int status;
//typedef int ElemType;
//#define LIST_INIT_SIZE 10
//typedef struct
//{
//    ElemType *elem;
//    int length;
//    int listsize;
//}SqList;
//
//status InitList_Sq(SqList; &L)
//{
//    L.elem=(ElemType *)malloc(LIST_INIT_SIZE*sizeof(ElemType));
//    if(!L.elem) return OVERFLOW;
//    L.length=0;
//    L.listsize=LIST_INIT_SIZE;
//    return 0;
//}
//
//status Rabbit(SqList &L)
//{
//    int i,current=0;
//    for(i=0;i<LIST_INIT_SIZE;i++)
//    {
//        L.elem(i)=1;
//    }
//    L.elem[LIST_INIT_SIZE-1]=0;
//    L.elem[0]=0;
//    for(i=2;i<=1000;i++)
//    {
//        current=(current+i)%LIST_INIT_SIZE;
//        L.elem[current]=0;
//    }
//    printf("\n兔子可能藏在如下的洞中：");
//    for(i=0;i<LIST_INIT_SIZE;i++)
//    {
//        if((L)->elem[i]==1)
//            printf("\n此洞是第%d号洞",i+1);
//    }
//    return 0;
//}
//
//int main()
//{
//    SqList L;
//    InitList_Sq(L);
//    Rabbit(L);
//    return 0;
//}

//*******************************************









//**************************************
//#include<stdio.h>
//#include<stdlib.h>
//#include<conio.h>
//#define NULL 0
//#define OK 1
//#define ERROR 0
//#define OVERFLOW -2
//typedef int Status;
//typedef int Elemtype;
//typedef struct Cnode
//{
//	Elemtype data;
//	struct Cnode *next;
//}CNode;
//CNode *joseph;
//
//Status Create_clist(CNode *clist,int n)
//{
//	CNode *p,*q;
//	int i;
//	clist=NULL;
//	for(i=n;i>=1;i--)
//	{
//		p=(Cnode *)malloc(sizeof(Cnode));
//		if(p==NULL)
//			return OVERFLOW;
//		p->data=i;
//		p->next=clist;
//		clist=p;
//		if(i==n)
//			q=p;
//	}
//	q->next=clist;
//	joseph=clist;
//	return OK;
//}
//
//Status Joseph(CNode *clist,int n,int k)
//{
//	int i;
//	CNode *p,*q;
//	if(!Create_clist(clist,n))
//		return ERROR;
//	p=joseph;
//	for(i=1;i<n;++i)
//	{
//		p=p->next;
//	}
//	while(p)
//	{
//		for(i=1;i<k;i++)
//		{
//			p=p->next;
//			--k;
//			if(1==k)
//				k=13;
//		}
//		q=p->next;
//		p->next=q->next;
//		free(q);
//	}
//	clist=NULL;
//}
//int main()
//{
//	int n,k=13;
//	CNode *clist;
//	clist=NULL;
//	scanf(" 猴子数目：%d",&n);
//	Create_clist(clist,n);
//	printf("\n猴王为:");
//	Joseph(clist,n,k);
//	getch();
//	return 0;
//}

//*******************************************
/*
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
			p=p->next;
		q=p->next;
		printf("%d",q->data);
		if(p->next==p)
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
int main()
{
	int m=1,n=15,k=13;
	CNode *clist;
	clist=NULL;
	printf("\n你希望报数到第几个人数的人出列k:");
	scanf("%d",&k);
	Create_clist(clist,n);
	printf("\n出列的顺序如下:\n");
	Joseph(clist,m,n,k);
	getch();
	return 0;
}
*/
//*******************************************


//#include <stdio.h>
//#include <stdlib.h>
//#include <conio.h>
//#define OK 1
//#define OVERFLOW -2
//typedef int status;
//typedef int ElemType;
//#define LIST_INIT_SIZE 10
//typedef struct
//{
//    ElemType *elem;
//    int length;
//    int listsize;
//}SqList;
//
//status InitList_Sq(SqList *L)
//{
//    (L)->elem=(ElemType *)malloc(LIST_INIT_SIZE*sizeof(ElemType));
//    if(!((L)->elem))
//        return OVERFLOW;
//    (L)->length=0;
//    (L)->listsize-LIST_INIT_SIZE;
//    return 0;
//}
//
//status Rabbit(SqList *L)
//{
//    int i,current=0;
//    for(i=0;i<LIST_INIT_SIZE;i++)
//        (L)->elem[i]=1;
////    (L).elem[LIST_INIT_SIZE-1]=0;
//    (L)->elem[0]=0;
//    for(i=2;i<=1000;i++)
//    {
//        current=(current+i)%LIST_INIT_SIZE;
//        (L)->elem[current]=0;
//    }
//    printf("\n兔子可能藏在如下的洞中：");
//    for(i=0;i<LIST_INIT_SIZE;i++)
//        if((L)->elem[i]==1)
//            printf("\n此洞是第%d号洞",i+1);
//    return OK;
//}
//
//int main()
//{
//    SqList *L;
//    InitList_Sq(L);
//    Rabbit(L);
//    getch();
//    return 0;
//}


//*******************************************




//#include<stdio.h>
//#include<stdlib.h>
//#include<conio.h>
//#define NULL 0
//#define OK 1
//#define ERROR 0
//#define OVERFLOW -2
//typedef int Status;
//typedef int Elemtype;
//typedef struct Cnode
//{
//	Elemtype data;
//	struct Cnode *next;
//}CNode;
//CNode *joseph;
//Status Create_clist(CNode &clist,int n)
//{
//	CNode *p,*q;
//	int i;
//	clist=NULL;
//	for(i=n;i>=1;i--)
//	{
//		p=(CNode *)malloc(sizeof(CNode));
//		if(p==NULL)
//			return OVERFLOW;
//		p->data=i;
//		p->next=clist;
//		clist=p;
//		if(i==n)
//			q=p;
//	}
//	q->next=clist;
//	joseph=clist;
//	return OK;
//}
//Status Joseph(CNode &clist,int m,int n,int k)
//{
//	int i;
//	CNode *p,*q;
//	if(m>n)
//		return ERROR;
//	if(!Create_clist(clist,n))
//		return ERROR;
//	p=joseph;
//	for(i=1;i<m;i++)
//		p=p->next;
//	while(p)
//	{
//		for(i=1;i<k-1;i++)
//			q=p->next;
//		printf("%d",q->data);
//		if(q->next==p)
//			p=NULL;
//		else
//		{
//			p->next=q->next;
//			p=p->next;
//			free(q);
//		}
//	}
//	clist=NULL;
//}
//void main()
//{
//	int m,n,k,i;
//	CNode clist;
//	clist=NULL;
//	printf("\n请输入围坐在圆桌周围的人数n:");
//	scanf("%d",&n);
//	printf("\n请输入第一次开始报数人的位置m:");
//	scanf("%d",&m);
//	printf("\n你希望报数到第几个人数的人出列k:");
//	scanf("%d",&k);
//	Create_clist(clist,n);
//	printf("\n出列的顺序如下:\n");
//	Joseph(clist,m,n,k);
//	getch();
//}


//*******************************************




//#include <stdio.h>
//#include <stdlib.h>
//#include <conio.h>
//#define OK 1
//#define OVERFLOW -2
//typedef int status;
//typedef int ElemType;
//#define LIST_INIT_SIZE 10
//typedef struct
//{
//    ElemType *elem;
//    int length;
//    int listsize;
//}SqList;
//
//status InitList_Sq(SqList &L)
//{
//    (L).elem=(ElemType *)malloc(LIST_INIT_SIZE*sizeof(ElemType));
//    if(!((L).elem))
//        return OVERFLOW;
//    (L).length=0;
//    (L).listsize-LIST_INIT_SIZE;
//    return 0;
//}
//
//status Rabbit(SqList &L)
//{
//    int i,current=0;
//    for(i=0;i<LIST_INIT_SIZE;i++)
//        (L).elem[i]=1;
// //   (L).elem[LIST_INIT_SIZE-1]=0;
//    (L).elem[0]=0;
//    for(i=2;i<=1000;i++)
//    {
//        current=(current+i)%LIST_INIT_SIZE;
//        (L).elem[current]=0;
//    }
//    printf("\n兔子可能藏在如下的洞中：");
//    for(i=0;i<LIST_INIT_SIZE;i++)
//        if((L).elem[i]==1)
//            printf("\n此洞是第%d号洞",i+1);
//    return OK;
//}
//
//int main()
//{
//    SqList L;
//    InitList_Sq(L);
//    Rabbit(L);
//    getch();
//    return 0;
//}
