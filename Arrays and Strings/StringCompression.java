import java.util.Scanner;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters
 * Created by dinu on 12/25/16.
 */
public class StringCompression {
    public static void main (String args[]){

        Scanner sc = new Scanner(System.in);
        String testString = sc.nextLine();
        String output = getCompressedString(testString);
        output = output.length()>=testString.length()?testString:output;
        System.out.println(output);

    }

    /**
     * O(N)
     * @param testString
     * @return
     */
    private static String getCompressedString(String testString) {
        StringBuilder sbd = new StringBuilder();
        int mostRecentCharacterCount = 1;
        char mostRecentChar=testString.charAt(0);
        sbd.append(mostRecentChar);
        for (int i = 1; i < testString.length(); i++) {
            char temp = testString.charAt(i);
            if(mostRecentChar == temp){
                mostRecentCharacterCount++;
            }else{
                if(mostRecentCharacterCount>1){
                    sbd.append(mostRecentCharacterCount);
                }
                mostRecentCharacterCount = 1;
                mostRecentChar = temp;
                sbd.append(temp);
            }
        }
        if(mostRecentCharacterCount>1){
            sbd.append(mostRecentCharacterCount);
        }

        return sbd.toString();
    }
}
