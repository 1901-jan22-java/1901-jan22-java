package question_23;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class String2Date {

	static Date string_to_date(String str) {
		String[] data = str.split(":");
		DateFormat df = new SimpleDateFormat("MM-dd-yyy", Locale.ENGLISH);
		try {
			return df.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println( string_to_date("10-07-14") );
	}
	
}
