package shape;
 
public class Triangle extends Shape{
	private double a,b,c;
	
	public Triangle()
	{
		num++;
	}
	
	public Triangle(int a,int b,int c)
	{
		this.a=a;
		this.b=b;
		this.c=c;
		num++;
	}
	
	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}


	
	@Override
	public void CauArea()
	{
		double p=(a+b+c)/2;
		area=Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}
	@Override
	public void CauPerimeter()
	{
		perimeter=a+b+c;
	}

}
