struct student
{
	char name[5];
	char sex;
}stu,*pstd,arrstu[3];
pstd=&stu;
//�ṹ���Ա������
stu.sex;//stu.sex=='m';
pstd->sex;
(*pstd).sex;

stu.name[0];
pstd->name[0];//����
(*pstd).name[0];

arrstu[0].sex;//��һ���ṹ�����sex����,���ýṹ�������еı�����Ա
arrstu[1].sex;


arrstu[0].name[0];//��һ���ṹ������ַ�����ĵ�һ��Ԫ�أ����ýṹ�������е������Ա
arrstu[1].name[0];

//��Ƕ�ṹ���Ա������
struct student//�ṹ��˵����ʽ
{
	char name[5];
	char sex;
	int age;
}

struct monitor
{
	struct student status;//�ṹ��Ƕ�ס�status�ṹ��������൱��stu��status��monitor�ĳ�Ա��
	int tel;
}stu,*s;
s=&stu;

stu.status.sex;
s->status.sex;
(*s).status.sex;

stu.status.name[0];
s->status.name[1];
(*s).status.name[4];

