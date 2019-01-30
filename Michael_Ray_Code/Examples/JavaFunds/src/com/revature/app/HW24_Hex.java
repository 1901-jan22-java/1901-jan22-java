package com.revature.app;

public class HW24_Hex {
public static void main(String[] args) {
	System.out.println(DecToHex(100));
}
public static String DecToHex(int num){
	String hexNumStore = "";
	String hexNum = "0x";
	
	int modNum = 0;
	int dividNum = 0;
	do{
		modNum = num % 16;
		dividNum = num / 16;
		
		switch(modNum){
		//case 0 :{
		//	hexNumStore += "1";
		//	break;
		//}
		case 10:{
			hexNumStore += "A";
			break;
		}
		case 11:{
			hexNumStore += "B";
			break;
		}
		case 12:{
			hexNumStore += "C";
			break;
		}
		case 13:{
			hexNumStore += "D";
			break;
		}
		case 14:{
			hexNumStore += "E";
			break;
		}
		case 15:{
			hexNumStore += "F";
			break;
		}
		default:{
			hexNumStore += modNum;
		}
		}
		
	}while(dividNum > 15);
	
	
	switch(dividNum){
	case 0:{
		break;
	}
	case 10:{
		hexNumStore += "A";
		break;
	}
	case 11:{
		hexNumStore += "B";
		break;
	}
	case 12:{
		hexNumStore += "C";
		break;
	}
	case 13:{
		hexNumStore += "D";
		break;
	}
	case 14:{
		hexNumStore += "E";
		break;
	}
	case 15:{
		hexNumStore += "F";
		break;
	}
	default:{
		hexNumStore += dividNum;
	}
	}
	
	for(int i = hexNumStore.length() -1; i >= 0; i--){
		hexNum += hexNumStore.charAt(i);
	}
	
	return hexNum;
}
}
