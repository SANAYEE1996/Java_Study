package designPattern.headFirst.chapter01_Strategy;

public class MuteQuack implements QuackBehavior{
	public void quack() {
		System.out.println("나는 울지 못합니다.");
	}
}
