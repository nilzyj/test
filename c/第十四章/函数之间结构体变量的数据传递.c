struct student
{
	char name[5];
	char sex;
}stu,*s,arrstu[3];
s=&stu;

void fun1(char a){}//�βκ�ʵ�ε�����Ҫһ��
void fun2(struct student j)//fun2�е�ʵ�δ��ݸ��βΣ�����ʹ�ýṹ���Ա
{
	j.sex 
	j.name[0]
}
void fun3(struct student *p){}//*ǰ����struct����������ָ�붨��
void fun4(struct student *p){}	

main()
{
	fun1(stu.sex);//�ṹ���Ա��Ϊʵ��
	fun2(stu);//�ṹ������(����)��Ϊʵ��,
	fun3(s);//ָ���ṹ������ĵ�ַ����Ϊʵ��
	fun4(arrstu);//�ṹ����������Ϊʵ��
}












//����֮�䴫��
int fun(int a)
{
	a=1
	return a;
}

void test()
{
	fun(b);
}

main()
{
	test();
}