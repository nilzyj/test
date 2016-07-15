#include<iostream>
#include<stdio.h>
#include<conio.h>
using namespace std;
#define N 8
int b[8][2]={{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
int mz[N][N];
bool flag;
int sx, sy;
void chess(int x, int y, int t)
{
    mz[x][y] = t;
    if(t==N*N)
    {
        flag = true;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                printf("%5d", mz[i][j]);
            }
            putchar('\n');
        }
        return;
    }
    for(int i=0; i<8 && !flag; i++)
    {
        int tx = x+b[i][0];
        int ty = y+b[i][1];
        if(tx>=0&&tx<N&&ty>=0&&ty<N&&!mz[tx][ty])
        {
            chess(tx,ty,t+1);
        }
    }
    mz[x][y] = 0;
}
int main()
{
    int x,y;
    cout<<"请输入起点坐标：";
    cin>>x>>y;
    x--, y--;
    sx = x, sy = y;
    flag = false;
    chess(x,y,1);
    if(!flag)cout<<"找不到可行路径！";
        return 0;
    getch();
}
