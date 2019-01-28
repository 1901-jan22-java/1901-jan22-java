package hw1.q15;

interface Calculation{
	int addition(int a,int b);
	int subtraction(int a,int b);
	int multiplication(int a, int b);
	double division(int a, int b);
}
 class Calculator implements Calculation{
	@Override
	public int addition(int a,int b){
		return a+b;
	}

	@Override
	public int subtraction(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public int multiplication(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public double division(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}
 
 public static void main(String[] args){
	 Calculator cal=new Calculator();
	 int a=2;int b=10;
	 
	 System.out.println(cal.addition(a, b));
	 System.out.println(cal.subtraction(a, b));
	 System.out.println(cal.multiplication(a, b));
	 System.out.println(cal.division(a, b));
 }}
