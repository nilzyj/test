public class Calculate {
	final float PI=3.14159f;                    //����һ�����ڱ�ʾԲ���ʵĳ���PI
	//��Բ�ε����
	public float getArea(float r){                //����һ�����ڼ�������ķ���getArea()
		float area=PI*r*r;
		return area;
	}
	//����ε����
	public float getArea(float l,float w){         //����getArea ()����
		float area=l*w;
		return area;
	}
	//��������״��ͼ��
	public void draw(int num){                 //����һ�����ڻ�ͼ�ķ���draw()
		System.out.println("��"+num+"��������״��ͼ��");
	}
	//��ָ����״��ͼ��
	public void draw(String shape){              //����draw()����
		System.out.println("��һ��"+shape);
	}
	public static void main(String[] args) {
		Calculate calculate=new Calculate();       //����Calculate��Ķ���Ϊ������ڴ�
		float l=20;
		float w=30;
		float areaRectangle=calculate.getArea(l, w);
		System.out.println("��Ϊ"+l+" ��Ϊ"+w+"�ľ��ε�����ǣ�"+areaRectangle);
		float r=7;
		float areaCirc=calculate.getArea(r);
		System.out.println("��뾶Ϊ"+r+"��Բ������ǣ�"+areaCirc);
		int num=7;
		calculate.draw(num);
		calculate.draw("������");
	}
}
