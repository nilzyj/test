package com.mingrisoft;

import java.util.ArrayList;
import java.util.List;

public class Gather {											//������Gather
	public static void main(String[] args) {						//������
		List list = new ArrayList();								//�������϶���
		int i = (int) (Math.random() * (list.size()-1));					//���0~2֮��������
		list.add("a");										//�򼯺����Ԫ��
		list.add("b");
		list.add("c");
		System.out.println("�����ȡ�����е�Ԫ�أ�"+list.get(i));
		list.remove(2);										//��ָ������λ�õ�Ԫ�شӼ������Ƴ�
		System.out.println("��������'2'��Ԫ�ش������Ƴ��������е�Ԫ���ǣ�");
		for (int j = 0; j < list.size(); j++) {							//ѭ����������
			System.out.print(list.get(j)+"  ");
		}
	}
}

