import java.util.Scanner;

/**
 *
 * Check whether the second string is a rotation of the first string
 * Using isSubtring only once.
 * Created by dinu on 12/25/16.
 */
public class StringRotation {

    public static void main (String args[]){

        Scanner sc = new Scanner(System.in);
        String firstString = sc.next();
        String secondString = sc.next();
        String output="";
        // Concantanete second string with itself, the first string should be a substring
        secondString = secondString+secondString;
        if(IsSubstring(firstString,secondString)){
            output = "True";
        }else{
            output = "False";
        }
        System.out.println(output);

    }

    private static boolean IsSubstring(String firstString, String secondString) {
        if (secondString.indexOf(firstString) >= 0) {
            return true;
        } else {
            return false;
        }
    }


}
