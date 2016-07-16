#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<conio.h>
#define INITSIZE 100
#define INCREASE 10
typedef struct SqStack
{
    char *base;
    char *top;
    int stacksize;
}SqStack;
SqStack s;
void Initstack()
{
    s.base=(char *)malloc(INITSIZE*sizeof(int));
    if(!(s.base))             //�洢����ʧ��
        exit(-2);
    s.top=s.base;
    s.stacksize=INITSIZE;
}
int stackempty()
{
    if(s.base==s.top)
        return 1;
    else if(s.base!=s.top)
        return 1;
    else
        return 0;
}
void push(char *e)
{
    if(s.top-s.base>=s.stacksize)//ջ����׷�Ӵ���ռ�
    {
        s.base=(char *)malloc((s.stacksize+INCREASE)*sizeof(int));
        if((!s.base))             //�洢����ʧ��
            exit(-2);
        s.top=s.base+s.stacksize;
        s.stacksize+=INCREASE;
    }
    s.top=e;
    s.top++;
}
int pop()
{
    if(s.top==s.base)
    {
        return 1;
    }
    else
    {
        s.top--;
        return 0;
    }
}

int operta(char ch)
{
    if(ch=='+'||ch=='-'||ch=='*'||ch=='/')
        return 1;
    else
        return 0;
}
int num(char ch)
{
    if(ch<='9'&&ch>='0')
        return 1;
    return 0;
}
void test(char *a)
{
    int len;
    int i;
    len=strlen(a);
    for(i=0;i<len;i++)
    {
        if(a[i]=='(')
        {
            if(a[i+1]==')')
            {
                printf("���ʽ����\n");
                return;
            }
            else
                push(&a[i]);
        }
        if(operta(a[i]))
        {
            if(a[i+1]==')')
            {
                printf("���ʽ����\n");
                return;
            }
        }
        if(num(a[i]))
        {
            if(a[i+1]=='(')
            {
                printf("���ʽ����\n");
                return;
            }
        }
        if(a[i]==')')
        {
            if(pop()==0)
            {
                printf("���ʽ����\n");
                return;
            }
        }
    }
    if(stackempty())
    {
        printf("���ʽ��ȷ\n");
    }
    else
        printf("���ʽ����\n");
}
int main()
{
    char a[100];
    printf("������ʽ\n");
    scanf("%s",a);
    test(a);
    getch();
    return 0;
}
