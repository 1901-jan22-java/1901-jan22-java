package question_15;

public class Math_Stuff implements Basic_Ops {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		return a-b;
	}

	@Override
	public int mul(int a, int b) {
		return a*b;
	}

	@Override
	public int div(int a, int b) {
		return a/b;
	}

	public static void main(String args[]) {
		Math_Stuff mathyness = new Math_Stuff();
		System.out.println(mathyness.add(1,1));
		System.out.println(mathyness.sub(1,1));
		System.out.println(mathyness.mul(2,2));
		System.out.println(mathyness.div(2,2));
	}
}
