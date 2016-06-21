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
//    char line_num[8];//�����
//    char plane_num[8];//�ɻ���
//    char end_place[20];//Ŀ�ĵ�
//    int total;//��λ����
//    int left;//ʣ����λ
//    struct airline *next;//��һ�����
//}airline;
//
//typedef struct customer{
//    char name[9];//�˿���
//    char line_num[8];//�����
//    int seat_num;//��λ��
//    struct customer *next;//��һ�����
//}customer;
//
//airline *init_airline(){//��ʼ������
//    airline *l;
//    l=(airline*)malloc(sizeof(airline));
//    if(l==NULL){
//        exit(0);
//        }
//    l->next=NULL;
//    return l;
//}
//
//customer * init_customer(){//��ʼ������
//    customer *l;
//    l=(customer*)malloc(sizeof(customer));
//    if(l==NULL){
//        exit(0);
//        }
//    l->next=NULL;
//    return l;
//}
//
//status insert_airline(airline **p,char *line_num,char *plane_num,char *end_place,int total,int left){//airline����������
//    airline *q;
//    q=(airline*)malloc(sizeof(airline));
//    /*{
//        PR("�ڴ����ʧ��\n");
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
//status insert_customer(customer **p,char *name,char *line_num,int seat){//customer����������
//    customer *q;
//    q=(customer*)malloc(sizeof(customer));
///*  {
//        PR("�ڴ����ʧ��\n");
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
//airline *modefy_airline(airline *l,char *line_num)//�޸�airline�����е�����
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
//    PR("û��������࣬�޷�����޸�����\n");
//    return 0;
//}
//
//status delete_airline(airline *h,char *line_num)//ɾ������
//{
//    airline *p,*pr;
//    pr=h;
//    p=pr->next ;
//    while(p!=NULL)
//    {
//        if(strcmp(line_num,p->line_num )==0)
//        {
//            pr->next =p->next ;
//            PR("ɾ��  %s  ����\n",p->line_num  );
//            return OK;
//        }
//        pr=pr->next ;
//        p=pr->next ;
//    }
//    PR("�޴˺��࣬�޷�ɾ����\n");
//    return ERROR;
//}
//
//status delete_customer(customer *h,char *line_num)//ɾ���˿�
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
////  PR("�޴˺��࣬�޷�ɾ����\n");
//    return OK;
//}
//
//status delete_cus(customer *h,airline *l,char *name)//�˿���Ʊ
//{
//    customer *p,*pr;
//    char line_num[8];
////  qr=h;
//    pr=h;
//    p=pr->next ;
////  PR("��ʼɾ��\n");
//    while(p!=NULL)
//    {
//        if(strcmp(name,p->name )==0)
//        {
//            strcpy(line_num,p->line_num );
//            l=modefy_airline(l,line_num);
//            pr->next =p->next ;
//            PR("�˿� %s ��Ʊ�ɹ�!\n",p->name );
//            return OK;
//        }
//        pr=pr->next ;
//        p=pr->next ;
//    }
//    PR("�޴˹˿ͣ��޷���Ʊ��\n");
//    return ERROR;
//}
//
//status save_airline(airline *l)//����airline.dat
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
//status save_customer(customer *l)//����˿���Ϣ customer.dat
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
//int changStrInt(char *ch)//���ַ���ת��Ϊ����
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
//            PR("%c ���Ϸ�,�޷������ַ���ת��Ϊ����!\n",ch[i]);
//            return 0;
//        }
////  printf("the c is %d\n",c);
//    }
//    return c;
//}
//
//status creat_airline(airline **l)//����airline������
//{
//    airline *p=*l;
//    int i=0;
//    char *line_num[3]={"bjnc01","bjsh02","shgz03"};
//    char *plane_num[3]={"plane1","plane2","plane3"};
//    char *end_place[3]={"�ϲ�","�Ϻ�","����"};
//    int total[3]={100,100,100};
//    int left[3]={51,50,78};
//    for (i=0;i<3;i++){
//        insert_airline(&p,line_num[i],plane_num[i],end_place[i],total[i],left[i]);
//    }
//    return OK;
//}
//
//status creat_customer(customer **l)////����customer������
//{
//    customer *p=*l;
//    int i=0;
//    char *name[3]={"ŷ������","������","��ʤ"};
//    char *line_num[3]={"bjnc01","bjsh02","shgz03"};
//    int seat_num[3]={1,5,10};
//    for (i=0;i<3;i++){
//        insert_customer(&p,name[i],line_num[i],seat_num[i]);
//    }
//    return OK;
//}
//
//status increase_air(airline *l,char *line_num,char *plane_num,char *end_place,int total)//���Ӻ���
//{
//    airline *p=l->next ;
//    for(;p->next !=NULL;p=p->next){}
//    insert_airline(&p,line_num,plane_num,end_place,total,total);
//    PR("���Ӻ��� %s �ɹ�!\n",line_num);
//    return OK;
//}
//
//status book(airline *l,char *line_num,customer *c,char *name)//��Ʊ
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
//                PR("��ϲ��!��Ʊ�ɹ�!\n");
//                PR("�����λ����:  %d\n",(p->total -p->left +1));
//                insert_customer(&q,name,line_num,p->total -p->left +1);
//                p->left --;
//                return OK;
//            }
//            else PR("�Բ���,��λ����!\n");
//            return 0;
//        }
//    }
//    PR("�Բ���,û����������!\n");
//    return ERROR;
//}
//
//status print_airline(airline *l)//��ӡ������Ϣ
//{
//    airline *p=l->next ;
//    for(;p!=NULL;p=p->next )
//    {
//        PR("%8s%8s%8s%9d%9d\n",p->line_num ,p->plane_num ,p->end_place ,p->total ,p->left );
//    }
//    return OK;
//}
//
//status print_customer(customer *l)//��ӡ�˿���Ϣ
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
//    PR("    ΢��024�� ���ݽṹ �γ���� (һ)\n");
//    PR("        ���ն�Ʊϵͳ\n");
//    PR("    С���Ա:ŷ������,����,�ξ�Ե\n");
//    creat_airline(&air);
//    creat_customer(&cus);
//    save_airline(air);
//    save_customer(cus);
//    while(t==1)
//    {
//        PR("*----------------------------*\n");
//        PR("*--���ն�Ʊϵͳѡ��˵�------*\n");
//        PR("*    ��Ʊ-------0        *\n");
//        PR("*    ��Ʊ-------1        *\n");
//        PR("*    ��ѯ-------2        *\n");
//        PR("*    �޸ĺ���---3        *\n");
//        PR("*    �˳�-------4        *\n");
//        PR("*----------------------------*\n");
//        PR("��ѡ��: ");
//        choice =(char) getch();
//        PR("%c",choice);
//        if(choice=='0')
//        {
//            PR("\n��������Ҫ���ĺ����: ");
//            scanf( "%s",line_num);
//            PR("�������������: ");
//            scanf( "%s",name);
//            book(air,line_num,cus,name);
//            save_airline(air);
//            save_customer(cus);
//        }
//        else if(choice=='1')
//        {
//            PR("\n�������������: ");
//            scanf( "%s",name);
//            delete_cus(cus,air,name);
//            save_airline(air);
//            save_customer(cus);
//        }
//        else if(choice=='2')
//        {
//            PR("\n  �����  �ɻ���   Ŀ�ĵ�    ��Ʊ��   ��Ʊ��\n");
//            print_airline(air);
//            PR("    ����            �����      ��λ��\n");
//            print_customer(cus);
//        }
//        else if(choice=='3')
//        {
//            tt=1;
//            PR("����������: ");
//            scanf("%s",password);
//            if(strcmp(password,pass)==0)
//            {
//                while (tt==1){
//                    PR("\n*------------------------------*\n");
//                    PR("*-------������Ϣ�޸�:----------*\n");
//                    PR("*   ���Ӻ����-----'0'     *\n");
//                    PR("*   ɾ�������-----'1'     *\n");
//                    PR("*   �޸�����-------'2'     *\n");
//                    PR("*   ��ѯ������Ϣ---'3'     *\n");
//                    PR("*   �˳������޸�---'4'     *\n");
//                    PR("*------------------------------*\n");
//                    PR("��ѡ��: ");
//
//                    choice2=getch();
//                    PR("%c\n",choice2);
//                    if(choice2=='0')
//                    {
//                        PR("��������Ҫ���ӵĺ����: ");
//                        scanf("%s",line_num);
//                        PR("������ɻ���: ");
//                        scanf("%s",plane_num);
//                        PR("������Ŀ�ĵ�: ");
//                        scanf("%s",end_place);
//                        PR("��������λ����: ");
//                        scanf("%d",&total);
//                        increase_air(air,line_num,plane_num,end_place,total);
//                        save_airline(air);
//                        save_customer(cus);
//                    }
//                    else if (choice2=='1')
//                    {
//                        PR("��������Ҫɾ���ĺ����: \n");
//                        scanf("%s",line_num);
//                        delete_airline(air,line_num);
//                        delete_customer(cus,line_num);
//                        save_airline(air);
//                        save_customer(cus);
//                    }
//                    else if(choice2=='2')
//                    {
//                        PR("ע��:���벻�ܳ���8λ!\n");
//                        PR("�����������룺");
//                        scanf("%s",re_pass_1);
//                        PR("��������һ��: ");
//                        scanf("%s",re_pass_2);
//                        if(strcmp(re_pass_1,re_pass_2)==0)
//                        {
//                            strcpy(pass,re_pass_1);
//                            PR("�����޸ĳɹ�!���ס.\n");
//                        }
//                        else {
//                            PR("��������������벻һ��!\n");
//                        }
//                    }
//                    else if(choice2=='3')
//                    {
//                        PR("\n  �����  �ɻ���   Ŀ�ĵ�    ��Ʊ��   ��Ʊ��\n");
//                        print_airline(air);
//                    }
//                    else if(choice2=='4')
//                    {
//                        tt=0;
//                    }
//                    else {
//                        PR("�����������\n");
//                        tt=0;
//                    }
//                }//end while
//            }//end if
//            else {
//                PR("�Բ���!����������벻��ȷ!\n");
//            }
//        }//end else if �޸�
//        else if(choice=='4')
//        {
//            PR("�ټ�!");
//            t=0;
//        }
//        else
//        {
//            PR("�����������\n");
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
    char line_num[8];//�����
    char plane_num[8];//�ɻ���
    char end_place[20];//Ŀ�ĵ�
    int total;//��λ����
    int left;//ʣ����λ
    struct airline *next;//��һ�����
}airline;

typedef struct customer{
    char name[9];//�˿���
    char line_num[8];//�����
    int seat_num;//��λ��
    struct customer *next;//��һ�����
}customer;

airline *init_airline(){//��ʼ������
    airline *l;
    l=(airline*)malloc(sizeof(airline));
    if(l==NULL){
        exit(0);
        }
    l->next=NULL;
    return l;
}

customer * init_customer(){//��ʼ������
    customer *l;
    l=(customer*)malloc(sizeof(customer));
    if(l==NULL){
        exit(0);
        }
    l->next=NULL;
    return l;
}

status insert_airline(airline **p,char *line_num,char *plane_num,char *end_place,int total,int left){//airline����������
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

status insert_customer(customer **p,char *name,char *line_num,int seat){//customer����������
    customer *q;
    q=(customer*)malloc(sizeof(customer));
/*  {
        PR("�ڴ����ʧ��\n");
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

airline *modefy_airline(airline *l,char *line_num)//�޸�airline�����е�����
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
    PR("û��������࣬�޷�����޸�����\n");
    return 0;
}

status delete_airline(airline *h,char *line_num)//ɾ������
{
    airline *p,*pr;
    pr=h;
    p=pr->next ;
    while(p!=NULL)
    {
        if(strcmp(line_num,p->line_num )==0)
        {
            pr->next =p->next ;
            PR("ɾ��  %s  ����\n",p->line_num  );
            return OK;
        }
        pr=pr->next ;
        p=pr->next ;
    }
    PR("�޴˺��࣬�޷�ɾ����\n");
    return ERROR;
}

status delete_customer(customer *h,char *line_num)//ɾ���˿�
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
//  PR("�޴˺��࣬�޷�ɾ����\n");
    return OK;
}

status delete_cus(customer *h,airline *l,char *name)//�˿���Ʊ
{
    customer *p,*pr;
    char line_num[8];
//  qr=h;
    pr=h;
    p=pr->next ;
//  PR("��ʼɾ��\n");
    while(p!=NULL)
    {
        if(strcmp(name,p->name )==0)
        {
            strcpy(line_num,p->line_num );
            l=modefy_airline(l,line_num);
            pr->next =p->next ;
            PR("�˿� %s ��Ʊ�ɹ�!\n",p->name );
            return OK;
        }
        pr=pr->next ;
        p=pr->next ;
    }
    PR("�޴˹˿ͣ��޷���Ʊ��\n");
    return ERROR;
}

status save_airline(airline *l)//����airline.dat
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

status save_customer(customer *l)//����˿���Ϣ customer.dat
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

int changStrInt(char *ch)//���ַ���ת��Ϊ����
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
            PR("%c ���Ϸ�,�޷������ַ���ת��Ϊ����!\n",ch[i]);
            return 0;
        }
//  printf("the c is %d\n",c);
    }
    return c;
}

status insert_air(airline *l,char *line_num,char *plane_num,char *end_place,int total,int left){//airline����������
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

status insert_cus(customer *l,char *name,char *line_num,int seat){//customer����������
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
    char line_num[8];//�����
    char plane_num[8];//�ɻ���
    char end_place[20];//Ŀ�ĵ�
    char total_str[5];
    char left_str[5];
    int total;//��λ����
    int left;//ʣ����λ
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
                PR("����\n");
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
    char line_num[8];//�����
    char seat_num_str[5];
    int seat_num;//��λ
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
                PR("����\n");
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

status creat_airline(airline **l)//����airline������
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

status creat_customer(customer **l)////����customer������
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

status increase_air(airline *l,char *line_num,char *plane_num,char *end_place,int total)//���Ӻ���
{
    airline *p=l->next ;
    for(;p->next !=NULL;p=p->next){}
    insert_airline(&p,line_num,plane_num,end_place,total,total);
    PR("���Ӻ��� %s �ɹ�!\n",line_num);
    return OK;
}

status book(airline *l,char *line_num,customer *c,char *name)//��Ʊ
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
                PR("��ϲ��!��Ʊ�ɹ�!\n");
                PR("�����λ����:  %d\n",(p->total -p->left +1));
                insert_customer(&q,name,line_num,p->total -p->left +1);
                p->left --;
                return OK;
            }
            else PR("�Բ���,��λ����!\n");
            return 0;
        }
    }
    PR("�Բ���,û����������!\n");
    return ERROR;
}

status print_airline(airline *l)//��ӡ������Ϣ
{
    airline *p=l->next ;
    for(;p!=NULL;p=p->next )
    {
        PR("%8s%8s%8s%9d%9d\n",p->line_num ,p->plane_num ,p->end_place ,p->total ,p->left );
    }
    return OK;
}

status print_customer(customer *l)//��ӡ�˿���Ϣ
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
    PR("    ΢��024�� ���ݽṹ �γ���� (һ)\n");
    PR("        ���ն�Ʊϵͳ\n");
    PR("    С���Ա:ŷ������,����,�ξ�Ե\n");
    creat_airline(&air);
    creat_customer(&cus);
//  save_airline(air);
//  save_customer(cus);
    while(t==1)
    {
        PR("*----------------------------*\n");
        PR("*--���ն�Ʊϵͳѡ��˵�------*\n");
        PR("*    ��Ʊ-------0        *\n");
        PR("*    ��Ʊ-------1        *\n");
        PR("*    ��ѯ-------2        *\n");
        PR("*    �޸ĺ���---3        *\n");
        PR("*    �����ļ�---4        *\n");
        PR("*    �˳�-------5        *\n");
        PR("*----------------------------*\n");
        PR("��ѡ��: ");
        choice = getch();
        PR("%c\n",choice);
        if(choice=='0')
        {
            PR("��������Ҫ���ĺ����: ");
            scanf( "%s",line_num);
            PR("�������������: ");
            scanf( "%s",name);
            book(air,line_num,cus,name);
            save_airline(air);
            save_customer(cus);
        }
        else if(choice=='1')
        {
            PR("\n�������������: ");
            scanf( "%s",name);
            delete_cus(cus,air,name);
            save_airline(air);
            save_customer(cus);
        }
        else if(choice=='2')
        {
            PR("\n  �����  �ɻ���   Ŀ�ĵ�    ��Ʊ��   ��Ʊ��\n");
            print_airline(air);
            PR("    ����            �����      ��λ��\n");
            print_customer(cus);
        }
        else if(choice=='3')
        {
            tt=1;
            PR("����������: ");
            scanf("%s",password);
            if(strcmp(password,pass)==0)
            {
                while (tt==1){
                    PR("\n*------------------------------*\n");
                    PR("*-------������Ϣ�޸�:----------*\n");
                    PR("*   ���Ӻ����-----'0'     *\n");
                    PR("*   ɾ�������-----'1'     *\n");
                    PR("*   �޸�����-------'2'     *\n");
                    PR("*   ��ѯ������Ϣ---'3'     *\n");
                    PR("*   �˳������޸�---'4'     *\n");
                    PR("*------------------------------*\n");
                    PR("��ѡ��: ");

                    choice2=getch();
                    PR("%c\n",choice2);
                    if(choice2=='0')
                    {
                        PR("��������Ҫ���ӵĺ����: ");
                        scanf("%s",line_num);
                        PR("������ɻ���: ");
                        scanf("%s",plane_num);
                        PR("������Ŀ�ĵ�: ");
                        scanf("%s",end_place);
                        PR("��������λ����: ");
                        scanf("%d",&total);
                        increase_air(air,line_num,plane_num,end_place,total);
                        save_airline(air);
                        save_customer(cus);
                    }
                    else if (choice2=='1')
                    {
                        PR("��������Ҫɾ���ĺ����: ");
                        scanf("%s",line_num);
                        delete_airline(air,line_num);
                        delete_customer(cus,line_num);
                        save_airline(air);
                        save_customer(cus);
                    }
                    else if(choice2=='2')
                    {
                        PR("ע��:���벻�ܳ���8λ!\n");
                        PR("�����������룺");
                        scanf("%s",re_pass_1);
                        PR("��������һ��: ");
                        scanf("%s",re_pass_2);
                        if(strcmp(re_pass_1,re_pass_2)==0)
                        {
                            strcpy(pass,re_pass_1);
                            PR("�����޸ĳɹ�!���ס.\n");
                        }
                        else {
                            PR("��������������벻һ��!\n");
                        }
                    }
                    else if(choice2=='3')
                    {
                        PR("\n  �����  �ɻ���   Ŀ�ĵ�    ��Ʊ��   ��Ʊ��\n");
                        print_airline(air);
                    }
                    else if(choice2=='4')
                    {
                        tt=0;
                    }
                    else {
                        PR("�����������\n");
                        tt=0;
                    }
                }//end while
            }//end if
            else {
                PR("�Բ���!����������벻��ȷ!\n");
            }
        }//end else if �޸�
        else if(choice=='4')
        {
            load_airline(air);
            load_customer(cus);
        }
        else if(choice=='5')
        {
            PR("�ټ�!");
            t=0;
        }
        else
        {
            PR("�����������\n");
        }
    }
    getch();
}
