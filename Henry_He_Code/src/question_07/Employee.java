package question_07;

import java.util.Comparator;

public class Employee implements Comparator<Employee>{

	String name;
	String department;
	int age;
	
	Employee(String n, String d, int a){
		name = n;
		department = d;
		age = a;
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		/*
		 * Not entirely sure if what I'm doing is correct...
		 * But the idea is to compare name first, department second and age last.
		 */
		int result = o1.name.compareTo(o2.name);
		if (result == 0) result = o1.department.compareTo(o2.department);
		if (result == 0) result = o1.age - o2.age;
		return result;
	}
	
	
	
//	public static Comparator<Employee> NameComparator = new Comparator<Employee>() {
//        @Override
//        public int compare(Employee e1, Employee e2) {
//            return e1.name.compareTo(e2.name);
//        }
//    };
//    
//    public static Comparator<Employee> DepartmentComparator = new Comparator<Employee>() {
//    	public int compare(Employee e1, Employee e2) {
//    		return e1.department.compareTo(e2.department);
//    	}
//    };
//	
//	public static Comparator<Employee> AgeComparator = new Comparator<Employee>() {
//        @Override
//        public int compare(Employee e1, Employee e2) {
//            return e1.age - e2.age;
//        }
//    };

}

