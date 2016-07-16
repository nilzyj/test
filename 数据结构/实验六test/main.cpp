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
//ð��***********************************************
void BubbleSort(SqList &);
//ð��***********************************************
//����***********************************************
void QuickSort(SqList &);
void QSort(SqList &,int,int);
int  Partition(SqList &,int,int);
//����***********************************************
//ϣ��***********************************************
void ShellSort(SqList &,int [],int);
void ShellInsert(SqList&,int);
//ϣ��***********************************************
//��***********************************************
void HeapSort(SqList &);
void HeapAdjust(SqList &,int,int);
//��***********************************************
//�鲢***********************************************
void MergeSort(SqList &);
void MSort(int [],int [],int,int);
void Merge(int [],int [],int,int,int);
//�鲢***********************************************
int main()
{
    SqList L;
	clock_t t1;

    InitialSqList(L);
    printf("2000�������\n");
	printf("ð������:");
	t1=clock();
    BubbleSort(L);
    //PrintSqList(L);
	printf("%d\n",clock()-t1);

    printf("��������:");
	t1=clock();
    QuickSort(L);
    //PrintSqList(L);
	printf("%d\n",clock()-t1);

	printf("ϣ������:");
	int dlta[3]={5,3,1};
	int t=3;
	t1=clock();
	ShellSort(L,dlta,t);
	//PrintSqList(L);
	printf("%d\n",clock()-t1);

	printf("������:");
	t1=clock();
    HeapSort(L);
    //PrintSqList(L);
	printf("%d\n",clock()-t1);

	printf("�鲢����:");
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

//ð��***********************************************
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
//ð��***********************************************
//����***********************************************
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
//����***********************************************
//ϣ��***********************************************
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
//ϣ��***********************************************
//��***********************************************
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
//��***********************************************
//�鲢***********************************************
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
//�鲢***********************************************


/*//* * * * * * * * * * * * * * * * * * * * * * * *
//*CHAPTER          :5  (5_5)                   *
//*PROGRAM          :���·��                   *
//*CONTENT          :�Ͻ�˹�����㷨             *
//* * * * * * * * * * * * * * * * * * * * * * * *
#include <dos.h>
#include <conio.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define INFINITY 30000    //����һ��Ȩֵ�����ֵ
#define MAX_VERTEX_NUM 20 //ͼ����󶥵���
enum BOOL {False,True};
typedef struct
{
	int arcs[MAX_VERTEX_NUM][MAX_VERTEX_NUM]; //�ڽӾ���
	int vexnum,arcnum;                //ͼ�ĵ�ǰ����ͱ���
}Graph;

void CreateGraph(Graph &);    //����ͼ���ڽӾ���
void ShortestPath_DiJ(Graph,int,int[][MAX_VERTEX_NUM],int[]);
    //�õϽ�˹�����㷨���ĳһԴ�㵽���ඥ������·��
void Print_ShortestPath(Graph,int,int[][MAX_VERTEX_NUM],int[]);//��ʾ���·��

void main()
{
	Graph G;  //�����ڽӾ���ṹ��ͼ
	char j='y';
	int u;
	int P[MAX_VERTEX_NUM][MAX_VERTEX_NUM]; //��Ŵ�Դ�㵽����������·��
	int D[MAX_VERTEX_NUM];                 //��Ŵ�Դ�㵽����������·���ľ���
//	textbackground(3);  //�趨��Ļ��ɫ
//	textcolor(15);
//	clrscr();
 //------------------�����˵----------------------------
	printf("��������ʾ���õϽ�˹�����㷨��\n��ͼ��һ�㵽���ඥ������·��.\n");
	printf("��������ͼ�Ķ������ͻ���.\n��ʽ��������������������:5,7\n");
	printf("Ȼ�����������Ȩֵ.\n��ʽ����β����ͷ��Ȩֵ������:\n1,2,10\n1,3,18\n2,4,5\n3,2,5\n4,3,2\n4,5,2\n5,3,2\n");
	printf("��������ĸ��������������:1\n");
	printf("���򽫻��ҳ���1�����ඥ������·��.\n");
	printf("10  1->2\n17  1->2->4->3\n15  1->2->4\n17  1->2->4->5\n");
 //------------------------------------------------------
	while(j!='N'&&j!='n')
	{
		CreateGraph(G);       //�����ڽӾ���ṹ��ͼ
		printf("���ĸ��������:");
		scanf("%d",&u);  //����Ͻ�˹�����㷨�е���ʼ����

		ShortestPath_DiJ(G,u,P,D); //���õϽ�˹�����㷨�����·��

		Print_ShortestPath(G,u,P,D); //��ʾ���·��
		printf("���·����ʾ��ϣ�����������?(Y/N)");
		scanf(" %c",&j);
	}
}

void CreateGraph(Graph &G)
{//�����ڽӾ���ṹ��ͼG
	int i,j;
	int start,end,weight;
	printf("������ͼ�Ķ������ͻ���(������������):");
	scanf("%d,%d",&G.vexnum,&G.arcnum); //����ͼ�Ķ������ͱ���
	for(i=1;i<=G.vexnum;i++)
		for(j=1;j<=G.vexnum;j++)
			G.arcs[i][j]=INFINITY; //��ʼ���ڽӾ���
	printf("���������Ȩֵ����ʽ����β����ͷ��Ȩֵ\n");
	for(i=1;i<=G.arcnum;i++)
	{
		scanf("%d,%d,%d",&start,&end,&weight); //����ߵ������յ㼰Ȩֵ
		G.arcs[start][end]=weight;
	}
}
void ShortestPath_DiJ(Graph G,int v0,int P[][MAX_VERTEX_NUM],int D[])
{//�õϽ�˹�����㷨��������G��v0���㵽���ඥ��v�����·��P[v]�����Ȩ·������D[v]
 //��P[v][0]��0,������Դ���������һ��������v�����·������·�������P[v]��
 //final[v]ΪTrue������Ѿ��ҵ���v0��v�����·��
	int i,j,w,v;
	int min;
	BOOL final[MAX_VERTEX_NUM];
	for(v=1;v<=G.vexnum;v++)   //��ʼ��
	{
		final[v]=False; D[v]=G.arcs[v0][v];
		for(i=0;i<=G.vexnum;i++)
			P[v][i]=0; //���·��
    //if(D[v]<INFINITY) P[v][0]=v0; //����v0��v��ֱ��·��
	}
	D[v0]=0; final[v0]=True; //��ʼʱ��v0����S��
 //��ʼ��ѭ����ÿ�����v0��ĳ������v�����·��������v��S��
	for(i=1;i<=G.vexnum;i++)  //Ѱ������G.vexnum-1������
	{
		v=0;
		min=INFINITY;
		for(w=1;w<=G.vexnum;w++)   //Ѱ�ҵ�ǰ��v0����Ķ���v
		if((!final[w])&&(D[w]<min))
		{
			v=w;min=D[w];}
			if(!v) break;  //��v=0����������v0��ͨ·�Ķ�������ҵ������·�����˳���ѭ��
			final[v]=True; //��v����S��
			for(j=0;P[v][j]!=0;j++) ;
				P[v][j]=v;     //��·��P[v]���쵽����v
			for(w=1;w<=G.vexnum;w++) //���µ�ǰ���·��������
				if(!final[w]&&(min+G.arcs[v][w]<D[w]))
				{
					D[w]=min+G.arcs[v][w];
					for(j=0;P[v][j]!=0;j++)
						P[w][j]=P[v][j];
				}
	}
}

void Print_ShortestPath(Graph G,int v0,int P[][MAX_VERTEX_NUM],int D[])
{//��ʾ�Ӷ���u�����ඥ������·��������
	int v,j;
	printf("The shortest path from Vertex %d to the other Vertex:\n");
	for(v=1;v<=G.vexnum;v++)
	{
		if(P[v][0]==0) continue; //��������v0������vû��ͨ·
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
    printf("������㣬�յ㣬Ȩֵ��");
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
    printf("��С��������\n");
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
    printf("���붥������������");
    scanf("%d%d",&g.m,&g.n);
    if(g.n>(g.m*(g.m-1)/2))
    {
        printf("error!");
        return 0;
    }
    Create_Graph(g);
    printf("������С����������㣺");
    scanf("%d",&x);
    Prim(g,x);
    return 0;
}*/


/*
//* * * * * * * * * * * * * * * * * * * * * * * *
//*CHAPTER          :5  (5_2)                   *
//*PROGRAM          :��С����������             *
//*CONTENT          :����ķ�㷨                 *
//* * * * * * * * * * * * * * * * * * * * * * * *
#include <dos.h>
#include <conio.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define INFINITY 30000    //����һ��Ȩֵ�����ֵ
#define MAX_VERTEX_NUM 20 //ͼ����󶥵���
typedef struct
{
	int arcs[MAX_VERTEX_NUM][MAX_VERTEX_NUM]; //�ڽӾ���
	int vexnum,arcnum;                //ͼ�ĵ�ǰ����ͱ���
}Graph;

typedef struct
{
	int adjvex;  //ĳ�������ѹ���õĲ����������Ķ���֮��Ȩֵ��С�Ķ���
	int lowcost; //ĳ�������ѹ���õĲ����������Ķ���֮�����СȨֵ
}ClosEdge[MAX_VERTEX_NUM]; //������ķ�㷨����С������ʱ�ĸ�������
void CreateGraph(Graph &);    //����ͼ���ڽӾ���
void MiniSpanTree_PRIM(Graph,int); //������ķ�㷨����С������
int  minimum(ClosEdge,int); //������ķ�㷨������һ�����
int main()
{
	Graph G;  //�����ڽӾ���ṹ��ͼ
	char j='y';
	int u;
// textbackground(3);  //�趨��Ļ��ɫ
// textcolor(15);
// clrscr();
 //------------------�����˵----------------------------
	printf("��������ʾ����ͼ����С������������\n");
	printf("��������ͼ�Ķ������ͻ���.\n��ʽ��������������������:4,4\n");
	printf("�������������(��β,��ͷ)�ͻ���Ȩֵ��\n");
	printf("��ʽ:��β����ͷ��Ȩֵ������\n1,2,1\n1,3,2\n2,4,3\n3,4,4\n");
	printf("���򽫻ṹ���ͼ����С������������\n");
	printf("����ʾ����С��������\n1,2\n1,3\n2,4\n");
 //------------------------------------------------------
	while(j!='N'&&j!='n')
	{
		printf("������ͼ�Ķ���ͻ���:");
		scanf("%d,%d",&G.vexnum,&G.arcnum); //����ͼ�Ķ������ͱ���
		CreateGraph(G);       //�����ڽӾ���ṹ��ͼ
		printf("����һ���㿪ʼ:");
		scanf("%d",&u);  //��������ķ�㷨�е���ʼ����
		MiniSpanTree_PRIM(G,u); //����ķ�㷨����С������
		printf("��С����������������ϣ�����������?(Y/N)");
		scanf(" %c",&j);
    }
}

void CreateGraph(Graph &G)
{//�����ڽӾ���ṹ��ͼG
	int i,j;
	int start,end,weight;
	for(i=1;i<=G.vexnum;i++)
		for(j=1;j<=G.vexnum;j++)
			G.arcs[i][j]=INFINITY; //��ʼ���ڽӾ���
	printf("���뻡����Ȩֵ����ʽ����β����ͷ��Ȩֵ\n");
	for(i=1;i<=G.arcnum;i++)
	{
		scanf("%d,%d,%d",&start,&end,&weight); //����ߵ������յ㼰Ȩֵ
		G.arcs[start][end]=weight;
		G.arcs[end][start]=weight;
	}
}
void MiniSpanTree_PRIM(Graph G,int u)
{//�ӵ�u�������������ͼG����С������
	ClosEdge closedge;
	int i,j,k;
	printf("��С����������:\n");
	for(j=1;j<=G.vexnum;j++) //���������ʼ��
		if(j!=u)
		{
			closedge[j].adjvex=u;
			closedge[j].lowcost=G.arcs[u][j];
		}

	closedge[u].lowcost=0; //��ʼ��U={u}
	for(i=1;i<G.vexnum;i++) //ѡ�������G.vexnum-1������
	{
		k=minimum(closedge,G.vexnum); //�������������һ������
		printf("%d,%d\n",closedge[k].adjvex,k); //����������ı�
		closedge[k].lowcost=0;   //��k���㲢��U��
		for(j=1;j<=G.vexnum;j++) //�¶��㲢��U������ѡ����С��
			if(G.arcs[k][j]<closedge[j].lowcost)
			{
				closedge[j].adjvex=k;
				closedge[j].lowcost=G.arcs[k][j];
			}
    }
}
int minimum(ClosEdge cl,int vnum)
{//�ڸ�������cl[vnum]��ѡ��Ȩֵ��С�Ķ��㣬��������λ��
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
#define VNUM  10+1                                             //����û��IDΪ0�ĵ�,so id�ŷ�Χ1~10

int edge[VNUM][VNUM]={};//������ڽӾ���
int lowcost[VNUM]={0};                                         //��¼Vnew��ÿ���㵽V���ڽӵ����̱�
int addvnew[VNUM];                                             //���ĳ���Ƿ����Vnew
int adjecent[VNUM]={0};                                        //��¼V����Vnew���ڽ��ĵ�


void prim(int start)
{
     int sumweight=0;
     int i,j;

     for(i=1;i<VNUM;i++)                                      //�����Ǵ�1��ʼ
     {
        lowcost[i]=edge[start][i];
        addvnew[i]=-1;                                         //�����е�����Vnew֮��,V֮�ڣ�����ֻҪ��Ӧ��Ϊ-1���ͱ�ʾ��Vnew֮��
     }

     addvnew[start]=0;                                        //����ʼ��start����Vnew
     adjecent[start]=start;

     for(i=1;i<VNUM-1;i++)
     {
        int min=MAX;
        int v=-1;
        for(j=1;j<VNUM;j++)
        {
            if(addvnew[j]!=-1&&lowcost[j]<min)                 //��Vnew֮��Ѱ�����·��
            {
                min=lowcost[j];
                v=j;
            }
        }
        if(v!=-1)
        {
            printf("%d %d %d\n",adjecent[v],v,lowcost[v]);
            addvnew[v]=0;                                      //��v��Vnew��

            sumweight+=lowcost[v];                             //����·������֮��
            for(j=1;j<VNUM;j++)
            {
                if(addvnew[j]==-1&&edge[v][j]<lowcost[j])
                {
                    lowcost[j]=edge[v][j];                     //��ʱv�����Vnew ��Ҫ����lowcost
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
void max_test(int a,int b)//���Լ��
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
void min_test(int a,int b)//��С������
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
//    printf("���뾫��:");
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
//    printf("���Ϊ��%lf",a);
//    return 0;
//}ûд����

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
//	printf("input radius��");
//	scanf("%f",&r);
//	printf("���Ϊ:%f,�ܳ�Ϊ:%f",circumference(r),square(r));
//	return 0;
//}
