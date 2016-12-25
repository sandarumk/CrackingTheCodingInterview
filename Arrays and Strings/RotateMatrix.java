import java.nio.channels.Pipe;
import java.util.Scanner;

/**
 * Created by dinu on 12/25/16.
 */
public class RotateMatrix {

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
        matrix = rotateMatrix(matrix,size);
        System.out.println("--------------------------------------------------------");
        printMatrix(matrix,size);
    }

    /**
     * This solution requires O(N^2) both in space and running time
     * We can reduce the space by rotating layers to O(N)
     * @param matrix
     * @param n
     * @return
     */
    private static int[][] rotateMatrix(int[][] matrix, int n) {
        int[][] matrixRotate = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                int newj = i;
                int newi = n-1-j;
                matrixRotate[newi][newj] = matrix[i][j];
            }

        }
        return matrixRotate;
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
