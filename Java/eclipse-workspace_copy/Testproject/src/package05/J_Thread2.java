package package05;

public class J_Thread2 extends Thread{

	private String ThreadName;

	public J_Thread2(String threadName) {
		super();
		ThreadName = threadName;
		System.out.println("完成了创建 "+ThreadName+"线程的工作");
	}



	@Override
	public void run() 
	{
		for(int i=0;i<100;i++)
		{
			System.out.println("正在运行线程"+ThreadName+"第"+i+"次");
		
		}
	}
	
	
	public static void main(String []args)
	{
		Thread a=new J_Thread2("王晨");
		Thread b=new J_Thread2("哈哈");
		
		a.start();
		
		b.start();
		

		
		System.out.println("Main（函数）线程结束");
	}
	
}
