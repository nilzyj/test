#include <iostream>
using namespace std;
#define MAX 100
int Num[18]={22,12,13,8,9,20,33,42,44,38,24,48,60,58,74,49,86,53};
struct Index
{
    int Max;
    int num;
};
Index index[3]={{22,1},{48,7},{86,13}};

int compare(int left,int right,int number)
{
    int center;
    if(left==right)
        return index[right].num;
    center=(left+right)/2;
    if(number>=index[left].Max && number<=index[center].Max)
        return compare(left,center,number);
    else if(number<=index[left].Max)
        return 1;
    else
        return compare(center+1,right,number);
}

int Find(int left,int right,int number)
{
    for(int i=left;i<=right;i++)
    {
        if(number==Num[i])
            return i;
    }
    return 999;
}
int main()
{
    return 0;
}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define HashMaxSize  43
#define NullTag  -1

struct ElemType{
	int key ;
	char name[20];
};


typedef struct ElemType hashlistl[HashMaxSize];//定义哈希表结构体

typedef int KeyType;


int H(KeyType key ,int m)//对关键字取余
{
	return key%m;
}

void InitHashList(hashlistl HT)  /* 把散列表HT中的每一单元的关键字key域都置为空标志*/  // 初始化散列表

{
	int i ;
    for  (i=0;i<HashMaxSize; i++)
    HT[i].key=NullTag;//-1为空
}



int Insert(hashlistl HT,int m , struct ElemType x) /*向长度为m的散列表HT中插入一个元素x */   // 向散列表插入一个元素

{
	/*可选用任一种合适的构造散列函数的方法来计算散列地址*/
	int d=H(x.key,m);//对关键字取余
	//用temp变量暂存散列地址
	int temp =d ;
	// 用线性探查法处理冲突
	while (HT[d].key!=NullTag)
	{
		d=(d+1)%m;
		if (d==temp){
			printf("散列表的空间已被占满，应重建！\n");
			return 0; // 返回0表示插入失败

		}
	}
	/*将新元素插入到下标为d的位置，接着返回1表示插入成功*/
	HT[d]=x ;
	return 1;
}


int Search(hashlistl HT, int m, char k[])// 从散列表中查找一个元素
/*从长度为m的散列表HT中查找关键字为K的一个元素*/
{
    int y=(char)k[0];
	int d = H(y,m);
	int temp =d;
	while (HT[d].key!=NullTag)
	{ // 当散列地址中的关键字域不为空则循环
		if(strcmp(HT[d].name,k)==0)
			return d;  // 查找成功返回下标d
		else
			d=(d+1)%m;
		if(d==temp) return -1 ; // 查找失败返回-1
	}
	return -1;
}


void PrintHashList(hashlistl HT , int m)
{
	int i ;
	printf ("散列表为：");
	for (i=0; i <m ; i++)
    {
        if(HT[i].key!=-1)
           printf("%s ",HT[i].name);
        else
            printf("NULL ");

    }

	printf("\n");
}


int main()
{
	int n,m,i,j,r;
	struct ElemType x;
	char e[40];
	hashlistl ht;
	InitHashList(ht);

	printf("从键盘输入待散列元素的个数n和散列长度m：");

	do{
		scanf("%d%d", &n,&m);
		if(n>m||m>HashMaxSize) printf("重输入n和m值：");
	}while(n>m||m>HashMaxSize);

	printf("从键盘向散列表输入%d个元素的关键字：\n",n);
	for(i=0;i<n;i++){
		scanf ("%s",&x.name);
		x.key=(int)x.name[0];
		Insert(ht,m,x);

	}
	PrintHashList(ht , m);

	printf("从键盘输入一个关键字进行查找：");
	scanf("%s",&e);
	r = Search(ht,m,e);
	if(r==-1)
		printf("不存在你要查找的元素\n");
	else
		printf("在第%d个位置找到\n",r+1);
}

