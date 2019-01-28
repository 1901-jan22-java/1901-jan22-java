
import java.util.Scanner;
import java.util.ArrayList;

public class myBankDriver{



public static void main (String [] args){

      myBank maw = new myBank();

   
      Scanner keyboard = new Scanner(System.in);

      System.out.println("Hello Welome to myBanking what would you like to Do?  ");
   
      System.out.println("Log In  Sign Up    Cancel ");
      String response = keyboard.nextLine();
      maw.HomePageLogic(response);

}
 


}



