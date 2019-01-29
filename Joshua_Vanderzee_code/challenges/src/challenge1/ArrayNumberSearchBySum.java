package challenge1;

public class ArrayNumberSearchBySum {

	public static void main(String[] args) {
		int[] arr1 = {1,3,7,2,5,10};
		int[] arr2 = {2,4,6,8};

	}
	
	public static boolean Search(int target, int... nums) {
		if (nums != null)
		{
			boolean even = EvenNumberClass.IfEven(target);
			final int RequiredEvens = 2;
			final int Requiredodds = even ? 2 : 1;
			int countEvens = 0;
			int countOdds = 0;	
			for (int i = 0; i < nums.length; i++) {
				if (even)
				{
					if (countEvens < RequiredEvens)
					{
						countEvens += EvenNumberClass.IfEven(nums[i]) ? 1 : 0;
					}
				}
				else
				{
					if (countOdds < Requiredodds)
					{
						countEvens += EvenNumberClass.IfEven(nums[i]) ? 0 : 1;
					}
				}
			}
		}
		return false;
	}

}
