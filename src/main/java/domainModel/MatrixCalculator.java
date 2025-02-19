/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

/**
 * Matrix Operators for Calculator
 * @author Chloe
 */
public class MatrixCalculator {
    
    /**
     * Adds two matrices together. The matrices must have the same dimensions
     *
     * @param matrixA the first matrix to be added
     * @param matrixB the second matrix to be added
     * @return a new matrix that is the result of adding matrixA and matrixB
     */
    
    public Matrix add(Matrix matrixA, Matrix matrixB) {
        // TODO: Check if matrices have the same dimensions
        // TODO: Add corresponding elements of matrixA and matrixB

        // Preconditions:
        // Matrices A and B must have the same number of rows and columns.
        
        // Postconditions:
        // Returns a new Matrix object that represents the sum of matrixA and matrixB
        
        return new Matrix(matrixA.getRows(), matrixA.getCols()); 
        // TODO: remove dummy return
    }

    /**
     * Subtracts the second matrix from the first matrix. Matrices must have the same dimensions.
     *
     * @param matrixA the matrix subtracted from
     * @param matrixB the matrix subtracted
     * @return the new resultant matrix of subtracting matrixB from matrixA
     */
    
    public Matrix subtract(Matrix matrixA, Matrix matrixB) {
        // TODO: Check if matrices have the same dimensions
        // TODO: Subtract elements of matrixB from matrixA

        // Preconditions:
        // matrixA and matrixB must have the same number of rows and columns.
        
        // Postconditions:
        // Returns a new Matrix that is the difference of matrixA and matrixB.
       
        return new Matrix(matrixA.getRows(), matrixA.getCols()); 
        // TODO: remove dummy return
    }

    /**
     * Multiplies two matrices together. The number of columns in the first matrix must equal the number of rows in the second matrix.
     *
     * @param matrixA the first matrix to be multiplied
     * @param matrixB the second matrix to be multiplied
     * @return a new matrix that is the result of multiplying matrixA and matrixB
     */
    
    public Matrix multiply(Matrix matrixA, Matrix matrixB) {
        // TODO: Check if matrixA columns match matrixB rows
        // TODO: Perform matrix multiplication 

        // Preconditions:
        // The number of columns in matrixA must equal the number of rows in matrixB.
        
        // Postconditions:
        // Returns a new Matrix object that is the product of matrixA and matrixB.

        return new Matrix(matrixA.getRows(), matrixB.getCols()); 
        // TODO: remove dummy return
    }
    
    /**
     * Transposes the current matrix by swapping its rows into columns and columns into rows.
     * @param matrixA matrix to be transposed (only A allowed for transpose?)
     * @return A new matrix that is the transposed version of the current matrix.
     */
    
    public Matrix transpose(Matrix matrixA) {
        // TODO: Implement transpose logic
        // Preconditions:
        // Must have values to transpose and cannot be a 1x1 matrix
        
        // Postconditions:
        // matrixA rows are swapped with columns
        
        return new Matrix(matrixA.getCols(), matrixA.getRows()); 
        // TODO: remove dummy return 
    }
    
    /**
    * Displays the result matrix after performing the selected operation.
    */
    public void calculate() {
        // TODO: Implement logic to display the result matrix
        // Preconditions:
        // A matrix result should already be calculated by previous operations
    
        // Postconditions:
        // The resultant matrix will be displayed.
        
        System.out.println();  
        // TODO: Implement resultantMatrix object
}



    /**
     * Clears the current matrix, resetting it to empty state
     */
    
    public void clear() {
        // TODO: Implement clear method to reset the matrix
        // Preconditions:
        // N/A
        
        // Postconditions:
        // Matrix is cleared/emptied
    }

    /**
     * Swaps the current matrix with another matrix.
     * @param otherMatrix the matrix to swap with the current matrix
     */
    
    public void swap(Matrix otherMatrix) {
        // TODO: Implement swap logic
        // Preconditions:
        // Matrices must be the same size
        
        // Postconditions: 
        // Matrices are swapped
    }

    /**
     * Resizes the current matrix to the specified number of rows and columns.
     * @param newRows the new number of rows for the matrix
     * @param newCols the new number of columns for the matrix
     */
    
    public void resize(int newRows, int newCols) {
        // TODO: Implement resize logic to resize the matrix
        // Preconditions:
        // N/A
        
        // Postconditions: 
        // Matrix is resized
    }
}
