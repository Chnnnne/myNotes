package package02;

import java.text.DecimalFormat;

public class PrinArea<T extends Shape> {
	public void prinarea(T a)
	{
		DecimalFormat df = new DecimalFormat( "0.00");
		a.CalculateArea();
		System.out.println("面积是"+df.format(a.getArea()));
	}
	
	
	
	public static void main(String []args)
	{
		
		
		
		
		Circle c=new Circle(2);
		Square s=new Square(2);
		PrinArea<Circle> cc=new PrinArea<Circle>();
		System.out.print("圆形的");
		cc.prinarea(c);
		PrinArea<Square> ss=new PrinArea<Square>();
		System.out.print("正方形的");
		ss.prinarea(s);
		
	}

}
