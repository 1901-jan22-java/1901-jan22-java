package question18;

public class SubClass extends AbstractClass{
	
	public static void main(String[] args) {
	}

	@Override
	boolean hasUpper(String s) {
		for(int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) return true;
		}
		return false;
	}
	
	

	@Override
	String convertToUpper(String s) {
		return s.toUpperCase();
	}

	@Override
	void toInt(String s) {
		System.out.println(s.codePointCount(0, s.length()) + 10);
		
	}
	
	

}
