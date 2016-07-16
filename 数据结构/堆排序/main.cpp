//* * * * * * * * * * * * * * * * * * * * * * * *
//*CHAPTER          :7  (7_6)                   *
//*PROGRAM          :������                     *
//*CONTENT          :������                     *
//* * * * * * * * * * * * * * * * * * * * * * * *
#include <dos.h>
#include <conio.h>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 20 //�������������
typedef struct           //���������Ľṹ
{
    int  elemword[MAXSIZE]; //����Ԫ�عؼ���
    int length;            //���е�ǰԪ�صĸ���
}SqList;
void InitialSqList(SqList&);       //��ʼ�������
void HeapSort(SqList &);           //������
void HeapAdjust(SqList &,int,int); //�ѵ���
void PrintSqList(SqList);          //��ʾ���е�����Ԫ��
int main()
{
    SqList L;  //������L
    char j='y';
// textbackground(3);  //�趨��Ļ��ɫ
// textcolor(15);
// clrscr();
 //-------------------------����˵��-------------------------------
    printf("��������ʾ������Ĳ�����\n");
 //----------------------------------------------------------------
    while(j!='n'&&j!='N')
    {
        InitialSqList(L);    //�������г�ʼ��
        HeapSort(L);         //������
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
    scanf("%d",&L.length);
    printf("�����������ļ�¼�Ĺؼ���(������):\n");
    for(i=1;i<=L.length;i++)
        scanf("%d",&L.elemword[i]);
}
void HeapSort(SqList &L)
{//��˳���L��������
    int i,j,t;
    for(i=L.length/2;i>0;--i)   //��L.elemword[1..L.length]���ɴ󶥶�
        HeapAdjust(L,i,L.length);
    for(i=L.length;i>1;--i)
    {
        t=L.elemword[1];             //���Ѷ���¼�͵�ǰδ������������L.elemword[1..i]
        L.elemword[1]=L.elemword[i]; //�е����һ����¼�໥����
        L.elemword[i]=t;
        HeapAdjust(L,1,i-1);         //��L.r[1..i-1]���µ���Ϊ�󶥶�
    }
}
void HeapAdjust(SqList &H,int s,int m)
{//��֪H.elemword[s..m]�г�H.elemword[s]֮�������ѵĶ���,����������H.elemword[s]
 //ʹH.elemword[s..m]��Ϊһ���󶥶�
    int j,rc;
    rc=H.elemword[s];
    for(j=2*s;j<=m;j*=2)     //�عؼ��ֽд�Ľ������ɸѡ
    {
        if(j<m&&H.elemword[j]<H.elemword[j+1]) ++j; //jΪ�ؼ��ֽϴ�ļ�¼���±�
            if(rc>=H.elemword[j])
                break;    //rcӦ������λ��s��
        H.elemword[s]=H.elemword[j];
        s=j;
    }
    H.elemword[s]=rc;  //����
}
void PrintSqList(SqList L)
{//��ʾ��������Ԫ��
    int i;
    printf("���ź�����������£�\n");
    for(i=1;i<=L.length;i++)
        printf("%4d",L.elemword[i]);
    printf("\n");
}
