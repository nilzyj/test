public class Beast {

	String skin = "";// 成员变量

	public Beast() { // 默认构造方法
	}

	public Beast(String strSkin) { // 带参数的购造方法
		skin = strSkin;

	}

	public void move() { // 成员方法
		System.out.println("跑");
	}
}
