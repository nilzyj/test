//哈夫曼编码？
//#include<stdio.h>
//#include<string.h>
//#define N 10
//#define M 2*N-1
//typedef struct
//{
//    unsigned int weight;
//    unsigned int parent,lchild,rchild;
//}HTNode;
//
//typedef struct
//{
//    char data;
//    int weight;
//    char code[N];
//}HTCode;
//
//void Init(HTCode hc[],int *n)
//{
//    int i;
//    printf("\ninput n=");
//    scanf("%d",&(*n));
//    printf("\ninput %d character\n",*n);
//    for(i=1;i<*n;i++)
//        hc[i].data=getchar();
//    printf("\ninput %d weight\n",*n);
//    for(i=1;i<=*n;i++)
//        scanf("%d",&(hc[i].weight));
//}
//
//void Select(HTNode ht[],int k,int *s1,int *s2)
//{
//    int i;
//    for(i=1;i<=k && ht[i].parent!=0;i++)
//        *s1=i;
//    for(i=1;i<=k;i++)
//        if(ht[i].parent==0 && ht[i].weight<ht[*s1].weight)
//            *s1=i;
//    for(i=1;i<=k;i++)
//        if(ht[i].parent==0 && i!=*s1)
//            break;
//    *s2=i;
//    for(i=1;i<=k;i++)
//        if(ht[i].parent==0 && i!=*s1 && ht[i].weight<ht[*s2].weight)
//            *s2=i;
//}
//
//void HuffmanCoding(HTNode ht[],HTCode hc[],int n)
//{
//    char cd[N];
//    int i,j,m,c,f,s1,s2,start;
//    m=2*n-1;
//    for(i=1;i<=m;i++)
//    {
//        if(i<=n)
//            ht[i].weight=hc[i].weight;
//        else
//            ht[i].weight=0;
//        ht[i].parent=ht[i].lchild=ht[i].rchild=0;
//    }
//    for(i=n+1;i<=m;i++)
//    {
//        Select(ht,i-1,&s1,&s2);
//        ht[s1].parent=i;
//        ht[s2].parent=i;
//        ht[i].lchild=s1;
//        ht[i].rchild=s2;
//        ht[i].weight=ht[s1].weight+ht[s2].weight;
//    }
//    cd[n-1]='\0';
//    for(i=1;i<=n;i++)
//    {
//        start=n-1;
//        for(c=i,f=ht[i].parent;f;c=f,f=ht[f].parent)
//            if(ht[f].lchild==c)
//                cd[--start]='\0';
//            else
//                cd[--start]='1';
//        strcpy(hc[i].code,&cd[start]);
//    }
//}
//
//int main()
//{
//    int i,m,n,w[N+1];
//    HTNode ht[N+1];
//    HTCode hc[N+1];
//    Init(hc,&n);
//    HuffmanCoding(ht,hc,n);
//    for(i=1;i<=n;i++)
//        printf("\n%c --- %s",hc[i].data,hc[i].code);
//    return 0;
//}








//哈夫曼编码ok
//#include <stdio.h>
//#include <string.h>
//#define N 10
//#define M 2*N-1
//typedef struct
//{
//	unsigned int weight;
//	unsigned int parent,lchild,rchild;
//}HTNode;
//typedef struct
//{
//	char data;
//	int weight;
//	char code[N];
//}HTCode;
//void Init(HTCode hc[],int *n)
//{
//	int i;
//	printf("\n(0 over)input n=");
//	scanf("%d",&(*n));
//	if(*n!=0)
//	{
//		printf("input %d character\n",*n);
//		getchar();
//		for(i=1;i<=*n;i++)
//			hc[i].data=getchar();
//		printf("input %d weight\n",*n);
//		for(i=1;i<=*n;i++)
//            scanf("%4d",&hc[i].weight);
//	}
//}
//
//void Select(HTNode ht[],int k,int *s1,int *s2)
//{
//	int i;
//	for(i=1;i<=k && ht[i].parent!=0;i++);
//	*s1=i;
//	for(i=1;i<=k;i++)
//        if(ht[i].parent==0 && ht[i].weight<ht[*s1].weight)
//            *s1=i;
//	for (i=1;i<=k;i++)
//		if (ht[i].parent==0 && i!=*s1)
//			break;
//    *s2=i;
//	for(i=1;i<=k;i++)
//		if(ht[i].parent==0 && i!=*s1 && ht[i].weight<ht[*s2].weight)
//			*s2=i;
//}
//
//void huffmancoding(HTNode ht[],HTCode hc[],int n)
//{
//    char cd[N];
//	int i,m,c,f,s1,s2,start;
//
//	m=2*n-1;
//	for(i=1;i<=m;i++)
//	{
//		if(i<=n)
//			ht[i].weight=hc[i].weight;
//		else
//			ht[i].weight=0;
//		ht[i].parent=ht[i].lchild=ht[i].rchild=0;
//	}
//	for(i=n+1;i<=m;i++)
//	{
//		Select(ht,i-1,&s1,&s2);
//		ht[s1].parent=i;
//		ht[s2].parent=i;
//		ht[i].lchild=s1;
//		ht[i].rchild=s2;
//		ht[i].weight=ht[s1].weight+ht[s2].weight;
//	}
//	cd[n-1]='\0';
//	for(i=1;i<=n;i++)
//	{
//		start=n-1;
//		for(c=i,f=ht[i].parent;f;c=f,f=ht[f].parent)
//			if(ht[f].lchild==c)
//				cd[--start]='0';
//			else
//                cd[--start]='1';
//        strcpy(hc[i].code,&cd[start]);
//	}
//}
//int main()
//{
//	int i,n;
//	while(1)
//	{
//		HTNode ht[M+1];
//		HTCode hc[N+1];
//		Init(hc,&n);
//		if(n==0)
//			break;
//		huffmancoding(ht,hc,n);
//		for(i=1;i<=n;i++)
//            printf("%c --- %s\n",hc[i].data,hc[i].code);
//	}
//	return 0;
//}


//中序和后序有问题
//#include<stdio.h>
//#include<malloc.h>
//#include<stdlib.h>
//#define INITSIZE 100
//#define INCREASE 10
//typedef struct BiTNode//二叉树
//{
//	char data;
//	struct BiTNode *lchild, *rchild;
//}BiTNode, *BiTree;
//
//typedef struct//栈
//{
//	BiTree *base;
//	BiTree *top;
//	int stacksize;
//}SqStack;
//int InitStack(SqStack &S)//初始化栈
//{
//	S.base=(BiTree *)malloc(sizeof(BiTree));
//	if(!S.base)
//		exit(-2);
//	S.top=S.base;
//	S.stacksize=INITSIZE;
//	return 1;
//}
//int GetTop(SqStack &S,BiTree &e)//获取栈顶元素
//{
//	if(S.top==S.base)
//		return 0;
//	e=*(S.top-1);
//	return 1;
//}
//int Push(SqStack &S,BiTree e)//入栈
//{
//	if(S.top-S.base>=S.stacksize)
//	{
//		S.base=(BiTree *)realloc(S.base,(S.stacksize+INCREASE)*sizeof(BiTree));
//		if(!S.base)
//			return 0;
//		S.top=S.base+S.stacksize;
//		S.stacksize+=INCREASE;
//	}
//	*S.top=e;
//	S.top++;
//	return 1;
//}
//int Pop(SqStack &S,BiTree &e)//出栈
//{
//	if(S.base==S.top)
//		return 0;
//	S.top--;
//	e=*S.top;
//	return 1;
//}
//int StackEmpty(SqStack S)//判断栈是否空
//{
//	if(S.top==S.base)
//		return 1;
//	else
//		return 0;
//}
//int CreateBiTree(BiTree &T)
//{
//	char ch;
//	scanf("%c",&ch);
//	if(ch=='#')
//		T=NULL;
//	else
//	{
//		if(!(T=(BiTNode* )malloc(sizeof(BiTNode))))
//			exit(-2);
//		T->data=ch;
//		CreateBiTree(T->lchild);
//		CreateBiTree(T->rchild);
//	}
//	return 1;
//}
//int PreOrderUn(BiTree T)
//{
//	SqStack s;
//	BiTree P=T;
//	InitStack(s);
//	while ( P!=NULL || !StackEmpty(s))
//	{
//		if (P!=NULL)
//		{
//			printf("%c",P->data);
//			Push(s,P);
//			P=P->lchild;
//		}
//		else
//		{
//			Pop(s,P);
//			P=P->rchild;
//		}
//	}
//	return 1;
//}
//int InOrderUn(BiTree T)
//{
//	SqStack S;
//	InitStack(S);
//	BiTree p;
//	p=T;
//	while(p || !StackEmpty(S))
//	{
//		if(p)
//		{
//			Push(S,p);
//			p=p->lchild;
//		}
//		else
//		{
//			Pop(S,p);
//			printf("%c",p->data);
//			p=p->rchild;
//		}
//	}
//	return 1;
//}
//int PostOrderUn(BiTree T)
//{
//	SqStack s,tag;
//	BiTree f,m,n,P=T;
//	m=(BiTNode*)malloc(sizeof(BiTNode));
//	m->data=1;
//	m->lchild=NULL;
//	m->rchild=NULL;
//	n=(BiTNode*)malloc(sizeof(BiTNode));
//	n->data=2;
//	n->lchild=NULL;
//	n->rchild=NULL;
//	InitStack(s);
//	InitStack(tag);
//	while (P ||!StackEmpty(s))
//	{
//		if(P)
//		{
//			Push(s,P);
//			Push(tag,m);
//			P=P->lchild;
//		}
//		else
//		{
//			Pop(s,P);
//			Pop(tag,f);
//			if(f==m)
//			{
//				Push(s,P);
//				Push( tag, n);
//				P=P->rchild;
//			}
//			else
//			{
//				printf("%c",P->data);
//				P=NULL;
//			}
//		}
//	}
//	return 1;
//}
//
//int main()
//{
//	printf("建立二叉树:");
//	BiTree t;
//	CreateBiTree(t);
//	printf("先序非递归遍历输出为：");
//	PreOrderUn(t);
//	printf("\n");
//	printf("中序非递归遍历输出为：");
//	InOrderUn(t);
//	printf("\n");
//	printf("后序非递归遍历输出为：");
//	PostOrderUn(t);
//	printf("\n");
//	return 0;
//}




#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
#define INITSIZE 100
#define INCREASE 10
typedef struct BiTNode//二叉树
{
	char data;
	struct BiTNode *lchild, *rchild;
}BiTNode, *BiTree;

typedef struct//栈
{
	BiTree *base;
	BiTree *top;
	int stacksize;
}SqStack;
int InitStack(SqStack &S)//初始化栈
{
	S.base=(BiTree *)malloc(sizeof(BiTree));
	if(!S.base)
		exit(-2);
	S.top=S.base;
	S.stacksize=INITSIZE;
	return 1;
}
int GetTop(SqStack &S,BiTree &e)//获取栈顶元素
{
	if(S.top==S.base)
		return 0;
	e=*(S.top-1);
	return 1;
}
int Push(SqStack &S,BiTree e)//入栈
{
	if(S.top-S.base>=S.stacksize)
	{
		S.base=(BiTree *)realloc(S.base,(S.stacksize+INCREASE)*sizeof(BiTree));
		if(!S.base)
			return 0;
		S.top=S.base+S.stacksize;
		S.stacksize+=INCREASE;
	}
	*S.top=e;
	S.top++;
	return 1;
}
int Pop(SqStack &S,BiTree &e)//出栈
{
	if(S.base==S.top)
		return 0;
	S.top--;
	e=*S.top;
	return 1;
}
int StackEmpty(SqStack S)//判断栈是否空
{
	if(S.top==S.base)
		return 1;
	else
		return 0;
}
int CreateBiTree(BiTree &T)
{
	char ch;
	scanf("%c",&ch);
	if(ch =='#')
		T=NULL;
	else
	{
		if(!(T=(BiTNode* )malloc(sizeof(BiTNode))))
			exit(-2);
		T->data=ch;
		CreateBiTree(T->lchild);
		CreateBiTree(T->rchild);
	}
	return 1;
}
int PreOrderUn(BiTree T)
{
	SqStack s;
	BiTree P=T;
	InitStack(s);
	while(P || !StackEmpty(s))
	{
		if (P)
		{
			printf("%c",P->data);
			Push(s,P);
			P=P->lchild;
		}
		else
		{
			Pop(s,P);
			P=P->rchild;
		}
	}
	return 1;
}
int InOrderUn(BiTree T)
{
	SqStack S;
	InitStack(S);
	BiTree p;
	p=T;
	while(p || !StackEmpty(S))
	{
		if(p)
		{
			Push(S,p);
			p=p->lchild;
		}
		else
		{
			Pop(S,p);
			printf("%c",p->data);
			p=p->rchild;
		}
	}
	return 1;
}
int PostOrderUn(BiTree T)
{
	SqStack s,tag;
	BiTree f,m,n,P=T;
	m=(BiTNode*)malloc(sizeof(BiTNode));
	m->data=1;
	m->lchild=NULL;
	m->rchild=NULL;
	n=(BiTNode*)malloc(sizeof(BiTNode));
	n->data=2;
	n->lchild=NULL;
	n->rchild=NULL;
	InitStack(s);
	InitStack(tag);
	while (P ||!StackEmpty(s))
	{
		if(P)
		{
			Push(s,P);
			Push(tag,m);
			P=P->lchild;
		}
		else
		{
			Pop(s,P);
			Pop(tag,f);
			if(f==m)
			{
				Push(s,P);
				Push( tag, n);
				P=P->rchild;
			}
			else
			{
				printf("%c",P->data);
				P=NULL;
			}
		}
	}
	return 1;
}

int main()
{
	printf("建立二叉树:");
	BiTree t;
	CreateBiTree(t);
	printf("先序非递归遍历输出为：");
	PreOrderUn(t);
	printf("\n");
	printf("中序非递归遍历输出为：");
	InOrderUn(t);
	printf("\n");
	printf("后序非递归遍历输出为：");
	PostOrderUn(t);
	printf("\n");
	return 0;
}





//？
//#include<stdio.h>
//#include<stdlib.h>
//#define INITSIZE 100
//#define INCREASE 10
//
////二叉树
//typedef struct BiTNode
//{
//    char data;
//    struct BiTNode *lchild,*rchild;
//}BiTNode,*BiTree;
//
////栈
//typedef struct
//{
//    BiTree *base;
//    BiTree *top;
//    int stacksize;
//}SqStack;
//
//
//
////先序递归建立二叉树
//int CreateBiTree(BiTree &T)
//{
//    char ch=getchar();
//    if(ch=='#')
//        T=NULL;
//    else
//    {
//        T=(BiTNode *)malloc(sizeof(BiTNode));
//        T->data=ch;
//        CreateBiTree((T->lchild));
//        CreateBiTree((T->rchild));
//    }
//    return 1;
//}
//
////先序递归遍历
////void PreOrder(BiTree T)
////{
////    if(T)
////    {
////        printf("%2c",T->data);
////        PreOrder(T->lchild);
////        PreOrder(T->rchild);
////    }
////}
//////中序递归遍历
////void InOrder(BiTree T)
////{
////    if(T)
////    {
////        InOrder(T->lchild);
////        printf("%2c",T->data);
////        InOrder(T->rchild);
////    }
////}
//////后序递归遍历
////void PostOrder(BiTree T)
////{
////    if(T)
////    {
////        PostOrder(T->lchild);
////        PostOrder(T->rchild);
////        printf("%2c",T->data);
////    }
////}
//
////初始化栈
//int Initstack(SqStack &s)
//{
//    s.base=(BiTree *)malloc(INITSIZE*sizeof(BiTNode));
//    if(!(s.base))             //存储分配失败
//        exit(-2);
//    s.top=s.base;
//    s.stacksize=INITSIZE;
//    return 1;
//}
//
////入栈
//int push(SqStack &s,BiTree *T)
//{
//    if(s.top-s.base>=s.stacksize)//栈满，追加储存空间
//    {
//        s.base=(BiTree *)malloc((s.stacksize+INCREASE)*sizeof(BiTNode));
//        if((!s.base))             //存储分配失败
//            exit(-2);
//        s.top=s.base+s.stacksize;
//        s.stacksize+=INCREASE;
//    }
//    s.top=T;
//    s.top++;
//    return 1;
//}
////出栈
//int pop(SqStack &s)
//{
//
//	if(s.top==s.base)
//        return 0;
//	else
//	{
//		s.top--;
//		return 1;
//	}
//}
//
////栈是否为空，空返回1，否则返回0
//int stackempty(SqStack s)
//{
//    if(s.top==s.base)
//        return 1;
//    else
//        return 0;
//}
////先序非递归遍历
//void PreOrderUn(BiTree *T)//SqStack *s,
//{
//    SqStack s;
//    Initstack(s);
//
//    while((*T)!=NULL || !stackempty(s))
//    {
//        while((*T)!=NULL)
//        {
//            printf("%2c",(*T)->data);
//            push(s,T);
//            (*T)=(*T)->lchild;
//        }
//        if (!stackempty(s))
//        {
//			pop(s);
//			T=s.top--;
//
//            (*T)=(*T)->rchild;
//        }
//    }
//
//
//}
////中序非递归遍历
////void InOrderUn(BiTree T)//SqStack *s,
////{
////
////    SqStack s;
////    Initstack(&s);
////    while (T!=NULL || !stackempty(s))
////    {
////        while(T!=NULL)
////        {
////            push(&s,T);
////            T=T->lchild;
////        }
////    }
////    if(!stackempty(s))
////    {
////        T=pop(&s,T);
////        printf("%2c",T->data);
////        T=T->rchild;
////    }
////}
//
//
//////后序非递归遍历
////void PostOrderUn(SqStack *s,BiTree T)
////{
////}
//
//int main()
//{
//    BiTree T=(BiTNode *)malloc(sizeof(BiTNode));
//    SqStack S;
//    Initstack(S);
//    CreateBiTree(T);
////    printf("先序递归遍历");
////    PreOrder(T);
////    printf("\n");
////    printf("中序递归遍历");
////    InOrder(T);
////    printf("\n");
////    printf("后序递归遍历");
////    PostOrder(T);
//    printf("\n");
//    printf("先序非递归遍历");
//    PreOrderUn(&T);
//    printf("\n");
////    printf("中序非递归遍历");
////    InOrderUn(T);
//    printf("\n");
////    printf("后序非递归遍历");
////    PostOrderUn(&S,T);
//    printf("\n");
//    return 0;
//}
//test*******************************test

//*******************************************************
//哈夫曼树与哈夫曼编码
//#include<stdio.h>
//#include<string.h>
//#include<conio.h>
//#define N 10
//#define M 2*N-1
//typedef struct
//{
//    unsigned int weight;
//    unsigned int parent,lchild,rchild;
//}HTNode;
//
//typedef struct
//{
//    char data;
//    int weight;
//    char code[N];
//}HTCode;
//
//void Init(HTCode hc[],int *n)
//{
//    int i;
//    printf("\ninput n=");
//    scanf("%d",&(*n));
//
//    printf("\ninput %d character\n",*n);
//    getchar();
//    for(i=1;i<*n;i++)
//    {
//        hc[i].data=getchar();
//
//    }
//
//
//    printf("\ninput %d weight\n",*n);
//    for(i=1;i<=*n;i++)
//        scanf("%4d",&(hc[i].weight));
//}
//
//void Select(HTNode ht[],int k,int *s1,int *s2)
//{
//    int i;
//    for(i=1;i<=k && ht[i].parent!=0;i++)
//        *s1=i;
//    for(i=1;i<=k;i++)
//        if(ht[i].parent==0 && ht[i].weight<ht[*s1].weight)
//            *s1=i;
//    for(i=1;i<=k;i++)
//        if(ht[i].parent==0 && i!=*s1)
//            break;
//    *s2=i;
//    for(i=1;i<=k;i++)
//        if(ht[i].parent==0 && i!=*s1 && ht[i].weight<ht[*s2].weight)
//            *s2=i;
//}
//void HuffmanCoding(HTNode ht[],HTCode hc[],int n)
//{
//    char cd[N];
//    int i,j,m,c,f,s1,s2,start;
//    m=2*n-1;
//    for(i=1;i<=m;i++)
//    {
//        if(i<=n)
//            ht[i].weight=hc[i].weight;
//        else
//            ht[i].weight=0;
//        ht[i].parent=ht[i].lchild=ht[i].rchild=0;
//    }
//    for(i=n+1;i<=m;i++)
//    {
//        Select(ht,i-1,&s1,&s2);
//        ht[s1].parent=i;
//        ht[s2].parent=i;
//        ht[i].lchild=s1;
//        ht[i].rchild=s2;
//        ht[i].weight=ht[s1].weight+ht[s2].weight;
//    }
//    cd[n-1]='\0';
//    for(i=1;i<=n;i++)
//    {
//        start=n-1;
//        for(c=i,f=ht[i].parent;f;c=f,f=ht[f].parent)
//            if(ht[f].lchild==c)
//                cd[--start]='0';
//            else
//                cd[--start]='1';
//        strcpy(hc[i].code,&cd[start]);
//    }
//}
//
//int main()
//{
//    int i,n;
//    HTNode ht[M+1];
//    HTCode hc[N+1];
//    Init(hc,&n);
//    HuffmanCoding(ht,hc,n);
//    for(i=1;i<=n;i++)
//        printf("\n%c --- %s",hc[i].data,hc[i].code);
//    return 0;
//}

//************************************************************
//线索二叉树
//#include<stdio.h>
//#include<stdlib.h>
//#define NULL 0
//typedef char TElemType;
//typedef int Status;
//typedef enum{Link,Thread} PointerTag;
//typedef struct BiThrNode
//{
//    TElemType data;
//    struct BiThrNode *lchild,*rchild;
//    PointerTag LTag,RTag;
//}BiThrNode,*BiThrTree;
//BiThrTree pre;
//Status CreateBiTree(BiThrTree *T)
//{
//    char ch;
//    ch=getchar();
//    if(ch=='#')
//        (*T)=NULL;
//    else
//    {
//        (*T)=(BiThrTree)malloc(sizeof(BiThrNode));
//        (*T)->data=ch;
//        (*T)->LTag=(*T)->RTag=Link;
//        CreateBiTree(&(*T)->lchild);
//        CreateBiTree(&(*T)->rchild);
//    }
//    return 1;
//}
//void InThreading(BiThrTree p)
//{
//    if(p)
//    {
//        InThreading(p->lchild);
//        if(p->lchild==NULL)
//        {
//            p->LTag=Thread;
//            p->lchild=pre;
//        }
//        if(pre->rchild==NULL)
//        {
//            pre->RTag=Thread;
//            pre->rchild=p;
//        }
//        pre=p;
//        InThreading(p->rchild);
//    }
//}
//Status InorderThreading(BiThrTree *Thrt,BiThrTree T)
//{
//    (*Thrt)=(BiThrTree)malloc(sizeof(BiThrNode));
//    (*Thrt)->LTag=Link;
//    (*Thrt)->RTag=Thread;
//    (*Thrt)->rchild=(*Thrt);
//    if(T=NULL)
//        (*Thrt)->lchild=(*Thrt);
//    else
//    {
//        (*Thrt)->lchild=T;
//        pre=(*Thrt);
//        InThreading(T);
//        pre->rchild=(*Thrt);
//        pre->RTag=Thread;
//        (*Thrt)->rchild=pre;
//    }
//    return 1;
//}
//Status InorderTraverse(BiThrTree Thrt)
//{
//    BiThrTree p;
//    p=Thrt->lchild;
//    while(p!=Thrt)
//    {
//        while(p->LTag==NULL)
//            p=p->lchild;
//        printf("%2c",p->data);
//        while(p->RTag==Thread && p->rchild!=Thrt)
//        {
//            p=p->rchild;
//            printf("%2c",p->data);
//        }
//        p=p->rchild;
//    }
//    return 1;
//}
//int main()
//{
//    BiThrTree T=NULL,Thrt=NULL;
//    printf("\nCreate a Thread Binary Tree\n");
//    CreateBiTree(&T);
//    InorderThreading(&Thrt,T);
//    InorderTraverse(Thrt);
//    return 0;
//}


//*******************************************************
//二叉树的基本运算实验
//#include <stdio.h>
//#include <stdlib.h>
//#define MAX 20
//#define NULL 0
//typedef char TElemType;
//typedef int Status;
//typedef struct BiTNode
//{
//    TElemType data;
//    struct BiTNode *lchild,*rchild;
//}BiTNode,*BiTree;
//Status CreateBiTree(BiTree *T)
//{
//    char ch=getchar();
//    if(ch=='#')
//        (*T)=NULL;
//    else
//    {
//        (*T)=(BiTree)malloc(sizeof(BiTNode));
//        (*T)->data=ch;
//        CreateBiTree(&(*T)->lchild);
//        CreateBiTree(&(*T)->rchild);
//    }
//    return 1;
//}
//void PreOrder(BiTree T)
//{
//    if(T)
//    {
//        printf("%2c",T->data);
//        PreOrder(T->lchild);
//        PreOrder(T->rchild);
//    }
//}
//void Levleorder(BiTree T)
//{
//    BiTree Queue[MAX],b;
//    int front,rear;
//    front=rear=0;
//    if(T)
//    {
//        Queue[rear++]=T;
//        while(front!=rear)
//        {
//            b=Queue[front++];
//            printf("%2c",b->data);
//            if(b->lchild!=NULL)
//                Queue[rear++]=b->lchild;
//            if(b->rchild!=NULL)
//                Queue[rear++]=b->rchild;
//        }
//    }
//}
//int depth(BiTree T)
//{
//    int dep1,dep2;
//    if(T==NULL)
//        return 0;
//    else
//    {
//        dep1=depth(T->lchild);
//        dep2=depth(T->rchild);
//        return dep1>dep2?dep1+1:dep2+1;
//    }
//}
//
//int main()
//{
//    BiTree T=NULL;
//    printf("\nCreate a Binary Tree\n");
//    CreateBiTree(&T);
//    printf("\nThe preorder is:\n");
//    PreOrder(T);
//    printf("\nThe level order is:\n");
//    Levleorder(T);
//    printf("\nThe depth is:%d\n",depth(T));
//    return 0;
//}
//*******************************************************







//不知道干嘛的，也不知道从哪来的
//#include<stdio.h>
//#include<stdlib.h>
//#include<string>
//int main()
//{
//    unsigned char *s,*e="ABcd",*c="你好";
//    clrscr();
//    printf("English char =");
//    s=e;
//    while(*s!=0) /*C的字符串以0为结束符*/
//    {
//        printf("%3d,",*s);
//        s++;
//    }
//    printf("\nChinease char=");
//    s=c;
//    while(*s!=0)
//    {
//        printf("%3d,",*s);
//        s++;
//    }
//    return 0;
//}

//判断数字，空格，字符个数
//#include <iostream>
//#include<stdio.h>
//#include<stdlib.h>
//using namespace std;
//
//int main()
//{
//    char a;
//    int flag,n=1;
//    int j=0,k=0,l=0;
//    while(n<11)
//    {
//        scanf("%c",&a);
//        if(a>=48 && a<=57)
//            flag=1;
//        else if(32==a)
//            flag=2;
//        else// if((a>=0 && a<48) || (a>57 && a<128)&&a!=32)
//            flag=3;
//        switch(flag)
//        {
//            case 1:++j;break;
//            case 2:++k;break;
//            case 3:++l;break;
//        }
//        ++n;
//    }
//    printf("数字个数为%d，空格个数为%d，其他字符个数为%d",j,k,l);
//    return 0;
//}


//不知道从哪弄来的，反正不对
//#include <stdio.h>
//#include <malloc.h>
//#include <stdlib.h>
//#define STACK_INT_SIZE 100 //存储空间初始分配量
//#define STACKINCREMENT 10 //存储空间分配增量
//#define OK 1
//#define ERROR 0
//#define TRUE 1
//#define FALSE 0
//#define OVERFLOW -2
//typedef char TElemType;
//typedef int Status;
//typedef char SElemType;
////二叉树的二叉链表存储表示
//typedef struct BiTNode
// {
// TElemType data;
// struct BiTNode *lchild, *rchild; //左右孩子指针
//}BiTNode, *BiTree;
////用于存储二叉树结点的栈
//typedef struct
// {
// BiTree *base;
// BiTree *top;
// int stacksize; //当前已分配的存储空间
//}SqStack;
////定义链式队列结点
//typedef struct QNode
//{
// BiTree Queuedata;
// struct QNode * next;
//}QNode,* QueuePtr;
////定义链式队列
//typedef struct
//{
// QueuePtr front; //
// QueuePtr rear;
//}LinkQueue;
////创建存储二叉树结点的空栈
//Status InitStack(SqStack &S)
//{
// S.base = (BiTree *) malloc(sizeof(BiTree));
// if(!S.base) exit(OVERFLOW);
// S.top = S.base;
// S.stacksize = STACK_INT_SIZE;
// return OK;
//}
////存储二叉树结点的栈的取栈顶元素
//Status GetTop(SqStack &S, BiTree &e)
// {
//// 若栈不空，则用e返回S的栈顶元素
// if(S.top == S.base) return ERROR;
// e = *(S.top-1);
// return OK;
//}
////存储二叉树结点的栈的入栈操作
//Status Push(SqStack &S, BiTree e)
//{
//// 插入元素e为栈顶元素
// if(S.top - S.base >= S.stacksize)
// { //若栈满，则追加存储空间
// S.base = (BiTree *) realloc(S.base, (S.stacksize + STACKINCREMENT)*sizeof(BiTree));
// if(!S.base) return ERROR;
// S.top = S.base + S.stacksize;
// S.stacksize += STACKINCREMENT;
// }
// *S.top = e;
// S.top++;
// return OK;
//}
//
////用于存储二叉树结点的栈出栈操作
//Status Pop(SqStack &S,BiTree &e)
//{
//// 删除S的栈顶元素，并用e返回
// if(S.base == S.top) return ERROR;
// S.top--;
// e = *S.top;
// return OK;
//}
//
////判断存储二叉树结点的栈是否为空
// Status StackEmpty(SqStack S)
// {
////  若栈S为空栈，则返回TRUE，否则返回FALSE
// if(S.top == S.base) return TRUE;
// else return FALSE;
// }
////先序顺序创建一颗二叉树
//Status PreOrderCreateBiTree(BiTree &T)
// {
//// 按先序次序输入二叉树中结点的值
//// 构造二叉链表表示的二叉树T
// char ch;
// scanf("%c",&ch);
// if(ch == '0') T = NULL;
// else
// {
// if(!(T = (BiTree ) malloc(sizeof(BiTree)))) exit(OVERFLOW);//作用和下一语句的作用相同，注意两者的区别
// if(!(T = (BiTNode* ) malloc(sizeof(BiTNode)))) exit(OVERFLOW);
// T->data = ch; //生成根结点
// PreOrderCreateBiTree(T->lchild); //构造左子树
// PreOrderCreateBiTree(T->rchild); //构造右子树
// }
// return OK;
//} //CreateBiTree
////递归先序遍历二叉树
//void PreOrder ( BiTree bt )
//{
// if ( bt )
// {
// printf("%c",bt->data); //先访问根节点
// PreOrder ( bt->lchild );//遍历左子树
// PreOrder ( bt->rchild ); //遍历右子树
// }
//}
////递归中序遍历二叉树
//void Inorder ( BiTree bt )
//{
// if ( bt )
// {
// Inorder ( bt->lchild ); //遍历左子树
// printf("%c",bt->data);//访问根节点
// Inorder ( bt->rchild );//遍历右子树
// }
//}
////递归后序遍历二叉树
//void LastOrder ( BiTree bt )
//{
// if ( bt )
// {
// LastOrder( bt->lchild );//遍历左子树
// LastOrder( bt->rchild );//遍历右子树
// printf("%c",bt->data);//访问根节点
// }
//}
////非递归先序遍历二叉树 方法一：
//Status PreOrderTraverse(BiTree T)
//{
// SqStack s;
// BiTree P=T;
// InitStack(s);
// while ( P!=NULL || !StackEmpty(s))
// {
// if (P!=NULL)
// {
// printf("%c",P->data);
// Push(s,P); //访问完之后将根节点入栈
// P=P->lchild;
// }
//
// else
// {
// Pop(s,P);
// P=P->rchild;
// }
//}
// return OK;
//}
////非递归先序遍历二叉树 方法二：
//Status PreOrderTraverse2(BiTree T)
//{
// SqStack s;
// BiTree P=T;
// InitStack(s);
// Push(s,P); //先将根节点入栈
// while ( !StackEmpty(s))
// {
// Pop(s,P);
// if (P!=NULL)
// {
// printf("%c",P->data);//访问根节点
// Push(s,P->rchild);// 先进栈，后访问，所以这里先让右子树进栈
// Push(s,P->lchild);
// }
//
// }
// return OK;
//}
////非递归中序遍历二叉树
//Status InOrderTraverse(BiTree T)
//{
//// 中序遍历二叉树T的非递归算法，对每个数据元素调用函数Visit,也就是printf()函数
// SqStack S;
// InitStack(S);
// BiTree p;
// p = T;
//
// while(p || !StackEmpty(S))
// {
// if(p)
// {
// Push(S,p);
// p = p->lchild; //根指针进栈，遍历左子树
// }
// else
// { //根指针退栈，访问根结点，遍历右子树
// Pop(S,p);
// printf("%c",p->data);
// p = p->rchild;
// }
// }//while
//
// /*和上面的while开始的操作完全等同，可以视为方法二：
// Push(S,p);
// while (!StackEmpty(S))
// {
// while (GetTop(S,p) && p)
// {
// Push(S,p->lchild);
// }
// Pop(S,p);
// if (!StackEmpty(S))
// {
// Pop(S,p);
// printf("%c",p->data);
// Push(S,p->rchild);
// }
//
// }
// */
// return OK;
//} //InOrderTraverse
//
////非递归后序遍历二叉树 ：
//Status LastOrderTraverse(BiTree T)
//{
//// 后序遍历时，分别从左子树和右子树共两次返回根结点，
////只有从右子树返回时才访问根结点，所以增加一个栈标记到达结点的次序。
//SqStack s,tag;//定义两个栈，一个是存储二叉树结点的栈，一个是存储标志位的栈
//// stack2 tag ;
// BiTree f,m,n,P=T; //m，n是标志位。f是中间变量，用于检测标志位是m还是n的
//m=(BiTNode*)malloc(sizeof(BiTNode)); //注意：此处必须先创建结点，然后再赋值
// m->data=1;
// m->lchild=NULL;
// m->rchild=NULL;
// n=(BiTNode*)malloc(sizeof(BiTNode));//注意：此处必须先创建结点，然后再赋值
// n->data=2;
// n->lchild=NULL;
// n->rchild=NULL;
// InitStack(s);//此栈用来存放结点
// InitStack(tag);//此栈用来存放标志位，从左子树返回根节点时为1，从右子树返回根节点时为2
//
// while (P ||!StackEmpty(s))
// {
// if (P)
// {
// Push(s,P);
// Push(tag,m);//第一次入栈操作
// P=P->lchild;
// }
// else
// {
// Pop(s,P);
// Pop(tag,f);
// if (f==m)
// {
////  从左子树返回，二次入栈，然后p转右子树
// Push(s,P);
// Push( tag, n);//第二次入栈
// P=P->rchild;
// }
// else
// {
////  从右子树返回(二次出栈)，访问根结点，p转上层
// printf("%c",P->data);
// P=NULL; // 必须的，使下一步继续退栈
//
// }
//
// }
// }
//return OK;
//}
//
////初始化一个带头结点的队列
//Status InitQueue(LinkQueue &Q)
//{
// Q.front=(QNode*)malloc(sizeof(QNode));
// if (!Q.front)
// exit(OVERFLOW);
// Q.rear=Q.front;
// Q.front->next=NULL;
// return OK;
//}
////入队列
//Status EnQueue(LinkQueue &Q,BiTree e)
//{
// QueuePtr s=(QueuePtr)malloc(sizeof(QNode));
// if (!s)
// exit(OVERFLOW);
// s->Queuedata=e;
// s->next=NULL;
// Q.rear->next=s;
// Q.rear=s;
// return OK;
//}
////出队
//int DelQueue(LinkQueue &Q, BiTree &e)
//{
// char data1;
// QueuePtr s;
// s=Q.front->next;//注意：该队列为带头结点，所以刚开始出队列时，应该去front的next
// e=s->Queuedata;//获取对头记录的数据域，类型为BiTree
// data1=e->data;//获取BiTree类型的数据域，类型为char
// Q.front->next=s->next;
// if(Q.rear==s)//队列中只有一个元素
// Q.rear=Q.front;
// free(s);
//
// return TRUE;
//}
////队列的判断空操作
//Status QueueEmpty(LinkQueue Q)
//{
//// 队列带头结点，所以需要判断Q.front->next
// if (Q.front->next==NULL)
// return OK;
// else return ERROR;
//
//}
////按层次遍历
//Status HierarchyBiTree(BiTree bt)
//{
// LinkQueue Q; // 保存当前节点的左右孩子的队列
//
// InitQueue(Q); // 初始化队列
// BiTree p = bt; // 临时保存树根Root到指针p中
// if (bt == NULL) return ERROR; //树为空则返回
//
// EnQueue(Q,p); //先将根节点入队列
//
// while (!QueueEmpty(Q)) // 若队列不空，则层序遍历
// { DelQueue(Q, p); // 出队列
// printf("%C",p->data);// 访问当前节点
//
// if (p->lchild)
// EnQueue(Q, p->lchild); // 若存在左孩子，左孩子进队列
// if (p->rchild)
// EnQueue(Q, p->rchild); // 若存在右孩子，右孩子进队列
// }
//DelQueue(Q,p); // 释放队列空间
//return OK;
//}ts(BiTree bt)
//{
//
// if (bt!=NULL)
// {
// if (bt->lchild==NULL && bt->rchild==NULL)
// {
// printf("%4c",bt->data);
// sum++;
// }
// sum=SumLefts(bt->lchild);
// sum=SumLefts(bt->rchild);
// }
// return(sum);
//}
//int main()
//{ //注意创建二叉树时，用先序顺序创建
// printf("请输入先序建立二叉树所需要的数据(例如ABD0000)：");
// BiTree t;
// PreOrderCreateBiTree(t); //利用先序顺序创建二叉树
// printf("先序遍历输出为：");
// PreOrder(t);//先序递归遍历
// PreOrderTraverse(t);//先序非递归遍历
// printf("\n");
//
// printf("中序遍历输出为：");
// InOrderTraverse(t);//中序非递归遍历
// Inorder(t);//中序递归遍历
// printf("\n");
//
// printf("后序遍历输出为：");
// LastOrder(t);//后序递归遍历
// LastOrderTraverse(t);//后序非递归遍历
// printf("\n");
//printf("按层次遍历输出为：");
// HierarchyBiTree(t);//层次遍历，从上到下，从左到右
// printf("\n");
// printf("该二叉树中叶子节点个数为：");
// int leaves=SumLefts(t);
// printf("%d",leaves);
// printf("\n");
// return 0;
//}
//
////求叶子节点个数
//int sum=0;//此处一定要定义为全局变量，因为递归调用退出函数的时候局部变量会销毁
//int SumLefts(BiTree bt)
//{
//
// if (bt!=NULL)
// {
// if (bt->lchild==NULL && bt->rchild==NULL)
// {
// printf("%4c",bt->data);
// sum++;
// }
// sum=SumLefts(bt->lchild);
// sum=SumLefts(bt->rchild);
// }
// return(sum);
//}
//int main()
//{ //注意创建二叉树时，用先序顺序创建
// printf("请输入先序建立二叉树所需要的数据(例如ABD0000)：");
// BiTree t;
// PreOrderCreateBiTree(t); //利用先序顺序创建二叉树
// printf("先序遍历输出为：");
// PreOrder(t);//先序递归遍历
// PreOrderTraverse(t);//先序非递归遍历
// printf("\n");
//
// printf("中序遍历输出为：");
// InOrderTraverse(t);//中序非递归遍历
// Inorder(t);//中序递归遍历
// printf("\n");
//
// printf("后序遍历输出为：");
// LastOrder(t);//后序递归遍历
// LastOrderTraverse(t);//后序非递归遍历
// printf("\n");
//printf("按层次遍历输出为：");
// HierarchyBiTree(t);//层次遍历，从上到下，从左到右
// printf("\n");
// printf("该二叉树中叶子节点个数为：");
// int leaves=SumLefts(t);
// printf("%d",leaves);
// printf("\n");
// return 0;
//}







//后序有问题
//#include <stdio.h>
//#include <malloc.h>
//#include <stdlib.h>
//#include <queue>
//#include <stack>
//#include <iostream>
//using namespace std;
//typedef struct BiTNode{
//	char data;
//	BiTNode *lchild, *rchild;
//}BiTNode,*BiTree;
//
//void CreateBiTree(BiTree &T)//建树，按先序顺序输入节点
//{
//	char ch;
//	scanf("%c",&ch);
//	if(ch==' ')
//	{
//		T=NULL;
//		return;
//	}
//	else
//	{
//		T=(BiTree)malloc(sizeof(BiTNode));
//		if(!T)
//			exit(1);
//		T->data=ch;
//		CreateBiTree(T->lchild);
//		CreateBiTree(T->rchild);
//	}
//}
//void InOrderTraverse(BiTree T)//非递归中序遍历
//{
//
//	stack<BiTree> Stack;
//	if(!T)
//	{
//		printf("空树！\n");
//		return;
//	}
//
//	while(T || !Stack.empty())
//	{
//		while(T)
//		{
//			Stack.push(T);
//			T=T->lchild;
//		}
//		T=Stack.top();
//		Stack.pop();
//		printf("%c",T->data);
//		T=T->rchild;
//	}
//}
//
//
//
//void PreOrderTraverse(BiTree T)//非递归先序遍历
//{
//
//	stack<BiTree> Stack;
//	if(!T)
//	{
//		printf("空树！\n");
//		return;
//	}
//	while(T || !Stack.empty())
//	{
//		while(T)
//		{
//			Stack.push(T);
//			printf("%c",T->data);
//			T=T->lchild;
//		}
//		T=Stack.top();
//		Stack.pop();
//	         T=T->rchild;
//	}
//}
//
//
//void PostOrderTraverse(BiTree T)//非递归后序遍历,用一个标记标记右子树是否访问过
//{
//	int flag[20];
//	stack<BiTree> Stack;
//	if(!T)
//	{
//		printf("空树！\n");
//		return;
//	}
//	while(T)
//	{
//		Stack.push(T);
//		flag[Stack.size()]=0;
//		T=T->lchild;
//	}
//	while(!Stack.empty())
//	{
//		T=Stack.top();
//		while(T->rchild && flag[Stack.size()]==0)
//		{
//			flag[Stack.size()]=1;
//			T=T->rchild;
//			while(T)
//			{
//				Stack.push(T);
//				flag[Stack.size()]=0;
//			    T=T->lchild;
//			}
//		}
//		T=Stack.top();
//		printf("%c",T->data);
//    	Stack.pop();
//	}
//}
//int main()
//{
//
//	BiTree T;
//	CreateBiTree(T);
//	PreOrderTraverse(T);
//	printf("\n");
//         InOrderTraverse(T);
//	printf("\n");
//	PostOrderTraverse(T);
//	printf("\n");
//	return 0;
//}






//第一个版本，已经搞不定了
//#include<stdio.h>
//#include<stdlib.h>
//#define INITSIZE 100
//#define INCREASE 10
////栈
//typedef struct
//{
//    int *base;
//    int *top;
//    int stacksize;
//}SqStack;
////二叉树
//typedef struct BiTNode
//{
//    char data;
//    struct BiTNode *lchild,*rchild;
//}BiTNode,*BiTree;
//初始化栈
//int Initstack(SqStack *s)
//{
//    (*s).base=(BiTNode *)malloc(INITSIZE*sizeof(BiTNode));
//    if(!((*s).base))             //存储分配失败
//        exit(-2);
//    (*s).top=(*s).base;
//    (*s).stacksize=INITSIZE;
//    return 1;
//}
//递归建立二叉树
//int CreateBiTree(BiTree *T)
//{
//    char ch=getchar();
//    if(ch=='#')
//        T=NULL;
//    else
//    {
//        (*T)=(BiTNode *)malloc(sizeof(BiTNode));
//        (*T)->data=ch;
//        CreateBiTree(&((*T)->lchild));
//        CreateBiTree(&((*T)->rchild));
//    }
//    return 1;
//}
//递归建立二叉树
//int CreateBiTreeUn(BiTree *T)
//先序递归遍历
//void PreOrder(BiTree T)
//{
//    if(T)
//    {
//        printf("%2c",T->data);
//        PreOrder(T->lchild);
//        PreOrder(T->rchild);
//    }
//}
////中序递归遍历
//void InOrder(BiTree T)
//{
//    if(T)
//    {
//        InOrder(T->lchild);
//        printf("%2c",T->data);
//        InOrder(T->rchild);
//    }
//}
////后序递归遍历
//void PostOrder(BiTree T)
//{
//    if(T)
//    {
//        PostOrder(T->lchild);
//        PostOrder(T->rchild);
//        printf("%2c",T->data);
//    }
//}
//入栈
//int push(SqStack *s,BiTree T)
//{
//    if((*s).top-(*s).base>=(*s).stacksize)//栈满，追加储存空间
//    {
//        (*s).base=(BiTree *)malloc(((*s).stacksize+INCREASE)*sizeof(BiTree));
//        if((!(*s).base))             //存储分配失败
//            exit(-2);
//        (*s).top=(*s).base+(*s).stacksize;
//        (*s).stacksize+=INCREASE;
//    }
//    (*s).top=T;
//    (*s).top++;
//    return 1;
//}
////出栈
//BiTree pop(SqStack *s,BiTree T)
//{
//    if((*s).top==(*s).base)
//        return 0;
//    T=(*s).top;
//    (*s).top--;
//    return T;
//}
////栈是否为空，空返回1，否则返回0
//int stackempty(SqStack s)
//{
//    if(s.top==s.base)
//        return 1;
//    else
//        return 0;
//}
////先序非递归遍历
//void PreOrderUn(BiTree *T)//SqStack *s,
//{
//    SqStack s;
//    Initstack(&s);
//
//    while((*T)!=NULL || !stackempty(s))
//    {
//        while((*T)!=NULL)
//        {
//
//            push(&s,T);
//            printf("%2c",(*T)->data);getch();
//            (*T)=(*T)->lchild;
//        }
//        if (!stackempty(s))
//        {
//            (*T)=pop(&s,T);
//            (*T)=(*T)->rchild;
//        }
//    }


//    push(&s,T);
//    while(T!=NULL || !stackempty(s))
//    {
//        printf("%2c",T->data);
//        T=push(&s,T);
//        if(T->lchild)
//            push(&s,T);
//        if(T->rchild)
//            push(&s,T);
//    }



//    push(s,T);
//    BiTree Q=T;
//    while(!stackempty(s))
//    {
//        pop(s,T);
//        if(Q!=NULL)
//        {
//            printf("%c",Q->data);
//            push(s,Q->rchild);
//            push(s,Q->lchild);
//        }
//    }


//    while(T)
//    {
//        while(T)
//        {
//            push(s,T);
//            printf("%2c",T->data);
//            T=T->lchild;
//        }
//        T=pop(s,T);
//        T=T->rchild;
//    }


//    else
//        T=T->rchild;
//    T=pop(&s,T);
//    T=T->rchild;
//}
//中序非递归遍历
//void InOrderUn(BiTree T)//SqStack *s,
//{
//
//    SqStack s;
//    Initstack(&s);
//    while (T!=NULL || !stackempty(s))
//    {
//        while(T!=NULL)
//        {
//            push(&s,T);
//            T=T->lchild;
//        }
//    }
//    if(!stackempty(s))
//    {
//        T=pop(&s,T);
//        printf("%2c",T->data);
//        T=T->rchild;
//    }
//}




//    while(T)
//    {
//        while(T->lchild)
//        {
//            push(s,T);
//            T=T->lchild;
//        }
//
//        T=pop(s,T);
//        printf("%2c",T->data);
//        T=T->rchild;
//    }
//}
////后序非递归遍历
//void PostOrderUn(SqStack *s,BiTree T)
//{





//    while(T)
//    {
//        while(T->lchild)
//        {
//            push(s,T);
//        }
//        printf("%2c",T->data);
//        T=pop(s,T);
//        while(T->rchild)
//        {
//            push(&s,T);
//            T=T->rchild;
//        }
//    }
//}

//int main()
//{
//    BiTree T;
//    SqStack S;
//    Initstack(&S);
//    CreateBiTree(&T);
////    printf("先序递归遍历");
////    PreOrder(T);
////    printf("\n");
////    printf("中序递归遍历");
////    InOrder(T);
////    printf("\n");
////    printf("后序递归遍历");
////    PostOrder(T);
//    printf("\n");
//    printf("先序非递归遍历");
//    PreOrderUn(T);
//    printf("\n");
////    printf("中序非递归遍历");
////    InOrderUn(T);
//    printf("\n");
////    printf("后序非递归遍历");
////    PostOrderUn(&S,T);
//    printf("\n");
//    return 0;
//}








//后序输出有问题
//#include <stdio.h>
//#include <malloc.h>
//#include <stdlib.h>
//#define STACK_INT_SIZE 100 //存储空间初始分配量
//#define STACKINCREMENT 10 //存储空间分配增量
//#define OK 1
//#define ERROR 0
//#define TRUE 1
//#define FALSE 0
//#define OVERFLOW -2
//typedef char TElemType;
//typedef int Status;
//typedef char SElemType;
////二叉树的二叉链表存储表示
//typedef struct BiTNode
// {
// TElemType data;
// struct BiTNode *lchild, *rchild; //左右孩子指针
//}BiTNode, *BiTree;
////用于存储二叉树结点的栈
//typedef struct
// {
// BiTree *base;
// BiTree *top;
// int stacksize; //当前已分配的存储空间
//}SqStack;
////定义链式队列结点
//typedef struct QNode
//{
// BiTree Queuedata;
// struct QNode * next;
//}QNode,* QueuePtr;
////定义链式队列
//typedef struct
//{
// QueuePtr front; //
// QueuePtr rear;
//}LinkQueue;
////创建存储二叉树结点的空栈
//Status InitStack(SqStack &S)
//{
// S.base = (BiTree *) malloc(sizeof(BiTree));
// if(!S.base) exit(OVERFLOW);
// S.top = S.base;
// S.stacksize = STACK_INT_SIZE;
// return OK;
//}
////存储二叉树结点的栈的取栈顶元素
//Status GetTop(SqStack &S, BiTree &e)
// {
// //若栈不空，则用e返回S的栈顶元素
// if(S.top == S.base) return ERROR;
// e = *(S.top-1);
// return OK;
//}
////存储二叉树结点的栈的入栈操作
//Status Push(SqStack &S, BiTree e)
//{
// //插入元素e为栈顶元素
// if(S.top - S.base >= S.stacksize)
// { //若栈满，则追加存储空间
// S.base = (BiTree *) realloc(S.base, (S.stacksize + STACKINCREMENT)*sizeof(BiTree));
// if(!S.base) return ERROR;
// S.top = S.base + S.stacksize;
// S.stacksize += STACKINCREMENT;
// }
// *S.top = e;
// S.top++;
// return OK;
//}
//
////用于存储二叉树结点的栈出栈操作
//Status Pop(SqStack &S,BiTree &e)
//{
// //删除S的栈顶元素，并用e返回
// if(S.base == S.top) return ERROR;
// S.top--;
// e = *S.top;
// return OK;
//}
//
////判断存储二叉树结点的栈是否为空
// Status StackEmpty(SqStack S)
// {
// // 若栈S为空栈，则返回TRUE，否则返回FALSE
// if(S.top == S.base) return TRUE;
// else return FALSE;
// }
////先序顺序创建一颗二叉树
//Status PreOrderCreateBiTree(BiTree &T)
// {
// //按先序次序输入二叉树中结点的值
// //构造二叉链表表示的二叉树T
// char ch;
// scanf("%c",&ch);
// if(ch == '0') T = NULL;
// else
// {
// //if(!(T = (BiTree ) malloc(sizeof(BiTree)))) exit(OVERFLOW);//作用和下一语句的作用相同，注意两者的区别
// if(!(T = (BiTNode* ) malloc(sizeof(BiTNode)))) exit(OVERFLOW);
// T->data = ch; //生成根结点
// PreOrderCreateBiTree(T->lchild); //构造左子树
// PreOrderCreateBiTree(T->rchild); //构造右子树
// }
// return OK;
//} //CreateBiTree
////递归先序遍历二叉树
//void PreOrder ( BiTree bt )
//{
// if ( bt )
// {
// printf("%c",bt->data); //先访问根节点
// PreOrder ( bt->lchild );//遍历左子树
// PreOrder ( bt->rchild ); //遍历右子树
// }
//}
////递归中序遍历二叉树
//void Inorder ( BiTree bt )
//{
// if ( bt )
// {
// Inorder ( bt->lchild ); //遍历左子树
// printf("%c",bt->data);//访问根节点
// Inorder ( bt->rchild );//遍历右子树
// }
//}
////递归后序遍历二叉树
//void LastOrder ( BiTree bt )
//{
// if ( bt )
// {
// LastOrder( bt->lchild );//遍历左子树
// LastOrder( bt->rchild );//遍历右子树
// printf("%c",bt->data);//访问根节点
// }
//}
////非递归先序遍历二叉树 方法一：
//Status PreOrderTraverse(BiTree T)
//{
// SqStack s;
// BiTree P=T;
// InitStack(s);
// while ( P!=NULL || !StackEmpty(s))
// {
// if (P!=NULL)
// {
// printf("%c",P->data);
// Push(s,P); //访问完之后将根节点入栈
// P=P->lchild;
// }
//
// else
// {
// Pop(s,P);
// P=P->rchild;
// }
//}
// return OK;
//}
////非递归先序遍历二叉树 方法二：
//Status PreOrderTraverse2(BiTree T)
//{
// SqStack s;
// BiTree P=T;
// InitStack(s);
// Push(s,P); //先将根节点入栈
// while ( !StackEmpty(s))
// {
// Pop(s,P);
// if (P!=NULL)
// {
// printf("%c",P->data);//访问根节点
// Push(s,P->rchild);// 先进栈，后访问，所以这里先让右子树进栈
// Push(s,P->lchild);
// }
//
// }
// return OK;
//}
////非递归中序遍历二叉树
//Status InOrderTraverse(BiTree T)
//{
// //中序遍历二叉树T的非递归算法，对每个数据元素调用函数Visit,也就是printf()函数
// SqStack S;
// InitStack(S);
// BiTree p;
// p = T;
// /**/
// while(p || !StackEmpty(S))
// {
// if(p)
// {
// Push(S,p);
// p = p->lchild; //根指针进栈，遍历左子树
// }
// else
// { //根指针退栈，访问根结点，遍历右子树
// Pop(S,p);
// printf("%c",p->data);
// p = p->rchild;
// }
// }//while
//
// /*和上面的while开始的操作完全等同，可以视为方法二：
// Push(S,p);
// while (!StackEmpty(S))
// {
// while (GetTop(S,p) && p)
// {
// Push(S,p->lchild);
// }
// Pop(S,p);
// if (!StackEmpty(S))
// {
// Pop(S,p);
// printf("%c",p->data);
// Push(S,p->rchild);
// }
//
// }
// */
// return OK;
//} //InOrderTraverse
///**/
////非递归后序遍历二叉树 ：
//Status LastOrderTraverse(BiTree T)
//{
// //后序遍历时，分别从左子树和右子树共两次返回根结点，
// //只有从右子树返回时才访问根结点，所以增加一个栈标记到达结点的次序。
//SqStack s,tag;//定义两个栈，一个是存储二叉树结点的栈，一个是存储标志位的栈
// //stack2 tag ;
// BiTree f,m,n,P=T; //m，n是标志位。f是中间变量，用于检测标志位是m还是n的
//m=(BiTNode*)malloc(sizeof(BiTNode)); //注意：此处必须先创建结点，然后再赋值
// m->data=1;
// m->lchild=NULL;
// m->rchild=NULL;
// n=(BiTNode*)malloc(sizeof(BiTNode));//注意：此处必须先创建结点，然后再赋值
// n->data=2;
// n->lchild=NULL;
// n->rchild=NULL;
// InitStack(s);//此栈用来存放结点
// InitStack(tag);//此栈用来存放标志位，从左子树返回根节点时为1，从右子树返回根节点时为2
//
// while (P ||!StackEmpty(s))
// {
// if (P)
// {
// Push(s,P);
// Push(tag,m);//第一次入栈操作
// P=P->lchild;
// }
// else
// {
// Pop(s,P);
// Pop(tag,f);
// if (f==m)
// {
// // 从左子树返回，二次入栈，然后p转右子树
// Push(s,P);
// Push( tag, n);//第二次入栈
// P=P->rchild;
// }
// else
// {
// // 从右子树返回(二次出栈)，访问根结点，p转上层
// printf("%c",P->data);
// P=NULL; // 必须的，使下一步继续退栈
//
// }
//
// }
// }
//return OK;
//}
//
////初始化一个带头结点的队列
//Status InitQueue(LinkQueue &Q)
//{
// Q.front=(QNode*)malloc(sizeof(QNode));
// if (!Q.front)
// exit(OVERFLOW);
// Q.rear=Q.front;
// Q.front->next=NULL;
// return OK;
//}
////入队列
//Status EnQueue(LinkQueue &Q,BiTree e)
//{
// QueuePtr s=(QueuePtr)malloc(sizeof(QNode));
// if (!s)
// exit(OVERFLOW);
// s->Queuedata=e;
// s->next=NULL;
// Q.rear->next=s;
// Q.rear=s;
// return OK;
//}
////出队
//int DelQueue(LinkQueue &Q, BiTree &e)
//{
// char data1;
// QueuePtr s;
// s=Q.front->next;//注意：该队列为带头结点，所以刚开始出队列时，应该去front的next
// e=s->Queuedata;//获取对头记录的数据域，类型为BiTree
// data1=e->data;//获取BiTree类型的数据域，类型为char
// Q.front->next=s->next;
// if(Q.rear==s)//队列中只有一个元素
// Q.rear=Q.front;
// free(s);
//
// return TRUE;
//}
////队列的判断空操作
//Status QueueEmpty(LinkQueue Q)
//{
// //队列带头结点，所以需要判断Q.front->next
// if (Q.front->next==NULL)
// return OK;
// else return ERROR;
//
//}
////按层次遍历
//Status HierarchyBiTree(BiTree bt)
//{
// LinkQueue Q; // 保存当前节点的左右孩子的队列
//
// InitQueue(Q); // 初始化队列
// BiTree p = bt; // 临时保存树根Root到指针p中
// if (bt == NULL) return ERROR; //树为空则返回
//
// EnQueue(Q,p); //先将根节点入队列
//
// while (!QueueEmpty(Q)) // 若队列不空，则层序遍历
// { DelQueue(Q, p); // 出队列
// printf("%C",p->data);// 访问当前节点
//
// if (p->lchild)
// EnQueue(Q, p->lchild); // 若存在左孩子，左孩子进队列
// if (p->rchild)
// EnQueue(Q, p->rchild); // 若存在右孩子，右孩子进队列
// }
////DelQueue(Q,p); // 释放队列空间
//return OK;
//}
////求叶子节点个数
//int sum=0;//此处一定要定义为全局变量，因为递归调用退出函数的时候局部变量会销毁
//int SumLefts(BiTree bt)
//{
//
// if (bt!=NULL)
// {
// if (bt->lchild==NULL && bt->rchild==NULL)
// {
// //printf("%4c",bt->data);
// sum++;
// }
// sum=SumLefts(bt->lchild);
// sum=SumLefts(bt->rchild);
// }
// return(sum);
//}
//int main()
//{ //注意创建二叉树时，用先序顺序创建
// printf("请输入先序建立二叉树所需要的数据(例如ABD0000)：");
// BiTree t;
// PreOrderCreateBiTree(t); //利用先序顺序创建二叉树
// printf("先序遍历输出为：");
// //PreOrder(t);//先序递归遍历
// PreOrderTraverse(t);//先序非递归遍历
// printf("\n");
//
// printf("中序遍历输出为：");
// //InOrderTraverse(t);//中序非递归遍历
// Inorder(t);//中序递归遍历
// printf("\n");
//
// printf("后序遍历输出为：");
// //LastOrder(t);//后序递归遍历
// LastOrderTraverse(t);//后序非递归遍历
// printf("\n");
//printf("按层次遍历输出为：");
// HierarchyBiTree(t);//层次遍历，从上到下，从左到右
// printf("\n");
// printf("该二叉树中叶子节点个数为：");
// int leaves=SumLefts(t);
// printf("%d",leaves);
// printf("\n");
// return 0;
//}
