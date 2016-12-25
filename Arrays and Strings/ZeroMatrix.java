import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * If one element is zero, its entire column and row is zero
 * Created by dinu on 12/25/16.
 */
public class ZeroMatrix {
    public static void main (String[] args){
        Scanner sc= new Scanner(System.in);
        int size = sc.nextInt();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }

        }
        printMatrix(matrix,size);
        matrix = zeroMatrix(matrix,size);
        System.out.println("--------------------------------------------------------");
        printMatrix(matrix,size);
    }

    /**
     * Bruteforce solution
     * No extra space
     * But running time O(N^2)
     * @param matrix
     * @param size
     * @return
     */
    private static int[][] zeroMatrix(int[][] matrix, int size) {
        Set<Integer> zeroRow = new HashSet();
        Set<Integer> zeroColumn = new HashSet();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(matrix[i][j]==0){
                    zeroRow.add(i);
                    zeroColumn.add(j);

                }
            }

        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(zeroColumn.contains(j)||zeroRow.contains(i)){
                    matrix[i][j]=0;
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

}
