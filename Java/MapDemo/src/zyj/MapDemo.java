package zyj;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("1", "apple");
		map.put("2", "pear");
		map.put("3", "orange");
		for (int i = 1; i <= 3; i++) {
			System.out.println("µÚ"+i+"ÔªËØÊÇ£º"+map.get(""+i+""));
		}
	}

}
