package package02;

public class Singleton {
	private static Singleton obj1= new Singleton();
	private static Singleton obj2= new Singleton();

	private Singleton() {
	}
	
	public static Singleton get_obj1()
	{
		return obj1;
	}
	public static Singleton get_obj2()
	{
		return obj2;
	}
	
}
