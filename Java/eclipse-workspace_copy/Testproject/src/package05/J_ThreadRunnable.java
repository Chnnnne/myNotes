package package05;

public class J_ThreadRunnable implements Runnable{
	private String Name;

	public J_ThreadRunnable(String name) {
		super();
		Name = name;
		System.out.println(Name+"线程已经被创建");
	}

	@Override
	public void run() {
		for(int i=0;i<5;i++)
		{
			System.out.println("正在执行线程"+Name);
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String []args) throws InterruptedException
	{
		Thread t1=new Thread(new J_ThreadRunnable("王晨"));
		Thread t2=new Thread(new J_ThreadRunnable("哈哈"));
		t1.start();
		t2.start();
		Thread.sleep(1000);
		System.out.println("main方法结束");
		
	}
	
}
