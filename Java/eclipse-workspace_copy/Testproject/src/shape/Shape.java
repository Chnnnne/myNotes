package shape;

public abstract class Shape {
	public static int num;
	public double perimeter;
	public double area;
	
	public static int getNum()
	{
		return num;
	}
	
	public double getPerimeter() {
		return this.perimeter;
	}
	public void setPerimeter(int perimeter) {
		this.perimeter=perimeter;
	}
	public double getArea() {
		return this.area;
	}
	public void setArea(int area) {
		this.area=area;
	}
	
	public abstract void CauPerimeter();
	public abstract void CauArea();
}
