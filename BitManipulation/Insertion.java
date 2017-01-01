import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by dinu on 1/1/17.
 */
public class Insertion {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int i = sc.nextInt();
        int j = sc.nextInt();
        int result = bitbybitinsertion(n,m,i,j);
        System.out.println(result);

    }

    private static int bitbybitinsertion(int numberN, int numberM,int i, int j){
        int index = getBitLength(numberM)-1;
        while(index >= 0 ){
            if(getBit(numberM,index)){
                numberN=setBit(numberN,j);
            }else{
                numberN=clearBit(numberN,j);
            }
            index--;
            j--;
        }
        return numberN;

    }

    private static int getBitLength(int number){
        return BigInteger.valueOf(number).bitLength();
    }

    private static boolean getBit(int number, int i){
        return ((number & (1 << i)) != 0);
    }

    private static int setBit(int number, int i){
        return (number | (1<<i));
    }

    private static int clearBit(int number, int i){
        return (number & ~(1<<i));
    }
}
