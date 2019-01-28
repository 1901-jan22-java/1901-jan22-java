package hw1.q5;

public class Substring {
public String subString(String str, int idx){
	String sub="";
	
	for(int i=0;i<=idx-1;i++){
		sub=sub+""+str.charAt(i);
	}
	return sub;
}
public static void main(String[] args) {
	Substring suby=new Substring();
	System.out.println(suby.subString("Daysi",3));
}
}
