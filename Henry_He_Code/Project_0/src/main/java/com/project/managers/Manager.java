package com.project.managers;

import java.util.Scanner;
import com.jdbc.util.Data_Access_Obj;

public abstract class Manager {
		public static Data_Access_Obj dao = new Data_Access_Obj();
		public static Scanner scan = new Scanner(System.in);
		void takeover() {};
}
