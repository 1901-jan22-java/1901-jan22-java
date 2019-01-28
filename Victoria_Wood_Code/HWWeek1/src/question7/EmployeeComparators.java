package question7;

import java.util.Comparator;

public class EmployeeComparators {
				

	public static class CompareByAge implements Comparator<Employee> {

		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getAge() - e2.getAge();
		}
		
	}
	
	public static class CompareByDepartment implements Comparator<Employee> {

		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getDepartment().compareTo(e2.getDepartment());
		}
		
	}
	
	public static class CompareByName implements Comparator<Employee> {

		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getName().compareTo(e2.getName());
		}
		
	}
	
}


