package com.question20;

import java.util.List;


public class App {

	public static void main(String[] args) {
//		FileIo writer = new FileIo();
//		People mickey = new People("Mickey", "Mouse", "35", "Arizona");
//		People hulk = new People("Hulk", "Hogan", "50", "Virginia");
//		People roger = new People("Roger", "Rabbit", "22", "California");
//		People wonder = new People("Wonder", "Woman", "18", "Montana");
//		writer.writeData(mickey);
//		writer.writeData(hulk);
//		writer.writeData(roger);
//		writer.writeData(wonder);
		
		List<People> test = FileIo.readObj();
		for(People p : test){
			System.out.println("Name: " + p.getfName() + " " + p.getlName() + "\n" + "Age: " + p.getAge() + "\n" + "State: " + p.getState() + " State");
			System.out.println();
		}
	}
}