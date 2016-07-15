#include <iostream>
#include<math.h>
#include<string.h>
#include<stdio.h>
#include<stdlib.h>

using namespace std;

//#include <stdio.h>
//#define N  11
//int main(int argc, char *argv[])
//{
//
//
//   int  a[N],t,i,j,b;
//   for(i=0;i<N-1;i++)
//   {
//   	scanf("%d",&a[i]);
//   }
//    scanf("%d",&b);
//    a[N-1]=b;
// for(i=0;i<N;i++)
// {
// 	for(j=0;j<N-i-1;j++)
// 	{
// 		if(a[j]>a[j+1])
//	 	{
//		 t=a[j];
//	 	a[j]=a[j+1];
//	 	a[j+1]=t;
//	 	}
//	 }
// }
//   for(i=0;i<N;i++)
//
//   	{printf("%d\n",a[i]);}
//
//
//	return 0;
//}

//int main()
//{
//    int i,j,n,x,y;
//    char a[100];
//    printf("input the number of data:");
//    scanf("%d",&n);
//    printf("input data:");
//    for(i=0;i<n;++i)
//    {
//        scanf("%d",&x);
//        a[i]=x;
//    }
//    printf("input data of inserting:");
//    scanf("%d",&y);
//    while(a[i]<y)
//    {
//        i++;
//    }
//    for(j=i;j>=i;--j)
//    {
//        a[j]=a[j-1];
//    }
//    a[i-1]=y;
//    for(i=0;i<n+1;++i)
//    {
//        printf("%d\t",a[i]);
//    }
//    return 0;
//}
//*************************************************
//
//*************************************************
//数列的最长不下降子序列!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//int maxn=100;
//int a[maxn],b[maxn],c[maxn];
//int main()
//{
//    int n,i,j,Max,p;
//    scanf("%d",&n);
//    for(i=1;i<=n;++i)
//    {
//        scanf("%d",&a[i]);
//        b[i]=1;
//        c[i]=0;
//        for(i=n-1;i>=1;--i)
//        {
//            Max=0;
//            p=0;
//            for(j=i+1;j<=n;++j)
//                if(a[i]<a[j] && b[j]>Max)
//                {
//                    Max=b[j];
//                    p=j;
//                    if(p!=0)
//                    {
//                        b[i]=b[p]+1;
//                        c[i]=p;
//                    }
//                }
//        }
//    }
//    return 0;
//}

//*************************************************
//动态规划(数塔问题)
//int main()
//{
//    int a[50][50][3],i,j,n;
//    printf("input the number of rows:");
//    scanf("%d",&n);
//    for(i=1;i<=n;++i)
//        for(j=1;j<=i;++j)
//        {
//            scanf("%d",a[i][j][1]);
//            a[i][j][2]=a[i][j][1];
//            a[i][j][3]=0;
//        }
//    for(i=n-1;i>=1;--i)
//        for(j=1;j<=i;++j)
//            if(a[i+1][j][2]>a[i+1][j+1][2])
//            {
//                a[i][j][2]=a[i][j][2]+a[i+1][j][2];
//                a[i][j][3]=0;
//            }
//            else
//            {
//                a[i][j][2]=a[i][j][2]+a[i+1][j+1][2];
//                a[i][j][3]=1;
//            }
//    printf("max=",a[1][1][2]);
//    j=1;
//    for(i=1;i<=n-1;++i)
//    {
//        printf("%d->",a[i][j][1]);
//        j=j+a[i][j][3];
//    }
//    printf("%d",a[n][j][1]);
//    return 0;
//}

//*************************************************
//相对或近似贪婪问题


//*************************************************
//可绝对贪婪问题(一个正整数去掉n个数字后最小)
//void Delete(char n[],int b,int k)
//{
//    int i;
//    for(i=b;i<=sizeof(n)-k;++i)
//        n[i]=n[i+k];
//}
//int main()
//{
//    char n[100];
//    int s,i,j,j1,c,data[100],len;
//    scanf("%d%d",&n,&s);
//    len=sizeof(n);
//    if(s>len)
//    {
//        printf("data error");
//        return 0;
//    }
//    j1=0;
//    for(i=0;i<=s;++i)
//    {
//        for(j=1;j<sizeof(n);++j)
//            if(n[j]>n[j+1])
//        {
//            Delete(n,j,1);
//            if(j>j1)
//                data[i]=j+i;
//            else
//                data[i]=data[i-1]-1;
//            j1=j;
//            break;
//        }
//        if(j>sizeof(n))
//            break;
//    }
//    for(i=i;i<=s;++i)
//    {
//        j=len-i+1;
//        Delete(n,j,1);
//        data[i]=j;
//    }
//    while(n[i]='0' && sizeof(n)>1)
//        Delete(n,1,1);
//    printf("%d",n);
//    for(i=1;i<=s;++i)
//        printf("%d ",data[i]);
//    return 0;
//}
//int main()
//{
//    char n[100];
//    int s,i,j,j1,c,data[100],len;
//    scanf("%d%d",&n,&s);
//    len=sizeof(n);
//    if(s>len)
//    {
//        printf("data error");
//        return 0;
//    }
//    i=0;
//    j=1;
//    j1=0;
//    while(i<s && j<=sizeof(n)-1)
//    {
//        while(n[j]<=n[j+1])
//            ++j;
//        if(j<sizeof(n))
//        {
//            Delete(n,j,1);
//            if(j>j1)
//                data[i]=j+i;
//            else
//                data[i]=data[i-1]-1;
//            ++i;
//            j1=j;
//            j=j-1;
//        }
//    }
//    for(i=i;i<=s;++i)
//    {
//        j=len-i+1;
//        Delete(n,j,1);
//        data[i]=j;
//    }
//    while(n[1]='0' && sizeof(n)>1)
//        Delete(n,1,1);
//    printf("%d",n);
//    for(i=1;i<=s;++i)
//        printf("%d ",data[i]);
//    return 0;
//}

//int main()//埃及分数!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//{
//    int a,b,c;
//    printf("input element:");
//    scanf("%d",&a);
//    printf("input denominator:");
//    scanf("%d",&b);
//    if(a>=b)
//        printf("input error");
//    else
//        if(a==1 || b%a==0)
//            printf("%d/%d=1/%d",a,b,b/a);
//        else
//            while(a!=1)
//            {
//                c=b/a+1;
//                a=a*c-b;
//                b=b*c;
//                printf("1/%d",c);
//                if(a>1)
//                    printf("+");
//                if(b%a==0 || a==1)
//                {
//                    printf("1/%d",b/a);
//                    a=1;
//                }
//            }
//    return 0;
//}

//*************************************************
//非等分分治
//*************************************************
//二分法不独立情况（最大字段和）!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//int max_sum3(int a[],int n)
//{
//    return (max_sub_sum(a,1));
//}
//int max_sub_sum(int a[],int left,int right)
//{
//    int center,i,j,sum,left_sum,right_sum,s1,s2,lefts,rights;
//    if(left==right)
//        if(a[left]>0)
//            return (a[left]);
//        else
//            return n;
//    else
//    {
//        center=(left+right)/2;
//        left_sum=max_sub_sum(a,left,center);
//        right_sum=max_sub_sum(a,center+1,right);
//        s1=0;
//        lefts=0;
//        for(i=center;i>=left;--i)
//        {
//            lefts=lefts+a[i];
//            if(lefts>s1)
//                s1=lefts;
//        }
//        s2=0;
//        rights=0;
//        for(i=center+1;i<=rights;++i)
//        {
//            rights=rights+a[i];
//            if(rights>s2)
//                s2=rights;
//        }
//        if(s1+s2<left_sum && right_sum<left_sum)
//            return left_sum;
//        if(s1+s2<right_sum)
//            return right_sum;
//        return (s1+s2);
//    }
//}

//*************************************************
//典型二分法（金块问题）
//float a[n];
//maxmin(int i,int j,float &,float &fmin)
//{
//    int mid;
//    float lmax,lmin,rmax,rmin;
//    if(i==j)
//    {
//        fmax=a[i];
//        fmin=a[i];
//    }
//    else if(i==j-1)
//        if(a[i]<a[j])
//        {
//            fmax=a[j];
//            fmin=a[i];
//        }
//        else
//        {
//            fmax=a[i];
//            fmin=a[j];
//        }
//    else
//    {
//        mid=(i+j)/2;
//        maxmin(i,mid,lmax,lmin);
//        maxmin(mid+1,j,rmax,rmin);
//        if(lmax>rmax)
//            fmax=lmax;
//        else
//            fmax=rmax;
//        if(lmin>rmin)
//            fmin=rmin;
//        else
//            fmin=lmin;
//    }
//}
//*************************************************
//迭代（倒推）沙漠问题!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//int main()
//{
//    int dis,k,oil;
//    do
//    {
//        printf("storepoint %d distance %d oilquantity %d",k,1000-dis,oil);
//        ++k;
//        dis=dis+500/(2*k-1);
//        oil=500*k;
//    }while(dis<1000);
//    oil=500*(k-1)+(1000-dis)*(2*k-1);
//    printf("storepoint %d distance 0 oilquantity %d",k,oil);
//    return 0;
//}

//*************************************************
//杨辉三角?
//int main()
//{
//    int n,i,j,a[100];
//    scanf("%d",n);
//    printf("1");
//    printf("\n");
//    a[1]=a[2]=1;
//    printf("%d %d",a[1],a[2]);
//    printf("\n");
//    for(i=3;i<=n;++i)
//    {
//        a[1]=a[i]=1;
//        for(j=i-1;j>1;--j)
//            a[j]=a[j]+a[j-1];
//        for(j=1;j<=i;++j)
//            printf("%d",a[j]);
//        printf("\n");
//    }
//    return 0;
//}

//*************************************************
//数组中数据向后移位?
//int main()
//{
//    int a[100],b[100],i,n,k;
//    printf("input number of data and moving:");
//    scanf("%d%d",&n,&k);
//    printf("input data:");
//    for(i=0;i<n;++i)
//        scanf("%d",&a[i]);
//    for(i=0;i<n;++i)
//        b[(k+i)%n]=a[i];
//    for(i=0;i<n;++i)
//        printf("%d",b[i]);
//    return 0;
//}
//int main()
//{
//    int a[100],b[100],i,j,n,k,temp;
//    printf("input number of data and moving:");
//    scanf("%d%d",&n,&k);
//    printf("input data:");
//    for(i=0;i<n;++i)
//        scanf("%d",&a[i]);
//    for(i=0;i<k;++i)
//    {
//        temp=a[n-1];
//        for(j=n-1;j>0;j=j-1)
//            a[j]=a[j-1];
//        a[0]=temp;
//    }
//    for(i=0;i<n;++i)
//        printf("%d",a[i]);
//    return 0;
//}
//int ff(int a,int b)
//{
//    int i,t=1;
//    for(i=2;i<=a && i<=b;++i)
//        while(a%i==0 && b%i==0)
//    {
//        t=t*i;
//        a=a/i;
//        b=b/i;
//    }
//    return t;
//}
//int main()
//{
//    int a[100],b0,b1,i,j,n,k,m,tt;
//    printf("input numbers of data:");
//    scanf("%d",&n);
//    printf("input the distant of moving:");
//    scanf("%d",&k);
//    for(i=0;i<n;++i)
//        scanf("%d",a[i]);
//    m=ff(n,k);
//    for(j=0;j<m;++j)
//    {
//        b0=a[j];
//        tt=j;
//    }
//    for(i=0;i<n/m;++i)
//    {
//        tt=(tt+k)%n;
//        b1=a[tt];
//        a[tt]=b0;
//        b0=b1;
//    }
//    for(i=0;i<n;++i)
//        printf("%d",a[i]);
//    return 0;
//}
//*************************************************
//找出次品!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//int main()
//{
//    int i,k,n,t;
//    long w1,w2;
//    printf("input the number of boxes:");
//    scanf("%d",&n);
//    t=1;
//    for(i=1;i<=n;++i)
//    {
//        printf("%d box take %d units",i,t);
//        w1=w1+t;
//        t=t*2;
//    }
//    w1=w1*100;
//    printf("normal weight %d\n",w1);
//    printf("input reality weight");
//    scanf("%d",&w2);
//    w1=(w1-w2)/10;
//    while(w1!=0)
//    {
//        k=0;
//        t=1;
//        while(w1-t>0)
//        {
//            t=t*2;
//            ++k;
//        }
//        printf("%d is bad",k);
//        w1=w1-t/2;
//    }
//    return 0;
//}
//int main()
//{
//    int i,k,n,t;
//    long w1,w2;
//    printf("input the number boxs");
//    scanf("%d",&n);
//    t=1;
//    for(i=1;i<=n;++i)
//    {
//        printf("%d box take %d units",i,t);
//        w1=w1+t;
//        t=t*2;
//    }
//    w1=w1*100;
//    printf("\n normal weight %d\n",w1);
//    printf("input reality weight");
//    scanf("%d",&w2);
//    w1=(w1-w2)/10;
//    while(w1!=0)
//    {
//        k=log(w1)/log(2);
//        printf("%d is bad",k+1);
//        w1=w1-pow(2,k);
//    }
//    return 0;
//}

//*************************************************
//判定从键盘输入n个数据互不相等
//int main()
//{
//    int a[100],i,j,t,n;
//    printf("input numbers:");
//    scanf("%d",&n);
//    printf("input data:");
//    for(i=1;i<=n;++i)
//        scanf("%d",&a[i]);
//    t=1;
//    for(i=1;i<=n-1;++i)
//        for(j=i+1;j<=n;++j)
//            if(a[i]==a[j])
//            {
//                t=0;
//                break;
//            }
//    if(t==1)
//        printf("Non repeat");
//    else
//        printf("repeat");
//    return 0;
//}

//*************************************************
//冒泡排序算法改进
//int main()
//{
//    int i,j,t,n,a[100],flag;
//    printf("input data number(<100):");
//    scanf("%d",&n);
//    printf("input data:");
//    for(i=0;i<n;++i)
//    {
//        scanf("%d",&a[i]);
//    }
//    flag=1;
//    for(i=1;i<=n-1 && flag==1;++i)
//    {
//        flag=0;
//        for(j=n-1;j>=i;j=j-1)
//            if(a[j]<a[j-1])
//            {
//                t=a[j];
//                a[j]=a[j-1];
//                a[j-1]=t;
//                flag=1;
//            }
//        for(i=0;i<n;++i)
//            printf("%d\t",a[i]);
//    }
//    return 0;
//}

//*************************************************
//一组数形成圆圈，求相隔一个数据的两个数的乘积最大和最小
//int main()
//{
//    int max=1,min=32767,a[100],num,i,k,m,n,s,t,p,q;
//    printf("input a number:");
//    scanf("%d",&num);
//    for(i=0;i<num;++i)
//        scanf("%d",&a[i]);
//    for(i=0;i<num;++i)
//    {
//        p=(num+i-1)%num;
//        q=(i+1)%num;
//        k=a[p]*a[q];
//        if(k>max)
//        {
//            max=k;
//            m=a[p];
//            n=a[q];
//        }
//        if(k<min)
//        {
//            min=k;
//            s=a[p];
//            t=a[q];
//        }
//    }
//    printf("max=%d*%d=%d\n",m,n,max);
//    printf("min=%d*%d=%d",s,t,min);
//    return 0;
//}

//*************************************************
//开灯问题
//int main()
//{
//    int n,a[1000],i,k;
//    printf("input a number:");
//    scanf("%d",&n);
//    for(i=1;i<=n;++i)
//        a[i]=0;
//    for(i=2;i<=n;++i)
//    {
//        k=1;
//        while(i*k<=n)
//        {
//            a[i*k]=1-a[i*k];
//            ++k;
//        }
//        for(i=1;i<=n;++i)
//            if(a[i]==1)
//                printf("%d\t",i);
//    }
//    return 0;
//}

//*************************************************
//链环数字对
//int main()
//{
//    int a[10][10],n,i,j,k1,k0;
//    for(i=0;i<=9;++i)
//        for(j=0;j<=9;++j)
//            a[i][j]=0;
//    printf("How many is numbers:");
//    scanf("%d",&n);
//    printf("Please input these numbers:");
//    scanf("%d",&k0);
//    for(i=2;i<=n;++i)
//    {
//        scanf("%d",&k1);
//        a[k0][k1]=a[k0][k1]+1;
//        k0=k1;
//    }
//    for(i=1;i<9;++i)
//        for(j=0;j<=9;++j)
//            if(a[i][j]!=0 && a[j][i]!=0)
//                printf("(%d,%d)=%d,(%d,%d)=%d\n",i,j,a[i][j],j,i,a[j][i]);
//    return 0;
//}

//*************************************************
//魔方阵
//int main()
//{
//    int i,j,i1,j1,x,n,a[100][100];
//    printf("input an odd number:");
//    scanf("%d",&n);
//    if(n%2==0)
//    {
//        printf("error!");
//        return 0;
//    }
//    for(i=1;i<=n;++i)
//        for(j=1;j<=n;++j)
//            a[i][j]=0;
//    i=1;
//    j=int((n+1)/2);
//    x=1;
//    while(x<=n*n)
//    {
//        a[i][j]=x;
//        ++x;
//        i1=i;
//        j1=j;
//        --i;
//        --j;
//        if(i==0)
//            i=n;
//        if(j==0)
//            j=n;
//        if(a[i][j]!=0)
//        {
//            i=i1+1;
//            j=j1;
//        }
//        for(i=1;i<=n;++i)
//        {
//            printf("\n");
//            for(j=1;j<=n;++j)
//                printf("%d",a[i][j]);
//        }
//    }
//    return 0;
//}

//*************************************************
//螺旋矩阵?
//int main()
//{
//    int i,j,a[100][100],n,k;
//    scanf("%d",&n);
//    k=1;
//    for(i=1;i<n/2;++i)
//    {
//        for(j=i;j<=n-1;++j)
//        {
//            a[j][i]=k;
//            ++k;
//        }
//        for(j=i;j<=n-1;++j)
//        {
//            a[n+1-i][j]=k;
//            ++k;
//        }
//        for(j=n-i+1;j>=i+1;--j)
//        {
//            a[j][n+1-i]=k;
//            ++k;
//        }
//        for(j=n-i+1;j>=i+1;--j)
//        {
//            a[i][j]=k;
//            ++k;
//        }
//        if(n%2==1)
//        {
//            i=(n+1)/2;
//            a[i][i]=n*n;
//        }
//        for(i=1;i<=n;++i)
//        {
//            printf("\n");
//            for(j=1;j<=n;++j)
//                printf("%3d",a[i][j]);
//        }
//    }
//    return 0;
//}
//int main()
//{
//    int t,i,j,k,n,a[100][100],b[2],x,y;
//    scanf("%d",&n);//输入矩阵宽度
//    b[0]=0;
//    b[1]=1;
//    k=n;
//    t=1;
//    x=1;
//    while(x<=n*n)//未处理完所有元素，循环
//    {
//        for(y=1;y<=2*k-1;++y)
//        {
//            b[y/(k+1)]=b[y/(k+1)]+t;
//            a[b[0]][b[1]]=x;
//            ++x;
//        }
//        --k;
//        t=-t;
//    }
//    for(i=1;i<=n;++i)//输出矩阵
//    {
//        printf("\n");
//        for(j=1;j<=n;++j)
//            printf("%3d",a[i][j]);
//    }
//    return 0;
//}

//*************************************************
//n<100时，n!的精确解
//int main()
//{
//    long a[256],b,d;
//    int m,n,i,j,r;
//    scanf("%d",&n);
//    m=log(n)*n/6+2;
//    a[1]=1;
//    for(i=2;i<=m;++i)
//        a[i]=0;
//    d=0;
//    for(i=2;i<=m;++i)
//    {
//        for(j=1;j<=m;++j)
//        {
//            b=a[j]*i+d;
//            a[j]=b%1000000;
//            d=b/1000000;
//        }
//        if(d!=0)
//            a[j]=d;
//    }
//    for(i=m;i>=1;--i)
//        if(a[i]=0)
//            continue;
//        else
//        {
//            r=i;
//            break;
//        }
//    printf("n!=%d",n);
//    printf("%d ",a[r]);
//    for(i=r-1;i>=1;--i)
//    {
//        if(a[i]>99999)
//        {
//            printf("%d ",a[i]);
//            continue;
//        }
//        if(a[i]>9999)
//        {
//            printf("0%d ",a[i]);
//            continue;
//        }
//        if(a[i]>999)
//        {
//            printf("00%d ",a[i]);
//            continue;
//        }
//        if(a[i]>99)
//        {
//            printf("000%d ",a[i]);
//            continue;
//        }
//        if(a[i]>9)
//        {
//            printf("0000%d ",a[i]);
//            continue;
//        }
//        printf("00000% ",a[i]);
//    }
//    return 0;
//}

//*************************************************
//游戏问题
//int main()
//{
//    int a[100],i,k,p,m,n,x;
//    printf("input numbers of game:");
//    scanf("%d",&n);
//    printf("input serial number of game start:");
//    scanf("%d",&k);
//    printf("input number of out_ring:");
//    scanf("%d",&m);
//    for(i=1;i<=n;++i)
//        a[i]=1;
//    p=0;
//    --k;
//    printf("wash out:\n");
//    while(p<n-1)
//    {
//        x=0;
//        while(x<m)
//        {
//            ++k;
//            if(k>n)
//                k=1;
//            x+=a[k];
//        }
//        printf("%d\n",k);
//        a[k]=0;
//        ++p;
//    }
//    for(i=1;i<=n;++i)
//        if(a[i]==1)
//        printf("i=%d",i);
//    return 0;
//}

//*************************************************
//找钱
//int main()
//{
//    int i,j,x,y,z,a,b[7]={0,50,20,10,5,2,1},s[7];
//    scanf("%d%d",&x,&y);
//    z=y-x;
//    for(i=1;i<=6;++i)
//    {
//        a=z/b[i];
//        s[i]=a;
//        z=z-a*b[i];
//    }
//    printf("%d-%d=%d\n",x,y,z);
//    for(i=1;i<=6;++i)
//        if(s[i]!=0)
//        printf("%d----%d",b[i],s[i]);
//    return 0;
//}

//*************************************************
//数字编号转化成英文
//int main()
//{
//    int i,a[10],ind;
//    long num1,num2;
//    char eng[10][6]={"zero","one","two","three","four","five","six","seven","eight","nine"};
//    printf("Input a number:");
//    scanf("%d",&num1);
//    num2=num1;
//    ind=0;
//    while(num2!=0)
//    {
//        a[ind]=num2%10;
//        ind=ind+1;
//        num2=num2/10;
//    }
//    printf("English_exp:");//?
//    for(i=ind-2;i>=0;--i)
//        printf("-%c",eng[a[i]]);
//    return 0;
//}
//int main()
//{
//    int i=0,n;
//    char num[40];
//    char eng[10][6]={"zero","one","two","three","four","five","six","seven","eight","nine"};
//    printf("Input a number:");
//    scanf("%d",&num);
//    n=strlen(num);
//    if(n==0)
//        printf("input error!");
//    else
//    {
//        //printf()//?
//        for(i=1;i<=n-1;++i)
//            printf("-%c",eng[num[i]-48]);
//    }
//    return 0;
//}

//*************************************************
//n个自然数中r个数的组合
//int a[100];
//void comb(int m,int k)
//{
//    int i,j;
//    for(i=m;i>=k;--i)
//    {
//        a[k]=i;
//        if(k>1)
//            comb(i-1,k-1);
//        else
//        {
//            for(j=a[0];j>0;--j)
//                printf("%d",a[j]);
//            printf("\n");
//        }
//    }
//}
//int main()
//{
//    int n,r;
//    printf("n,r=");
//    scanf("%d%d",&n,&r);
//    if(r>n)
//    {
//        printf("error!");
//    }
//    else
//    {
//        a[0]=r;
//        comb(n,r);
//    }
//    return 0;
//}

//*************************************************
//用2的幂次方表示正整数?
//void tr(int n,int r)
//{
//    if(n==1)
//        printf("2(%d)",r);
//    else
//    {
//        tr(n/2,r+1);
//        if(n%2==1)
//            printf("+2(%d)",r);
//    }
//}
//int main()
//{
//    int n;
//    scanf("%d",&n);
//    if(n>=1)
//        tr(n,0);
//    else
//        printf("data error!");
//    return 0;
//}
//void tr(int n,int r)
//{
//    if(n==1)
//        switch(r)
//        {
//            case 0:printf("2(0)");break;
//            case 1:printf("2");break;
//            case 2:printf("2(2)");break;
//            default:printf("2(%d)",tr(r,0));
//        }
//    else
//    {
//        tr(n/2,r+1);
//        if(n%2==1)
//            switch(r)
//            {
//                case 0:printf("+2(0)");break;
//                case 1:printf("+2");break;
//                case 2:printf("+2(2)");break;
//                default:printf("+2(%d)",tr(r,0));
//            }
//    }
//}
//int main()
//{
//    int n;
//    scanf("%d",&n);
//    if(n>=1)
//        tr(n,0);
//    else
//        printf("data error!");
//    return 0;
//}

//*************************************************
//输入十进制，转化为m进制
//void f(int n,int m)
//{
//    if(n<m)
//        printf("%d",n);
//    else
//    {
//        f(n/10,m);
//        printf("%d",n%m);
//    }
//}
//int main()
//{
//    int n,m;
//    printf("输入十进制数及要转化的进制：");
//    scanf("%d%d",&n,&m);
//    printf("结果为（%d进制）：",m);
//    f(n,m);
//    return 0;
//}
//输入十进制，从高位到低位输出各数字
//void f(int n)
//{
//    if(n<10)
//        printf("%d",n);
//    else
//    {
//        f(n/10);
//        printf("%d",n%10);
//    }
//}
//int main()
//{
//    int n;
//    scanf("%d",&n);
//    f(n);
//    return 0;
//}
//输入十进制，从低位到高位输出各数字
//void f(int n)
//{
//    if(n<10)
//        printf("%d",n);
//    else
//    {
//        printf("%d",n%10);
//        f(n/10);
//    }
//}
//int main()
//{
//    int n;
//    scanf("%d",&n);
//    f(n);
//    return 0;
//}

//*************************************************
//整数分划?
//int Divinteger(int n,int m)
//{
//    if(n<1 || m<1)
//        printf("ERROR");
//    else if(n==1 || m==1)
//        return 1;
//    else if(n<m)
//        return Divinteger(n,n);
//    else if(n==m)
//        return (1+Divinteger(n,n-1));
//    else
//        return (Divinteger(n,m-1)+Divinteger(n-m,m));
//}
//int main()
//{
//    int n;
//    scanf("%d",&n);
//    printf("%d",Divinteger(n,n));
//    return 0;
//}

//*************************************************
//汉诺塔?
//void test(int n,char a,char b,char c)
//{
//    if(n>0)
//    {
//        test(n-1,a,c,b);
//        printf("Move dish %d from pile %c to %c\n",n,a,b);
//        test(n-1,c,b,a);
//    }
//}
//
//int main()
//{
//    int n;
//    scanf("%d",&n);
//    test(n,'A','B','C');
//    return 0;
//}

//*************************************************
//fibonacci
//int fibo(int n)
//{
//    if(n==1)
//        return 1;
//    else if(n==2)
//        return 2;
//    else
//        return (fibo(n-1)+fibo(n-2));
//}
//int main()
//{
//    int n;
//    scanf("%d",&n);
//    printf("%d",fibo(n));
//    return 0;
//}

//*************************************************
//完数?
//int main()
//{
//    int i,k,j,s,a[20];
//    for(i=1;i<=1000;++i)
//    {
//        s=1;
//        k=0;
//        for(j=2;j<i;++j)
//            if((i%j)==0)
//            {
//                s+=j;
//                a[k]=j;
//                ++k;
//            }
//        if(i==s)
//        {
//            printf("%d\n",s);
//            for(j=0;i<k;++j)
//                printf("%d",a[k]);
//        }
//    }
//}
