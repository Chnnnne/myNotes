package shape;

public class Circle extends Shape {
	private int x,y;
	private double r;
	
	public Circle() {
		super();
		num++;
	}
	public Circle(int x, int y, double r) {
		super();
		this.x = x;
		this.y = y;
		this.r = r;
		num++;
	}
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}


	@Override
	public void CauPerimeter() {
		perimeter=2*Math.PI*r;
	}
	@Override
	public void CauArea() {
		area=Math.PI*Math.pow(r, 2);
	}
	
	

}
