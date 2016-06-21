//#include<stdio.h>
//#include<string.h>
//#include<stdlib.h>
//#define OK 1
//#define TRUE 1
//#define FALSE 0
//#define ERROR 0
//#define OVERFLOW -2
//#define PR printf
//typedef int status;
//typedef struct airline{
//    char line_num[8];//航班号
//    char plane_num[8];//飞机号
//    char end_place[20];//目的的
//    int total;//座位总数
//    int left;//剩余座位
//    struct airline *next;//下一个结点
//}airline;
//
//typedef struct customer{
//    char name[9];//顾客名
//    char line_num[8];//航班号
//    int seat_num;//座位号
//    struct customer *next;//下一个结点
//}customer;
//
//airline *init_airline(){//初始化链表
//    airline *l;
//    l=(airline*)malloc(sizeof(airline));
//    if(l==NULL){
//        exit(0);
//        }
//    l->next=NULL;
//    return l;
//}
//
//customer * init_customer(){//初始化链表
//    customer *l;
//    l=(customer*)malloc(sizeof(customer));
//    if(l==NULL){
//        exit(0);
//        }
//    l->next=NULL;
//    return l;
//}
//
//status insert_airline(airline **p,char *line_num,char *plane_num,char *end_place,int total,int left){//airline链表插入操作
//    airline *q;
//    q=(airline*)malloc(sizeof(airline));
//    /*{
//        PR("内存分配失败\n");
//        return OVERFLOW;
//    }*/
//    strcpy(q->line_num , line_num);
//    strcpy(q->plane_num , plane_num);
//    strcpy(q->end_place , end_place);
//    q->total  =total;
//    q->left =left;
//    q->next=NULL;
//    (*p)->next=q;
//    (*p)=(*p)->next;
// //   PR("insert %d ,%dis succssed!\n",e,bl);
//    return OK;
//    }
//
//status insert_customer(customer **p,char *name,char *line_num,int seat){//customer链表插入操作
//    customer *q;
//    q=(customer*)malloc(sizeof(customer));
///*  {
//        PR("内存分配失败\n");
//        return OVERFLOW;
//    }*/
//    strcpy(q->name , name);
//    strcpy(q->line_num , line_num);
//    q->seat_num =seat;
//    q->next=NULL;
//    (*p)->next=q;
//    (*p)=(*p)->next;
// //   PR("insert %d ,%dis succssed!\n",e,bl);
//    return OK;
//    }
//
//airline *modefy_airline(airline *l,char *line_num)//修改airline链表中的数据
//{
//    airline *p;
//    p=l->next ;
//    for(;p!=NULL;p=p->next )
//    {
//        if(strcmp(line_num,p->line_num )==0)
//        {
//            p->left ++;
//    //      PR("modefy %s\n",p->line_num );
//            return l;
//        }
//    }
//    PR("没有这个航班，无法完成修改任务！\n");
//    return 0;
//}
//
//status delete_airline(airline *h,char *line_num)//删除航班
//{
//    airline *p,*pr;
//    pr=h;
//    p=pr->next ;
//    while(p!=NULL)
//    {
//        if(strcmp(line_num,p->line_num )==0)
//        {
//            pr->next =p->next ;
//            PR("删除  %s  航班\n",p->line_num  );
//            return OK;
//        }
//        pr=pr->next ;
//        p=pr->next ;
//    }
//    PR("无此航班，无法删除！\n");
//    return ERROR;
//}
//
//status delete_customer(customer *h,char *line_num)//删除顾客
//{
//    customer *p,*pr;
//    pr=h;
//    p=pr->next ;
//    while(p!=NULL)
//    {
//        if(strcmp(line_num,p->line_num )==0)
//        {
//            pr->next =p->next ;
//        }
//        pr=pr->next ;
//        p=pr->next ;
//    }
////  PR("无此航班，无法删除！\n");
//    return OK;
//}
//
//status delete_cus(customer *h,airline *l,char *name)//顾客退票
//{
//    customer *p,*pr;
//    char line_num[8];
////  qr=h;
//    pr=h;
//    p=pr->next ;
////  PR("开始删除\n");
//    while(p!=NULL)
//    {
//        if(strcmp(name,p->name )==0)
//        {
//            strcpy(line_num,p->line_num );
//            l=modefy_airline(l,line_num);
//            pr->next =p->next ;
//            PR("顾客 %s 退票成功!\n",p->name );
//            return OK;
//        }
//        pr=pr->next ;
//        p=pr->next ;
//    }
//    PR("无此顾客，无法退票！\n");
//    return ERROR;
//}
//
//status save_airline(airline *l)//保存airline.dat
//{
//    FILE *fp_airline;
//    char ch='#';
//    airline *p=l->next ;
//    char filename[]="c:\\airline.dat";
//    if((fp_airline=fopen(filename,"wb"))==NULL)
//    {
//        printf("can not open file to write:%s\n",filename);
//        return ERROR;
//    }
//    for(;p!=NULL;p=p->next )
//    {
//    //  printf("%s,%s,%s,%d,%d\n",p->line_num ,p->plane_num ,p->end_place ,p->total ,p->left );
//        fprintf(fp_airline,"%s,%s,%s,%d,%d%c\n",p->line_num ,p->plane_num ,p->end_place ,p->total ,p->left ,ch);
//    }
//    fclose(fp_airline);
//    return OK;
//}
//
//status save_customer(customer *l)//保存顾客信息 customer.dat
//{
//    FILE *fp_customer;
//    char ch='#';
//    customer *p=l->next ;
//    char filename[]="c:\\customer.dat";
//    if((fp_customer=fopen(filename,"wb"))==NULL)
//    {
//        printf("can not open file to write:%s\n",filename);
//        return ERROR;
//    }
//    for(;p!=NULL;p=p->next )
//    {
//    //  PR("%s,%s,%d\n",p->name ,p->line_num ,p->seat_num );
//        fprintf(fp_customer,"%s,%s,%d%c",p->name ,p->line_num ,p->seat_num ,ch);
//    }
//    fclose(fp_customer);
//    return OK;
//}
//
//int changStrInt(char *ch)//把字符串转化为整型
//{
//    int a=1,b=0,c=0,i;
//    for (i=strlen(ch)-1;i>=0;i--)
//    {
//        if (ch[i]<58&&ch[i]>47)
//        {
//            b=a*(ch[i]-48);
//            a=a*10;
//            c=c+b;
//
//        }
//        else
//        {
//            PR("%c 不合法,无法将此字符串转化为整形!\n",ch[i]);
//            return 0;
//        }
////  printf("the c is %d\n",c);
//    }
//    return c;
//}
//
//status creat_airline(airline **l)//创建airline单链表
//{
//    airline *p=*l;
//    int i=0;
//    char *line_num[3]={"bjnc01","bjsh02","shgz03"};
//    char *plane_num[3]={"plane1","plane2","plane3"};
//    char *end_place[3]={"南昌","上海","广州"};
//    int total[3]={100,100,100};
//    int left[3]={51,50,78};
//    for (i=0;i<3;i++){
//        insert_airline(&p,line_num[i],plane_num[i],end_place[i],total[i],left[i]);
//    }
//    return OK;
//}
//
//status creat_customer(customer **l)////创建customer单链表
//{
//    customer *p=*l;
//    int i=0;
//    char *name[3]={"欧阳锦林","尹焕亮","付胜"};
//    char *line_num[3]={"bjnc01","bjsh02","shgz03"};
//    int seat_num[3]={1,5,10};
//    for (i=0;i<3;i++){
//        insert_customer(&p,name[i],line_num[i],seat_num[i]);
//    }
//    return OK;
//}
//
//status increase_air(airline *l,char *line_num,char *plane_num,char *end_place,int total)//增加航线
//{
//    airline *p=l->next ;
//    for(;p->next !=NULL;p=p->next){}
//    insert_airline(&p,line_num,plane_num,end_place,total,total);
//    PR("增加航班 %s 成功!\n",line_num);
//    return OK;
//}
//
//status book(airline *l,char *line_num,customer *c,char *name)//订票
//{
//    airline *p=l;
//    customer *q=c->next ;
//    p=l->next ;
//    for(;q->next !=NULL;q=q->next){}
////  PR("%s\n",q->name );
//    for(;p!=NULL;p=p->next )
//    {
//        if(strcmp(line_num,p->line_num )==0)
//        {
//            if(p->left >0)
//            {
//                PR("恭喜您!订票成功!\n");
//                PR("你的座位号是:  %d\n",(p->total -p->left +1));
//                insert_customer(&q,name,line_num,p->total -p->left +1);
//                p->left --;
//                return OK;
//            }
//            else PR("对不起,座位已满!\n");
//            return 0;
//        }
//    }
//    PR("对不起,没有这个航班号!\n");
//    return ERROR;
//}
//
//status print_airline(airline *l)//打印航线信息
//{
//    airline *p=l->next ;
//    for(;p!=NULL;p=p->next )
//    {
//        PR("%8s%8s%8s%9d%9d\n",p->line_num ,p->plane_num ,p->end_place ,p->total ,p->left );
//    }
//    return OK;
//}
//
//status print_customer(customer *l)//打印顾客信息
//{
//    customer *p=l->next ;
//    for(;p!=NULL;p=p->next )
//    {
//        PR("%10s      %10s       %d\n",p->name ,p->line_num ,p->seat_num );
//    }
//    return OK;
//}
//
//void main()
//{
//    char choice,choice2,name[9],line_num[8],password[9],plane_num[8],end_place[9];
//    char pass[9]="wj024",re_pass_1[9],re_pass_2[9];
//    int t=1,tt=1,total;
//    airline *air=init_airline();
//    customer *cus=init_customer();
//    PR("    微机024班 数据结构 课程设计 (一)\n");
//    PR("        航空订票系统\n");
//    PR("    小组成员:欧阳锦林,王峰,段静缘\n");
//    creat_airline(&air);
//    creat_customer(&cus);
//    save_airline(air);
//    save_customer(cus);
//    while(t==1)
//    {
//        PR("*----------------------------*\n");
//        PR("*--航空订票系统选择菜单------*\n");
//        PR("*    订票-------0        *\n");
//        PR("*    退票-------1        *\n");
//        PR("*    查询-------2        *\n");
//        PR("*    修改航线---3        *\n");
//        PR("*    退出-------4        *\n");
//        PR("*----------------------------*\n");
//        PR("请选择: ");
//        choice =(char) getch();
//        PR("%c",choice);
//        if(choice=='0')
//        {
//            PR("\n请输入你要订的航班号: ");
//            scanf( "%s",line_num);
//            PR("请输入你的姓名: ");
//            scanf( "%s",name);
//            book(air,line_num,cus,name);
//            save_airline(air);
//            save_customer(cus);
//        }
//        else if(choice=='1')
//        {
//            PR("\n请输入你的姓名: ");
//            scanf( "%s",name);
//            delete_cus(cus,air,name);
//            save_airline(air);
//            save_customer(cus);
//        }
//        else if(choice=='2')
//        {
//            PR("\n  航班号  飞机号   目的地    总票数   余票数\n");
//            print_airline(air);
//            PR("    姓名            航班号      座位号\n");
//            print_customer(cus);
//        }
//        else if(choice=='3')
//        {
//            tt=1;
//            PR("请输入密码: ");
//            scanf("%s",password);
//            if(strcmp(password,pass)==0)
//            {
//                while (tt==1){
//                    PR("\n*------------------------------*\n");
//                    PR("*-------航线信息修改:----------*\n");
//                    PR("*   增加航班号-----'0'     *\n");
//                    PR("*   删除航班号-----'1'     *\n");
//                    PR("*   修改密码-------'2'     *\n");
//                    PR("*   查询航线信息---'3'     *\n");
//                    PR("*   退出航线修改---'4'     *\n");
//                    PR("*------------------------------*\n");
//                    PR("请选择: ");
//
//                    choice2=getch();
//                    PR("%c\n",choice2);
//                    if(choice2=='0')
//                    {
//                        PR("请输入你要增加的航班号: ");
//                        scanf("%s",line_num);
//                        PR("请输入飞机号: ");
//                        scanf("%s",plane_num);
//                        PR("请输入目的地: ");
//                        scanf("%s",end_place);
//                        PR("请输入座位总数: ");
//                        scanf("%d",&total);
//                        increase_air(air,line_num,plane_num,end_place,total);
//                        save_airline(air);
//                        save_customer(cus);
//                    }
//                    else if (choice2=='1')
//                    {
//                        PR("请输入你要删除的航班号: \n");
//                        scanf("%s",line_num);
//                        delete_airline(air,line_num);
//                        delete_customer(cus,line_num);
//                        save_airline(air);
//                        save_customer(cus);
//                    }
//                    else if(choice2=='2')
//                    {
//                        PR("注意:密码不能超过8位!\n");
//                        PR("请输入新密码：");
//                        scanf("%s",re_pass_1);
//                        PR("请再输入一次: ");
//                        scanf("%s",re_pass_2);
//                        if(strcmp(re_pass_1,re_pass_2)==0)
//                        {
//                            strcpy(pass,re_pass_1);
//                            PR("密码修改成功!请记住.\n");
//                        }
//                        else {
//                            PR("你两次输入的密码不一致!\n");
//                        }
//                    }
//                    else if(choice2=='3')
//                    {
//                        PR("\n  航班号  飞机号   目的地    总票数   余票数\n");
//                        print_airline(air);
//                    }
//                    else if(choice2=='4')
//                    {
//                        tt=0;
//                    }
//                    else {
//                        PR("你的输入有误\n");
//                        tt=0;
//                    }
//                }//end while
//            }//end if
//            else {
//                PR("对不起!你输入的密码不正确!\n");
//            }
//        }//end else if 修改
//        else if(choice=='4')
//        {
//            PR("再见!");
//            t=0;
//        }
//        else
//        {
//            PR("你的输入有误\n");
//        }
//    }
//    getch();
//}





#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define OK 1
#define TRUE 1
#define FALSE 0
#define ERROR 0
#define OVERFLOW -2
#define PR printf
typedef int status;
typedef struct airline{
    char line_num[8];//航班号
    char plane_num[8];//飞机号
    char end_place[20];//目的的
    int total;//座位总数
    int left;//剩余座位
    struct airline *next;//下一个结点
}airline;

typedef struct customer{
    char name[9];//顾客名
    char line_num[8];//航班号
    int seat_num;//座位号
    struct customer *next;//下一个结点
}customer;

airline *init_airline(){//初始化链表
    airline *l;
    l=(airline*)malloc(sizeof(airline));
    if(l==NULL){
        exit(0);
        }
    l->next=NULL;
    return l;
}

customer * init_customer(){//初始化链表
    customer *l;
    l=(customer*)malloc(sizeof(customer));
    if(l==NULL){
        exit(0);
        }
    l->next=NULL;
    return l;
}

status insert_airline(airline **p,char *line_num,char *plane_num,char *end_place,int total,int left){//airline链表插入操作
    airline *q;
    q=(airline*)malloc(sizeof(airline));
    strcpy(q->line_num , line_num);
    strcpy(q->plane_num , plane_num);
    strcpy(q->end_place , end_place);
    q->total  =total;
    q->left =left;
    q->next=NULL;
    (*p)->next=q;
    (*p)=(*p)->next;
 //   PR("insert %d ,%dis succssed!\n",e,bl);
    return OK;
    }

status insert_customer(customer **p,char *name,char *line_num,int seat){//customer链表插入操作
    customer *q;
    q=(customer*)malloc(sizeof(customer));
/*  {
        PR("内存分配失败\n");
        return OVERFLOW;
    }*/
    strcpy(q->name , name);
    strcpy(q->line_num , line_num);
    q->seat_num =seat;
    q->next=NULL;
    (*p)->next=q;
    (*p)=(*p)->next;
 //   PR("insert %d ,%dis succssed!\n",e,bl);
    return OK;
    }

airline *modefy_airline(airline *l,char *line_num)//修改airline链表中的数据
{
    airline *p;
    p=l->next ;
    for(;p!=NULL;p=p->next )
    {
        if(strcmp(line_num,p->line_num )==0)
        {
            p->left ++;
    //      PR("modefy %s\n",p->line_num );
            return l;
        }
    }
    PR("没有这个航班，无法完成修改任务！\n");
    return 0;
}

status delete_airline(airline *h,char *line_num)//删除航班
{
    airline *p,*pr;
    pr=h;
    p=pr->next ;
    while(p!=NULL)
    {
        if(strcmp(line_num,p->line_num )==0)
        {
            pr->next =p->next ;
            PR("删除  %s  航班\n",p->line_num  );
            return OK;
        }
        pr=pr->next ;
        p=pr->next ;
    }
    PR("无此航班，无法删除！\n");
    return ERROR;
}

status delete_customer(customer *h,char *line_num)//删除顾客
{
    customer *p,*pr;
    pr=h;
    p=pr->next ;
    while(p!=NULL)
    {
        if(strcmp(line_num,p->line_num )==0)
        {
            pr->next =p->next ;
        }
        pr=pr->next ;
        p=pr->next ;
    }
//  PR("无此航班，无法删除！\n");
    return OK;
}

status delete_cus(customer *h,airline *l,char *name)//顾客退票
{
    customer *p,*pr;
    char line_num[8];
//  qr=h;
    pr=h;
    p=pr->next ;
//  PR("开始删除\n");
    while(p!=NULL)
    {
        if(strcmp(name,p->name )==0)
        {
            strcpy(line_num,p->line_num );
            l=modefy_airline(l,line_num);
            pr->next =p->next ;
            PR("顾客 %s 退票成功!\n",p->name );
            return OK;
        }
        pr=pr->next ;
        p=pr->next ;
    }
    PR("无此顾客，无法退票！\n");
    return ERROR;
}

status save_airline(airline *l)//保存airline.dat
{
    FILE *fp_airline;
    char ch='#';
    airline *p=l->next ;
    char filename[]="c:\\airline.dat";
    if((fp_airline=fopen(filename,"wb"))==NULL)
    {
        printf("can not open file to write:%s\n",filename);
        return ERROR;
    }
    for(;p!=NULL;p=p->next )
    {
    //  printf("%s,%s,%s,%d,%d\n",p->line_num ,p->plane_num ,p->end_place ,p->total ,p->left );
        fprintf(fp_airline,"%s,%s,%s,%d,%d%c\n",p->line_num ,p->plane_num ,p->end_place ,p->total ,p->left ,ch);
    }
    fclose(fp_airline);
    return OK;
}

status save_customer(customer *l)//保存顾客信息 customer.dat
{
    FILE *fp_customer;
    char ch='#';
    customer *p=l->next ;
    char filename[]="c:\\customer.dat";
    if((fp_customer=fopen(filename,"wb"))==NULL)
    {
        printf("can not open file to write:%s\n",filename);
        return ERROR;
    }
    for(;p!=NULL;p=p->next )
    {
    //  PR("%s,%s,%d\n",p->name ,p->line_num ,p->seat_num );
        fprintf(fp_customer,"%s,%s,%d%c",p->name ,p->line_num ,p->seat_num ,ch);
    }
    fclose(fp_customer);
    return OK;
}

int changStrInt(char *ch)//把字符串转化为整型
{
    int a=1,b=0,c=0,i;
    for (i=strlen(ch)-1;i>=0;i--)
    {
        if (ch[i]<58&&ch[i]>47)
        {
            b=a*(ch[i]-48);
            a=a*10;
            c=c+b;

        }
        else
        {
            PR("%c 不合法,无法将此字符串转化为整形!\n",ch[i]);
            return 0;
        }
//  printf("the c is %d\n",c);
    }
    return c;
}

status insert_air(airline *l,char *line_num,char *plane_num,char *end_place,int total,int left){//airline链表插入操作
    airline *q;
    q=(airline*)malloc(sizeof(airline));
    strcpy(q->line_num , line_num);
    strcpy(q->plane_num , plane_num);
    strcpy(q->end_place , end_place);
    q->total  =total;
    q->left =left;
    q->next=l->next ;
    l->next=q;
 //   PR("insert %d ,%dis succssed!\n",e,bl);
    return OK;
    }

status insert_cus(customer *l,char *name,char *line_num,int seat){//customer链表插入操作
    customer *q;
    q=(customer*)malloc(sizeof(customer));
    strcpy(q->name , name);
    strcpy(q->line_num , line_num);
    q->seat_num =seat;
    q->next=l->next ;
    l->next=q;
    return OK;
    }

status load_airline(airline *l)
{
    FILE *fp_airline;
    int flag=0,i=0;
    char ch;
    char line_num[8];//航班号
    char plane_num[8];//飞机号
    char end_place[20];//目的的
    char total_str[5];
    char left_str[5];
    int total;//座位总数
    int left;//剩余座位
//  airline *p=l;
    char filename[]="c:\\airline.dat";
    if((fp_airline=fopen(filename,"rb"))==NULL)
    {
        printf("can not open file to load:%s\n",filename);
        return ERROR;
    }
    while(!feof(fp_airline))
    {
        ch=fgetc(fp_airline);
        if(ch!='#')
        {
            if(flag==0&&ch!=',')
            {
                line_num[i]=ch;
                i++;
            }
            else if(flag==1&&ch!=',')
            {
                plane_num[i]=ch;
                i++;
            }
            else if(flag==2&&ch!=',')
            {
                end_place[i]=ch;
                i++;
            }
            else if(flag==3&&ch!=',')
            {
                total_str[i]=ch;
                i++;
            }
            else if(flag==4&&ch!=',')
            {
                left_str[i]=ch;
                i++;
            }
            else if (ch==',')
            {
                flag++;
                i=0;
            }
        /*  else
            {
                PR("错误\n");
                return ERROR;
            }*/
        }
        else
        {
            flag=0;
            i=0;
            total=changStrInt(total_str);
            left=changStrInt(left_str);
            PR("%8s%8s%8s%9d%9d\n",line_num ,plane_num ,end_place ,total ,left );
            insert_air(l,line_num,plane_num,end_place,total,left);
        }
    }
    fclose(fp_airline);
    return OK;
}

status load_customer(customer *l)
{
    FILE *fp_customer;
    int flag=0,i=0;
    char ch;
    char name[9];
    char line_num[8];//航班号
    char seat_num_str[5];
    int seat_num;//座位
//  customer *p=*l;
    char filename[50]="c:\\customer.dat";
    if((fp_customer=fopen(filename,"rb"))==NULL)
    {
        printf("can not open file to load:%s\n",filename);
        return ERROR;
    }
    while(!feof(fp_customer))
    {
        ch=fgetc(fp_customer);
        printf("%c\n",ch);
        if(ch!='#')
        {
            if(flag==0&&ch!=',')
            {
                name[i]=ch;
                i++;
            }
            else if(flag==1&&ch!=',')
            {
                line_num[i]=ch;
                i++;
            }
            else if(flag==2&&ch!=',')
            {
                seat_num_str[i]=ch;
                i++;
            }
            else if (ch==',')
            {
                flag++;
                i=0;
            }
            else
            {
                PR("错误\n");
                return ERROR;
            }
        }
        else
        {
            flag=0;
            seat_num=changStrInt(seat_num_str);
            PR("%10s      %10s       %d\n",name ,line_num ,seat_num );
            insert_cus(l,name,line_num,seat_num);
//          p=p->next ;
        }
    }
    fclose(fp_customer);
    return OK;
}

status creat_airline(airline **l)//创建airline单链表
{
    airline *p=*l;
    int i=0;
    char *line_num[3]={"bjnc01","bjsh02","shgz03"};
    char *plane_num[3]={"plane1","plane2","plane3"};
    char *end_place[3]={"nc","sh","gz"};
    int total[3]={100,100,100};
    int left[3]={51,50,78};
    for (i=0;i<3;i++){
        insert_airline(&p,line_num[i],plane_num[i],end_place[i],total[i],left[i]);
    }
    return OK;
}

status creat_customer(customer **l)////创建customer单链表
{
    customer *p=*l;
    int i=0;
    char *name[3]={"ouyangj0","yhl","fs"};
    char *line_num[3]={"bjnc01","bjsh02","shgz03"};
    int seat_num[3]={1,5,10};
    for (i=0;i<3;i++){
        insert_customer(&p,name[i],line_num[i],seat_num[i]);
    }
    return OK;
}

status increase_air(airline *l,char *line_num,char *plane_num,char *end_place,int total)//增加航线
{
    airline *p=l->next ;
    for(;p->next !=NULL;p=p->next){}
    insert_airline(&p,line_num,plane_num,end_place,total,total);
    PR("增加航班 %s 成功!\n",line_num);
    return OK;
}

status book(airline *l,char *line_num,customer *c,char *name)//订票
{
    airline *p=l;
    customer *q=c->next ;
    p=l->next ;
    for(;q->next !=NULL;q=q->next){}
//  PR("%s\n",q->name );
    for(;p!=NULL;p=p->next )
    {
        if(strcmp(line_num,p->line_num )==0)
        {
            if(p->left >0)
            {
                PR("恭喜您!订票成功!\n");
                PR("你的座位号是:  %d\n",(p->total -p->left +1));
                insert_customer(&q,name,line_num,p->total -p->left +1);
                p->left --;
                return OK;
            }
            else PR("对不起,座位已满!\n");
            return 0;
        }
    }
    PR("对不起,没有这个航班号!\n");
    return ERROR;
}

status print_airline(airline *l)//打印航线信息
{
    airline *p=l->next ;
    for(;p!=NULL;p=p->next )
    {
        PR("%8s%8s%8s%9d%9d\n",p->line_num ,p->plane_num ,p->end_place ,p->total ,p->left );
    }
    return OK;
}

status print_customer(customer *l)//打印顾客信息
{
    customer *p=l->next ;
    for(;p!=NULL;p=p->next )
    {
        PR("%10s      %10s       %d\n",p->name ,p->line_num ,p->seat_num );
    }
    return OK;
}

void main()
{
    char choice,choice2,name[9],line_num[8],password[9],plane_num[8],end_place[9];
    char pass[9]="wj024",re_pass_1[9],re_pass_2[9];
    int t=1,tt=1,total;
    airline *air=init_airline();
    customer *cus=init_customer();
    PR("    微机024班 数据结构 课程设计 (一)\n");
    PR("        航空订票系统\n");
    PR("    小组成员:欧阳锦林,王峰,段静缘\n");
    creat_airline(&air);
    creat_customer(&cus);
//  save_airline(air);
//  save_customer(cus);
    while(t==1)
    {
        PR("*----------------------------*\n");
        PR("*--航空订票系统选择菜单------*\n");
        PR("*    订票-------0        *\n");
        PR("*    退票-------1        *\n");
        PR("*    查询-------2        *\n");
        PR("*    修改航线---3        *\n");
        PR("*    读入文件---4        *\n");
        PR("*    退出-------5        *\n");
        PR("*----------------------------*\n");
        PR("请选择: ");
        choice = getch();
        PR("%c\n",choice);
        if(choice=='0')
        {
            PR("请输入你要订的航班号: ");
            scanf( "%s",line_num);
            PR("请输入你的姓名: ");
            scanf( "%s",name);
            book(air,line_num,cus,name);
            save_airline(air);
            save_customer(cus);
        }
        else if(choice=='1')
        {
            PR("\n请输入你的姓名: ");
            scanf( "%s",name);
            delete_cus(cus,air,name);
            save_airline(air);
            save_customer(cus);
        }
        else if(choice=='2')
        {
            PR("\n  航班号  飞机号   目的地    总票数   余票数\n");
            print_airline(air);
            PR("    姓名            航班号      座位号\n");
            print_customer(cus);
        }
        else if(choice=='3')
        {
            tt=1;
            PR("请输入密码: ");
            scanf("%s",password);
            if(strcmp(password,pass)==0)
            {
                while (tt==1){
                    PR("\n*------------------------------*\n");
                    PR("*-------航线信息修改:----------*\n");
                    PR("*   增加航班号-----'0'     *\n");
                    PR("*   删除航班号-----'1'     *\n");
                    PR("*   修改密码-------'2'     *\n");
                    PR("*   查询航线信息---'3'     *\n");
                    PR("*   退出航线修改---'4'     *\n");
                    PR("*------------------------------*\n");
                    PR("请选择: ");

                    choice2=getch();
                    PR("%c\n",choice2);
                    if(choice2=='0')
                    {
                        PR("请输入你要增加的航班号: ");
                        scanf("%s",line_num);
                        PR("请输入飞机号: ");
                        scanf("%s",plane_num);
                        PR("请输入目的地: ");
                        scanf("%s",end_place);
                        PR("请输入座位总数: ");
                        scanf("%d",&total);
                        increase_air(air,line_num,plane_num,end_place,total);
                        save_airline(air);
                        save_customer(cus);
                    }
                    else if (choice2=='1')
                    {
                        PR("请输入你要删除的航班号: ");
                        scanf("%s",line_num);
                        delete_airline(air,line_num);
                        delete_customer(cus,line_num);
                        save_airline(air);
                        save_customer(cus);
                    }
                    else if(choice2=='2')
                    {
                        PR("注意:密码不能超过8位!\n");
                        PR("请输入新密码：");
                        scanf("%s",re_pass_1);
                        PR("请再输入一次: ");
                        scanf("%s",re_pass_2);
                        if(strcmp(re_pass_1,re_pass_2)==0)
                        {
                            strcpy(pass,re_pass_1);
                            PR("密码修改成功!请记住.\n");
                        }
                        else {
                            PR("你两次输入的密码不一致!\n");
                        }
                    }
                    else if(choice2=='3')
                    {
                        PR("\n  航班号  飞机号   目的地    总票数   余票数\n");
                        print_airline(air);
                    }
                    else if(choice2=='4')
                    {
                        tt=0;
                    }
                    else {
                        PR("你的输入有误\n");
                        tt=0;
                    }
                }//end while
            }//end if
            else {
                PR("对不起!你输入的密码不正确!\n");
            }
        }//end else if 修改
        else if(choice=='4')
        {
            load_airline(air);
            load_customer(cus);
        }
        else if(choice=='5')
        {
            PR("再见!");
            t=0;
        }
        else
        {
            PR("你的输入有误\n");
        }
    }
    getch();
}
