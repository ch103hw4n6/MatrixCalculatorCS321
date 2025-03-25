package domainModel;

/**
 * MatrixCalculator provides arithmetic operations for matrix manipulation.
 * Supported operations include addition, subtraction, multiplication, transposition,
 * resizing, clearing, and swapping of matrices.
 * 
 * This class assumes input matrices are valid and performs precondition checks
 * where necessary to avoid illegal operations.
 * 
 * All calculations update an internal resultMatrix instance.
 * 
 * @author Chloe, Carter
 */
public class MatrixCalculator {

    // Holds the result of the most recent operation
    private Matrix resultMatrix;

    /**
     * Adds two matrices of the same dimensions.
     *
     * @param matrixA the first matrix to add
     * @param matrixB the second matrix to add
     * @return a new matrix containing the element-wise sum
     * @throws IllegalArgumentException if dimensions do not match
     */
    public Matrix add(Matrix matrixA, Matrix matrixB) {
        if (matrixA.getRows() != matrixB.getRows() || matrixA.getCols() != matrixB.getCols()) {
            throw new IllegalArgumentException("Matrix dimensions must match for addition.");
        }

        Matrix result = new Matrix(matrixA.getRows(), matrixA.getCols());

        for (int i = 0; i < result.getRows(); i++) {
            for (int j = 0; j < result.getCols(); j++) {
                double sum = matrixA.getElement(i, j) + matrixB.getElement(i, j);
                result.setElement(i, j, sum);
            }
        }

        resultMatrix = result;
        return result;
    }

    /**
     * Subtracts the second matrix from the first matrix.
     *
     * @param matrixA the matrix to subtract from
     * @param matrixB the matrix to subtract
     * @return a new matrix containing the element-wise difference
     * @throws IllegalArgumentException if dimensions do not match
     */
    public Matrix subtract(Matrix matrixA, Matrix matrixB) {
        if (matrixA.getRows() != matrixB.getRows() || matrixA.getCols() != matrixB.getCols()) {
            throw new IllegalArgumentException("Matrix dimensions must match for subtraction.");
        }

        Matrix result = new Matrix(matrixA.getRows(), matrixA.getCols());

        for (int i = 0; i < result.getRows(); i++) {
            for (int j = 0; j < result.getCols(); j++) {
                double diff = matrixA.getElement(i, j) - matrixB.getElement(i, j);
                result.setElement(i, j, diff);
            }
        }

        resultMatrix = result;
        return result;
    }

    /**
     * Multiplies two matrices using standard matrix multiplication.
     *
     * @param matrixA the first matrix (left-hand side)
     * @param matrixB the second matrix (right-hand side)
     * @return the resulting matrix product
     * @throws IllegalArgumentException if matrixA columns do not equal matrixB rows
     */
    public Matrix multiply(Matrix matrixA, Matrix matrixB) {
        if (matrixA.getCols() != matrixB.getRows()) {
            throw new IllegalArgumentException("Matrix A's columns must match Matrix B's rows for multiplication.");
        }

        Matrix result = new Matrix(matrixA.getRows(), matrixB.getCols());

        for (int i = 0; i < matrixA.getRows(); i++) {
            for (int j = 0; j < matrixB.getCols(); j++) {
                double productSum = 0;
                for (int k = 0; k < matrixA.getCols(); k++) {
                    productSum += matrixA.getElement(i, k) * matrixB.getElement(k, j);
                }
                result.setElement(i, j, productSum);
            }
        }

        resultMatrix = result;
        return result;
    }

    /**
     * Transposes the given matrix by flipping rows and columns.
     *
     * @param matrixA the matrix to transpose
     * @return a new matrix that is the transpose of matrixA
     */
    public Matrix transpose(Matrix matrixA) {
        Matrix result = new Matrix(matrixA.getCols(), matrixA.getRows());

        for (int i = 0; i < matrixA.getRows(); i++) {
            for (int j = 0; j < matrixA.getCols(); j++) {
                result.setElement(j, i, matrixA.getElement(i, j));
            }
        }

        resultMatrix = result;
        return result;
    }

    /**
     * Displays the contents of the most recent result matrix.
     * If no result is available, a message is printed instead.
     */
    public void calculate() {
        if (resultMatrix == null) {
            System.out.println("No result to display. Perform an operation first.");
            return;
        }

        for (int i = 0; i < resultMatrix.getRows(); i++) {
            for (int j = 0; j < resultMatrix.getCols(); j++) {
                System.out.print(resultMatrix.getElement(i, j) + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Clears the currently stored result matrix.
     * After this, no matrix will be available for display.
     */
    public void clear() {
        resultMatrix = null;
    }

    /**
     * Swaps the contents of the result matrix with another matrix of equal dimensions.
     *
     * @param otherMatrix the matrix to swap with the result matrix
     * @throws IllegalStateException if resultMatrix is null
     * @throws IllegalArgumentException if dimensions do not match
     */
    public void swap(Matrix otherMatrix) {
        if (resultMatrix == null) {
            throw new IllegalStateException("No result matrix to swap.");
        }

        if (resultMatrix.getRows() != otherMatrix.getRows() || resultMatrix.getCols() != otherMatrix.getCols()) {
            throw new IllegalArgumentException("Matrices must have the same dimensions to be swapped.");
        }

        for (int i = 0; i < resultMatrix.getRows(); i++) {
            for (int j = 0; j < resultMatrix.getCols(); j++) {
                double temp = resultMatrix.getElement(i, j);
                resultMatrix.setElement(i, j, otherMatrix.getElement(i, j));
                otherMatrix.setElement(i, j, temp);
            }
        }
    }

    /**
     * Resizes the result matrix to new dimensions, preserving original values where possible.
     * New elements are initialized to 0.
     *
     * @param newRows new number of rows
     * @param newCols new number of columns
     * @throws IllegalStateException if no result matrix exists
     */
    public void resize(int newRows, int newCols) {
        if (resultMatrix == null) {
            throw new IllegalStateException("No result matrix to resize.");
        }

        Matrix resized = new Matrix(newRows, newCols);

        for (int i = 0; i < Math.min(newRows, resultMatrix.getRows()); i++) {
            for (int j = 0; j < Math.min(newCols, resultMatrix.getCols()); j++) {
                resized.setElement(i, j, resultMatrix.getElement(i, j));
            }
        }

        resultMatrix = resized;
    }
}
