#include<iostream>
using namespace std;
int a[8][8]={0};
int b[8][2]={{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
void tr(int x,int y,int s)
{
    int t=1;
    int i,j,k;
//    int n=1;
    int p=x,q=y;
    while(t<=8*8)
    {
        for(i=s;i<8;++i)
        {
            if(x+b[i][1]>=0 && x+b[i][1]<8 && y+b[i][2]>=0 && y+b[i][2]<8 && a[x+b[i][0]][y+b[i][1]]==0)
            {
                a[x][y]=t;
                for(j=0;j<8;++j)
                {
                    for(k=0;k<8;++k)
                        cout<<a[j][k];
                    cout<<endl;
                }
                cout<<endl;


                x+=b[i][0];
                y+=b[i][1];
                break;
            }
            if(i==7)
                i=0;
        }

        if(i==7 && a[x+b[1][0]][y+b[1][1]]!=0
                && a[x+b[2][0]][y+b[2][1]]!=0
                && a[x+b[3][0]][y+b[3][1]]!=0
                && a[x+b[4][0]][y+b[4][1]]!=0
                && a[x+b[5][0]][y+b[5][1]]!=0
                && a[x+b[6][0]][y+b[6][1]]!=0
                && a[x+b[7][0]][y+b[7][1]]!=0
                && a[x+b[8][0]][y+b[8][1]]!=0)
            {
//                for(j=0;j<8;++j)
//                    for(k=0;k<8;++k)
//                        cout<<a[j][k];
//                cout<<endl;
                tr(p,q,s++);
                cout<<"无法遍历!";
            }

    ++t;
    }
}

int main()
{
    int x,y,s=0;
    cout<<"输入坐标：";
    cin>>x>>y;
    x--,y--;

    tr(x,y,s);

    for(int i=0;i<8;++i)
    {
        for(int j=0;j<8;++j)
            cout<<a[i][j];
        cout<<endl;
    }


    return(0);
}




    #include<iostream>
    #include<stdio.h>
    #include<memory.h>

    using namespace std;

    //      棋盘大小
    #define N 8

    // 八方向
    #define DIR 8
    int dir[DIR][2] = { {2,1}, {1,2}, {-1,2}, {-2,1}, {-2,-1}, {-1,-2}, {1,-2}, {2,-1} };

    int mz[N][N];
    bool flag;
    int sx, sy;

    /**
    * 遍历算法
    * 输入： 起点坐标
    */
    void chess(int x, int y, int t){
            //      标记这格走完了
            mz[x][y] = t;

            //      走完N*N格
            if(t==N*N){
                    //      标记找到了路径
                    flag = true;

                    for(int i=0; i<N; i++){
                            for(int j=0; j<N; j++){
                                    printf("%5d", mz[i][j]);
                            }
                            putchar('\n');
                    }

                    return;

            }

            //      八方向可以走到的格子
            for(int i=0; i<DIR&&!flag; i++){
                    int tx = x+dir[i][0];
                    int ty = y+dir[i][1];

                    //      如果存在该格并且没走过
                    if(tx>=0&&tx<N&&ty>=0&&ty<N&&!mz[tx][ty]){
                            //      走进去
                            chess(tx,ty,t+1);
                    }
            }

            //      还原状态
            mz[x][y] = 0;
    }


    int main(){
            int x,y;

            memset(mz,0,sizeof(mz));

            cout<<"请输入起点坐标：";
            cin>>x>>y;

            x--, y--;

            sx = x, sy = y;

            //      寻路标记置为false
            flag = false;

            //      从(x,y)开始寻路
            chess(x,y,1);

            if(!flag)puts("找不到可行路径！");

            return 0;
    }
