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


typedef struct ElemType hashlistl[HashMaxSize];//�����ϣ��ṹ��

typedef int KeyType;


int H(KeyType key ,int m)//�Թؼ���ȡ��
{
	return key%m;
}

void InitHashList(hashlistl HT)  /* ��ɢ�б�HT�е�ÿһ��Ԫ�Ĺؼ���key����Ϊ�ձ�־*/  // ��ʼ��ɢ�б�

{
	int i ;
    for  (i=0;i<HashMaxSize; i++)
    HT[i].key=NullTag;//-1Ϊ��
}



int Insert(hashlistl HT,int m , struct ElemType x) /*�򳤶�Ϊm��ɢ�б�HT�в���һ��Ԫ��x */   // ��ɢ�б����һ��Ԫ��

{
	/*��ѡ����һ�ֺ��ʵĹ���ɢ�к����ķ���������ɢ�е�ַ*/
	int d=H(x.key,m);//�Թؼ���ȡ��
	//��temp�����ݴ�ɢ�е�ַ
	int temp =d ;
	// ������̽�鷨�����ͻ
	while (HT[d].key!=NullTag)
	{
		d=(d+1)%m;
		if (d==temp){
			printf("ɢ�б�Ŀռ��ѱ�ռ����Ӧ�ؽ���\n");
			return 0; // ����0��ʾ����ʧ��

		}
	}
	/*����Ԫ�ز��뵽�±�Ϊd��λ�ã����ŷ���1��ʾ����ɹ�*/
	HT[d]=x ;
	return 1;
}


int Search(hashlistl HT, int m, char k[])// ��ɢ�б��в���һ��Ԫ��
/*�ӳ���Ϊm��ɢ�б�HT�в��ҹؼ���ΪK��һ��Ԫ��*/
{
    int y=(char)k[0];
	int d = H(y,m);
	int temp =d;
	while (HT[d].key!=NullTag)
	{ // ��ɢ�е�ַ�еĹؼ�����Ϊ����ѭ��
		if(strcmp(HT[d].name,k)==0)
			return d;  // ���ҳɹ������±�d
		else
			d=(d+1)%m;
		if(d==temp) return -1 ; // ����ʧ�ܷ���-1
	}
	return -1;
}


void PrintHashList(hashlistl HT , int m)
{
	int i ;
	printf ("ɢ�б�Ϊ��");
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

	printf("�Ӽ��������ɢ��Ԫ�صĸ���n��ɢ�г���m��");

	do{
		scanf("%d%d", &n,&m);
		if(n>m||m>HashMaxSize) printf("������n��mֵ��");
	}while(n>m||m>HashMaxSize);

	printf("�Ӽ�����ɢ�б�����%d��Ԫ�صĹؼ��֣�\n",n);
	for(i=0;i<n;i++){
		scanf ("%s",&x.name);
		x.key=(int)x.name[0];
		Insert(ht,m,x);

	}
	PrintHashList(ht , m);

	printf("�Ӽ�������һ���ؼ��ֽ��в��ң�");
	scanf("%s",&e);
	r = Search(ht,m,e);
	if(r==-1)
		printf("��������Ҫ���ҵ�Ԫ��\n");
	else
		printf("�ڵ�%d��λ���ҵ�\n",r+1);
}

