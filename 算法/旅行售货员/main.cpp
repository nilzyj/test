#include<stdio.h>
#include<conio.h>
#define N 8
int jz[N][N]=
{
{0,12,14,8,32,23,21,10},
{12,0,54,4,7,63,34,15},
{14,54,0,90,9,43,13,31},
{8,4,90,0,87,44,55,66},
{32,7,9,87,0,30,29,28},
{23,63,43,44,30,0,85,58},
{21,34,13,55,29,85,0,3},
{10,15,31,66,28,58,3,0}
};
char a[N]={'A','B','C','D','E','F','G','H'};
int b[N]={0,1,2,3,4,5,6,7};
int sum=9999;
int temp[N];

int is_smaller()
{
    int add=0;
    int i;
    int m,n;
    for(i=0;i<N-1;i++)
    {
        m=b[i];
        n=b[i+1];
        add+=jz[m][n];
    }
    m=b[N-1];
    n=b[0];
    add+=jz[m][n];
    if(add<sum)
    {
        sum=add;
        return 1;
    }
    return 0;
}
void swap(int t1,int t2)
{
    int t;
    t=b[t1];
    b[t1]=b[t2];
    b[t2]=t;
}
void tr(int t)
{
    int j;
    int i;
    if(t>=N)
    {
        if(is_smaller())
        {
            for(i=0;i<N;i++)
                temp[i]=b[i];
        }
    }
    else
    {
        for(j=t;j<N;j++)
        {
            swap(t,j);
            tr(t+1);
            swap(t,j);
        }
    }
}


int main()
{
    int i;
    int m;
    tr(1);
    for(i=0;i<N;i++)
    {
        m=temp[i];
        printf("%c",a[m]);
    }
    printf("A");
    printf("\n");
    getch();
    return 0;
}

