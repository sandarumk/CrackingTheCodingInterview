import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given two strings find one is a permutation of the other
 * Created by dinu on 12/24/16.
 */
public class CheckPermutation {

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        // To take the empty characters, otherwise use next
        String firstString = sc.nextLine();
        String secondString = sc.nextLine();
        boolean result ;

        if (firstString.equals(secondString)){
            result = true;
        }else if (firstString.length()!=secondString.length()){
            result = false;
        }else {
            result = CheckPemutationSortBased(firstString,secondString);
        }
        String output = result ? "Permutation" : "Not permutation";

        System.out.println(output);
    }

    /**
     * Add the characters to a map, then remove them one by one looping the next string
     * Complexity O(3N) -> O(N)
     * @param firstString
     * @param secondString
     * @return
     */
    public static boolean checkPermutationMapBased(String firstString, String secondString){
        Map<Character, Integer> characterMap = new HashMap();
        for (int i = 0; i < firstString.length(); i++){
            char temp = firstString.charAt(i);
            if(characterMap.containsKey(temp)){
                int count = characterMap.get(temp);
                count ++;
                characterMap.put(temp,count);
            }else{
                characterMap.put(temp,1);
            }
        }
        for (int j = 0; j < secondString.length(); j++) {
            char temp = secondString.charAt(j);
            if(characterMap.containsKey(temp)){
                int count = characterMap.get(temp);
                count --;
                characterMap.put(temp,count);
            }else{
                return false;
            }
        }

        for(int value: characterMap.values()){
            if(value<0 || value>0){
                return false;
            }
        }

        return true;
    }

    /**
     * Sort the characters in the string then check whether the sorted strings are equal
     * Complexity O(Nlog(N))
     * @param firstString
     * @param secondString
     * @return
     */
    public static boolean CheckPemutationSortBased(String firstString, String secondString){
        firstString = sort(firstString);
        secondString = sort(secondString);
        if (firstString.equals(secondString)){
            return true;
        }
        return false;

    }

    /**
     * Sort the string
     * @param unsortedString
     * @return
     */
    private static String sort (String unsortedString){
        char[] charArray = unsortedString.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

}
