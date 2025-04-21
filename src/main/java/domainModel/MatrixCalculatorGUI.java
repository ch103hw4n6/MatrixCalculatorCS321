package domainModel;

import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList; 
import java.util.List;

 

public class MatrixCalculatorGUI extends JFrame {
    private JTextField rowsField1, colsField1, rowsField2, colsField2, scalarField;
    private JTable matrix1Table, matrix2Table, resultTable;
    private JButton addButton, multiplyButton, subtractButton, transposeButton, clearButton,swapButton,inverseButton, createTablesButton,scaleButton, detButton,evalueButton, evectButton;
    private JScrollPane matrix1ScrollPane, matrix2ScrollPane, resultScrollPane;
    private JPanel tablePanel; 
    
    
    public MatrixCalculatorGUI() {
        // Header Panel with formatted instructions 
        JLabel headerLabel = new JLabel("Matrix Calculator Instructions:");
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 16));

        JPanel instructionsPanel = new JPanel();
        instructionsPanel.setLayout(new BoxLayout(instructionsPanel, BoxLayout.Y_AXIS));

        Font sectionFont = new Font("SansSerif", Font.BOLD, 14);
        Font instructionFont = new Font("SansSerif", Font.PLAIN, 12);

        JLabel unaryLabel = new JLabel("Unary Operations (Matrix 1 only):");
        unaryLabel.setFont(sectionFont);
        instructionsPanel.add(unaryLabel);

        List<String> unaryInstructions = new ArrayList<>();
        unaryInstructions.add("Transpose: compute the transpose of a matrix.");
        unaryInstructions.add("Inverse: compute the inverse of a matrix (square matrices only).");
        unaryInstructions.add("Scale: scale a matrix by a rational number.");
        unaryInstructions.add("Determinants: compute the determinant of a matrix (square matrices only).");
        unaryInstructions.add("Eigendecomposition: compute the eigendecomposition of a matrix (square matrices only).");
        
        for (String instruction : unaryInstructions) {
            JLabel instructionLabel = new JLabel("• " + instruction);
            instructionLabel.setFont(instructionFont);
            instructionsPanel.add(instructionLabel);
        }

        JLabel unaryNoteLabel = new JLabel("Note: For unary operations, only Matrix 1 is used. Enter 0 for rows/columns of Matrix 2.");
        unaryNoteLabel.setFont(instructionFont);
        instructionsPanel.add(unaryNoteLabel);

        JLabel binaryLabel = new JLabel("Binary Operations:");
        binaryLabel.setFont(sectionFont);
        instructionsPanel.add(binaryLabel);

        List<String> binaryInstructions = new ArrayList<>();
        binaryInstructions.add("Add: perform matrix addition.");
        binaryInstructions.add("Subtract: perform matrix subtraction.");
        binaryInstructions.add("Multiply: perform matrix multiplication.");

        for (String instruction : binaryInstructions) {
            JLabel instructionLabel = new JLabel("• " + instruction);
            instructionLabel.setFont(instructionFont);
            instructionsPanel.add(instructionLabel);
        }

        JLabel enterNoteLabel = new JLabel("Important: After entering values in the matrix tables, press the Enter key in each cell to ensure the value is registered.");
        enterNoteLabel.setFont(instructionFont);
        instructionsPanel.add(enterNoteLabel);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(headerLabel, BorderLayout.NORTH);
        headerPanel.add(instructionsPanel, BorderLayout.CENTER);
        headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));


        setTitle("Matrix Calculator");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPanel = new JPanel(new GridBagLayout());
        setContentPane(new JScrollPane(contentPanel));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        

        // Panel for matrix size inputs
        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Matrix Dimensions"));
        inputPanel.add(new JLabel("Matrix 1 Rows:"));
        rowsField1 = new JTextField(3);
        inputPanel.add(rowsField1);
        inputPanel.add(new JLabel("Cols:"));
        colsField1 = new JTextField(3);
        inputPanel.add(colsField1);
        inputPanel.add(new JLabel("Matrix 2 Rows:"));
        rowsField2 = new JTextField(3);
        inputPanel.add(rowsField2);
        inputPanel.add(new JLabel("Cols:"));
        colsField2 = new JTextField(3);
        inputPanel.add(colsField2);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        contentPanel.add(inputPanel, gbc);
        
        // instructions
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPanel.add(headerPanel, gbc);
   

        // Button to create tables
        createTablesButton = new JButton("Create Matrices");
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        contentPanel.add(createTablesButton, gbc);

        // Table Panel
        tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.X_AXIS));
        tablePanel.setPreferredSize(new Dimension(600, 250));
        tablePanel.setBorder(BorderFactory.createTitledBorder("Matrix Tables"));
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        contentPanel.add(tablePanel, gbc);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        swapButton = new JButton("Swap");
        clearButton = new JButton("Clear");
        
        
        JPanel buttonPanelmid = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        transposeButton = new JButton("Transpose");
        inverseButton = new JButton("Inverse"); 
        scaleButton = new JButton("Scale by:");
        
        
        
        JPanel buttonPanelBottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        evalueButton = new JButton("Eigenvalue");
        evectButton = new JButton("Eigenvector");
        scalarField = new JTextField(3);
        detButton = new JButton("Det");
      
        
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(swapButton);
        buttonPanel.add(clearButton);
        gbc.gridy = 4;
        contentPanel.add(buttonPanel, gbc);
        
        buttonPanelmid.add(transposeButton);
        buttonPanelmid.add(inverseButton);
        buttonPanelmid.add(scaleButton);
        buttonPanelmid.add(scalarField);
        gbc.gridy = 5;
        contentPanel.add(buttonPanelmid, gbc);
        
        
        buttonPanelBottom.add(detButton);
        buttonPanelBottom.add(evalueButton);
        buttonPanelBottom.add(evectButton);
        gbc.gridy = 6;
        contentPanel.add(buttonPanelBottom, gbc);
        
        
        

        // Button Actions
        createTablesButton.addActionListener(e -> createTables());
        addButton.addActionListener(e -> performMatrixOperation("add"));
        subtractButton.addActionListener(e -> performMatrixOperation("subtract"));
        multiplyButton.addActionListener(e -> performMatrixOperation("multiply"));
        transposeButton.addActionListener(e -> performMatrixOperation("transpose"));
        inverseButton.addActionListener(e -> performMatrixOperation("inverse"));
        swapButton.addActionListener(e -> swapMatrices());
        clearButton.addActionListener(e -> clearInputs());
        scaleButton.addActionListener(e -> performMatrixOperation("scale"));
        detButton.addActionListener(e -> {
            try {
                int[][] matrix = getMatrixFromTable(matrix1Table);
                if (matrix == null) return;

                double det = MatrixCalculator.detMatrix(matrix);
                JOptionPane.showMessageDialog(this, "Determinant: " + det, "Result", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    showError("Cannot calculate determinant. Make sure matrix is square and valid.");
            }
        });
        evalueButton.addActionListener(e -> {
            try {
                int[][] matrix = getMatrixFromTable(matrix1Table);
                if (matrix == null) return;

                double[] evalue = MatrixCalculator.eigenvalueMatrix(matrix);
                String evalueStr = Arrays.toString(evalue);
                JOptionPane.showMessageDialog(this, "Eigenvalues: " + evalueStr, "Result", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    showError("Cannot calculate eigenvalue. Make sure matrix is square and valid.");
            }
        });
        evectButton.addActionListener(e -> {
            try {
                int[][] matrix = getMatrixFromTable(matrix1Table);
                if (matrix == null) return;

                double[][] evector = MatrixCalculator.eigenvectorMatrix(matrix);
                String evectorStr = Arrays.deepToString(evector);
                JOptionPane.showMessageDialog(this, "Eigenvectors: " + evectorStr, "Result", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    showError("Cannot calculate eigenvectors. Make sure matrix is square and valid.");
            }
        });
     
        setVisible(true);
        
        double[][] lastResult = MatrixCalculator.loadMatrixFromCSV();
        if (lastResult != null) {
            int rows = lastResult.length;
            int cols = lastResult[0].length;

            resultTable = new JTable(rows, cols);
            setTableProperties(resultTable, cols, rows);
            resultScrollPane = new JScrollPane(resultTable);
            resultScrollPane.setBorder(BorderFactory.createTitledBorder("History"));

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    resultTable.setValueAt(lastResult[i][j], i, j);
                }
            }

            tablePanel.add(resultScrollPane);
            tablePanel.revalidate();
            tablePanel.repaint();
        }
    }
    
    
    private void clearInputs() {
        rowsField1.setText("");
        colsField1.setText("");
        rowsField2.setText("");
        colsField2.setText("");
        tablePanel.removeAll();
        tablePanel.revalidate();
        tablePanel.repaint();
    }

    private void createTables() {
        try {
            int rows1 = Integer.parseInt(rowsField1.getText());
            int cols1 = Integer.parseInt(colsField1.getText());
            int rows2 = Integer.parseInt(rowsField2.getText());
            int cols2 = Integer.parseInt(colsField2.getText());

            // Create properly sized tables
            matrix1Table = new JTable(rows1, cols1);
            matrix2Table = new JTable(rows2, cols2);
            resultTable = new JTable(Math.max(rows1, rows2), Math.max(cols1, cols2));

            // Apply forced appearance fixes
            setTableProperties(matrix1Table, cols1, rows1);
            setTableProperties(matrix2Table, cols2, rows2);
            setTableProperties(resultTable, Math.max(cols1, cols2), Math.max(rows1, rows2));

            // Fill tables with default value (0)
            fillTableWithZeros(matrix1Table);
            fillTableWithZeros(matrix2Table);
            fillTableWithZeros(resultTable);

            // Add scroll panes
            matrix1ScrollPane = new JScrollPane(matrix1Table);
            matrix2ScrollPane = new JScrollPane(matrix2Table);
            resultScrollPane = new JScrollPane(resultTable);

            // Add borders for clarity
            matrix1ScrollPane.setBorder(BorderFactory.createTitledBorder("Matrix 1"));
            matrix2ScrollPane.setBorder(BorderFactory.createTitledBorder("Matrix 2"));
            resultScrollPane.setBorder(BorderFactory.createTitledBorder("Result"));

            // Ensure proper display by setting flex dimensions
            matrix1ScrollPane.setPreferredSize(null); // auto-resize
            matrix1ScrollPane.setMinimumSize(new Dimension(180, 180)); // fallback minimum
            matrix2ScrollPane.setPreferredSize(null); // auto-resize
            matrix2ScrollPane.setMinimumSize(new Dimension(180, 180)); // fallback minimum
            resultScrollPane.setPreferredSize(null); // auto-resize
            resultScrollPane.setMinimumSize(new Dimension(180, 180)); // fallback minimum


            // Adjust tablePanel layout
            tablePanel.removeAll();
            tablePanel.add(matrix1ScrollPane);
            tablePanel.add(matrix2ScrollPane);
            tablePanel.add(resultScrollPane);

            tablePanel.revalidate();
            tablePanel.repaint();

        } catch (Exception e) {
            showError("Invalid Input! Enter valid row/column values.");
        }
    }

    private void setTableProperties(JTable table, int cols, int rows) {
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < cols; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(60);
        }

        table.setPreferredScrollableViewportSize(new Dimension(cols * 60, rows * 30));
    }

    private void fillTableWithZeros(JTable table) {
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt(0, i, j);
            }
        }
    }

    private int[][] getMatrixFromTable(JTable table) {
        int rows = table.getRowCount();
        int cols = table.getColumnCount();
        int[][] matrix = new int[rows][cols];

        try {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Object value = table.getValueAt(i, j);
                    if (value == null || value.toString().trim().isEmpty()) {
                        matrix[i][j] = 0; // Default empty cells to 0 instead of showing an error
                    } else {
                        matrix[i][j] = Integer.parseInt(value.toString().trim());
                    }
                }
            }
        } catch (Exception e) {
            showError("Error: Ensure all matrix values are numbers.");
            return null;
        }

        return matrix;
    }

    private void performMatrixOperation(String operation) {
        try {
            int[][] matrix1 = getMatrixFromTable(matrix1Table);
            int[][] matrix2 = getMatrixFromTable(matrix2Table);

            if (matrix1 == null) return;
            if ((matrix2 == null && !operation.equals("transpose"))) return;

            int[][] result = null;

            switch (operation) {
                case "add":
                    result = MatrixCalculator.addMatrices(matrix1, matrix2);
                    break;
                 case "subtract":
                    result = MatrixCalculator.subtractMatrices(matrix1, matrix2);
                    break;
                case "multiply":
                    result = MatrixCalculator.multiplyMatrices(matrix1, matrix2);
                    break;
                case "transpose":
                    result = MatrixCalculator.transposeMatrix(matrix1);
                    break;
                case "inverse":
                    if (matrix1.length != matrix1[0].length) {
                        showError("Matrix must be square for inverse calculation!");
                        return;
                    }
                    double[][] inv = MatrixCalculator.inverseMatrix(matrix1);
                    if (inv == null) {
                        showError("Matrix is singular (not invertible)!");
                        return;
                    }
                    updateResultTable(inv);
                    return;
                case "scale":
                    double scalar = Double.parseDouble(scalarField.getText());
                    double[][] scaled = MatrixCalculator.scaleMatrix(matrix1,scalar);
                    updateResultTable(scaled);
                    return;
            }

            if (result != null) {
                updateResultTable(result);
            }
        } catch (Exception ex) {
            showError("Invalid Input! Please enter correct matrix values.");
        }
    }

    private void updateResultTable(int[][] result) {
        int rows = result.length;
        int cols = result[0].length;

        // Create a new table model with the correct size
        resultTable.setModel(new javax.swing.table.DefaultTableModel(rows, cols));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultTable.setValueAt(result[i][j], i, j);
            }
        }

        resultTable.revalidate();
        resultTable.repaint();
        MatrixCalculator.saveMatrixToCSV(result);
    }
    
    // Overloaded method to update the result table for double matrices (used for inverse)
    private void updateResultTable(double[][] result) {
        int rows = result.length;
        int cols = result[0].length;
        resultTable.setModel(new javax.swing.table.DefaultTableModel(rows, cols));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultTable.setValueAt(result[i][j], i, j);
            }
        }
        resultTable.revalidate();
        resultTable.repaint();
        MatrixCalculator.saveMatrixToCSV(result);
    }

    
    private void swapMatrices() {
        if (matrix1Table == null || matrix2Table == null) {
            showError("Matrices are not initialized!");
            return;
        }
        javax.swing.table.TableModel tempModel = matrix1Table.getModel();
        matrix1Table.setModel(matrix2Table.getModel());
        matrix2Table.setModel(tempModel);
        matrix1Table.revalidate();
        matrix2Table.revalidate();
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MatrixCalculatorGUI::new);
    }
}
