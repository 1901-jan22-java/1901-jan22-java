import java.util.ArrayList;
import java.util.List;

public class arraySets {
    
    List<Integer> set;
    
    //constructor
    public arraySets() {
   	 set = new ArrayList<>();
    }
    
    void add(int n) {
   	 int index = set.indexOf(n);
   	 if(index == -1) {
   		 set.add(n);
   	 } else {
   		 return;
   	 }
    };
    
    void remove(int n) {
   	 int index = set.indexOf(n);
   	 if(index != -1) {
   		 set.remove(index);
   	 } else {
   		 return;
   	 }
    };

    boolean isEmpty() {
   	 return set.isEmpty();
    };
    
    boolean contains(int n) {
   	 return (set.indexOf(n) != -1);
    };
    
    @Override
    public String toString() {
   	 return "Set " + set.toString() + "";
    }
    
    public static void main(String[] args) {
   	 arraySets test = new arraySets();
   	 
   	 // Check if add() works properly
   	 test.add(1);
   	 test.add(2);
   	 test.add(3);
   	 System.out.println(test);
   	 // SUCCESS
   	 
   	 // Check if remove() works properly
   	 test.remove(1);
   	 System.out.println(test);
   	 //SUCCESS
   	 
   	 // Check if duplicates is possible
   	 test.add(2);
   	 System.out.println(test);
   	 // SUCCESS - Duplicates not possible
   	 
   	 
   	 // Check if contains() works properly
   	 System.out.println( test.contains(1) );
   	 System.out.println( test.contains(3) );
   	 // SUCCESS
   	 
   	 // Check if isEmpty() works properly
   	 System.out.println( test.isEmpty() );
   	 test.remove(2);
   	 test.remove(3);
       test.remove(10); 
   	 System.out.println( test.isEmpty() );
   	 // SUCCESS
       
       System.out.println(test);

   	 
   	 
    }
    
}


