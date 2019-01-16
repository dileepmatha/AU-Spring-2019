class EvenOddMethod extends Thread
{
	public static int number = 0;
	public  synchronized void EvenTime() {
		for(int i = 0; i < 100; i++)
		{
			while(number % 2 == 1)
			{
				try
				{
					wait();
				}
				catch(InterruptedException e)
				{
					System.out.println(e.getMessage());
					e.getStackTrace();
				}
			}
		}
		System.out.println("Even Number: " + number++);
		notify();
		
	}
	public synchronized void OddTime() {
		for(int i = 0; i < 100; i++)
		{
			while(number % 2 == 0)
			{
				try
				{
					wait();
				}
				catch(InterruptedException e)
				{
					System.out.println(e.getMessage());
					e.getStackTrace();
				}
			}
			System.out.println("Odd Number: " + number++);
			notify();
		}
	}
}
public class EvenOdd
{
	public static void main(String[] args)
	{
		EvenOddMethod eo = new EvenOddMethod();
		//Lambda Expression
		new Thread(() -> {
			for(int i=0;i<100;i++)
			eo.EvenTime();
		}).start();
		//Lambda Expression 
		new Thread(() -> {
			for(int i=0;i<100;i++)
			eo.OddTime();
		}).start();
	}
}
