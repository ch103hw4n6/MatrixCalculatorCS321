/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

/**
 *  Initialization and methods for a matrix
 *  @author Chloe, Carter
 */
public class Matrix {

    // 2D array to hold matrix elements
    private double[][] data;

    /**
     * Constructs a Matrix object with the specified number of rows and columns.
     * Initialize all elements to zero
     * 
     * @param rows the number of rows in the matrix
     * @param cols the number of columns in the matrix
     * 
     * Preconditions:
     * - rows and cols must be greater than 0
     * 
     * Postconditions:
     * - Matrix is initialized with dimensions [rows][cols], all values set to 0.0
     */
    public Matrix(int rows, int cols) {
        // Initialize the 2D array with specified dimensions
        data = new double[rows][cols];
    }

    /**
     * Gets the element at a specific position in the matrix
     * 
     * @param row the row index of element 
     * @param cols the column index of element 
     * @return the element at the specified position
     * 
     * Preconditions:
     * - The specified indices must be within bounds
     * 
     * Postconditions:
     * - Returns the value stored at position (row, cols)
     */
    public double getElement(int row, int cols) {
        return data[row][cols];
    }

    /**
     * Sets the element at a specific position in the matrix
     * 
     * @param row the row index where the element will be set 
     * @param cols the column index where the element will be set 
     * @param value the value to set at the specified position
     * 
     * Preconditions:
     * - The specified indices must be within bounds
     * 
     * Postconditions:
     * - The value at (row, cols) is updated to the specified value
     */
    public void setElement(int row, int cols, double value) {
        data[row][cols] = value;
    }

    /**
     * Gets the number of rows in the matrix.
     * 
     * @return the number of rows in the matrix
     * 
     * Preconditions:
     * - N/A
     * 
     * Postconditions:
     * - Returns the row count of the matrix
     */
    public int getRows() {
        return data.length;
    }

    /**
     * Gets the number of columns in the matrix.
     * 
     * @return the number of columns in the matrix
     * 
     * Preconditions:
     * - Assumes matrix has at least one row
     * 
     * Postconditions:
     * - Returns the column count of the matrix
     */
    public int getCols() {
        return data[0].length;
    }
}
