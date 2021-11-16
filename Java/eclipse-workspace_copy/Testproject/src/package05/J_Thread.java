package package05;

public class J_Thread extends Thread{

	private String ThreadName;

	public J_Thread(String threadName) {
		super();
		ThreadName = threadName;
		System.out.println("完成了创建 "+ThreadName+"线程的工作");
	}



	@Override
	public void run() 
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("正在运行线程"+ThreadName+"第"+i+"次");
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String []args)
	{
		Thread a=new J_Thread("王晨");
		Thread b=new J_Thread("哈哈");
		
		a.start();
		
		b.start();
		
		for(int i=0;i<5;i++)
		{
			System.out.println("正在运行线程Main"+"第"+i+"次");
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Main（函数）线程结束");
	}
	
}
