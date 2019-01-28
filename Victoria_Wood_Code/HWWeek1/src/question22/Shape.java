package question22;

@FunctionalInterface
public interface Shape {
	
	abstract int calculateArea(int h, int l);
	
	default int calculatePerimeter(int h, int l) {
		return 2*h + 2*l;
	}

}
