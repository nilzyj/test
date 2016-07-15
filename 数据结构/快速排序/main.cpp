//* * * * * * * * * * * * * * * * * * * * * * * *
//*CHAPTER          :7  (7_4)                   *
//*PROGRAM          :��������                   *
//*CONTENT          :��������                   *
//* * * * * * * * * * * * * * * * * * * * * * * *
#include <dos.h>
#include <conio.h>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 20 //�������������
typedef struct           //���������Ľṹ
{
    int elemword[MAXSIZE]; //����Ԫ�عؼ���
    int Count;            //���е�ǰԪ�صĸ���
}SqList;
void InitialSqList(SqList&);        //��ʼ�������
void QuickSort(SqList &);           //��������
void QSort(SqList &,int,int);       //�����п�������
int  Partition(SqList &,int,int);   //һ�˿�������
void PrintSqList(SqList);           //��ʾ���е�����Ԫ��
int main()
{
    SqList L;  //������L
    char j='y';
    //textbackground(3);  //�趨��Ļ��ɫ
    //textcolor(15);
    //clrscr();
 //-------------------------����˵��-------------------------------
    printf("��������ʾ��������Ĳ�����\n");
 //----------------------------------------------------------------
    while(j!='n'&&j!='N')
    {
        InitialSqList(L);    //�������г�ʼ��
        QuickSort(L);        //��������
        PrintSqList(L);      //��ʾ������
        printf("����������һ��������?(Y/N)");
        scanf(" %c",&j);
    }
    printf("�������н���!\n��������رմ���!\n");
    getchar();getchar();
    return 0;
}
void InitialSqList(SqList &L)
{//���ʼ��
    int i;
    printf("�����������ļ�¼�ĸ���:");
    scanf("%d",&L.Count);
    printf("�����������ļ�¼�Ĺؼ���(������):\n");
    for(i=1;i<=L.Count;i++)
        scanf("%d",&L.elemword[i]);
}
void QuickSort(SqList &L)
{//��˳���L����������
    QSort(L,1,L.Count);
}
void QSort(SqList &L,int low,int high)
{//��˳����е�������L.r[low..high]����������
    int pivotloc;
    if(low<high)         //���ȴ���1
    {
        pivotloc=Partition(L,low,high); //��L.elemword[low..high]һ��Ϊ��
        QSort(L,low,pivotloc-1);        //�Ե��ӱ�ݹ�����,pivotloc������λ��
        QSort(L,pivotloc+1,high);       //�Ը��ӱ�ݹ�����
    }
}
int Partition(SqList &L,int low,int high)
{//����˳���L���ӱ�r[low..high]�ļ�¼�������¼��λ��������������λ�ã���ʱ
 //����֮ǰ(��)�ļ�¼������(С)����
    int pivotkey;
    pivotkey=L.elemword[low]; //���ӱ�ĵ�һ����¼�������¼
    while(low<high)      //�ӱ�����˽�������м�ɨ��
    {
        while(low<high && L.elemword[high]>=pivotkey)
            --high;
        L.elemword[low]=L.elemword[high];//���������¼С�ļ�¼�Ƶ��Ͷ�
        while(low<high && L.elemword[low]<=pivotkey)
            ++low;
        L.elemword[high]=L.elemword[low]; //���������¼��ļ�¼�Ƶ��߶�
    }
    L.elemword[low]=pivotkey;  //�����¼��λ
    return low;                //���������¼
}
void PrintSqList(SqList L)
{//��ʾ��������Ԫ��
    int i;
    printf("���ź�����������£�\n");
    for(i=1;i<=L.Count;i++)
        printf("%4d",L.elemword[i]);
    printf("\n");
}
