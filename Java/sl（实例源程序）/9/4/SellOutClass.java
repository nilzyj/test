
public class SellOutClass {
	private String name; // ˽�г�Ա����

	public SellOutClass() {// ���췽��
		name = "ƻ��";
	}

	public void sell(int price) {
		class Apple { // �ֲ��ڲ���
			int innerPrice = 0;

			public Apple(int price) {// ���췽��
				innerPrice = price;
			}

			public void price() {// ����
				System.out.println("���ڿ�ʼ����" + name);
				System.out.println("����Ϊ��" + innerPrice + "Ԫ");
			}
		}
		Apple apple = new Apple(price);// ʵ����Apple��Ķ���
		apple.price();// ���þֲ��ڲ���ķ���
	}

	public static void main(String[] args) {
		SellOutClass sample = new SellOutClass();// ʵ����SellOutClass��Ķ���
		sample.sell(100);// ����SellOutClass���sell()����
	}

}
