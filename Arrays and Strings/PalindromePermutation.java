import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Check if a given string is a permutation of a palindrome
 * Created by dinu on 12/25/16.
 */
public class PalindromePermutation {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        // To take the empty characters, otherwise use next
        String firstString = sc.nextLine();
        //firstString = firstString.toLowerCase(); If we want to take the capitals and simples as one
        boolean result = checkPermutationMapBased(firstString);

        String output = result ? "Palindrome Permutation" : "Not Palindrome permutation";

        System.out.println(output);
    }

    /**
     * Add the characters to a map, then check the frequencies are all even or all even one odd
     * This take the capital and simple letter as two different letters
     * Complexity O(2N) -> O(N)
     * @param firstString
     * @return
     */
    public static boolean checkPermutationMapBased(String firstString){
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
        boolean oneOdd = false;

        for(int value: characterMap.values()){
            if(!(value%2==0)){
                if(oneOdd){
                    return false;
                }else{
                    oneOdd=true;
                }
            }

        }
        return true;
    }

}
