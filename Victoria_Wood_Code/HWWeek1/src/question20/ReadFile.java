package question20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	
	public static void main(String[] args) {
		read();
	}
	
	static String file = "src/question20/Data.txt";
	
	public static void read() {
		try (BufferedReader br = new BufferedReader(
				new FileReader(file))) {
			String currLine = null;
			while ((currLine = br.readLine()) != null) {
				String[] info = currLine.split(":");
				System.out.println("Name: " + info[0] + " " + info[1]);
				System.out.println("Age: " + info[2] + " years");
				System.out.println("State: " + info[3] + " State");
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
}
