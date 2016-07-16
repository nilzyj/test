




#include<iostream>
#include<conio.h>
using namespace std;

int a[8]={0};

void print()//输出每一种情况下棋盘中皇后的摆放情况
{
    for(int i=0;i<8;i++)
    {
        for(int j=0;j<a[i];j++)
            cout<<"o";
        cout<<"1";
        for(int j=a[i]+1;j<8;j++)
            cout<<"o";
        cout<<endl;
    }
    cout<<"*********************************\n";
}

int check(int m,int n)//检查是否存在有多个皇后在同一行/列/对角线的情况
{
    int i;
    int s;
    for(i=0;i<m;i++)
    {
        s=a[i];
        if(n==s)
            return 0;
        if((i+s)==(m+n))
            return 0;
        if((i-s)==(m-n))
            return 0;
    }
    return 1;
}

void eight_queen(int m)
{
    int i;
    for(i=0;i<8;i++)
    {
        if(check(m,i))//没有多个皇后在同一行/列/对角线
        {
            a[m]=i;
            if(7==m)
            {
                print();
                a[m]=0;
                return;
            }
            eight_queen(m+1);
            a[m]=0;
        }
    }
}

int main()
{
    eight_queen(0);
    getch();
    return 0;
}
