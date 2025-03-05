/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

/**
 *  Initialization and methods for a matrix
 * @author Chloe
 */
public class Matrix {

    // 2D array to hold matrix elements
    private double[][] data;

    /**
     * Constructs a Matrix object with the specified number of rows and columns.
     * @param rows the number of rows in the matrix
     * @param cols the number of columns in the matrix
    */
    
    public Matrix(int rows, int cols) {
        // TODO: Implement constructor
        // Preconditions: 
        // N/A
        
        // Postconditions:
        // A new Matrix object with the specified number of rows and columns is created,
        // and the matrix is initialized with all elements set to zero.
        
        data = new double[rows][cols];
    }

    /**
     * Gets the element at a specific position in the matrix
     * @param row the row index of element 
     * @param cols the column index of element 
     * @return the element at the specified position
     */
    public double getElement(int row, int cols) {
        // TODO: Implement getElement method
        
        // Preconditions: 
        // An elemeent must exist at (row,col)
        
        // Postconditions:
        // Element is retrived
        
        return 0;
        // TODO: Implement return statement
    }

    /**
     * Sets the element at a specific position in the matrix
     * @param row the row index where the element will be set 
     * @param cols the column index where the element will be set 
     * @param value the value to set at the specified position
     */
    
    public void setElement(int row, int cols, double value) {
        // TODO: Implement setElement method
        // Preconditions: 
        // N/A
        
        // Postconditions:
        // Value is set at specified position
    }

    /**
     * Gets the number of rows in the matrix.
     * @return the number of rows in the matrix
     */
    public int getRows() {
        // TODO: Implement getRows method
        // Preconditions: 
        // N/A d
        
        // Postconditions:
        // Number of rows in stored in return value
        return 0;  
        // TODO: implement return value variable
    }

    /**
     * Gets the number of columns in the matrix.
     * @return the number of columns in the matrix
     */
    public int getCols() {
        // TODO: Implement getCols method
        // Preconditions: 
        // N/A
        
        // Postconditions:
        // Number of columns in stored in return value
        
        return 0;  
        // TODO: implement return value variable
    }
}

