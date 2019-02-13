package com.rev.proze.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.rev.proze.pojos.User;

public class Definitions 
{
	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    
    public static final String firstGreeting  = "Welcome to RevaBank!";
	
	public static final String onlyAlphabets	/*only letters	*/	= "^[a-zA-Z]*$"; 
	public static final String validName		/*allows hyphen */	= "^[a-zA-Z\\-]+$"; 
	public static final String validEmails 		/*checks for @  */	= "^(.+)@(.+)$"; 
	public static final String validUsername 	/*				*/	= "[a-zA-Z0-9\\_\\-]{3,}";
	public static final String validPassword	/*				*/	= "((?=.*[a-z])(?=.*\\d)(?=."+
																	  "*[A-Z])(?=.*[@#$%!]).{8,40})";
    
	
	public static final String mainMenu 	= 	" ---------------------------------------------------------------- \n"+
												"|  REVABANK - HOMEPAGE                                           |\n"+
												" ---------------------------------------------------------------- \n"+
												"| Options:                                                       |\n"+
												"|         01. Sign in                                            |\n"+	
												"|         02. Sign up                                            |\n"+
												"|         03. Exit                                               |\n"+
												"|                                                                |\n"+
												" ---------------------------------------------------------------- ";
	
	public static final String signInFail 	= 	" ---------------------------------------------------------------- \n"+
												"|  SIGN IN                                                       |\n"+
												" ---------------------------------------------------------------- \n"+
												"| Options:                                                       |\n"+
												"|         01. Try again                                          |\n"+	
												"|         02. Back to HomePage                                   |\n"+
												"|         03. Exit                                               |\n"+
												"|                                                                |\n"+
												" ----------------------------------------------------------------";
	
	public static final String signInHead 	= 	" ---------------------------------------------------------------- \n"+
												"|  SIGN IN                                                       |\n"+
												" ---------------------------------------------------------------- ";
	
	public static final String signUpHead	= 	" ---------------------------------------------------------------- \n"+
												"|  SIGN UP                                                       |\n"+
												" ---------------------------------------------------------------- ";
	
	public static final String loginHead	= 	" ---------------------------------------------------------------- \n"+
												"|  CREATE LOG IN                                                 |\n"+
												" ---------------------------------------------------------------- ";
										
	public static final String signInMid 	= 	"|                                                                |";
	
	public static final String signInEnd     =	"|                                                                |\n"+
												" ---------------------------------------------------------------- ";
	
	public static final String accHead		= 	" ---------------------------------------------------------------- \n"+
												"|  CREATE BANK ACCOUNT                                           |\n"+
												" ----------------------------------------------------------------";
	
	public static final String accMid 		= 	"|                                                                |";

	public static final String accEnd     	=	"|                                                                |\n"+
												" ---------------------------------------------------------------- ";
	
	
	
	public static final String success		=   " ---------------------------------------------------------------- \n"+
											    "|                                                       Success! |\n"+
											    " ---------------------------------------------------------------- \n";
	
	
	public static final String accLimit		=   " ---------------------------------------------------------------- \n"+
											    "|                                    Reached the Account limit!  |\n"+
											    " ---------------------------------------------------------------- \n";	
	
	public static final String farewell		=   " ---------------------------------------------------------------- \n"+
											    "|                                               Have a good day! |\n"+
											    " ---------------------------------------------------------------- \n";
	
	public static final String unRqmts 	= 	     "---------------------------------------------------------------- \n"+
												"|  username:                                                     |\n"+
												"|     * alphanumeric                                             |\n"+
												"|        * betweem 3 amd 15 character                            |\n"+
												"|           * can contain hyphens                                |\n"+	
												" ---------------------------------------------------------------- \n";
	
	public static final String pwRqmts 	= 	     "---------------------------------------------------------------- \n"+
												"|  password:                                                     |\n"+
												"|     * betweem 8 amd 10 character                               |\n"+
												"|        * must contain 1 digit                                  |\n"+
												"|           * must contain 1 [@#$%!.]                            |\n"+
												"|              * must contain 1 lower case                       |\n"+
												"|                 * must contain 1 upper case                    |\n"+
												" ---------------------------------------------------------------- \n";
	
	public static final String loggedMM 	= 	" ---------------------------------------------------------------- \n"+
												"|  WELCOME!                                                      |\n"+
												" ---------------------------------------------------------------- \n"+
												"| Options:                                                       |\n"+
												"|         01. Personal Information                               |\n"+	
												"|         02. Show Account(s)                                    |\n"+
												"|         03. Deposit                                            |\n"+
												"|         04. Withdrawal                                         |\n"+
												"|         05. Sign out                                           |\n"+
												"|                                                                |\n"+
												" ----------------------------------------------------------------";
	
	public void showUserHP2(User s)
	{

								String menu =   " ---------------------------------------------------------------- \n"+
												"|  WELCOME "+ s.getFn().toUpperCase() +
												"|  " + sdf.format(date) +
												" ---------------------------------------------------------------- \n"+
												"| Options:                                                       |\n"+
												"|         01. Personal Information                               |\n"+	
												"|         02. Show Account(s)                                    |\n"+
												"|         03. Deposit                                            |\n"+
												"|         04. Withdrawal                                         |\n"+
												"|         05. Sign out                                           |\n"+
												"|                                                                |\n"+
												" ----------------------------------------------------------------";
								System.out.println(menu);
	}
	
	
	public void showUserHP1(User s)
	{

								String menu =   " ---------------------------------------------------------------- \n"+
												"|  WELCOME "+ s.getFn().toUpperCase() +
												"|  " + sdf.format(date) +
												" ---------------------------------------------------------------- \n"+
												"| Options:                                                       |\n"+
												"|         01. Personal Information                               |\n"+	
												"|         02. Show Account(s)                                    |\n"+
												"|         03. Deposit                                            |\n"+
												"|         04. Withdrawal                                         |\n"+
												"|         05. Open a Bank Account                                |\n"+
												"|         06. Sign out                                           |\n"+
												"|                                                                |\n"+
												" ----------------------------------------------------------------";
								System.out.println(menu);
	}
	
	
	
	
	public void showUserHP0(User s)
	{
								String menu =   " ---------------------------------------------------------------- \n"+
												tableHeadPatch("WELCOME ",s.getFn().toUpperCase()+" !")+
												tableHeadPatch("Date: ", sdf.format(date))+
												" ---------------------------------------------------------------- \n"+
												"| Options:                                                       |\n"+
												"|         01. Personal Information                               |\n"+	
												"|         02. Open a Bank Account                                |\n"+
												"|         03. Sign out                                           |\n"+
												"|                                                                |\n"+
												"------------------------------------------------------------------";
								System.out.println(menu);
	}
	
	public void showUserInfo(User s)
	{
		String fn = "Firstname  :";		String fnval = s.getFn();
		String ln = "Lastname   :";		String lnval = s.getLn();
		String em = "Email      :";		String emval = s.getEm();
								String menu =   " ---------------------------------------------------------------- \n"+
												tableHeadPatch(fn, fnval)+
												tableHeadPatch(ln, lnval)+
												tableHeadPatch(em, emval)+
												" ---------------------------------------------------------------- \n"+
												"| Options:                                                       |\n"+
												"|         01. Back to Homepage                                   |\n"+	
												"|         02. Sign out                                           |\n"+
												"|                                                                |\n"+
												"-----------------------------------------------------------------";
								System.out.println(menu);
	}
	
	public void showAccTypeToOpen(User s)
	{
		String fn = "Firstname  :";		String fnval = s.getFn();
		String ln = "Lastname   :";		String lnval = s.getLn();
		String em = "Email      :";		String emval = s.getEm();
								String menu =   " ---------------------------------------------------------------- \n"+
												tableHeadPatch(fn, fnval)+
												tableHeadPatch(ln, lnval)+
												tableHeadPatch(em, emval)+
												" ---------------------------------------------------------------- \n"+
												"| Options:                                                       |\n"+
												"|         01. To open a Checking Account                         |\n"+	
												"|         02. To open a Savings  Account                         |\n"+
												"|         03. Back to Homepage                                   |\n"+
												"|         04. Sign out                                           |\n"+
												"|                                                                |\n"+
												"-----------------------------------------------------------------";
								System.out.println(menu);
	}
	

	
	public String tableHeadPatch(String s1, String s2)
	{
		String end = "|\n";
		String beg = "|  ";
		int bit1 = beg.length();
		int bit2 = s1.length();
		int bit3 = s2.length();
		int bit4 = end.length();
		String line = " ";
		
		for (int i = 0; i < (66 - (bit1+bit2+bit3+bit4)); i++) { line+=" "; }
		String out = beg + s1 + s2 + line + end;
		return out;
	}
		
	
	public static final String createProfilePrompt					= "Profile Form\nEnter the following information:";
	
	public static final String createLoginPrompt					= "Login Form\nEnter the following information:";	
	
	public static void main(String[] args) 
	{
		Definitions d = new Definitions();
		String random = "-----------------------------------------------------------------\n";
		System.out.println(random.length());
		
	}
	

}
