#include <math.h>
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 30000 //排序表的最大容量

//冒泡
//enum BOOL{False,True};
//typedef struct           //定义排序表的结构
//{
//    int  elemword[MAXSIZE]; //数据元素关键字
//    int Count;            //表中当前元素的个数
//}SqList;
//void InitialSqList(SqList&);        //初始化排序表
//void BubbleSort(SqList &);          //起泡排序
//void PrintSqList(SqList);           //显示表中的所有元素
//int main()
//{
//    SqList L;
//    clock_t t1;
//    InitialSqList(L);
//    printf("冒泡排序\n");
//    t1=clock();
//    BubbleSort(L);
//    printf("%d\n",clock()-t1);
//    //PrintSqList(L);
//    return 0;
//}
//void InitialSqList(SqList &L)
//{
//    int i;
//	srand((unsigned)time(NULL));
//	L.Count=20000;
//    for(i=0;i<L.Count;i++)
//		L.elemword[i]=rand();
//}
//void BubbleSort(SqList &L)
//{
//    int i,j,t;
//    BOOL change;
//    for(i=L.Count-1,change=True;i>0&&change;--i)
//    {
//        change=False;
//        for(j=0;j<i;j++)
//            if(L.elemword[j]>L.elemword[j+1])
//            {
//                t=L.elemword[j];
//                L.elemword[j]=L.elemword[j+1];
//                L.elemword[j+1]=t;
//                change=True;
//            }
//    }
//}
//void PrintSqList(SqList L)
//{
//    int i;
//    printf("已排好序的序列如下：\n");
//    for(i=0;i<L.Count;i++)
//        printf("%4d",L.elemword[i]);
//}

//快排
typedef struct
{int  elemword[MAXSIZE];
 int Count;
}SqList;
void InitialSqList(SqList&);
void QuickSort(SqList &);
void QSort(SqList &,int,int);
int  Partition(SqList &,int,int);
void PrintSqList(SqList);
int main()
{
    SqList L;  //声明表L
    clock_t t1;
    InitialSqList(L);    //待排序列初始化
    t1=clock();
    QuickSort(L);        //快速排序
    printf("%d\n",clock()-t1);
    //PrintSqList(L);      //显示排序结果
    return 0;
}
void InitialSqList(SqList &L)
{
    int i;
	srand((unsigned)time(NULL));
	L.Count=20000;
    for(i=0;i<L.Count;i++)
		L.elemword[i]=rand();
void QuickSort(SqList &L)
{
    QSort(L,1,L.Count);
}
void QSort(SqList &L,int low,int high)
{
 int pivotloc;
 if(low<high)         //长度大于1
   {pivotloc=Partition(L,low,high); //将L.elemword[low..high]一分为二
    QSort(L,low,pivotloc-1);        //对低子表递归排序,pivotloc是枢轴位置
    QSort(L,pivotloc+1,high);       //对高子表递归排序
   }
}
int Partition(SqList &L,int low,int high)
{//交换顺序表L中子表r[low..high]的记录，枢轴记录到位，并返回其所在位置，此时
 //在它之前(后)的记录均不大(小)于它
 int pivotkey;
 pivotkey=L.elemword[low]; //用子表的第一个记录作枢轴记录
 while(low<high)      //从表的两端交替地向中间扫描
   {while(low<high&&L.elemword[high]>=pivotkey)
       --high;
    L.elemword[low]=L.elemword[high];//将比枢轴记录小的记录移到低端
    while(low<high&&L.elemword[low]<=pivotkey)
       ++low;
    L.elemword[high]=L.elemword[low]; //将比枢轴记录大的记录移到高端
   }
 L.elemword[low]=pivotkey;  //枢轴记录到位
 return low;                //返回枢轴记录
}
void PrintSqList(SqList L)
{//显示表中所有元素
 int i;
 printf("已排好序的序列如下：\n");
 for(i=1;i<=L.Count;i++)
    printf("%4d",L.elemword[i]);
 printf("\n");
}

////希尔
//#define MAXSIZE 20 //排序表的最大容量
//typedef struct           //定义排序表的结构
//{int  elemword[MAXSIZE]; //数据元素关键字
// int Count;            //表中当前元素的个数
//}SqList;
//void InitialSqList(SqList&);        //初始化排序表
//void ShellSort(SqList &,int [],int);//希尔排序
//void ShellInsert(SqList&,int);      //一趟希尔排序
//void PrintSqList(SqList);           //显示表中的所有元素
//void main()
//{SqList L;  //声明表L
// char j='y';
// int dlta[3]={5,3,1}; //希尔排序增量序列，本程序采用5，3，1序列
// int t=3;             //希尔排序增量序列中增量的个数
// textbackground(3);  //设定屏幕颜色
// textcolor(15);
// clrscr();
// //-------------------------程序说明-------------------------------
// printf("本程序将演示希尔排序的操作。\n增量序列为5，3，1。\n");
// //----------------------------------------------------------------
// while(j!='n'&&j!='N')
//   {InitialSqList(L);    //待排序列初始化
//    ShellSort(L,dlta,t); //希尔排序
//    PrintSqList(L);      //显示希尔排序结果
//    printf("继续进行下一次排序吗?(Y/N)");
//    scanf(" %c",&j);
//   }
// printf("程序运行结束!\n按任意键关闭窗口!\n");
// getchar();getchar();
//}
//void InitialSqList(SqList &L)
//{//表初始化
// int i;
// printf("请输入待排序的记录的个数:");
// scanf("%d",&L.Count);
// printf("请输入待排序的记录的关键字(整型数):\n");
// for(i=1;i<=L.Count;i++)
//   scanf("%d",&L.elemword[i]);
//}
//void ShellSort(SqList &L,int dlta[],int t)
//{//按增量序列dlta[0..t-1]对顺序表L作希尔排序
// for(int k=0;k<t;++k)
//   ShellInsert(L,dlta[k]); //一趟增量为dlta[k]的插入排序
//}
//void ShellInsert(SqList &L,int dk)
//{//对顺序表L做一趟希尔插入排序。本算法是和一趟直接插入排序相比，作了以下修改：
// //1. 前后记录的增量是dk，而不是1
// //2. 0号单元只是暂存单元，不是哨兵。当j<=0时，插入位置已找到
// int i,j;
// for(i=dk+1;i<=L.Count;i++)
//   if(L.elemword[i]<L.elemword[i-dk])  //"<",需将L.elemword[i]插入有序子表
//     { L.elemword[0]=L.elemword[i];   //暂存在0号单元
//       for(j=i-dk;j>0&&L.elemword[0]<L.elemword[j];j-=dk)
//	  L.elemword[j+dk]=L.elemword[j];  //记录后移，查找插入位置
//       L.elemword[j+dk]=L.elemword[0];     //插入到正确的位置
//     }
//}
//void PrintSqList(SqList L)
//{//显示表所有元素
// int i;
// printf("已排好序的序列如下：\n");
// for(i=1;i<=L.Count;i++)
//    printf("%4d",L.elemword[i]);
// printf("\n");
//}
//
//
//
//
////堆
//#define MAXSIZE 20 //排序表的最大容量
//typedef struct           //定义排序表的结构
//{
//    int  elemword[MAXSIZE]; //数据元素关键字
//    int length;            //表中当前元素的个数
//}SqList;
//void InitialSqList(SqList&);       //初始化排序表
//void HeapSort(SqList &);           //堆排序
//void HeapAdjust(SqList &,int,int); //堆调整
//void PrintSqList(SqList);          //显示表中的所有元素
//int main()
//{
//    SqList L;  //声明表L
//    char j='y';
//// textbackground(3);  //设定屏幕颜色
//// textcolor(15);
//// clrscr();
// //-------------------------程序说明-------------------------------
//    printf("本程序将演示堆排序的操作。\n");
// //----------------------------------------------------------------
//    while(j!='n'&&j!='N')
//    {
//        InitialSqList(L);    //待排序列初始化
//        HeapSort(L);         //堆排序
//        PrintSqList(L);      //显示排序结果
//        printf("继续进行下一次排序吗?(Y/N)");
//        scanf(" %c",&j);
//    }
//    printf("程序运行结束!\n按任意键关闭窗口!\n");
//    getchar();getchar();
//    return 0;
//}
//void InitialSqList(SqList &L)
//{//表初始化
//    int i;
//    printf("请输入待排序的记录的个数:");
//    scanf("%d",&L.length);
//    printf("请输入待排序的记录的关键字(整型数):\n");
//    for(i=1;i<=L.length;i++)
//        scanf("%d",&L.elemword[i]);
//}
//void HeapSort(SqList &L)
//{//对顺序表L做堆排序。
//    int i,j,t;
//    for(i=L.length/2;i>0;--i)   //把L.elemword[1..L.length]建成大顶堆
//        HeapAdjust(L,i,L.length);
//    for(i=L.length;i>1;--i)
//    {
//        t=L.elemword[1];             //将堆顶记录和当前未经排序子序列L.elemword[1..i]
//        L.elemword[1]=L.elemword[i]; //中的最后一个记录相互交换
//        L.elemword[i]=t;
//        HeapAdjust(L,1,i-1);         //将L.r[1..i-1]重新调整为大顶堆
//    }
//}
//void HeapAdjust(SqList &H,int s,int m)
//{//已知H.elemword[s..m]中除H.elemword[s]之外均满足堆的定义,本函数调整H.elemword[s]
// //使H.elemword[s..m]成为一个大顶堆
//    int j,rc;
//    rc=H.elemword[s];
//    for(j=2*s;j<=m;j*=2)     //沿关键字叫大的结点向下筛选
//    {
//        if(j<m&&H.elemword[j]<H.elemword[j+1]) ++j; //j为关键字较大的记录的下标
//            if(rc>=H.elemword[j])
//                break;    //rc应插入在位置s上
//        H.elemword[s]=H.elemword[j];
//        s=j;
//    }
//    H.elemword[s]=rc;  //插入
//}
//void PrintSqList(SqList L)
//{//显示表中所有元素
//    int i;
//    printf("已排好序的序列如下：\n");
//    for(i=1;i<=L.length;i++)
//        printf("%4d",L.elemword[i]);
//    printf("\n");
//}
//
//
//
////归并
//typedef struct           //定义排序表的结构
//{int  elemword[MAXSIZE]; //数据元素关键字
// int length;            //表中当前元素的个数
//}SqList;
//void InitialSqList(SqList&);       //初始化排序表
//void MergeSort(SqList &);          //归并排序
//void MSort(int [],int [],int,int); //归并排序递归子程序
//void Merge(int [],int [],int,int,int); //两个子序列归并
//void PrintSqList(SqList);          //显示表中的所有元素
//void main()
//{SqList L;  //声明表L
// char j='y';
///* textbackground(3);  //设定屏幕颜色
// textcolor(15);
// clrscr();*/
// //-------------------------程序说明-------------------------------
// printf("本程序将演示归并排序的操作。\n");
// //----------------------------------------------------------------
// while(j!='n'&&j!='N')
//   {InitialSqList(L);    //待排序列初始化
//    MergeSort(L);         //归并排序
//    PrintSqList(L);      //显示排序结果
//    printf("继续进行下一次排序吗?(Y/N)");
//    scanf(" %c",&j);
//   }
// printf("程序运行结束!\n按任意键关闭窗口!\n");
// getchar();getchar();
//}
//void InitialSqList(SqList &L)
//{//表初始化
// int i;
// printf("请输入待排序的记录的个数:");
// scanf("%d",&L.length);
// printf("请输入待排序的记录的关键字(整型数):\n");
// for(i=1;i<=L.length;i++)
//   scanf("%d",&L.elemword[i]);
//}
//void MergeSort(SqList &L)
//{//对顺序表L做归并排序。
// MSort(L.elemword,L.elemword,1,L.length);
//}
//void MSort(int SR[],int TR1[],int s,int t)
//{//将SR[s..t]归并排序为TR1[s..t]。
// int m;
// int TR2[MAXSIZE];
// if(s==t) TR1[s]=SR[s];
// else
//   {m=(s+t)/2;           //将SR[s..t]平分为SR[s..m]和SR[m+1..t]
//    MSort(SR,TR2,s,m);   //递归地将SR[s..m]归并为有序的TR2[s..m]
//    MSort(SR,TR2,m+1,t); //递归地将SR[m+1..t]归并为有序的TR2[m+1..t]
//    Merge(TR2,TR1,s,m,t);//将TR2[s..m]和TR2[m+1..t]归并到TR1[s..t]
//   }
//}
//void Merge(int SR[],int TR[],int i,int m,int n)
//{//将有序的SR[i..m]和SR[m+1..n]归并为有序的TR[i..n]
// int j,k,p;
// for(j=m+1,k=i;i<=m&&j<=n;++k) //将SR中的记录有小到大地并入TR
//   {if(SR[i]<SR[j]) TR[k]=SR[i++];
//    else TR[k]=SR[j++];
//   }
// if(i<=m)
//   for(p=k;p<=n;p++) //将剩余的SR[i..m]复制到TR
//     {TR[p]=SR[i];
//      i++;
//     }
// if(j<=n)
//   for(p=k;p<=n;p++) //将剩余的SR[j..n]复制到TR
//     {TR[p]=SR[j];
//      j++;
//     }
//}
//void PrintSqList(SqList L)
//{//显示表中所有元素
// int i;
// printf("已排好序的序列如下：\n");
// for(i=1;i<=L.length;i++)
//    printf("%4d",L.elemword[i]);
// printf("\n");
//}
//
