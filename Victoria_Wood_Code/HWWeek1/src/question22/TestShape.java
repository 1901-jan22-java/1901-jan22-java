package question22;

public class TestShape {
	
	public static void main(String[] args) {
		
		int a = 7;
		int b = 19;
		
		Shape lambda = (int h, int l)-> h*l;
		
		int area = lambda.calculateArea(a, b);
		System.out.println(area);
		
		
		int perimeter = lambda.calculatePerimeter(a, b);
		System.out.println(perimeter);
	}

}
