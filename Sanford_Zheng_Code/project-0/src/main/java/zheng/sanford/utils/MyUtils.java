package zheng.sanford.utils;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.revature.bank.dao.AccountRepository;

public class MyUtils {
	public static final Logger LOGGER = Logger.getLogger(AccountRepository.class);
	public static String format(String...str) {
		ArrayList<String> strArr = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for(String s1: strArr) {
			String[] s1Arr = s1.split(" ");
			for(String s2: s1Arr) {
				if(!s2.isEmpty())
					sb.append(""+Character.toUpperCase(s2.charAt(0)) + s2.substring(1) + " ");
			}
		}
		return sb.toString();
	}
}
