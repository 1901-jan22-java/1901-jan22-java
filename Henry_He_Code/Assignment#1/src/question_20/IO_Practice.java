package question_20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IO_Practice {
	public static void main(String[] args) {
		String path = "src/question_20/Data";
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String curr_line = null;
			while( (curr_line = br.readLine()) != null ) {
				String[] person = curr_line.split(":");
				if(person[0].equals("Mickey"))
					System.out.println(
						"Name : " + person[0] + " " + person[1] +
						"\nAge : " + person[2] +
						"\nState : " + person[3]
					);
				else continue;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
}
