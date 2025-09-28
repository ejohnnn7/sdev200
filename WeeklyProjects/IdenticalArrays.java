package WeeklyProjects;
import java.util.Scanner;
public class IdenticalArrays {

    // Check if two 2D arrays are identical
    public static boolean equals(int[][] m1, int[][] m2) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false; // If the two 2D arrays are not identical
                }
            }
        }

        // If the two 2D arrays are identical
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] array1 = new int[3][3];
        int[][] array2 = new int[3][3];

        System.out.println("Enter the integers in the first 3x3 array:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array1[i][j] = input.nextInt();
            }
        }

        System.out.println("Enter the integers in the second 3x3 array:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array2[i][j] = input.nextInt();
            }
        }

        if (equals(array1, array2)) {
            System.out.println("The two arrays are identical.");
        } else {
            System.out.println("The two arrays are not identical.");
        }

        input.close();
    }
}
