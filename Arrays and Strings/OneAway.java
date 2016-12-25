import java.util.HashMap;
import java.util.Scanner;
import java.lang.Math.*;

/**
 * Created by dinu on 12/25/16.
 */
public class OneAway {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        // To take the empty characters, otherwise use next
        String firstString = sc.nextLine();
        String secondString = sc.nextLine();

        boolean result ;
        if(firstString.equals(secondString)){
            result = true;
        }else{
            int lendiff = firstString.length()-secondString.length();
            int lenDiffabs = Math.abs(lendiff);
            if(lenDiffabs == 0 || lenDiffabs== 1){
                result = checkOneAway(firstString,secondString,lendiff);
            }else{
                result = false;
            }
        }


        String output = result ? "true" : "false";

        System.out.println(output);
    }

    /**
     * O(N)
     * @param firstString
     * @param secondString
     * @param lenDiff
     * @return
     */
    private static boolean checkOneAway(String firstString, String secondString,int lenDiff) {
        boolean result;
        if(lenDiff == 0){
            result =compareReplace(firstString,secondString);
        }else if (lenDiff== -1){
            result =compareInsertion(firstString,secondString);
        }else{
            result = compareDeletion(firstString,secondString);
        }
        return result;


    }

    private static boolean compareDeletion(String firstString, String secondString) {
        int firstCount=0;
        boolean oneChange = false;
        for (int i = 0; i < secondString.length(); i++) {
            if(firstString.charAt(firstCount) == secondString.charAt(i)){
                firstCount++;
            }else{
                if(oneChange){
                    return false;
                }else{
                    oneChange=true;
                    firstCount++;
                    i--;
                }
            }
        }
        return true;

    }

    private static boolean compareInsertion(String firstString, String secondString) {
        int secondCount=0;
        boolean oneChange = false;
        for (int i = 0; i < firstString.length(); i++) {
            if(firstString.charAt(i) == secondString.charAt(secondCount)){
               secondCount++;
            }else{
                if(oneChange){
                    return false;
                }else{
                    oneChange=true;
                    secondCount++;
                    i--;
                }
            }
        }
        return true;
    }

    private static boolean compareReplace(String firstString, String secondString) {
        boolean oneChange = false;
        for (int i = 0; i < firstString.length(); i++) {
            if(firstString.charAt(i) == secondString.charAt(i)){
                //Do nothing
            }else{
                if(oneChange){
                    return false;
                }else{
                    oneChange=true;
                }
            }
        }
        return oneChange;
    }






}
