//操作系统作业调度模拟
//#include<stdio.h>
//#include<time.h>
//#include<conio.h>
//
typedef struct QNode
{
    int  data;
    struct QNode *next;
}QNode,*QueuePtr;

typedef struct
{
    QueuePtr front;
    QueuePtr rear;
}LinkQueue;

int InitQueue(LinkQueue *Q)
{
    (*Q).front=(*Q).rear=(QueuePtr)malloc(sizeof(QNode));
    if(!(*Q).front)
        exit(-2);
    (*Q).front->next=NULL;
    return 1;
}

int InQueue(LinkQueue *Q,int e)
{
    QueuePtr p;
    p=(QueuePtr)malloc(sizeof(QNode));
    if(!p)
        exit(-2);
    p->data=e;
    p->next==NULL;
    (*Q).rear->next=p;
    (*Q).rear=p;
    return 1;
}



int DeQueue(LinkQueue *Q,int e)
{
    QueuePtr p;
    if((*Q).front==(*Q).rear)
        return 0;
    p=(*Q).front->next;
    e=p->data;
    (*Q).front->next=p->next;
    if((*Q).rear==p)
        (*Q).rear=(*Q).front;
    free(p);
    return 1;
}

int data(LinkQueue *Q)
{
    int a;
    QueuePtr p=(*Q).front->next;
    a=p->data;
    return a;
}

void sub(LinkQueue *Q)
{
    QueuePtr p=(*Q).front->next;
    p->data-=1000;
}

int Empty(LinkQueue *Q)
{
    if((*Q).front==(*Q).rear)
    {
        printf("任务已全部完成！\n");
        return 1;
    }
    else
        return 0;
}

int main()
{
    LinkQueue Q;

    InitQueue(&Q);
    clock_t t1,t2;
    int m,n,i=1;
    int s=0;//总时间
    int max=0;
    printf("输入作业数量及作业占用cpu时间：");
    scanf("%d",&m);
    while(m>0)
    {
        scanf("%d",&n);
        s+=n;
        if(max<n)
            max=n;
        InQueue(&Q,n);
        --m;
    }
    while(1)
    {
        if(data(&Q)>1000)
        {
            t1=clock();
            while(1)
            {
                t2=clock();
                if(t2-t1>1000)
                {
                    sub(&Q);
                    InQueue(&Q,(data(&Q)));
                    DeQueue(&Q,(data(&Q)));
                    break;
                }
            }
        }
        else
        {
            t1=clock();
            while(1)
            {
                t2=clock();
                if(t2-t1>data(&Q))
                {
                    DeQueue(&Q,data(&Q));
                    printf("已完成%d个任务\n",i);
                    ++i;
                    break;
                }
            }
        }
        if(1==Empty(&Q))
            break;
    }
    printf("总作业时间为：%d，占用cpu最长时间为：%d",s,max);
    return 0;
}

//    int a[100][2];
//    for(i=0;i<100;++i)
//    {
//        a[i][0]=0;
//        a[i][1]=0;//未输入
//        a[i][2]=0;
//    }
//    InitQueue(&Q);
//    printf("输入作业数量及作业占用cpu时间：");
//    scanf("%d",&m);
//    i=0;
//    while(m>0)
//        {
//            scanf("%d",&n);
//            s+=n;
//            InQueue(&Q,&n);
//            a[i][0]=n;
//            a[i][1]=1;
//            --m;
//            ++i;
//        }
//    i=0;
//    while(1)
//    {
//    if(1==a[i][1])
//    {
//        t1=clock();
//        if(a[i][0]>1000)
//        {
//            while(t2-t1>1000)
//            {
//                InQueue(&Q,&((Q).front->data));
//                DeQueue(&Q,&((Q).front->data));
//            }
//            a[i][0]-=1000;
//        }
//        else
//        {
//            t1=clock();
//            while(a[i][0]==t2-t1)
//                DeQueue(&Q,&((Q).front->data));
//            a[i][1]=0;
//            a[i][2]=2;
//        }
//        for(j=0;j<100;++j)
//            {
//                if(2==a[j][2])
//                    printf("第%d个任务已完成",j+1);
//                a[i][2]=0;
//            }
//        ++i;
//        for(j=0;j<100;++j)
//
//    }
//    else
//        ++i;
//    }
//    printf("总作业时间为：%d",s);
//    return 0;
//}

//**********************************************************************
//排队问题test
//#include<stdio.h>
//#include<stdlib.h>
//#define OVERFLOW -2
//typedef struct
//{
//    int arrive;
//    int treat;
//}QNODE;
//typedef struct node
//{
//    QNODE data;
//    struct node *next;
//}LNODE;
//LNODE *front,*rear;
//QNODE curr,temp;
//char Fname[120];
//FILE *fp=NULL;
//void EnQueue(LNODE **hpt,LNODE **tpt,QNODE e)
//{
//    LNODE *p=(LNODE *)malloc(sizeof(LNODE));
//    if(!p)
//        exit(OVERFLOW);
//    p->data=e;
//    p->next=NULL;
//    if(*hpt==NULL)
//        *tpt=*hpt=p;
//    else
//        *tpt=(*tpt)->next=p;
//}
//int DeQueue(LNODE **hpt,LNODE **tpt,QNODE *cp)
//{
//    LNODE *p=*hpt;
//    if(*hpt==NULL)
//        return 1;
//    *cp=(*hpt)->data;
//    *hpt=(*hpt)->next;
//    if(*hpt==NULL)
//        *tpt=NULL;
//    free(p);
//    return 0;
//}
//int main()
//{
//    int dwait=0,clock=0,wait=0,count=0,have=0,finish;
//    printf("\n enter file name:");
//    scanf("%s",&Fname);
//    if((fp=fopen(Fname,"r"))==NULL)
//    {
//        printf("cannot open file %s",Fname);
//        return;
//    }
//    front=NULL;
//    rear=NULL;
//    have=fscanf(fp,"%d%s",&temp.arrive,&temp.treat);
//    do
//    {
//        if(front==NULL && have==2)
//        {
//            dwait+=(temp.arrive-clock);
//            clock=temp.arrive;
//            EnQueue(&front,&rear,temp);
//            have=fscanf(fp,"%d%d",&temp.arrive,&temp.treat);
//        }
//        count++;
//        DeQueue(&front,&rear,&curr);
//        wait+=clock-curr.arrive;
//        finish=clock+curr.treat;
//        while(have==2 && temp.arrive<=finish)
//        {
//            EnQueue(&front,&rear,temp);
//            have=fscanf(fp,"%d%d",&temp.arrive,&temp.treat);
//        }
//        clock=finish;
//    }
//    while(have==2 || front!=NULL);
//    printf("结果：业务员等待时间%d\n客户平均等待时间%f\n",dwait,(double)wait/count);
//    printf("模拟总时间：%d,\n客户人数：%d,\n总等待时间：%d\n",clock,count,wait);
//    getch();
//    return 0;
//}

//**********************************************************************************
//判断表达式正误
//#include<stdio.h>
//#define INITSIZE 100
//#define INCREASE 10
//typedef struct
//{
//    int *base;
//    int *top;
//    int stacksize;
//}SqStack;
//
//int Initstack(SqStack *s)
//{
//    (*s).base=(int *)malloc(INITSIZE*sizeof(int));
//    if(!((*s).base))             //存储分配失败
//        exit(-2);
//    (*s).top=(*s).base;
//    (*s).stacksize=INITSIZE;
//    return 1;
//}
//
//int push(SqStack *s,char e)
//{
//    if((*s).top-(*s).base>=(*s).stacksize)//栈满，追加储存空间
//    {
//        (*s).base=(int *)malloc(((*s).stacksize+INCREASE)*sizeof(int));
//        if((!(*s).base))             //存储分配失败
//            exit(-2);
//        (*s).top=(*s).base+(*s).stacksize;
//        (*s).stacksize+=INCREASE;
//    }
//    (*s).top=e;
//    (*s).top++;
//    return 1;
//}
//
//int pop(SqStack *s,char e)
//{
//    if((*s).top==(*s).base)
//        return 0;
//    e=(*s).top;
//    (*s).top--;
//    return 1;
//}
//
//int stackempty(SqStack *s)
//{
//    if((*s).base==(*s).top)
//        return -1;
//    else
//        return 0;
//}
//
//void correct(SqStack *s)
//{
//    char c;
//    int flag=0;
//    printf("输入表达式：");
//    while((c=getchar())!='\n')
//    {
//        if(c<40 || (c>43 && c<48) || c>57 && (c!=45 && c!= 47))// && flag!=1)
//        {
//            printf("表达式错误！");
//            return;//flag=1;
//        }
//        if(c==40)//左括号入栈
//            push(s,c);
//        if(c==41 && (*s).top==40)//为右括号，左括号出栈，标志有左括号
//        {
//            pop(s,40);
//            flag++;
//        }
//
//        if(c==41 && (*s).top!=40 && flag!=1)//无左括号，但有右括号，错误
//        {
//            //if(flag!=1)
//            //{
//                printf("表达式错误！");return;
//              //  flag=1;
//            //}
//        }
//    }
//    if((*s).top==40)// && flag!=1)
//        printf("表达式错误！\n");
//    else if(stackempty(&s)==-1)
//        printf("表达式正确！\n");
//}
//
//int main()
//{
//    SqStack s;
//    Initstack(&s);
//    correct(&s);
//    return 0;
//}


//**********************************************************
//计算表达式test
//#include<stdio.h>
//#define add 43
//#define subs 45
//#define mult 42
//#define div 47
//#define MAXSIZE 100
//typedef struct
//{
//    int stkdata[MAXSIZE];
//    int top;
//}STKzone;
//typedef STKzone *STK;
//typedef enum{ture=1,false=0} bool;
//typedef enum{ok,error} status;
//STKzone expSTKzone;
//STK expSTK;
//STK initSTK(STKzone *stack_zone)//执行栈初始化，建栈指针
//{
//    STK p;
//    p=stack_zone;
//    p->top=0;
//}
//status push(int *term,STK pstk)
//{
//    if(pstk->top==MAXSIZE)
//        return error;
//    pstk->stkdata[pstk->top]=*term;
//    (pstk->top)++;
//    return ok;
//}
//bool emptySTK(STK pstk)
//{
//    return (pstk->top==0);
//}
//status pop(int *pdata,STK pstk)
//{
//    if(emptySTK(pstk))
//        return error;
//    (pstk->top)--;
//    *pdata=pstk->stkdata[pstk->top];
//    return ok;
//}
//void synerror()
//{
//    printf("\n表达式语法错！");
//    exit(-1);
//}
//int eval(char tag,int a1,int a2)
//{
//    switch(tag)
//    {
//        case add:return(a1+a2);
//        case subs:return(a1-a2);
//        case mult:return(a1*a2);
//        case div:return(a1/a2);
//    }
//}
//int main()
//{
//    char c;
//    int opd1,opd2,temp,c1;
//    expSTK=initSTK(&expSTKzone);
//    printf("\n后置表达式：");
//    while((c=getchar())!='\n')
//    {
//        if(c==' ')
//            continue;
//        if((c>47)&&(c<58))
//        {
//            putchar(c);
//            c1=c-48;
//            if(push(&c1,expSTK)==error)
//            {
//                printf("\n表达式太长\n");
//                exit(-13);
//            }
//            else if((c==add)||(c==subs)||(c==mult)||(c==div))
//            {
//                putchar(c);
//                if(pop(&opd1,expSTK)==error)
//                    synerror();
//                temp=eval(c,opd2,opd1);
//                push(&temp,expSTK);
//            }
//            else
//                synerror();
//        }
//        if(pop(&opd1,expSTK)==error)
//            synerror();
//        if(!(emptySTK(expSTK)))
//            synerror();
//        printf("=%-3d\n",opd1);
//    }
//    return 0;
//}


//******************************************************************
//循环队列test
//#include <stdio.h>
//#include <stdlib.h>
//
//#define OK 1
//#define TRUE 1
//#define FALSE 0
//#define ERROR 0
//#define OVERFLOW -2
//#define MaxQsize 100
//typedef struct
//{
//    int *base;
//    int front;
//    int rear;
//}SqQueue;
//
//int InitQueue(SqQueue *Q)
//{
//    (*Q).base=(int *)malloc(MaxQsize*sizeof(int));
//    if(!(*Q).base)
//        return OVERFLOW;
//    (*Q).front=(*Q).rear=0;
//    return OK;
//}
//
//int QueueEmpty(SqQueue Q)
//{
//    if(Q.front==Q.rear)
//        return TRUE;
//    else
//        return FALSE;
//}
//
//int QueueLength(SqQueue Q)
//{
//    return (Q.rear-Q.front+MaxQsize)%MaxQsize;
//}
//
//int GetHead(SqQueue Q,int *e)
//{
//    if(Q.front==Q.rear)
//        return ERROR;
//    *e=Q.base[Q.front];
//    return OK;
//}
//
//int EnQueue(SqQueue *Q,int e)
//{
//    if(((*Q).rear+1)%MaxQsize==(*Q).front)
//        return ERROR;
//    (*Q).base[(*Q).rear]=e;
//    (*Q).rear=((*Q).rear+1)%MaxQsize;
//    return OK;
//}
//
//int DeQueue(SqQueue *Q,int *e)
//{
//    if((*Q).rear==(*Q).front)
//        return ERROR;
//    *e=(*Q).base[(*Q).front];
//    (*Q).front=((*Q).front+1)%MaxQsize;
//    return OK;
//}
//
//int main()
//{
//    SqQueue Q;
//    int select;
//    int e;
//    if(InitQueue(&Q)==OVERFLOW)
//        printf("分配失败，即将退出程序！");
//    else
//        do
//        {
//            printf("1：判断队列是否为空\n");
//            printf("2：测试队列的长度\n");
//            printf("3：取队头元素值\n");
//            printf("4：向队列中插入一新元素\n");
//            printf("5：删除队列中一元素\n");
//            printf("0：结束\n");
//            scanf("%d",&select);
//            switch(select)
//            {
//                case 1:if(QueueEmpty(Q)==TRUE)
//                            printf("队列为空\n");
//                        else
//                            printf("队列不为空\n");
//                        break;
//                case 2:printf("队列长度为：%d\n",QueueLength(Q));
//                        break;
//                case 3:if(GetHead(Q,&e)==ERROR)
//                            printf("队列为空\n");
//                        else
//                            printf("队首元素为：%d\n",e);
//                        break;
//                case 4:scanf("%d",&e);
//                        if(EnQueue(&Q,e)==ERROR)
//                            printf("队列满\n");
//                        else
//                            printf("元素成功插入\n");
//                        break;
//                case 5:if(DeQueue(&Q,&e)==ERROR)
//                        printf("队列空，无数据可删\n");
//                        else
//                            printf("删除元素为：%d\n",e);
//                        break;
//                case 0:printf("操作结束\n");
//                        break;
//                default:printf("输入选择错误\n");
//            }
//        }
//        while(select);
//    return 0;
//}


//***********************************************************************
//模拟服务台前的排队现象问题
//#include<stdio.h>
//#include<stdlib.h>
//#define OVERFLOW -2
//typedef struct
//{
//    int arrive;
//    int treat;
//}QNODE;
//typedef struct node
//{
//    QNODE data;
//    struct node *next;
//}LNODE;
//LNODE *front,*rear;
//QNODE curr,temp;
//char Fname[120];
//FILE *fp;
//void EnQueue(LNODE **hpt,LNODE **tpt,QNODE e)
//{
//    LNODE *p=(LNODE *)malloc(sizeof(LNODE));
//    if(!p)
//        exit(OVERFLOW);
//    p->data=e;
//    p->next=NULL;
//    if(*hpt==NULL)
//        *tpt=*hpt=p;
//    else
//        *tpt=(*tpt)->next=p;
//}
//int DeQueue(LNODE **hpt,LNODE **tpt,QNODE *cp)
//{
//    LNODE *p=*hpt;
//    if(*hpt==NULL)
//        return 1;
//    *cp=(*hpt)->data;
//    *hpt=(*hpt)->next;
//    if(*hpt==NULL)
//        *tpt=NULL;
//    free(p);
//    return 0;
//}
//int main()
//{
//    int dwait=0,clock=0,wait=0,count=0,have=0,finish;
//    printf("\n enter file name:");
//    scanf("%s",&Fname);
//    if((fp=fopen(Fname,"r"))==NULL)
//    {
//        printf("cannot open file %s",Fname);
//        return;
//    }
//    front=NULL;
//    rear=NULL;
//    have=fscanf(fp,"%d%s",&temp.arrive,&temp.treat);
//    do
//    {
//        if(front==NULL && have==2)
//        {
//            dwait+=temp.arrive-clock;
//            clock=temp.arrive;
//            EnQueue(&front,&rear,temp);
//            have=fscanf(fp,"%d%d",&temp.arrive,&temp.treat);
//            count++;
//            DeQueue(&front,&rear,&curr);
//            wait+=clock-curr.arrive;
//            finish=clock+curr.treat;
//            while(have==2 && temp.arrive<=finish)
//            {
//                EnQueue(&front,&rear,temp);
//                have=fscanf(fp,"%d%d",&temp.arrive,&temp.treat);
//            }
//            clock=finish;
//        }
//    }
//    while(have==2 || front!=NULL);
//    printf("结果：业务员等待时间%d\n客户平均等待时间%f\n",dwait,(double)wait/count);
//    printf("模拟总时间：%d,\n客户人数：%d,\n总等待时间：%d\n",clock,count,wait);
//    getch();
//    return 0;
//}




//*****************************************************************
//计算表达式的值
//#include<stdio.h>
//#define add 43
//#define subs 45
//#define mult 42
//#define div 47
//#define MAXSIZE 100
//typedef struct
//{
//    int stkdata[MAXSIZE];
//    int top;
//}STKzone;
//typedef STKzone *STK;
//typedef enum{ture=1,false=0} bool;
//typedef enum{ok,error} status;
//STKzone expSTKzone;
//STK expSTK;
//STK initSTK(STKzone *stack_zone)
//{
//    STK p;
//    p=stack_zone;
//    p->top=0;
//}
//status push(int *term,STK pstk)
//{
//    if(pstk->top==MAXSIZE)
//        return error;
//    pstk->stkdata[pstk->top]=*term;
//    (pstk->top)++;
//    return ok;
//}
//bool emptySTK(STK pstk)
//{
//    return (pstk->top==0);
//}
//status pop(int *pdata,STK pstk)
//{
//    if(emptySTK(pstk))
//        return error;
//    (pstk->top)--;
//    *pdata=pstk->stkdata[pstk->top];
//    return ok;
//}
//void synerror()
//{
//    printf("\n表达式语法错！");
//    exit(-1);
//}
//int eval(char tag,int a1,int a2)
//{
//    switch(tag)
//    {
//        case add:return(a1+a2);
//        case subs:return(a1-a2);
//        case mult:return(a1*a2);
//        case div:return(a1/a2);
//    }
//}
//int main()
//{
//    char c;
//    int opd1,opd2,temp,c1;
//    expSTK=initSTK(&expSTKzone);
//    printf("\n后置表达式：");
//    while((c=getchar())!='\n')
//    {
//        if(c==' ')
//            continue;
//        if((c>47)&&(c<58))
//        {
//            putchar(c);
//            c1=c-48;
//            if(push(&c1,expSTK)==error)
//            {
//                printf("\n表达式太长\n");
//                exit(-13);
//            }
//            else if((c==add)||(c==subs)||(c==mult)||(c==div))
//            {
//                putchar(c);
//                if(pop(&opd1,expSTK)==error)
//                    synerror();
//                temp=eval(c,opd2,opd1);
//                push(&temp,expSTK);
//            }
//            else
//                synerror();
//        }
//        if(pop(&opd1,expSTK)==error)
//            synerror();
//        if(!(emptySTK(expSTK)))
//            synerror();
//        printf("=%-3d\n",opd1);
//    }
//    return 0;
//}

//************************************************************************
////循环队列的表示和实现
//#include <stdio.h>
//#include <stdlib.h>
//typedef int QElemType;
//typedef int Status;
//#define OK 1
//#define TRUE 1
//#define FALSE 0
//#define ERROR 0
//#define OVERFLOW -2
//#define MaxQsize 100
//typedef struct
//{
//    QElemType *base;
//    int front;
//    int rear;
//}SqQueue;
//
//Status InitQueue(SqQueue *Q)
//{
//    (*Q).base=(QElemType *)malloc(MaxQsize*sizeof(QElemType));
//    if(!(*Q).base)
//        return OVERFLOW;
//    (*Q).front=(*Q).rear=0;
//    return OK;
//}
//
//Status QueueEmpty(SqQueue Q)
//{
//    if(Q.front==Q.rear)
//        return TRUE;
//    else
//        return FALSE;
//}
//
//int QueueLength(SqQueue Q)
//{
//    return (Q.rear-Q.front+MaxQsize)%MaxQsize;
//}
//
//Status GetHead(SqQueue Q,QElemType *e)
//{
//    if(Q.front==Q.rear)
//        return ERROR;
//    *e=Q.base[Q.front];
//    return OK;
//}
//
//Status EnQueue(SqQueue *Q,QElemType e)
//{
//    if(((*Q).rear+1)%MaxQsize==(*Q).front)
//        return ERROR;
//    (*Q).base[(*Q).rear]=e;
//    (*Q).rear=((*Q).rear+1)%MaxQsize;
//    return OK;
//}
//
//Status DeQueue(SqQueue *Q,QElemType *e)
//{
//    if((*Q).rear==(*Q).front)
//        return ERROR;
//    *e=(*Q).base[(*Q).front];
//    (*Q).front=((*Q).front+1)%MaxQsize;
//    return OK;
//}
//
//int main()
//{
//    SqQueue Q;
//    int select;
//    QElemType e;
//    if(InitQueue(&Q)==OVERFLOW)
//        printf("分配失败，即将退出程序！");
//    else
//        do
//        {
//            printf("1：判断队列是否为空\n");
//            printf("2：测试队列的长度\n");
//            printf("3：取队头元素值\n");
//            printf("4：向队列中插入一新元素\n");
//            printf("5：删除队列中一元素\n");
//            printf("0：结束\n");
//            scanf("%d",&select);
//            switch(select)
//            {
//                case 1:if(QueueEmpty(Q)==TRUE)
//                            printf("队列为空\n");
//                        else
//                            printf("队列不为空\n");
//                        break;
//                case 2:printf("队列长度为：%d\n",QueueLength(Q));
//                        break;
//                case 3:if(GetHead(Q,&e)==ERROR)
//                            printf("队列为空\n");
//                        else
//                            printf("队首元素为：%d\n",e);
//                        break;
//                case 4:scanf("%d",&e);
//                        if(EnQueue(&Q,e)==ERROR)
//                            printf("队列满\n");
//                        else
//                            printf("元素成功插入\n");
//                        break;
//                case 5:if(DeQueue(&Q,&e)==ERROR)
//                        printf("队列空，无数据可删\n");
//                        else
//                            printf("删除元素为：%d\n",e);
//                        break;
//                case 0:printf("操作结束\n");
//                        break;
//                default:printf("输入选择错误\n");
//            }
//        }
//        while(select);
//    return 0;
//}
