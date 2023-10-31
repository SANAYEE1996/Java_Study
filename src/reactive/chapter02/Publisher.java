package reactive.chapter02;

public interface Publisher<T> {
	public void subscribe(Subscriber<? super T> s);
}
