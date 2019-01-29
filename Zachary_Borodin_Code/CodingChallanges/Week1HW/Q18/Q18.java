package com.revature.hw1.Q18;

public class Q18 extends AbstClass {
	
	public Q18() {
		
	}

	@Override
	boolean checkUppercase(String s) {
		char c[] = s.toCharArray();
		for(int i=0; i<c.length;i++) {
			if(Character.isUpperCase(c[i]) == true)
				return true;
		}
		return false;
	}

	@Override
	String turnUppercase(String s) {
		String res = "";
		char c[] = s.toCharArray();
		for(int i=0; i<c.length; i++) {
			if(Character.isUpperCase(c[i]))
					res+= c[i];
			else res+= Character.toUpperCase(c[i]);
		}
		return res;
	}

	@Override
	void toInt(String s) {
		int res;
		res = Integer.parseInt(s);
		res +=10;
		System.out.println(res);
	}
	

}
