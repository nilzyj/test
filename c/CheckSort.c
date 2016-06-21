#include<stdio.h>
#include<string.h>

int fun(char *t)
{
    int len=strlen(t),i,flag=0;
    if(len<2)
    {
        printf("字符串长度小于2");
        return 0;
    }
    for(i=0;i<len;++i)
    {
        if((t[i+1])==(t[i]+1))
            flag=1;
        else
        {
            flag=0;
            return 1;
        }

    }
    return 0;
}

main()
{
    char s[26];
    gets(s);
    if(fun(s))
        printf("yes");
    else
        printf("no");
}
