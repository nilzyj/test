



#include<stdio.h>
#define N 1000
struct element
{
    int num;//编号
    char name[10];//姓名
    int wage;//工资
    int award;//奖金
    int insure;//保险
    int fact;//实发工资
}a[N];
int main()
{
    int n,i,j;
    int b[N];
    printf("输入员工人数：");
    scanf("%d",&n);
//    for(i=0;i<n;++i)
//    {
//        printf("输入员工的编号：");
//        scanf("%d",&a[i].num);
//        printf("输入编号为%d的员工的姓名：",a[i].num);
//        getchar();
//        gets(a[i].name);
//        printf("输入编号为%d的员工的工资：",a[i].num);
//        scanf("%d",&a[i].wage);
//        printf("输入编号为%d的员工的奖金：",a[i].num);
//        scanf("%d",&a[i].award);
//        printf("输入编号为%d的员工的保险：",a[i].num);
//        scanf("%d",&a[i].insure);
//    }
    for(i=0;i<n;++i)
            a[i].fact=a[i].wage+a[i].award-a[i].insure;
    for(i=0;i<n;++i)
    {
        printf("编号为%d的员工的实发工资为：%d\n",a[i].num,a[i].fact);
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
