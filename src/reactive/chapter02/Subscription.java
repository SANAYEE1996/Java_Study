package reactive.chapter02;

public interface Subscription {
	public void request(long n);
	public void cancel();
}
