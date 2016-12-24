/**
 * Implement an algorithm to determine if  string has all unique characters
 *
 * Created by dinu on 24th December, 2016
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IsUnique{
    public static void main (String args[]){

        Scanner sc = new Scanner(System.in);
        String testString = sc.nextLine();
        if(testString == ""){
            System.out.println("Empty");
            return;
        }
        boolean result = isUniqueArrayBased(testString);
        String output = result ? "Unique" : "Not Unique";
        System.out.println(output);

    }

    /**
     * Loop through the characters one by one
     * Running time O(N^2)
     * @param string
     * @return the result whether the string is unique or not
     */
    private static boolean isUniqueBruteForce(String string){
        int len = string.length();
        for(int i = 0; i < len; i++){
            for (int j = i+1; j < len; j++ ){
                char a = string.charAt(i);
                char b = string.charAt(j);
                if(a == b){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Add the string to a map while adding check whether the character is already added
     * Running time O(N)
     * @param string
     * @return the result whether the string is unique or not
     */
    private static boolean isUniqueMapBased(String string){
        Map<Character, Integer> characterMap = new HashMap<>();
        for(int i =0; i < string.length(); i++){
            if(characterMap.containsKey(string.charAt(i))){
                return false;
            }else{
                characterMap.put(string.charAt(i), 1);
            }
        }
        return true;
    }

    /**
     * Read the string and save it into array
     * 128 is selected as to take the all basic ASCII characters
     * Running time O(N)
     * @param string
     * @return the result whether the string is unique or not
     */
    private static boolean isUniqueArrayBased(String string){
        if(string.length() > 128){
            return false;
        }
        boolean[] uniqueArray = new boolean[128];
        for (int i = 0; i < string.length();i++){
            int index = string.charAt(i);
            if (uniqueArray[index]){
                return false;
            }else{
                uniqueArray[index] = true;
            }
        }
        return true;

    }


}