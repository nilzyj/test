package zyj;

import java.util.StringTokenizer;

public class StringDemo {

	public static void main(String[] args) {
		String a = new String();//String()
		a=" hello world";
		char cha[] = {'h','e','l','l','o'};
		String b = new String(cha);//�ȼ���String b = String("hello");
		String c = new String(cha,2,3);//�ȼ���String c = String("llo");
		//�ַ���������"+"
		System.out.println("�ַ������ȣ�"+a.length());//��ȡ�ַ�������
		System.out.println("�����ַ����������״γ��ֵ�λ�ã�"+a.indexOf("el"));
		System.out.println("�����ַ���������������λ�ã�"+a.indexOf("el"));
		System.out.println("��ȡָ������λ�õ��ַ���"+a.charAt(3));
		System.out.println("trim()ȡ��ǰ����β���ո�"+a.trim());
		StringTokenizer st = new StringTokenizer(a," ");//���ո�ָ��ַ���
		StringBuffer sb = new StringBuffer();
		int i = 1;
		while(st.hasMoreElements())//�ж��Ƿ��пո񣬻�������st.hasMoreToken()
		{
			i++;
			sb.append(st.nextToken());
		}
		System.out.println("StringTokennizerȥ���ո�"+sb.toString());
		
		System.out.println("replaceAll()ȥ���ո�"+a.replaceAll(" ", ""));
		
		System.out.println("replace()�ַ����滻��"+a.replace("world", "ml"));
		
		System.out.println("replaceFirst()�滻��һ�����ֵ��ַ�����"+a.replaceFirst("world", "ml"));
		
		if(a.equals("hello world"))//�ϸ����ִ�Сд��equalsIgnoreCase()�����ִ�Сд
		{
			System.out.println("�ַ������");
		}
		else
		{
			System.out.println("�ַ��������");
		}
		
		if(a.startsWith("hello"))//�ж��ַ����Ƿ��Բ���ָ�����ַ�����ʼ��endsWith()�ж��Ƿ��Բ���ָ�����ַ�����β
		{
			System.out.println("��hello��ͷ");
		}
		else
		{
			System.out.println("����hello��ͷ");
		}
		
		System.out.println("ת����Сд��"+a.toLowerCase());
		System.out.println("ת���ɴ�д��"+a.toUpperCase());
		
		String news[] = a.split(" ");//split(String sign)����
		System.out.print("�ָ����ַ�����");
		for(int j = 0;j < news.length;j++)
		{
			System.out.print(news[j]);
		}
		System.out.print("\n");
		news = a.split(" ", 1);//split(String sign,int limit)limit:���Ƶķָ����
		System.out.print("�ָ�һ�κ���ַ�����");
		for(int j = 0;j < news.length;j++)
		{
			System.out.print(news[j]);
		}
		
		//format��ʽ������
	}
}
