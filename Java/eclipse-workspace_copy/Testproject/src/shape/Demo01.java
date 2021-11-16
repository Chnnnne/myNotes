package shape;

public class Demo01 {
	public static void main(String []args){
		Shape a=new Triangle(3,4,5);
		a.CauArea();	
		a.CauPerimeter();
		System.out.println("三角形变长分别为3,4,5 \t\t其面积为："+a.getArea()+"\t\t\t周长为："+a.getPerimeter());
		
		a=new Circle(0,0,2);
		a.CauArea();
		a.CauPerimeter();
		System.out.println("圆心在(0,0)半径为2 \t\t\t其面积为："+a.getArea()+"\t周长为："+a.getPerimeter());
		
		
		
	}

}
