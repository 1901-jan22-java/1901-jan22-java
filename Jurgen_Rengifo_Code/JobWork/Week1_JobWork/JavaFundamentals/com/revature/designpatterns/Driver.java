
public class Driver {
	public static void main(String[] args) {
		useSingleton();
	}
	static void useSingleton() {
		Singleton a = Singleton.getInstance();
		a.setName("Singleton A");
		System.out.println();
	}
}
