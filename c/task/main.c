



#include<stdio.h>
#define N 1000
struct element
{
    int num;//���
    char name[10];//����
    int wage;//����
    int award;//����
    int insure;//����
    int fact;//ʵ������
}a[N];
int main()
{
    int n,i,j;
    int b[N];
    printf("����Ա��������");
    scanf("%d",&n);
//    for(i=0;i<n;++i)
//    {
//        printf("����Ա���ı�ţ�");
//        scanf("%d",&a[i].num);
//        printf("������Ϊ%d��Ա����������",a[i].num);
//        getchar();
//        gets(a[i].name);
//        printf("������Ϊ%d��Ա���Ĺ��ʣ�",a[i].num);
//        scanf("%d",&a[i].wage);
//        printf("������Ϊ%d��Ա���Ľ���",a[i].num);
//        scanf("%d",&a[i].award);
//        printf("������Ϊ%d��Ա���ı��գ�",a[i].num);
//        scanf("%d",&a[i].insure);
//    }
    for(i=0;i<n;++i)
            a[i].fact=a[i].wage+a[i].award-a[i].insure;
    for(i=0;i<n;++i)
    {
        printf("���Ϊ%d��Ա����ʵ������Ϊ��%d\n",a[i].num,a[i].fact);
    }
    return 0;
}





//#include <stdio.h>
//int main()
//{
//    int *p,*q,*t,a,b,c;
//    int *temp;
//    scanf("%d%d%d",&a,&b,&c);
//    p=&a;
//    q=&b;
//    t=&c;
//    if(*p>*q)
//    {
//        temp=p;
//        p=q;
//        q=temp;
//    }
//    if(*p>*t)
//    {
//        temp=p;
//        p=t;
//        t=temp;
//    }
//    if(*q>*t)
//    {
//        temp=q;
//        q=t;
//        t=temp;
//    }
//    printf("%d %d %d",*p,*q,*t);
//    return 0;
//}