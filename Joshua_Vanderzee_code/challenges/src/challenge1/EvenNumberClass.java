package challenge1;

public class EvenNumberClass {
	public static boolean IfEven(int num)
	{
		return (num & 1) == 0;
	}
	
	public static boolean IfEven(byte num)
	{
		return (num & 1) == 0;
	}
	
	public static boolean IfEven(long num)
	{
		return (num & 1) == 0;
	}
	
	public static boolean IfEven(short num)
	{
		return (num & 1) == 0;
	}
}
