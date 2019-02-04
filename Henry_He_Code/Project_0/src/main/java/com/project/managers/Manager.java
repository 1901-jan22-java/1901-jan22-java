package com.project.managers;

import java.util.Scanner;
import com.jdbc.util.Data_Access_Obj;

public interface Manager {
	static Data_Access_Obj dao = new Data_Access_Obj();
	default void takeover() {};
	default void takeover(Scanner scan) {};
}
