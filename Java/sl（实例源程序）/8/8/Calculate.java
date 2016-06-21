public class Calculate {
	final float PI=3.14159f;                    //定义一个用于表示圆周率的常量PI
	//求圆形的面积
	public float getArea(float r){                //定义一个用于计算面积的方法getArea()
		float area=PI*r*r;
		return area;
	}
	//求矩形的面积
	public float getArea(float l,float w){         //重载getArea ()方法
		float area=l*w;
		return area;
	}
	//画任意形状的图形
	public void draw(int num){                 //定义一个用于画图的方法draw()
		System.out.println("画"+num+"个任意形状的图形");
	}
	//画指定形状的图形
	public void draw(String shape){              //重载draw()方法
		System.out.println("画一个"+shape);
	}
	public static void main(String[] args) {
		Calculate calculate=new Calculate();       //创建Calculate类的对象并为其分配内存
		float l=20;
		float w=30;
		float areaRectangle=calculate.getArea(l, w);
		System.out.println("求长为"+l+" 宽为"+w+"的矩形的面积是："+areaRectangle);
		float r=7;
		float areaCirc=calculate.getArea(r);
		System.out.println("求半径为"+r+"的圆的面积是："+areaCirc);
		int num=7;
		calculate.draw(num);
		calculate.draw("三角形");
	}
}
