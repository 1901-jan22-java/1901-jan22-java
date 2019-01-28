package com.revature.Q13;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	enum Side {
		left,
		right
	}
	
	public static void Draw(int size) {
		List<String> tri = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			Side s = Side.left;
			String temp = "";
			if (i > 0) {
				temp = tri.get(0);
				for (int j = 0; j < i; j++) {
					if (s == Side.left) {
						temp = (temp.charAt(0) == '0' ? "1" : "0") + temp;
						s = Side.right;
					}
					else
					{
						temp = temp + (temp.charAt(temp.length() - 1) == '0' ? "1" : "0");
						s = Side.left;
					}
				}
				tri.add(temp);
			}
			else
				tri.add("0");
		}
		for (String string : tri) {
			System.out.println(string);
		}
	}
}
