package question_18;

abstract class The_Absent_Parent {

	abstract boolean checkUppercase(String str);
	abstract String upcase(String str);
	abstract int mathStuff(String str);
	
}


public class The_Struggling_Child extends The_Absent_Parent{

	@Override
	boolean checkUppercase(String str) {
		for(char c : str.toCharArray())
			if(Character.isUpperCase(c)) 
				return true;
		return false;
	}

	@Override
	String upcase(String str) {
		return str.toUpperCase();
	}

	@Override
	int mathStuff(String str) {
		int num = 0;
		for(char c : str.toCharArray()) 
			num+=c;
		return num+10;
	}

	public static void main(String[] args) {
		The_Struggling_Child tsc = new The_Struggling_Child();
		String str = "Maybe your dark jokes are why you're not as popular as you could be."
				+ "\nBut self-deprecation gets pretty cheap after a while...";
		System.out.println(tsc.checkUppercase(str));
		System.out.println(tsc.upcase(str));
		System.out.println(tsc.mathStuff(str));
	}
	
}
