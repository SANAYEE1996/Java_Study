package ysp_2021_12_14;

public class ThreadTest extends Thread{
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(500);
				System.out.println("Thread : " +i);
			}
		}
		catch(InterruptedException e) {
			System.out.println(e);
		}
	}
}
