#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MAXSIZE 30000
enum BOOL{False,True};
typedef struct
{
    int  elemword[MAXSIZE];
    int Count;
}SqList;
void InitialSqList(SqList&);
void PrintSqList(SqList);
//冒泡***********************************************
void BubbleSort(SqList &);
//冒泡***********************************************
//快排***********************************************
void QuickSort(SqList &);
void QSort(SqList &,int,int);
int  Partition(SqList &,int,int);
//快排***********************************************
//希尔***********************************************
void ShellSort(SqList &,int [],int);
void ShellInsert(SqList&,int);
//希尔***********************************************
//堆***********************************************
void HeapSort(SqList &);
void HeapAdjust(SqList &,int,int);
//堆***********************************************
//归并***********************************************
void MergeSort(SqList &);
void MSort(int [],int [],int,int);
void Merge(int [],int [],int,int,int);
//归并***********************************************
int main()
{
    SqList L;
	clock_t t1;

    InitialSqList(L);
    printf("2000个随机数\n");
	printf("冒泡排序:");
	t1=clock();
    BubbleSort(L);
    //PrintSqList(L);
	printf("%d\n",clock()-t1);

    printf("快速排序:");
	t1=clock();
    QuickSort(L);
    //PrintSqList(L);
	printf("%d\n",clock()-t1);

	printf("希尔排序:");
	int dlta[3]={5,3,1};
	int t=3;
	t1=clock();
	ShellSort(L,dlta,t);
	//PrintSqList(L);
	printf("%d\n",clock()-t1);

	printf("堆排序:");
	t1=clock();
    HeapSort(L);
    //PrintSqList(L);
	printf("%d\n",clock()-t1);

	printf("归并排序:");
	t1=clock();
    MergeSort(L);
    //PrintSqList(L);
	printf("%d\n",clock()-t1);


    return 0;
}
void InitialSqList(SqList &L)
{
    int i;
	srand((unsigned)time(NULL));
	L.Count=2000;
    for(i=0;i<L.Count;i++)
		L.elemword[i]=rand();
}
void PrintSqList(SqList L)
{
    int i;
    for(i=0;i<L.Count;i++)
        printf("%6d",L.elemword[i]);
    printf("\n");
}

//冒泡***********************************************
void BubbleSort(SqList &L)
{
    int i,j,t;
    BOOL change;
    for(i=L.Count-1,change=True;i>0&&change;--i)
    {
        change=False;
        for(j=0;j<i;j++)
            if(L.elemword[j]>L.elemword[j+1])
            {
                t=L.elemword[j];
                L.elemword[j]=L.elemword[j+1];
                L.elemword[j+1]=t;
                change=True;
            }
    }
}
//冒泡***********************************************
//快排***********************************************
void QuickSort(SqList &L)
{
    QSort(L,0,L.Count-1);
}
void QSort(SqList &L,int low,int high)
{
    int pivotloc;
    if(low<high)
    {
        pivotloc=Partition(L,low,high);
        QSort(L,low,pivotloc-1);
        QSort(L,pivotloc+1,high);
    }
}
int Partition(SqList &L,int low,int high)
{
    int pivotkey;
    pivotkey=L.elemword[low];
    while(low<high)
    {
        while(low<high&&L.elemword[high]>=pivotkey)
        --high;
        L.elemword[low]=L.elemword[high];
        while(low<high&&L.elemword[low]<=pivotkey)
            ++low;
        L.elemword[high]=L.elemword[low];
    }
    L.elemword[low]=pivotkey;
    return low;
}
//快排***********************************************
//希尔***********************************************
void ShellSort(SqList &L,int dlta[],int t)
{
	for(int k=0;k<t;++k)
		ShellInsert(L,dlta[k]);
}
void ShellInsert(SqList &L,int dk)
{
	int i,j,a;
	for(i=dk;i<L.Count;i++)
		if(L.elemword[i-dk]>L.elemword[i])
		{
			a=L.elemword[i];
			for(j=i-dk;j>=0 && a<L.elemword[j];j-=dk)
				L.elemword[j+dk]=L.elemword[j];
			L.elemword[j+dk]=a;
		}
}
//希尔***********************************************
//堆***********************************************
void HeapSort(SqList &L)
{
    int i,j,t;
    for(i=L.Count/2;i>0;--i)
        HeapAdjust(L,i,L.Count);
    for(i=L.Count;i>1;--i)
    {
        t=L.elemword[1];
        L.elemword[1]=L.elemword[i];
        L.elemword[i]=t;
        HeapAdjust(L,1,i-1);
    }
}
void HeapAdjust(SqList &H,int s,int m)
{
    int j,rc;
    rc=H.elemword[s];
    for(j=2*s;j<=m;j*=2)
    {
        if(j<m&&H.elemword[j]<H.elemword[j+1]) ++j;
            if(rc>=H.elemword[j])
                break;
        H.elemword[s]=H.elemword[j];
        s=j;
    }
    H.elemword[s]=rc;
}
//堆***********************************************
//归并***********************************************
void MergeSort(SqList &L)
{
    MSort(L.elemword,L.elemword,1,L.Count);
}
void MSort(int SR[],int TR1[],int s,int t)
{
    int m;
    int TR2[MAXSIZE];
    if(s==t) TR1[s]=SR[s];
    else
    {
        m=(s+t)/2;
        MSort(SR,TR2,s,m);
        MSort(SR,TR2,m+1,t);
        Merge(TR2,TR1,s,m,t);
    }
}
void Merge(int SR[],int TR[],int i,int m,int n)
{
    int j,k,p;
    for(j=m+1,k=i;i<=m&&j<=n;++k)
    {
        if(SR[i]<SR[j]) TR[k]=SR[i++];
        else TR[k]=SR[j++];
    }
    if(i<=m)
        for(p=k;p<=n;p++)
        {
            TR[p]=SR[i];
            i++;
        }
    if(j<=n)
        for(p=k;p<=n;p++)
        {
            TR[p]=SR[j];
            j++;
        }
}
//归并***********************************************


/*//* * * * * * * * * * * * * * * * * * * * * * * *
//*CHAPTER          :5  (5_5)                   *
//*PROGRAM          :最短路径                   *
//*CONTENT          :迪杰斯特拉算法             *
//* * * * * * * * * * * * * * * * * * * * * * * *
#include <dos.h>
#include <conio.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define INFINITY 30000    //定义一个权值的最大值
#define MAX_VERTEX_NUM 20 //图的最大顶点数
enum BOOL {False,True};
typedef struct
{
	int arcs[MAX_VERTEX_NUM][MAX_VERTEX_NUM]; //邻接矩阵
	int vexnum,arcnum;                //图的当前顶点和边数
}Graph;

void CreateGraph(Graph &);    //生成图的邻接矩阵
void ShortestPath_DiJ(Graph,int,int[][MAX_VERTEX_NUM],int[]);
    //用迪杰斯特拉算法求从某一源点到其余顶点的最短路径
void Print_ShortestPath(Graph,int,int[][MAX_VERTEX_NUM],int[]);//显示最短路径

void main()
{
	Graph G;  //采用邻接矩阵结构的图
	char j='y';
	int u;
	int P[MAX_VERTEX_NUM][MAX_VERTEX_NUM]; //存放从源点到各顶点的最短路径
	int D[MAX_VERTEX_NUM];                 //存放从源点到各顶点的最短路径的距离
//	textbackground(3);  //设定屏幕颜色
//	textcolor(15);
//	clrscr();
 //------------------程序解说----------------------------
	printf("本程序将演示利用迪杰斯特拉算法求\n从图的一点到其余顶点的最短路径.\n");
	printf("首先输入图的顶点数和弧数.\n格式：顶点数，弧数；例如:5,7\n");
	printf("然后输入各弧和权值.\n格式：弧尾，弧头，权值；例如:\n1,2,10\n1,3,18\n2,4,5\n3,2,5\n4,3,2\n4,5,2\n5,3,2\n");
	printf("再输入从哪个顶点出发，例如:1\n");
	printf("程序将会找出从1到其余顶点的最短路径.\n");
	printf("10  1->2\n17  1->2->4->3\n15  1->2->4\n17  1->2->4->5\n");
 //------------------------------------------------------
	while(j!='N'&&j!='n')
	{
		CreateGraph(G);       //生成邻接矩阵结构的图
		printf("从哪个顶点出发:");
		scanf("%d",&u);  //输入迪杰斯特拉算法中的起始顶点

		ShortestPath_DiJ(G,u,P,D); //利用迪杰斯特拉算法求最短路径

		Print_ShortestPath(G,u,P,D); //显示最短路径
		printf("最短路径演示完毕，继续进行吗?(Y/N)");
		scanf(" %c",&j);
	}
}

void CreateGraph(Graph &G)
{//构造邻接矩阵结构的图G
	int i,j;
	int start,end,weight;
	printf("请输入图的顶点数和弧数(顶点数，弧数):");
	scanf("%d,%d",&G.vexnum,&G.arcnum); //输入图的顶点数和边数
	for(i=1;i<=G.vexnum;i++)
		for(j=1;j<=G.vexnum;j++)
			G.arcs[i][j]=INFINITY; //初始化邻接矩阵
	printf("输入各弧和权值，格式：弧尾，弧头，权值\n");
	for(i=1;i<=G.arcnum;i++)
	{
		scanf("%d,%d,%d",&start,&end,&weight); //输入边的起点和终点及权值
		G.arcs[start][end]=weight;
	}
}
void ShortestPath_DiJ(Graph G,int v0,int P[][MAX_VERTEX_NUM],int D[])
{//用迪杰斯特拉算法求有向网G的v0顶点到其余顶点v的最短路径P[v]及其带权路径长度D[v]
 //若P[v][0]≠0,表明从源点出发存在一条到顶点v的最短路径，该路径存放在P[v]中
 //final[v]为True则表明已经找到从v0到v的最短路径
	int i,j,w,v;
	int min;
	BOOL final[MAX_VERTEX_NUM];
	for(v=1;v<=G.vexnum;v++)   //初始化
	{
		final[v]=False; D[v]=G.arcs[v0][v];
		for(i=0;i<=G.vexnum;i++)
			P[v][i]=0; //设空路径
    //if(D[v]<INFINITY) P[v][0]=v0; //若从v0到v有直达路径
	}
	D[v0]=0; final[v0]=True; //初始时，v0属于S集
 //开始主循环，每次求得v0到某个顶点v的最短路径，并加v到S集
	for(i=1;i<=G.vexnum;i++)  //寻找其余G.vexnum-1个顶点
	{
		v=0;
		min=INFINITY;
		for(w=1;w<=G.vexnum;w++)   //寻找当前离v0最近的顶点v
		if((!final[w])&&(D[w]<min))
		{
			v=w;min=D[w];}
			if(!v) break;  //若v=0表明所有与v0有通路的顶点均已找到了最短路径，退出主循环
			final[v]=True; //将v加入S集
			for(j=0;P[v][j]!=0;j++) ;
				P[v][j]=v;     //将路径P[v]延伸到顶点v
			for(w=1;w<=G.vexnum;w++) //更新当前最短路径及距离
				if(!final[w]&&(min+G.arcs[v][w]<D[w]))
				{
					D[w]=min+G.arcs[v][w];
					for(j=0;P[v][j]!=0;j++)
						P[w][j]=P[v][j];
				}
	}
}

void Print_ShortestPath(Graph G,int v0,int P[][MAX_VERTEX_NUM],int D[])
{//显示从顶点u到其余顶点的最短路径及距离
	int v,j;
	printf("The shortest path from Vertex %d to the other Vertex:\n");
	for(v=1;v<=G.vexnum;v++)
	{
		if(P[v][0]==0) continue; //表明顶点v0到顶点v没有通路
		printf("%-4d",D[v]);
		printf("%d->",v0);
		for(j=0;P[v][j]!=0;j++)
		printf("%d->",P[v][j]);
		printf("\b\b  \n");
	}
}
*/



/*#include<stdio.h>
#include<stdlib.h>
#define NUM 20
#define INI 10000
typedef struct graph
{
    int a[NUM][NUM];
    int m,n;
}Graph;
typedef struct
{
    int d;
    int q;
}Un[NUM];
void Create_Graph(Graph &g)
{
    int start,finish,weight;
    int i,j;
    for(i=1;i<=g.m;++i)
        for(j=1;j<=g.m;++j)
            g.a[i][j]=INI;
    printf("输入起点，终点，权值：");
    for(i=1;i<=g.n;++i)
    {
        scanf("%d%d%d",&start,&finish,&weight);
        g.a[start][finish]=weight;
        g.a[finish][start]=weight;
    }
}
int minq(Un u,int num)
{
    int y,w=INI;
    int i;
    for(i=1;i<=num;++i)
    {
        if(u[i].q!=0 && u[i].q<w)
        {
            w=u[i].q;
            y=i;
        }

    }
    return y;
}
void Prim(Graph g,int head)
{
    Un u;
    int i,j,k;
    printf("最小生成树：\n");
    for(i=1;i<=g.m;++i)
    {
        if(i!=head)
        {
            u[i].d=head;
            u[i].q=g.a[head][i];
        }
    }
    u[head].q=0;
    for(i=1;i<g.m;++i)
    {
        k=minq(u,g.m);
        printf("%d %d\n",u[k].d,k);
        u[k].q=0;
        for(j=1;j<=g.m;++j)
            if(g.a[k][j]<u[j].q)
        {
            u[j].d=k;
            u[j].q=g.a[k][j];
        }
    }
}
int main()
{
    Graph g;
    int x;
    printf("输入顶点数及边数：");
    scanf("%d%d",&g.m,&g.n);
    if(g.n>(g.m*(g.m-1)/2))
    {
        printf("error!");
        return 0;
    }
    Create_Graph(g);
    printf("输入最小生成树的起点：");
    scanf("%d",&x);
    Prim(g,x);
    return 0;
}*/


/*
//* * * * * * * * * * * * * * * * * * * * * * * *
//*CHAPTER          :5  (5_2)                   *
//*PROGRAM          :最小代价生成树             *
//*CONTENT          :普里姆算法                 *
//* * * * * * * * * * * * * * * * * * * * * * * *
#include <dos.h>
#include <conio.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define INFINITY 30000    //定义一个权值的最大值
#define MAX_VERTEX_NUM 20 //图的最大顶点数
typedef struct
{
	int arcs[MAX_VERTEX_NUM][MAX_VERTEX_NUM]; //邻接矩阵
	int vexnum,arcnum;                //图的当前顶点和边数
}Graph;

typedef struct
{
	int adjvex;  //某顶点与已构造好的部分生成树的顶点之间权值最小的顶点
	int lowcost; //某顶点与已构造好的部分生成树的顶点之间的最小权值
}ClosEdge[MAX_VERTEX_NUM]; //用普里姆算法求最小生成树时的辅助数组
void CreateGraph(Graph &);    //生成图的邻接矩阵
void MiniSpanTree_PRIM(Graph,int); //用普里姆算法求最小生成树
int  minimum(ClosEdge,int); //在普里姆算法中求下一个结点
int main()
{
	Graph G;  //采用邻接矩阵结构的图
	char j='y';
	int u;
// textbackground(3);  //设定屏幕颜色
// textcolor(15);
// clrscr();
 //------------------程序解说----------------------------
	printf("本程序将演示构造图的最小代价生成树。\n");
	printf("首先输入图的顶点数和弧数.\n格式：顶点数，弧数；例如:4,4\n");
	printf("接着输入各条弧(弧尾,弧头)和弧的权值。\n");
	printf("格式:弧尾，弧头，权值；例如\n1,2,1\n1,3,2\n2,4,3\n3,4,4\n");
	printf("程序将会构造该图的最小代价生成树。\n");
	printf("并显示该最小生成树。\n1,2\n1,3\n2,4\n");
 //------------------------------------------------------
	while(j!='N'&&j!='n')
	{
		printf("请输入图的顶点和弧数:");
		scanf("%d,%d",&G.vexnum,&G.arcnum); //输入图的顶点数和边数
		CreateGraph(G);       //生成邻接矩阵结构的图
		printf("从哪一顶点开始:");
		scanf("%d",&u);  //输入普里姆算法中的起始顶点
		MiniSpanTree_PRIM(G,u); //普里姆算法求最小生成树
		printf("最小代价生成树构造完毕，继续进行吗?(Y/N)");
		scanf(" %c",&j);
    }
}

void CreateGraph(Graph &G)
{//构造邻接矩阵结构的图G
	int i,j;
	int start,end,weight;
	for(i=1;i<=G.vexnum;i++)
		for(j=1;j<=G.vexnum;j++)
			G.arcs[i][j]=INFINITY; //初始化邻接矩阵
	printf("输入弧和其权值，格式：弧尾，弧头，权值\n");
	for(i=1;i<=G.arcnum;i++)
	{
		scanf("%d,%d,%d",&start,&end,&weight); //输入边的起点和终点及权值
		G.arcs[start][end]=weight;
		G.arcs[end][start]=weight;
	}
}
void MiniSpanTree_PRIM(Graph G,int u)
{//从第u个顶点出发构造图G的最小生成树
	ClosEdge closedge;
	int i,j,k;
	printf("最小代价生成树:\n");
	for(j=1;j<=G.vexnum;j++) //辅助数组初始化
		if(j!=u)
		{
			closedge[j].adjvex=u;
			closedge[j].lowcost=G.arcs[u][j];
		}

	closedge[u].lowcost=0; //初始，U={u}
	for(i=1;i<G.vexnum;i++) //选择其余的G.vexnum-1个顶点
	{
		k=minimum(closedge,G.vexnum); //求出生成树的下一个顶点
		printf("%d,%d\n",closedge[k].adjvex,k); //输出生成树的边
		closedge[k].lowcost=0;   //第k顶点并入U集
		for(j=1;j<=G.vexnum;j++) //新顶点并入U后，重新选择最小边
			if(G.arcs[k][j]<closedge[j].lowcost)
			{
				closedge[j].adjvex=k;
				closedge[j].lowcost=G.arcs[k][j];
			}
    }
}
int minimum(ClosEdge cl,int vnum)
{//在辅助数组cl[vnum]中选择权值最小的顶点，并返回其位置
	int i;
	int w,p;
	w=INFINITY;
	for(i=1;i<=vnum;i++)
		if(cl[i].lowcost!=0 && cl[i].lowcost<w)
		{
			w=cl[i].lowcost;
			p=i;
		}
	return p;
}*/


/*
#include<stdio.h>
#define MAX  100000
#define VNUM  10+1                                             //这里没有ID为0的点,so id号范围1~10

int edge[VNUM][VNUM]={};//输入的邻接矩阵
int lowcost[VNUM]={0};                                         //记录Vnew中每个点到V中邻接点的最短边
int addvnew[VNUM];                                             //标记某点是否加入Vnew
int adjecent[VNUM]={0};                                        //记录V中与Vnew最邻近的点


void prim(int start)
{
     int sumweight=0;
     int i,j;

     for(i=1;i<VNUM;i++)                                      //顶点是从1开始
     {
        lowcost[i]=edge[start][i];
        addvnew[i]=-1;                                         //将所有点至于Vnew之外,V之内，这里只要对应的为-1，就表示在Vnew之外
     }

     addvnew[start]=0;                                        //将起始点start加入Vnew
     adjecent[start]=start;

     for(i=1;i<VNUM-1;i++)
     {
        int min=MAX;
        int v=-1;
        for(j=1;j<VNUM;j++)
        {
            if(addvnew[j]!=-1&&lowcost[j]<min)                 //在Vnew之外寻找最短路径
            {
                min=lowcost[j];
                v=j;
            }
        }
        if(v!=-1)
        {
            printf("%d %d %d\n",adjecent[v],v,lowcost[v]);
            addvnew[v]=0;                                      //将v加Vnew中

            sumweight+=lowcost[v];                             //计算路径长度之和
            for(j=1;j<VNUM;j++)
            {
                if(addvnew[j]==-1&&edge[v][j]<lowcost[j])
                {
                    lowcost[j]=edge[v][j];                     //此时v点加入Vnew 需要更新lowcost
                    adjecent[j]=v;
                }
            }
        }
    }
    printf("the minmum weight is %d",sumweight);
}
*/

//3.
/*#include<stdio.h>
void max_test(int a,int b)//最大公约数
{
	int i;
	while(1)
	{
		i=a;
		if(a>b)
			i=b;
		while(a%i!=0 || b%i!=0)
			i--;
		printf("%d\n",i);
		break;
	}
}
void min_test(int a,int b)//最小公倍数
{
    int i;
	while(1)
    {
		i=a;
		if(a<b)
			i=b;
		while(i%a!=0 || i%b!=0)
			i++;
		printf("%d\n",i);
		break;
	}
}
int main()
{
    int a,b;
    scanf("%d%d",&a,&b);
    max_test(a,b);
    min_test(a,b);
    return 0;
}*/



//2.
//#include<stdio.h>
//
//double test()
//{
//    int e=0,i=1,flag=1,sum;
//    double c;
//    printf("输入精度:");
//    scanf("%lf",&c);
//    while(e<(10*c))
//    {
//        e+=flag*1/i;
//        i+=2;
//        flag=-flag;
//    }
//    return e;
//}
//
//int main()
//{
//    double a;
//    a=4*test();
//    printf("结果为：%lf",a);
//    return 0;
//}没写出来

//1.
//#include<stdio.h>
//
//float square(float r)
//{
//	return 3.14*r*r;
//}
//
//float circumference(float r)
//{
//	return 2*3.14*r;
//}
//
//int main()
//{
//	float r;
//	printf("input radius：");
//	scanf("%f",&r);
//	printf("面积为:%f,周长为:%f",circumference(r),square(r));
//	return 0;
//}
