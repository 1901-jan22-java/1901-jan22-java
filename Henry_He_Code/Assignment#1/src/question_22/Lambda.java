package question_22;

interface Totally_Functional_Interface {

	void bah();
	
}

public class Lambda implements Totally_Functional_Interface{

	@Override
	public void bah() {
		System.out.println("Baaaaaaah");
	}

	public static void main(String[] args) {
		Lambda larry_the_lamb = new Lambda();
		larry_the_lamb.bah();
		
		// Lance is a rebel(?)
		Totally_Functional_Interface lance_the_lamb = () -> {
			System.out.println("Baaaaah, I'm no sheep!");
		};
		lance_the_lamb.bah();
		// Well lance, I'm not exactly sure what IS the difference between sheeps and lambs...
	}
	
}
