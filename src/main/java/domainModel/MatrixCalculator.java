package calculator;

import java.util.Scanner;

/* TODO: 
    Using possibly Java Swing to implement UI where each button associates
    with the below functions.
                1. Add fillable boxes to take inputs for matrices
                2. Add clear/reset functions to take new input matrices
                3. Error handling for default inputs/operations
                4. Robust prompts to verify proper inputs before operations
    The main function below showcases only the matrix transpose output to the
    terminal window with accepting user input also from the terminal window.

    
*/ 

public class MatrixCalculator {
    
    // Method to input a matrix
    public static int[][] inputMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix elements e.g., (1 2 ENTER 3 4 for a 2x2 matrix):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    // Method to display a matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // Matrix addition
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length, cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    // Matrix multiplication
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length, colsA = A[0].length, colsB = B[0].length;
        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    // Transpose a matrix
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of rows and columns for the matrix (e.g., 3 3): ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        
        int[][] matrix1 = inputMatrix(rows, cols, scanner);

        System.out.println("Original Matrix:");
        displayMatrix(matrix1);
        
        // Testing transpose function above 
        System.out.println("Transpose of the Matrix:");
        displayMatrix(transposeMatrix(matrix1));

        scanner.close();
    }
}


