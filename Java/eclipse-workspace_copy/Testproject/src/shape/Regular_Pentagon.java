package shape;

public class Regular_Pentagon extends Shape{
	private int x,y;
	private double r;
	public Regular_Pentagon() {
		super();
		num++;
	}
	public Regular_Pentagon(int x, int y, double r) {
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
		
		 perimeter=r*Math.sin(2*Math.PI/5)/Math.sin(3*Math.PI/10);
	}
	@Override
	public void CauArea() {
		area=0.5*r*r*Math.sin(Math.PI/5);
		
	}
	
	

}
