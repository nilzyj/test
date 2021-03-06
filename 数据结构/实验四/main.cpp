//prim算法求最小生成树
//#include<stdio.h>
//#include<stdlib.h>
//#define NUM 20
//#define INI 10000
//typedef struct graph
//{
//    int a[NUM][NUM];
//    int m,n;
//}Graph;
//typedef struct
//{
//    int d;
//    int q;
//}Un[NUM];
//void Create_Graph(Graph &g)
//{
//    int start,finish,weight;
//    int i,j;
//    for(i=1;i<=g.m;++i)
//        for(j=1;j<=g.m;++j)
//            g.a[i][j]=INI;
//    printf("输入起点，终点，权值：\n");
//    for(i=1;i<=g.n;++i)
//    {
//        scanf("%d%d%d",&start,&finish,&weight);
//        g.a[start][finish]=weight;
//        g.a[finish][start]=weight;
//    }
//}
//int minq(Un u,int num)
//{
//    int y,w=INI;
//    int i;
//    for(i=1;i<=num;++i)
//    {
//        if(u[i].q!=0 && u[i].q<w)
//        {
//            w=u[i].q;
//            y=i;
//        }
//
//    }
//    return y;
//}
//void Prim(Graph g,int head)
//{
//    Un u;
//    int i,j,k;
//    printf("最小生成树：\n");
//    for(i=1;i<=g.m;++i)
//    {
//        if(i!=head)
//        {
//            u[i].d=head;
//            u[i].q=g.a[head][i];
//        }
//    }
//    u[head].q=0;
//    for(i=1;i<g.m;++i)
//    {
//        k=minq(u,g.m);
//        printf("%d %d\n",u[k].d,k);
//        u[k].q=0;
//        for(j=1;j<=g.m;++j)
//            if(g.a[k][j]<u[j].q)
//        {
//            u[j].d=k;
//            u[j].q=g.a[k][j];
//        }
//    }
//}
//int main()
//{
//    Graph g;
//    int x;
//    printf("输入顶点数及边数：");
//    scanf("%d%d",&g.m,&g.n);
//    if(g.n>(g.m*(g.m-1)/2))
//    {
//        printf("error!");
//        return 0;
//    }
//    Create_Graph(g);
//    printf("输入最小生成树的起点：");
//    scanf("%d",&x);
//    Prim(g,x);
//    return 0;
//}

//dijkstra求最短路径
#include <stdio.h>
#include <stdlib.h>
#define INI 30000
#define NUM 20
enum BOOL {False,True};
typedef struct graph
{
	int a[NUM][NUM];
	int m,n;
}Graph;
void Create_Graph(Graph &G)
{
	int i,j;
	int start,finish,weight;
	printf("请输入图的顶点数和弧数:");
	scanf("%d %d",&G.m,&G.n);
	for(i=1;i<=G.m;i++)
		for(j=1;j<=G.m;j++)
			G.a[i][j]=INI;
	printf("输入起点，终点，权值\n");
	for(i=1;i<=G.n;i++)
	{
		scanf("%d %d %d",&start,&finish,&weight);
		G.a[start][finish]=weight;
	}
}
void ShortestPath(Graph G,int v0,int P[][NUM],int D[])
{
	int i,j,w,v;
	int mini;
	BOOL final[NUM];
	for(v=1;v<=G.m;v++)
	{
		final[v]=False;
		D[v]=G.a[v0][v];
		for(i=0;i<=G.m;i++)
			P[v][i]=0;
	}
	D[v0]=0;
	final[v0]=True;
	for(i=1;i<=G.m;i++)
	{
		v=0;
		mini=INI;
		for(w=1;w<=G.m;w++)
		if((!final[w])&&(D[w]<mini))
		{
			v=w;
			mini=D[w];
        }
        if(!v)
            break;
		final[v]=True;
		for(j=0;P[v][j]!=0;j++);
			P[v][j]=v;
		for(w=1;w<=G.m;w++)
			if(!final[w]&&(mini+G.a[v][w]<D[w]))
			{
				D[w]=mini+G.a[v][w];
				for(j=0;P[v][j]!=0;j++)
					P[w][j]=P[v][j];
			}
	}
}
void Print_ShortestPath(Graph G,int v0,int P[][NUM],int D[])
{
	int v,j;
	for(v=1;v<=G.m;v++)
	{
		if(P[v][0]==0) continue;
		printf("%-4d",D[v]);
		printf("%d->",v0);
		for(j=0;P[v][j]!=0;j++)
		printf("%d->",P[v][j]);
		printf("\b\b  \n");
	}
}
int main()
{
	Graph G;
	int u;
	int P[NUM][NUM];
	int D[NUM];
    Create_Graph(G);
    printf("从哪个顶点出发:");
	scanf("%d",&u);
    ShortestPath(G,u,P,D);
    Print_ShortestPath(G,u,P,D);
	return 0;
}










//#include<stdio.h>
//#define MAX  100000
//#define VNUM  10+1                                             //这里没有ID为0的点,so id号范围1~10
//
//int edge[VNUM][VNUM]={/*输入的邻接矩阵*/};
//int lowcost[VNUM]={0};                                         //记录Vnew中每个点到V中邻接点的最短边
//int addvnew[VNUM];                                             //标记某点是否加入Vnew
//int adjecent[VNUM]={0};                                        //记录V中与Vnew最邻近的点
//
//
//void prim(int start)
//{
//     int sumweight=0;
//     int i,j;
//
//     for(i=1;i<VNUM;i++)                                      //顶点是从1开始
//     {
//        lowcost[i]=edge[start][i];
//        addvnew[i]=-1;                                         //将所有点至于Vnew之外,V之内，这里只要对应的为-1，就表示在Vnew之外
//     }
//
//     addvnew[start]=0;                                        //将起始点start加入Vnew
//     adjecent[start]=start;
//
//     for(i=1;i<VNUM-1;i++)
//     {
//        int min=MAX;
//        int v=-1;
//        for(j=1;j<VNUM;j++)
//        {
//            if(addvnew[j]!=-1&&lowcost[j]<min)                 //在Vnew之外寻找最短路径
//            {
//                min=lowcost[j];
//                v=j;
//            }
//        }
//        if(v!=-1)
//        {
//            printf("%d %d %d\n",adjecent[v],v,lowcost[v]);
//            addvnew[v]=0;                                      //将v加Vnew中
//
//            sumweight+=lowcost[v];                             //计算路径长度之和
//            for(j=1;j<VNUM;j++)
//            {
//                if(addvnew[j]==-1&&edge[v][j]<lowcost[j])
//                {
//                    lowcost[j]=edge[v][j];                     //此时v点加入Vnew 需要更新lowcost
//                    adjecent[j]=v;
//                }
//            }
//        }
//    }
//    printf("the minmum weight is %d",sumweight);
//}
//int main()
//{
//    int a=5;
//    prim(a);
//    return 0;
//}
