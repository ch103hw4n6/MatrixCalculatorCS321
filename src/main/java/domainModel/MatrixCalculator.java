package domainModel;

import java.util.Scanner;
import org.apache.commons.math3.linear.*;

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
    
    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int rows = A.length, cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] - B[i][j];
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
    
    // Inverse a square matrix using Gauss–Jordan elimination
    public static double[][] inverseMatrix(int[][] matrix) {
        int n = matrix.length;
        if(n != matrix[0].length) {
            return null; // Not a square matrix
        }
        
        // Build augmented matrix [matrix | identity]
        double[][] aug = new double[n][2 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aug[i][j] = matrix[i][j];
            }
            for (int j = n; j < 2 * n; j++) {
                aug[i][j] = (i == j - n) ? 1 : 0;
            }
        }
        
        // Forward elimination to form reduced row echelon form
        for (int i = 0; i < n; i++) {
            // If pivot is zero, swap with a lower row
            if (aug[i][i] == 0) {
                int swap = i + 1;
                while (swap < n && aug[swap][i] == 0) {
                    swap++;
                }
                if (swap == n) {
                    return null; // Singular matrix
                }
                double[] temp = aug[i];
                aug[i] = aug[swap];
                aug[swap] = temp;
            }
            // Normalize the pivot row
            double pivot = aug[i][i];
            for (int j = 0; j < 2 * n; j++) {
                aug[i][j] /= pivot;
            }
            // Eliminate pivot column from other rows
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = aug[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        aug[k][j] -= factor * aug[i][j];
                    }
                }
            }
        }
        
        // Extract the inverse matrix
        double[][] inverse = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] = aug[i][j + n];
            }
        }
        return inverse;
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
    
    
    public static int[][] scaleMatrix(int[][] matrix, int scalar) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }

        return result;
    }
    
    public static double detMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] doubleMatrix = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                doubleMatrix[i][j] = matrix[i][j];
            }
        }
        RealMatrix realMatrix = MatrixUtils.createRealMatrix(doubleMatrix);
        LUDecomposition decomposition = new LUDecomposition(realMatrix);
        double det = decomposition.getDeterminant();
        return det;
    }
    
    public static double[] eigenvalueMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] doubleMatrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                doubleMatrix[i][j] = matrix[i][j];
            }
        }
        RealMatrix realMatrix = MatrixUtils.createRealMatrix(doubleMatrix);
        EigenDecomposition eigenDecomp = new EigenDecomposition(realMatrix);
        double[] eigenvalues = eigenDecomp.getRealEigenvalues();
        return eigenvalues;
    }
    public static double[][] eigenvectorMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] doubleMatrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                doubleMatrix[i][j] = matrix[i][j];
            }
        }
        RealMatrix realMatrix = MatrixUtils.createRealMatrix(doubleMatrix);
        EigenDecomposition eigenDecomposition = new EigenDecomposition(realMatrix);
        RealMatrix eigenvectors = eigenDecomposition.getV();
        return eigenvectors.getData();
    }
   
    
    
}


