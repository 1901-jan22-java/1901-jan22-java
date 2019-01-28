package hw1.q22;

interface Cookies {
void chocolateChip(String str);

}
class testCookies {
	public static void main(String[] args) {
		Cookies chocolateChip=(String str)->System.out.print("I want chocolate chip cookies");
		chocolateChip.chocolateChip("I am hungry");
	}
}
