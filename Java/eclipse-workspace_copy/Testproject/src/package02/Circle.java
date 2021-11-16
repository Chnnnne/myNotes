package package02;

public class Circle implements Shape{
	private double Radius;
	private double Area;
	
	public Circle() {
		super();
	}

	public Circle(int radius) {
		super();
		Radius = radius;
	}

	public double getRadius() {
		return Radius;
	}

	public void setRadius(int radius) {
		Radius = radius;
	}
	
	@Override
	public double getArea() {
		return Area;
	}

	@Override
	public void CalculateArea() {
		this.Area=Math.PI*Math.pow(Radius, 2);
	}

	
	
}
