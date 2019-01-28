package question21;



public class Hello {
    public static void main(String[] args) {
        String str1 = "Rainnnnnnnnn";
        System.out.println(removeDuplicateChars(str1));
        String str2 = "helllllllllllo";
        System.out.println(removeDuplicateChars(str2));
    }
 
    private static String removeDuplicateChars(String sourceStr) {
        // Store letters in this string.
        char[] chrArray = sourceStr.toCharArray();
        String targetStr = "";
 
        // Loop over each character.
        for (char value : chrArray) {
            // See if character is in the target
            if (targetStr.indexOf(value) == -1) {
                targetStr += value; // Use StringBuilder as shown below
            }
        }
        return targetStr;
    }
}
