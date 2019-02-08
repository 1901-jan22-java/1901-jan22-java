package associate_project.Associate;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AssociateRepository peeps=new AssociateRepository();
      //List<Associate>files=peeps.findAll();
      //System.out.println(files);
      System.out.println("Hello! Please enter the following number corresponding to your log in");
      System.out.println("(1) Associate log in");
      System.out.println("(2) Admin log in");
      Scanner sc1=new Scanner(System.in);
      int ans=sc1.nextInt();
      if(ans==1){
    	  forAssociate(peeps);
      }
      if(ans==2){
    	  //method for admin
      }
    }
    public static void forAssociate(AssociateRepository rep){
    	System.out.print("Hello Associate ! Please enter your password");
    	Scanner sc2= new Scanner(System.in);
    	String pass=sc2.nextLine();
    	Associate r=rep.getAssociateInfo(pass);
    	//make method to see if password is valid 
    	//assuming password is valid Ask if they want to view their account info or update a field in their account
    	System.out.println("Would you like to:");
    	System.out.println("(1) View your account info");
    	System.out.println("(2) Update your current account");
    	int curr=sc2.nextInt();
    	if(curr==1){
    		viewAssociateInfo(rep,r);
    	}
    	
    	System.out.println("You can update the following:");
    	System.out.println("(1) FirstName");
    	System.out.println("(2) LastName");
    	System.out.println("(3) Email");
    	System.out.println("(4) Password");
    	//check for valid number input
    	int opt=sc2.nextInt();
    	if(opt==1){
    		System.out.println("please enter your new firstname:");
    		String name=sc2.next();
    		r.setFirstName(name);
    		rep.update1(r);
    	}
    	if(opt==2){
    		System.out.println("please enter your new lastname:");
    		String name=sc2.next();
    		r.setLastName(name);
    		rep.update1(r);
    	}
    	if(opt==3){
    		System.out.println("please enter your new email:");
    		String email=sc2.next();
    		r.setEmail(email);
    		rep.update1(r);
    	}
    	if(opt==4){
    		System.out.println("please enter your new password:");
    		String pwrd=sc2.next();
    		r.setPassword(pwrd);
    		rep.update1(r);
    	}
    }
    public static void forAdmin(AssociateRepository repo){
    	System.out.println("Hello Admin ! please enter your password");
    	Scanner sc3=new Scanner(System.in);
    	String pass=sc3.nextLine();
    	System.out.println("To view all of Asscoiate info enter 1:");
    	List<Associate>files=repo.findAll();
       System.out.println(files);
    }
    public static void viewAssociateInfo(AssociateRepository rep,Associate person){
    	rep.getAssociateInfoPrint(person.getPassword());
    }
    
}
