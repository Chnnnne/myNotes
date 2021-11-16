package package02;

public class Square implements Shape {
	private int SideLength;
	private double Area;
	
	public Square() {
		super();
	}

	public Square(int sideLength) {
		super();
		SideLength = sideLength;
	}

	public int getSideLength() {
		return SideLength;
	}

	public void setSideLength(int sideLength) {
		SideLength = sideLength;
	}
	@Override
	public double getArea() {
		return Area;
	}

	@Override
	public void CalculateArea() {
		this.Area=this.SideLength*this.SideLength;
	}



	
}
