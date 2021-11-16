package shape;

public class Square extends Shape{
	private int x,y;
	private double length,width;
	
	
	public Square()
	{
		num++;
	}
	
	public Square(int x,int y,double length,double width)
	{
		this.x=x;
		this.y=y;
		this.length=length;
		this.width=width;
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

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}


	@Override
	public void CauArea()
	{
		area=length*width;
	}
	@Override
	public void CauPerimeter()
	{
		perimeter=length*2+width*2;
	}
	

}
