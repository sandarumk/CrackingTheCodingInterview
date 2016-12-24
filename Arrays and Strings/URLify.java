import java.util.Scanner;

/**
 * Replace the spaces with %20
 * Complexity O(N)
 * Created by dinu on 12/25/16.
 */
public class URLify {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        //TODO : Handle ArrayOutoBound
        String string = sc.nextLine();
        String firstPart = string.split(",")[0];
        int numberOfChar = Integer.parseInt(string.split(",")[1]);

        char[] charArray = new char[firstPart.length()];
        int stringIndex =0;
        for (int i = 0; i < firstPart.length(); i++) {
            if(firstPart.charAt(stringIndex) == ' '){
                if(stringIndex < numberOfChar){
                    charArray[i] = '%';
                    charArray[i+1] = '2';
                    charArray[i+2] = '0';
                    i +=2;
                    stringIndex++;
                }

            }else{
                charArray[i] = firstPart.charAt(stringIndex);
                stringIndex++;
            }

        }
        System.out.println(new String(charArray));

    }
}
