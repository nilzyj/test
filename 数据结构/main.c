#include<stdio.h>
#include<stdlib.h>
#define INITSIZE 100
#define INCREASE 10
//栈
typedef struct
{
    int *base;
    int *top;
    int stacksize;
}SqStack;
//二叉树
typedef struct BiTNode
{
    char data;
    struct BiTNode *lchild,*rchild;
}BiTNode,*BiTree;
//初始化栈
int Initstack(SqStack *s)
{
    (*s).base=(int *)malloc(INITSIZE*sizeof(int));
    if(!((*s).base))             //存储分配失败
        exit(-2);
    (*s).top=(*s).base;
    (*s).stacksize=INITSIZE;
    return 1;
}
//递归建立二叉树
int CreateBiTree(BiTree *T)
{
    char ch=getchar();
    if(ch=='#')
        (*T)=NULL;
    else
    {
        (*T)=(BiTNode *)malloc(sizeof(BiTNode));
        (*T)->data=ch;
        CreateBiTree(&((*T)->lchild));
        CreateBiTree(&((*T)->rchild));
    }
    return 1;
}
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
int push(SqStack *s,BiTree T)
{
    if((*s).top-(*s).base>=(*s).stacksize)//栈满，追加储存空间
    {
        (*s).base=(BiTree *)malloc(((*s).stacksize+INCREASE)*sizeof(BiTree));
        if((!(*s).base))             //存储分配失败
            exit(-2);
        (*s).top=(*s).base+(*s).stacksize;
        (*s).stacksize+=INCREASE;
    }
    (*s).top=T;
    (*s).top++;
    return 1;
}
//出栈
int pop(SqStack *s,BiTree T)
{
    if((*s).top==(*s).base)
        return 0;
    T=(*s).top;
    (*s).top--;
    return T;
}
//栈是否为空，空返回1，否则返回0
int stackempty(SqStack s)
{
    if(s.top==s.base)
        return 1;
    else
        return 0;
}
//先序非递归遍历
void PreOrderUn(BiTree T)//SqStack *s,
{
    SqStack s;
    Initstack(&s);

    while(T!=NULL || !stackempty(s))
    {
        while(T!=NULL)
        {

            push(&s,T);
            printf("%2c",T->data);
            T=T->lchild;
        }
        if (!stackempty(s))
        {
            T=pop(&s,T);
            T=T->rchild;
        }
    }


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
}
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

int main()
{
    BiTree T;
    SqStack S;
    Initstack(&S);
    CreateBiTree(&T);
//    printf("先序递归遍历");
//    PreOrder(T);
//    printf("\n");
//    printf("中序递归遍历");
//    InOrder(T);
//    printf("\n");
//    printf("后序递归遍历");
//    PostOrder(T);
    printf("\n");
    printf("先序非递归遍历");
    PreOrderUn(T);
    printf("\n");
//    printf("中序非递归遍历");
//    InOrderUn(T);
    printf("\n");
//    printf("后序非递归遍历");
//    PostOrderUn(&S,T);
    printf("\n");
    return 0;
}


//*******************************************************
//哈夫曼树与哈夫曼编码
#include<stdio.h>
#define N 10
#define M 2*N-1
typedef struct
{
    unsigned int weight;
    unsigned int parent,lchild,rchild;
}HTNode;
typedef struct
{
    char data;
    int weight;
    char code[N];
}HTCode;
void Init(HTCode hc[],int *n)
{
    int i;
    printf("\ninput n=");
    scanf("%d",&(*n));
    printf("\ninput %d character\n",*n);
    for(i=1;i<*n;i++)
        hc[i].data=getchar();
    printf("\ninput %d weight\n",*n);
    for(i=1;i<=*n;i++)
        scanf("%d",&(hc[i].weight));
}
void Select(HTNode ht[],int k,int *s1,int *s2)
{
    int i;
    for(i=1;i<=k && ht[i].parent!=0;i++)
        *s1=i;
    for(i=1;i<=k;i++)
        if(ht[i].parent==0 && ht[i].weight<ht[*s1].weight)
            *s1=i;
    for(i=1;i<=k;i++)
        if(ht[i].parent==0 && i!=*s1)
            break;
    *s2=i;
    for(i=1;i<=k;i++)
        if(ht[i].parent==0 && i!=*s1 && ht[i].weight<ht[*s2].weight)
            *s2=i;
}
void HuffmanCoding(HTNode ht[],HTCode hc[],int n)
{
    char cd[N];
    int i,j,m,c,f,s1,s2,start;
    m=2*n-1;
    for(i=1;i<=m;i++)
    {
        if(i<=n)
            ht[i].weight=hc[i].weight;
        else
            ht[i].weight=0;
        ht[i].parent=ht[i].lchild=ht[i].rchild=0;
    }
    for(i=n+1;i<=m;i++)
    {
        Select(ht,i-1,&s1,&s2);
        ht[s1].parent=i;
        ht[s2].parent=i;
        ht[i].lchild=s1;
        ht[i].rchild=s2;
        ht[i].weight=ht[s1].weight+ht[s2].weight;
    }
    cd[n-1]='\0';
    for(i=1;i<=n;i++)
    {
        start=n-1;
        for(c=i,f=ht[i].parent;f;c=f,f=ht[f].parent)
            if(ht[f].lchild==c)
                cd[--start]='\0';
            else
                cd[--start]='1';
        strcpy(hc[i].code,&cd[start]);
    }
}
int main()
{
    int i,m,n,w[N+1];
    HTNode ht[N+1];
    HTCode hc[N+1];
    Init(hc,&n);
    HuffmanCoding(ht,hc,n);
    for(i=1;i<=n;i++)
        printf("\n%c --- %s",hc[i].data,hc[i].code);
    return 0;
}

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
