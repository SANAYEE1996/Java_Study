package designPattern.headFirst.chapter05_Singleton;

public class DefaultConfig {
	
	private static DefaultConfig defaultConfig;
	
	public static DefaultConfig template() {
		return defaultConfig;
	}
}
