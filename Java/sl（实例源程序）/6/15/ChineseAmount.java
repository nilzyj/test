package com.mingrisoft;

import java.util.regex.Pattern;
public class ChineseAmount {
	public static void main(String[] args) {
		String text = "���տƼ�soft";					// ��ȡ�û�����
		int amount = 0;								// ������������������
		for (int i = 0; i < text.length(); i++) {				// �����ַ���ÿһ���ַ�
												// ʹ��������ʽ�ж��ַ��Ƿ����ں��ֱ���
			boolean matches = Pattern.matches("^[\u4E00-\u9FA5]{0,}$", ""
							+ text.charAt(i));
			if (matches) {							// ����Ǻ���
				amount++;						// �ۼӼ�����
			}
		}
		System.out.println("���տƼ�soft" + "���м������֣�"+ amount + "��");
	}
}

