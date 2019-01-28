
import java.util.Scanner;
import java.util.ArrayList;

/** # Project 0
To be presented during QC on 2/6/18


### Requirements

* Create a Banking app where your user communicates with your app through the console
* A user must be able to create an account
* A user must be able to log in and log out(end interaction with the app and have transaction persisted)
* A user must be able to create one or more account(s) of specified types
* A user must be able to withdraw and deposit money
* There should be validation to make sure that usernames are unique, users aren't withdrawing more money than they have in the particular account, and that the application will not stop running if a user enters an incompatible data type with what your application expects

### Tech Stack

* Java 1.8
* Oracle DB
* JDBC
* You must include at least one of each: Statement, PreparedStatement, and CallableStatement
* You must create a custom exception
* Use Log4J to log to a file (optional) **/


public class myBank{

int count = 0;
String username = "";
boolean bankActive = false;
String usernameCheck = "";
String passwordCheck = "";
//String username = "";
String password = "";





// public static void main (String [] args){
//    
//       Scanner keyboard = new Scanner(System.in);
//
//       System.out.println("Hello Welome to myBanking what would you like to Do?  ");
//    
//       System.out.println("Log In  Sign Up    Cancel ");
//       String response = keyboard.nextLine();
//       HomePageLogic(response);
//
// }



static void accounts (String str, String str2){

boolean bankActive = false;

int id = 0;
int temp;


 


 ArrayList<String>  arr = new ArrayList<String>();

arr.add(str);
arr.add( str2);
temp = id;
arr.add(Integer.toString(temp));

id++;

//return arr;
}

static boolean accountCheck ( boolean x){

return x ;
}





//nested class for logged in users
public class user {


int balance = 100;

public void userLogged() {



myBank.user maw = new myBank.user ();


System.out.print("Welome " + username);


}}////////////


public void signUpUSer(){


}


public  void loginUser() {

myBank.user maw = new myBank.user ();
Scanner scan = new Scanner(System.in);

if ( accountCheck(bankActive) == true) {
               System.out.println("Username: ");
               usernameCheck = scan.nextLine();
            
               System.out.println("Password: ");
               passwordCheck = scan.nextLine();
            
             
                  if (username.equals(usernameCheck) && password.equals(passwordCheck)) {
                        System.out.println("Welcome user! " );
                       
                        maw.userLogged();
                       
                  }
                
                 else {
               
                     System.out.println("Sorry Wrong password/username");
                 }         
            }
         
      



}

public void tempWrapper(){

Scanner scan = new Scanner(System.in);
String response = "";

System.out.println(" Sorry please enter [yes] [no] or [cancel] \n Would you like to log in now ? ");

response = scan.nextLine();

if (response.equalsIgnoreCase("yes")){


          loginUser();

}


else if ( response.equalsIgnoreCase("no") ) {
      
      
       System.out.print("Thank You "  + username  + " for signing up and banking with myBank! ");
      
      
      
      
       }
      
 else if ( response.equalsIgnoreCase("cancel")){
 
 
 
 
         System.out.println("Thank you for using myBank for your banking application");
 }
      
      
      
       else{
        
        
         tempWrapper(); 
      
      
       }



}


public void HomePageLogic( String str){

myBank.user maw = new myBank.user ();
String response = "";




Scanner scan = new Scanner(System.in);


//make this into a seperate sign up method
if (str.equalsIgnoreCase("Sign up")){


System.out.println("What would you like your username to be ?");

username = scan.nextLine();

System.out.println("What would you like your password to be ?");

password = scan.nextLine();

accounts (username, password);
bankActive = true;

System.out.println("Succesfully made account would you like to log in now ? ");

response = scan.nextLine();

if (response.equalsIgnoreCase("yes")){


          loginUser();

}


else if ( response.equalsIgnoreCase("no") ) {
      
      
       System.out.print("Thank You "  + username  + " for signing up and banking with myBank! ");
      
      
      
      
       }
      
      
       else if ( response.equalsIgnoreCase("cancel")){
 
 
 
 
         System.out.println("Thank you for using myBank for your banking application");
 }

      
      
      
       else{
        
        
         tempWrapper(); 
      
      
       }


      // System.out.println("Hello Welome to myBanking what would you like to Do?  ");
//    
//       System.out.println("Log In  Sign Up    Cancel ");
//       str = scan.nextLine();
//       HomePageLogic(str);
//
 





}

// make a seperate login method for this
else if (str.equalsIgnoreCase("Log in")){

   if ( accountCheck(bankActive) == false){
 
  System.out.println("This section is currently under maintenance");}
 
   else if ( accountCheck(bankActive) == true) {
               System.out.println("Username: ");
               usernameCheck = scan.nextLine();
            
               System.out.println("Password: ");
               passwordCheck = scan.nextLine();
            
             
                  if (username.equals(usernameCheck) && password.equals(passwordCheck)) {
                        System.out.print("Welcome user " );
                  }
                
                           
            }
         
       
}

// possibly make a cancel method but this might work in end
else if(str.equalsIgnoreCase("cancel")){


System.out.println("Thank you for using myBanking ");
}


else {
System.out.println("Invalid Input Please try again");
Scanner keyboard = new Scanner(System.in);

      System.out.println("Hello Welome to myBanking what would you like to Do?  ");
   
      System.out.println("Log In  Sign Up    Cancel ");
      str = keyboard.nextLine();
      HomePageLogic(str);
   


}


}





}










