package package05;

public class J_ThreadDaemon extends Thread{
	private String ThreadName;
	
	public J_ThreadDaemon(String threadName) {
		super();
		ThreadName = threadName;
		System.out.println("线程："+ThreadName+"被创建");
	}

	public void run()
	{
		for(int i=1;true;i++)
			System.out.println("线程"+ThreadName+"运行了"+i+"次");
	}
	
	
	public static void main(String []args) throws InterruptedException
	{
		J_ThreadDaemon t=new J_ThreadDaemon("王晨");
		
		t.setDaemon(true);
		t.start();
		Thread.sleep(200);
		System.out.println("主线程结束");
		
	}
}
