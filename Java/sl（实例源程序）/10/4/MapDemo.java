package com.mingrisoft;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>(); 			// ����Map����
		map.put("1", "apple");										// �򼯺���Ӷ���
		map.put("2", "pear");
		map.put("3", "orange");
		for (int i = 1; i <= 3; i++) {
			System.out.println("��"+i+"Ԫ���ǣ�"+map.get("" + i + ""));			// �����Ӧλ��Ԫ��ֵ
		}
	}
}
