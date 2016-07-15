#include<iostream>
#include<string>
#include<stdio.h>
#include<algorithm>
using namespace std;
bool comp(string num1,string num2)
{
	int len=num1.length();
	for(int i=0;i<len;i++)
	{
		if(num1[i]!='0')
			break;
	}
	num1=num1.substr(i,len);
	if(num1.length()==0)
		num1="0";

	len=num2.length();
	for(i=0;i<len;i++)
	{
		if(num2[i]!='0')
			break;
	}
	num2=num2.substr(i,len);
	if(num2.length()==0)
		num2="0";

	if(num1.length()>num2.length())
		return true;
	else if(num1.length()==num2.length())
	{
		if(num1>=num2)
			return true;
		else
			return false;
	}
	else
		return false;
}

string _plu(string num1,string num2)//加法
{
	string result="";
	int i;
	reverse(num1.begin(),num1.end());
	reverse(num2.begin(),num2.end());
	for(i=0;i<num1.length() && i<num2.length();++i)
	{
		char c=(char)(num1[i]+num2[i]-48);
		result=result+c;
	}
	while(i<num1.length())
	{
		result=result+num1[i];i++;
	}
	while(i<num2.length())
	{
		result=result+num2[i];i++;
	}
	int jinwei=0;
	for(i=0;i<result.length();i++)
	{
		int zhi=result[i]-48+jinwei;
		result[i]=(char)(zhi%10+48);
		jinwei=zhi/10;
	}
	if(jinwei!=0)result=result+(char)(jinwei+48);
	for(i=result.length()-1;i>=0;i--)
	{
		if(result[i]!='0')break;
	}
	result=result.substr(0,i+1);
	reverse(result.begin(),result.end());
	if(result.length()==0)
		result="0";
	return result;
}

string _sub(string num1,string num2)//减法
{
	if(comp(num2,num1)){string ss=num1;num1=num2;num2=ss;}
	reverse(num1.begin(),num1.end());
	reverse(num2.begin(),num2.end());
	string result="";
	int i;
	for(i=0;i<num1.length()&&i<num2.length();i++)
	{
		char c=num1[i]-num2[i]+48;
		result=result+c;
	}
	if(i<num1.length())for(;i<num1.length();i++)
		result=result+num1[i];
	int jiewei=0;
	for(i=0;i<result.length();i++)
	{
		int zhi=result[i]-48+jiewei;
		if(zhi<0){zhi=zhi+10;jiewei=-1;}
		else jiewei=0;
		result[i]=(char)(zhi+48);
	}
	for(i=result.length()-1;i>=0;i--)
	{
		if(result[i]!='0')break;
	}
	result=result.substr(0,i+1);
	reverse(result.begin(),result.end());
	if(result.length()==0)
		result="0";
	return result;
}

string _mul(string num1,string num2)//乘法
{
	reverse(num1.begin(),num1.end());
	reverse(num2.begin(),num2.end());
	string result="";
	int i,j,k,re_int[150];
	memset(re_int,0,sizeof(re_int));
	for(i=0;i<num1.length();i++)
	for(j=0;j<num2.length();j++)
	{
		re_int[i+j]+=((num1[i]-48)*(num2[j]-48));
	}
	int jinwei=0;
	for(i=0;i<num1.length()+num2.length();i++)
	{
		int zhi=re_int[i]+jinwei;
		re_int[i]=zhi%10;
		jinwei=zhi/10;
	}
	for(i=num1.length()+num2.length()-1;i>=0;i--)
	{
		if(re_int[i]!=0)
			break;
	}
	for(;i>=0;i--)
	{
		result=result+(char)(re_int[i]+48);
	}
	if(result=="")
		result="0";
	return result;
}

string _div(string num1,string num2)//除法
{
	if(comp(num2,num1))
	{
		string ss=num1;num1=num2;num2=ss;
	}
	string result="",r1;
	int i,j,k;
	int length1=num1.length(),length2=num2.length(),pos;
	r1=num1.substr(0,length2);
	pos=length2-1;
	while(pos<length1)
	{
		int digit=0;
		while(comp(r1,num2))
		{
			digit++;r1=_sub(r1,num2);
		}
		result=result+(char)(digit+48);
		pos++;
		if(pos<length1)
			r1+=num1[pos];
	}
	k=result.length();
	for(i=0;i<k;i++)
	{
		if(result[i]!='0')
			break;
	}
	result=result.substr(i,k);
	return result;
}

int main(int argc, char* argv[])
{
	string num1,num2,result;
	int a,b,c,i,j,k,m,n;
	while(cin>>num1>>num2)
	{
	result="";
	result=_plu(num1,num2);
	cout<<result<<endl;
	result=_sub(num1,num2);
	cout<<result<<endl;
	result=_mul(num1,num2);
	cout<<result<<endl;
	result=_div(num1,num2);
	cout<<result<<endl;
}
return 0;
}



//#include<stdio.h>
//int main()
//{
//    int a;
//    printf("1.加法，2.减法，3.乘法，4.除法");
//    scanf("%d",&a);
//    switch(a)
//    {
//    case 1:plu();break;
//    case 2:sub();break;
//    case 3:mul();break;
//    case 4:div();break;
//    }
//    return 0;
//}





/*
//设计一个支持大数运算的计算器，其中乘法使用分治法求解。该计算器支持加减乘除还有开方根运算。
#include <iostream>
#include <list>
#include <string>
#include <cstdio>
#include <cctype>
#include <cmath>
using namespace std;
list<char> Add(list<char> s, list<char> t);
list<char> Sub(list<char> s, list<char> t);
list<char> Mul(list<char> s, list<char> t);
void Div(list<char> s, list<char> t);
void  Root(list<char>);
void print(list<char> ans);
void printhelp()             //打印帮助信息
{
    cout << "请选择要进行的大数运算" << endl;
    cout << "1:加法运算" << endl;
    cout << "2:减法运算" << endl;
    cout << "3:乘法运算" << endl;
    cout << "4:除法运算" << endl;
    cout << "5:开平方根运算" << endl;
    cout << "6:退出" << endl;
}
list<char> Add(list<char> num1,list<char> num2)  //加法运算
{
    list<char> ans;
    list<char>::iterator iter1,iter2;
    iter1 = num1.begin();
    iter2 = num2.begin();
    int sign = 0;                                   //标记结果符号
    if((*iter1) == '-' && (*iter2) == '-')        //如果两个数都是负数
    {
        num1.pop_front();
        num2.pop_front();
        sign = 1;
        ans = Add(num1,num2);
        ans.push_front('-');
    }
    else if((*iter1) == '-' && (*iter2) != '-')      //如果一负一正
    {
        num1.pop_front();
        ans = Sub(num2,num1);

    }
    else if((*iter1) != '-' && (*iter2) == '-')      //如果一正一负
    {
        num2.pop_front();
        ans = Sub(num1,num2);
    }
    else                                          //如果都为正
    {
        int len1,len2,i,len,carry;
        len1 = num1.size();
        len2 = num2.size();
        if(len1 >= len2)                     //补齐两个数的位数
        {
            len = len1;
            for(i = 0; i < len1 - len2; i++)
                num2.push_front('0');
        }
        else
        {
            len = len2;
            for(i = 0; i < len2 - len1; i++)
                num1.push_front('0');
        }
        //print(num1);
        //print(num2);
        carry = 0;
        iter1 = num1.end();
        iter2 = num2.end();
        iter1--;
        iter2--;
        for(;(iter1 != num1.begin()) && (iter2 != num2.begin()); --iter1,--iter2)  //进行运算
        {
            i = (*iter1 - '0') + (*iter2 - '0') + carry;
            //cout << (*iter1 - '0') << " " << (*iter2 - '0') << " " << i << endl;
            ans.push_front((i % 10) + '0');
            carry = i / 10;
        }
        i = (*iter1 - '0') + (*iter2 - '0') + carry;
        //cout << (*iter1 - '0') << " " << (*iter2 - '0') << " " << i << endl;
        ans.push_front((i % 10) + '0');
        carry = i / 10;
        if(carry)
            ans.push_front(carry+'0');
    }
    return ans;                                                     //返回结果
}
list<char> Sub(list<char> num1,list<char> num2)                    //减法运算
{
    list<char> ans;
    int sign = 0;
    list<char>::iterator iter1,iter2;
    int len1,len2,len;
    iter1 = num1.begin();
    iter2 = num2.begin();
    if((*iter1) == '-' && (*iter2) == '-')                  //如果两个数都为负数
    {
        num2.pop_front();
        num1.pop_front();
        ans = Sub(num2,num1);
        //ans.push_front('-');
    }
    else if( (*iter1) == '-' && (*iter2) != '-')              //如果一负一正
    {
        num1.pop_front();
        ans = Add(num1,num2);
        ans.push_front('-');
    }
    else if( (*iter1) != '-' && (*iter2) == '-')              //如果一正一负
    {
        num2.pop_front();
        ans = Add(num1,num2);

    }
    else                                                   //如果都为正
    {
        len1 = num1.size();
        len2 = num2.size();
        if(len1 >= len2)                                 //补齐位数
        {
            len = len1;
            for(int i = 0; i < len1 - len2; i++)
                num2.push_front('0');
        }
        else
        {
            len = len2;
            for(int i = 0; i < len2 - len1; i++)
                num1.push_front('0');
        }
        //print(num1);cout << endl;
        //print(num2);cout << endl;
        int carry = 0,i;
        iter1 = num1.end();
        iter2 = num2.end();
        iter1--;
        iter2--;
        for(;(iter1 != num1.begin()) && (iter2 != num2.begin()); --iter1,--iter2)    //进行运算
        {
            i = (*iter1 - '0' - carry) - (*iter2 - '0');
            carry = 0;
            if( i < 0)
            {
                i += 10;
                carry = 1;
            }
            //cout << (*iter1 - '0') << " " << (*iter2 - '0') << " " << i << endl;
            ans.push_front((i % 10) + '0');
        }
        i = (*iter1 - '0' - carry) - (*iter2 - '0');
        if(i < 0)
        {
            i += 10;
            sign = 1;
        }
        //cout << (*iter1 - '0') << " " << (*iter2 - '0') << " " << i << endl;
        if(i) ans.push_front(i + '0');
        if(sign)
            ans.push_front('-');
    }
    return ans;
}
list<char> Mul(list<char> num1,list<char> num2)  // 分治法求两大数的积
{
    list<char> ans;
    int sign = 0;
    int len1,len2,len;
    list<char>::iterator iter1,iter2,iter;
    list<char> high,low;
    list<char> anshigh,anslow;
    int th,tl;
    int i,j,k;
    //print(num1);cout << endl;
    //print(num2);cout << endl;
    if(num1.size() == 1 && num2.size() == 1)     //如果两数都已是一位数，则进行运算
    {
        th = *(num1.begin()) - '0';
        tl = *(num2.begin()) - '0';
        th *= tl;
        ans.push_front( th % 10 + '0');
        ans.push_front( th / 10 + '0');
        return ans;
    }
    else if(num1.size() == 1 && num2.size() > 1)            //如果num1位数大于1，则对Num1分治求积
    {
         if(*(num2.begin()) == '-')
           {
                sign = 1;
                num2.pop_front();
           }
         len2 = num2.size();
         if(len2 == 1)
         {
            ans = Mul(num1,num2);
            if(sign)
                ans.push_front('-');
         }
         else
         {
            for(iter= num2.begin(),i = 0; i < len2 / 2; i++,iter++)
            {
                high.push_back(*iter);
            }
            for(;iter!=num2.end();iter++)
            {
                low.push_back(*iter);
            }
            len = low.size();
            anshigh = Mul(num1,high);                 //num1分为两部分，high,low
            anslow = Mul(num1,low);
            for(i = 0; i < len; i++)
                anshigh.push_back('0');
            ans = Add(anshigh,anslow);                 //合并结果
            if(sign)
                ans.push_front('-');
         }
         return ans;
    }
    else if(num2.size() == 1 && num1.size() > 1)              //如果num2位数大于1，则对Num2分治求积
    {
         if(*(num1.begin()) == '-')
           {
                sign = 1;
                num1.pop_front();
           }
         len1 = num1.size();
         if(len2 == 1)
         {
            ans = Mul(num1,num2);
            if(sign)
                ans.push_front('-');
         }
         else
         {
            for(iter= num1.begin(),i = 0; i < len1 / 2; i++,iter++)
            {
                high.push_back(*iter);
            }
            for(;iter!=num1.end();iter++)
            {
                low.push_back(*iter);
            }
            len = low.size();
            anshigh = Mul(num2,high);                   //num2分为两部分，high,low
            anslow = Mul(num2,low);
            for(i = 0; i < len; i++)
                anshigh.push_back('0');
            ans = Add(anshigh,anslow);                    //合并结果
            if(sign)
                ans.push_front('-');
         }
         return ans;
    }                                                       //如果两数位数都大于1，则都运用分治
    else
    {
        list<char> num1high,num1low,num2high,num2low;
        int flag1 = 0,flag2 = 0;
        if(*(num1.begin()) == '-')
        {
            flag1 = 1;
            num1.pop_front();
        }
        if(*(num2.begin()) == '-')
        {
            flag2 = 1;
            num2.pop_front();
        }
        if((flag1 == 1 && flag2 == 0)||(flag1 == 0 && flag2 == 1))  //如果有一正一负，则标记结果为负
        {
            sign = 1;
        }
        len1 = num1.size();
        len2 = num2.size();
        if(len1 == 1 || len2 == 1)                 //如果有一个数是一位数，则直接递归调用
        {
            ans = Mul(num1,num2);
            if(sign)
                ans.push_front('-');
        }
        else
        {                                                //否则分治法求
            for(iter = num1.begin(),i = 0; i < len1 / 2; iter++,i++)
                num1high.push_back(*iter);            //被乘数高位部分
            for( ; iter != num1.end(); iter++)
                num1low.push_back(*iter);                 //被乘数低位部分
            for(iter = num2.begin(),i = 0; i < len2 / 2; iter++,i++)
                num2high.push_back(*iter);                  //乘数高位部分
            for( ; iter != num2.end(); iter++)
                num2low.push_back(*iter);                    //乘数低位部分
            int a = (len1 + 1) / 2;
            int b = (len2 + 1) / 2;
            list<char> AC,AD,BC,BD;
            //print(num2high);cout << endl;
            //print(num2low);cout << endl;
            AC = Mul(num1high,num2high);                  //运用X=A*10^a + B; Y= C*10^b + D;
            AD = Mul(num1high,num2low);                   // X*Y = AC * 10 ^(a+b) + AD *10^a + BC * 10 ^b + BD公式求
            BC = Mul(num1low,num2high);
            BD = Mul(num1low,num2low);
            for(i = 0; i < a + b; i++)
                AC.push_back('0');
            for(i = 0; i < a; i++)
                AD.push_back('0');
            for(i = 0; i < b; i++)
                BC.push_back('0');
            ans = Add(AC,AD);
            ans = Add(ans,BC);
            ans = Add(ans,BD);                            //累加结果
            if(sign)
                ans.push_front('-');
        }
        return ans;
    }
}
void Div(list<char> num1,list<char> num2)                 //用辗转相除求结果
{
    list<char> ans;
    list<char> temp;
    int len1,len2,len;
    int i,j,k;
    int sign = 0;
    int flag1 = 0,flag2 = 0;
    list<char>::iterator iter;
    if(*(num1.begin()) == '-')
    {
        flag1 = 1;
        num1.pop_front();
    }
    if(*(num2.begin()) == '-')
    {
        flag2 = 1;
        num2.pop_front();
    }
    if((flag1 == 1 && flag2 != 1) || (flag1 == 0 && flag2 == 1))
        sign = 1;                                          //标记结果符号
    len1 = num1.size();
    len2 = num2.size();
    if(len1 < len2)                                 //如果被除数小于除法，除数为0
    {
        cout << "商是0；余数是" ;
        print(num2);
        cout << endl;
        return ;
    }
    else                                               //用辗转相除求结果
    {
        for(iter = num1.begin(),i = 0; i < len2 ;++i,++iter)
            temp.push_back(*iter);
        list<char> digit,res;
        for(j = 0; j < 10; j++)
        {
                digit.clear();
                digit.push_back(j + '0');
                res = Mul(num2,digit);
                res = Sub(temp,res);
                if(*(res.begin()) == '-')
                    break;
        }
            //cout << endl;print(temp); cout << endl;
        j -= 1;
        if(j > 0)
        {
            digit.clear();
            digit.push_back(j + '0');
            temp = Sub(temp,num2);
            ans.push_back(j + '0');
        }

        for(;iter != num1.end();++iter)
        {
            temp.push_back(*iter);
            for(j = 0; j < 10; j++)
            {
                digit.clear();
                digit.push_back(j + '0');
                res = Mul(num2,digit);
                res = Sub(temp,res);
                if(*(res.begin()) == '-')
                    break;
            }
            //cout << endl;print(temp); cout << endl;
            j -= 1;
            digit.clear();
            digit.push_back(j + '0');
            res = Mul(num2,digit);
            temp = Sub(temp,res);
            ans.push_back(j + '0');
        }
        if(sign)
            ans.push_front('-');
    }
    cout << "商是";
    print(ans);
    cout << "；余数是" ;
    print(temp);
    cout << endl;
    return ;
}
void  Root(list<char> num1)                     //求大数的平方根，用枚举算法暴力搜索算法求
{
    list<char> ans;
    int len1;
    list<char> digit,temp;
    len1 = num1.size();
    int a = len1 / 2;                            //a是结果的最少位数
    int i;
    digit.push_back('1');
    ans.push_back('1');                        //从ans=10 ^ a 开始搜索
    for(i = 0; i < a - 1; i++)
        ans.push_back('0');
    while(true)                                  //搜到则结束
    {
        temp = Mul(ans,ans);
        temp = Sub(num1,temp);
        if(*(temp.begin()) == '-')                      //如果当前ans的平方大于num1，则得结果
            break;
        ans = Add(ans,digit);
    }
    ans = Sub(ans,digit);
    print(ans);
    cout << endl;
}
list<char> translate(string input)
{
    list<char> res;
    int len = input.length();
    for(int i = 0; i < len; i++)
        res.push_back(input[i]);
    return res;
}
void print(list<char> ans)
{
    list<char>::iterator iter;
    int flag = 1;
    iter = ans.begin();
    if(*iter == '-')
     {
        cout << *iter;
        iter++;
     }
    for(;iter != ans.end(); ++iter)
    {
        if(*iter == '0' && flag)
            continue;
            //cout << (*iter);
        else
        {
            flag = 0;
            cout << (*iter);
        }
    }
    if( flag == 1)
        cout << 0 ;;
    //cout << endl;
}
int main()
{
    char choice;         //选择要进行的运算
    list<char> num1;
    list<char> num2;
    list<char> res;
    string input;
    while(true)
    {
        cout << endl;
        printhelp();
        cin >> choice;
        switch(choice)
        {
            case '1':                      //如果选择加法运算
                cout << "请输入第一个数" << endl;
                cin >> input;
                num1 = translate(input);
                cout << "请输入第二个数" << endl;
                cin >> input;
                num2 = translate(input);
                res = Add(num1,num2);
                print(num1);
                cout << " + " ;
                print(num2);
                cout << " = ";
                print(res);
                cout << endl;
                break;
            case '2':                    //选择减法运算
                cout << "请输入第一个数" << endl;
                cin >> input;
                num1 = translate(input);
                cout << "请输入第二个数" << endl;
                cin >> input;
                num2 = translate(input);
                res = Sub(num1,num2);
                print(num1);
                cout <<" - " ;
                print(num2);
                cout << " = ";
                print(res);
                cout << endl;
                break;
            case '3':                  //选择乘法运算
                cout << "请输入第一个数" << endl;
                cin >> input;
                num1 = translate(input);
                cout << "请输入第二个数" << endl;
                cin >> input;
                num2 = translate(input);
                res = Mul(num1,num2);
                print(num1);
                cout <<" * " ;
                print(num2);
                cout << " = ";
                print(res);
                cout << endl;
                break;
            case '4':                      //选择除法运算
                cout << "请输入第一个数" << endl;
                cin >> input;
                num1 = translate(input);
                cout << "请输入第二个数" << endl;
                cin >> input;
                num2 = translate(input);
                print(num1);
                cout << " / " ;
                print(num2);
                cout << " = ";
                if(num2.size() == 1 && (*(num2.begin()) == '0'))
                {
                    cout << "divided zero error" << endl;
                    break;
                }
                Div(num1,num2);
                //print(res);
                cout << endl;
                break;
            case '5':                         //选择求根运算
                cout << "请输入第一个数" << endl;
                cin >> input;
                num1 = translate(input);
                if(*(num1.begin()) == '-')
                {
                    cout << "负数没有实数平方根" << endl;
                    break;
                }
                Root(num1);
                break;
            case '6':
                return 0;
            default:
                  break;
        }
    }
}

//*****************************************************************************************


struct Node // 定义一个双向链表用来存贮结果
{
char data; // 数据*定义为字符的原因：要显示负号
Node *next; // 尾指针
Node *ahead; // 首指针
};

/*--------------------------------------------------------------------------
*函数名称： 大数加法
*函数过程：1 比较两个数那一个长
* 2 以长的作为循环次数
* 3 对应项相加 进位存贮直到下高位相加用
* 4 直到循环结束
* 5 !!!!!!没设计负数相加
*入口参数：numa，numb，result字符串
*出口参数：无
*编辑环境：winSP2 + VC2003 + C++
*--------------------------------------------------------------------------*/
/*
void addition(char *numa, char *numb,char *result) // 计算两大数之和
{
char *pna = findend(numa); // 指向numa的一个指针。point numa pna 指向乘数的最低位，
char *pnb = findend(numb); //指向numb的一个指针 //pnb 指向被乘数的最低位，
int along=(int)strlen(numa); //标记数字a的长度；
int blong=(int)strlen(numb); //标记数字b的长度；
int times = 0; // 标致要计算多少次。
int carry=0,temp_result; //存贮进位 和临时结果的
Node *head, // 用于存贮头指针
*pstart, // 用于存贮计算时的首指针
*pnew; //作于申请新结点
head = pstart =new Node; //初始化首结点和头结点。
pstart -> data = 0;
pstart -> next = NULL;
pstart -> ahead = NULL;

if (abigerb(numa ,numb)>=1)
times = (int)strlen(numa); //比较两个字符串长度，以大的作为循环次数
else
{
times = (int)strlen(numb);
pna = findend(numb); //交换指针
pnb = findend(numa);
along=(int)strlen(numb); //标记数字a的长度；
blong=(int)strlen(numa); //标记数字b的长度；
}
while ((times-- && (times>=0))|| carry != 0)
{
if(!pstart->next) //如果当前为空结点，则申请新结点
{
pnew = new Node;
pnew -> data = 0;
pnew -> next = NULL;
pnew -> ahead = pstart;
pstart -> next = pnew;
}
else temp_result =(pstart->data +(*pna-48)+(*pnb-48)+carry) ; //自身的值+新值+进位 作为当前的新值

pstart -> data = temp_result%10; //存贮个位
carry = temp_result/10; //存贮进位
pstart = pstart -> next; //结点移动
blong--;
if(blong>0)pnb--; //指针移向被加数高位
else *pnb=48; //之后相减就变为了0不作任何运算；
pna--; //加数指针移动，
}
pstart =head; //寻找链表的结尾点
while(pstart->next != 0)
{
pstart->data += 48; //!!<<<因为我们的输出是字符。所以再此加上48>>>> 逆顺输出
pstart = pstart->next ;
}

int tip = 0; //转为字符串用
pstart = pstart->ahead ; //找有效字
//cout<<"\n结果是 : ";
while(pstart != 0) //输出正序的结果；
{
result[tip++] = pstart->data;
//cout< data;
pstart = pstart->ahead ;
}
result[tip] = '\0';

pstart =head; //释放空间
while(pstart->next != 0)
{
pnew = pstart->next ;delete pstart;
pstart =pnew;
}
return ;
}

//比较两个数字符串大小的函数
//返回值说明:0是alongblong ; 2是along=blong
int abigerb(char *numa, char *numb) //比较两个数最高位那一个大
{
int along=(int)strlen(numa); //标记数字a的长度；
int blong=(int)strlen(numb); //标记数字b的长度；
char *pna = numa; //指向数A的最高位，
char *pnb = numb; //指向数B的最高位，
if (along>blong) return 1;
if (along==blong)
{
while(*pna) //比较两个数那一个大
{
if(*pna>*pnb)return 1;
else if(*pna<*pnb)return 0 ;
else if(*pna==*pnb){pna++;pnb++;} //1111与1112
}
return 2; //这表明找到最后了还是全相等;
}
return 0 ;
}

/*--------------------------------------------------------------------------
*函数名称： 大数减法
*函数过程：1 比较两个数那一个长
* 2 以长的作为循环次数
* 3 如果两个数长度相等，从最高位开始比直到发现那一个数更大，使大项减去小项
* 4 对应项相减 进位存贮直到下高位相加用
* 5 每一位对应项相减时，处理三种可能的情况，a=b,ab;
* 6 a=b时，则计算,11-12,111-112,要考虑借位
* 7 直到循环结束
*入口参数：numa，numb，result字符串
*出口参数：无
*--------------------------------------------------------------------------*/
/*

void subtract(char *numa, char *numb,char *result)//计算减
{ char *pna = findend(numa);//指向numa的一个指针。point numa pna 指向减数的最低位，
char *pnb = findend(numb);//指向numb的一个指针 //pnb 指向被减数的最低位，
int along=(int)strlen(numa);//标记数字a的长度；
int blong=(int)strlen(numb);//标记数字b的长度；
int times = 0; // 标记要计算多少次。
int carry=0; //存贮借位
int clear0=0; //消除结果最前面无用的'0' 13-5 = 08 的效果！！
int isnegative=0; //用来加上被减数大于减数时补上最后一个负号
Node *head, // 用于存贮头指针
*pstart, // 用于存贮计算时的首指针
*pnew; //作于申请新结点
head = pstart =new Node;//初始化首结点和头结点。
pstart -> data = 0;
pstart -> next = NULL;
pstart -> ahead = NULL;
if (abigerb(numa ,numb))
times = strlen(numa);//比较两个字符串长度，以大的作为循环次数
else //交换位置以降低难度
{
times = strlen(numb);//让数（字符串）长的减去数（字符串）短的
pna = findend(numb);//交换指针
pnb = findend(numa);
along=(int)strlen(numb);//标记数字a的长度；
blong=(int)strlen(numa);//标记数字b的长度；
isnegative=1;//标记最后要加上负号
}
while ((times-- && (times>=0))|| carry != 0)//carry != 0 说没有借位时
{
if(!pstart->next)//如果当前为空结点，则申请新结点
{
pnew = new Node;
pnew -> data = 0;
pnew -> next = NULL;
pnew -> ahead = pstart;
pstart -> next = pnew;
}
if(times<0)//如果计算完之后，借位等于1，，说明必然为负值;
{ pstart -> data = -3 ;//让它等于负号 '-'//-3来源于负号与0相差3。。
break; }
else
{
if ( *pna == *pnb )//减数等于被减数时。结果等于直截相减的结果；并置借位为0
{
if(carry==0)pstart -> data = (*pna-48)-(*pnb-48); //111-11的情况
else
{
pstart->data = (*pna-48)-(*pnb-48)+10 -carry;//1121-1112 carry=1;
}
}
if( *pna > *pnb )//减数大于被减数时。结果等于直截相减的结果；并置借位为0
{
pstart -> data = (*pna-48)-(*pnb-48)-carry; //存贮个位
carry=0;
}
else if( *pna < *pnb )//说明被减数大于减数，让结果加10，相当于借位 (carry)为1
{ if(times>0)
pstart->data = (*pna-48)-(*pnb-48)+10 -carry;//13-5的情况作为新值
else
pstart->data = (*pnb-48)-(*pna-48) -carry; //3-5 作为当前的新值
carry=1;
}
}
pstart = pstart -> next;
//结点移动
blong--;
if(blong>0)pnb--;//指针移向被减数高位
else *pnb=48;//之后相减就变为了0不作任何运算，其实可以优化的。但代码会长！而且还需要重新开结点。所以放弃； pna--;//被数指针移动，
}
if(isnegative==1)////加上负号处理。增加一长度并置为负号
{
pnew = new Node;
pnew -> data = 0;
pnew -> next = NULL;
pnew -> ahead = pstart;
pstart -> next = pnew;
pstart->data=-3;//因为寻找链表的结尾点要统一加48。又因为‘-’是45。所以等于‘-3’
}
pstart =head;//寻找链表的结尾点
while(pstart->next != 0)
{
pstart->data += 48;//!!<<<因为我们的输出是字符。所以再此加上48>>>> 逆顺输出
pstart = pstart->next ;
}
int tip = 0;//转为字符串用
clear0=0;// 消除结果最前面无用的'0' 13-5 = 08 的效果 ..>>修改字符串的首指针
pstart = pstart->ahead ;//找有效字
while(pstart != 0)//输出正序的结果；
{ if(clear0==0 && ((int)pstart->data)==48&&pstart->ahead!=0)// 消除结果最前面无用的'0' ;
//不输出任何东西
else
result[tip++] = pstart->data;
if(((int)pstart->data)!=48&&((int)pstart->data)!=45)clear0=1;//'－'号
pstart = pstart->ahead ;
}
result[tip] = '\0';
pstart =head; //释放空间
while(pstart->next != 0)
{
pnew = pstart->next ;
delete pstart;
pstart =pnew;
}
return ;
}
/*--------------------------------------------------------------------------
*函数名称： 大数乘法
*函数过程：1 输入两个大数作为字符串
* 2 作一个双向链表
* 3 两个指针分别指向数字字符串的最低位
* 4 以第一个数的最低的一个位乘以第二个数的所有项存于链表中
* 5 链表首指针移
* 6 重复4，5依次从最低位乘到最高位
* 7 乘完后因为最低位是链表首，最后一位是链表尾。所以在逆顺输出链表。
* 4 直到循环结束
*入口参数：numa，numb，result字符串
*出口参数：无
*--------------------------------------------------------------------------*/
/*

void multiply(char *numa, char *numb ,char *result)//用来储结果的)//计算乘积
{ char *pna = findend(numa);//指向numa的一个指针。point numa pna 指向乘数的最低位，
char *pnb = findend(numb);//指向numb的一个指针
//pnb 指向被乘数的最低位，
int along=(int)strlen(numa);//标记数字a的长度；
int blong=(int)strlen(numb);//标记数字b的长度；
int carry=0,temp_result;//存贮进位 和临时结果的
Node *head, // 用于存贮头指针
*pstart, // 用于存贮计算时的首指针
*pnew, //作于申请新结点
*pgo; //作为每计算完一行时，回到下一行起始节点用,移位标致来用
head = pstart =new Node;//初始化首结点和头结点。
pstart -> data = 0;
pstart -> next = NULL;
pstart -> ahead = NULL;
while (along--)
{
pgo = pstart;//保存进位点
blong = (int)strlen(numb);//初始化长度
pnb = findend(numb); //初始化指针
while ((blong-- && (blong>=0))|| carry != 0)
{ if(!pstart->next)//如果当前为空结点，则申请新结点
{ pnew = new Node;
pnew -> data = 0;
pnew -> next = NULL;
pnew -> ahead = pstart;
pstart -> next = pnew;
}
if(blong<0)temp_result = carry ;//处理只有进位的情况
else temp_result =(pstart->data+(*pna-48)*(*pnb-48)+carry);//自身值+新值+进位作为新值
pstart -> data = temp_result%10; //存贮个位
carry = temp_result/10; //存贮进位
pstart = pstart -> next; //结点移动
pnb--; //指针移向被乘数高位
}
pstart = pgo->next; //前进一个位置；
pna--; //指针移向乘数高位
}
pstart =head;//寻找链表的结尾点
while(pstart->next != 0) {
pstart->data += 48;//!!<<<因为我们的输出是字符。所以再此加上48>>>> 逆顺输出
pstart = pstart->next ; }
int tip = 0;//转为字符串用
pstart = pstart->ahead ;//找有效字
while(pstart != 0)//输出正序的结果；
{ result[tip++] = pstart->data;
pstart = pstart->ahead ; }
result[tip] = '\0';
pstart =head; //释放空间
while(pstart->next != 0) {
pnew = pstart->next ;
delete pstart;
pstart =pnew;
}
return ;
}

/*--------------------------------------------------------------------------
*函数名称： 大数除法2--
*函数想法：1 用指针指向除数的最高位，保存临时字符串； tempstr[a++] = pna
* 2 如果临时字符串大于被除数，则相减。结果等于余数
* if(tempstr>numb)tempstr = tempstr - numb
* 3 如果小于被除数且指针到头，余数 等于 临时字符串
* if(tempstr *
*入口参数：numa，numb，result,remainder字符串
*出口参数：无
*--------------------------------------------------------------------------*/
/*
void divide2( char *numa, char *numb,char *result,char *remainder)//计算除法2
{ char one[]="1";//临时字符串....
char one2[]="1";//
char zero[]="0";//
char numb2[6048];//
char tempstr[6018]="";//临时字符串 i
nt ia=0,ia2=0;//tempstr的指示器
bool moveon=false;//翻转牌
char *pna = numa;//指向numa的一个指针point numa pna //指向减数的最低位，
char *pnb = findend(numb);//指向numb的一个指针 //pnb 指向被减数的最低位，
Node *head, // 用于存贮头指针
*pstart, // 用于存贮计算时的首指针
*pnew; //作于申请新结点
head = pstart =new Node;//初始化首结点和头结点。
pstart -> data = 0;
pstart -> next = NULL;
pstart -> ahead = NULL;
moveon = false; while(*pna)
{ if(!pstart->next)//如果当前为空结点，则申请新结点
{ pnew = new Node;
pnew -> data = 0;
pnew -> next = NULL;
pnew -> ahead = pstart;
pstart -> next = pnew; }
ia=(int)strlen(tempstr);//取的长度
tempstr[ia++] = *(pna++);
tempstr[ia] ='\0'; //转换为字符串
if(tempstr[0]=='0')//处理高位也是0的那种 如00
{
ia2=0;
while(tempstr[ia2]=='0')++ia2;
while(ia2>=1)//清除无用的0
{
ia=ia2-1;
tempstr[ia]=tempstr[ia2];
--ia2;
}
tempstr[++ia2]='\0';
}
while(abigerb(tempstr,numb)>0)//如果tempstr大于等于numb
{
if(tempstr[0]=='0')//处理高位也是0的那种 如00----此乃冗余代码，留做记念用
{
ia2=0;
while(tempstr[ia2]=='0')++ia2;
if(ia==ia2 )
{ moveon = true; break; }
}
strcpy(numb2,numb);
subtract(tempstr, numb,tempstr);//A-B strcpy(numb,numb2);
if(tempstr[0]=='-')//若判断的不准，变为了负数就再加上B。。
{
strcpy(numb2,numb);
addition(tempstr, numb,tempstr);//A-B
strcpy(numb,numb2);
ia2=0; //修正之后的长度。因为加法中未做负数运算
ia=0; //为了消除最后的那一个负号，整体向前移动。
while(tempstr[ia2]!='\0')++ia2;
while(ia2>=1)//清除无用的0 {
tempstr[ia]=tempstr[ia+1];
++ia;
--ia2; }
tempstr[ia]='\0';
moveon = true;
break; }
pstart->data++ ; //结果自加
moveon = true; }
if(moveon) pstart = pstart -> next; //结点移动
}
strcpy(remainder,tempstr);//存贮余数
int tip = 0;//转为字符串用
pstart =head;//寻找链表的结尾点
while(pstart->next != 0) {
pstart->data += 48;//!!<<<因为我们的输出是字符。所以再此加上48>>>> 逆顺输出
result[tip++] = pstart->data;
pstart = pstart->next ; }
result[tip] = '\0';//存贮结果
pstart =head; //释放空间
while(pstart->next != 0) {
pnew = pstart->next ;delete pstart; pstart =pnew; }
return ;
}
*/
