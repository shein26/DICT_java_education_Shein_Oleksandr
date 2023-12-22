import java.util.Scanner;

public class MatrixProcessing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addMatricesOperation(scanner);
                    break;
                case 2:
                    multiplyMatrixByConstantOperation(scanner);
                    break;
                case 3:
                    multiplyMatricesOperation(scanner);
                    break;
                case 4:
                    transposeMatrixOperation(scanner);
                    break;
                case 5:
                    calculateDeterminantOperation(scanner);
                    break;
                case 6:
                    inverseMatrixOperation(scanner);
                    break;
                case 0:
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    public static void addMatricesOperation(Scanner scanner) {
        System.out.println("Enter size of first matrix:");
        int[][] matrixA = readMatrix(scanner);

        System.out.println("Enter size of second matrix:");
        int[][] matrixB = readMatrix(scanner);

        if (!areMatricesAddable(matrixA, matrixB)) {
            System.out.println("The operation cannot be performed. Matrices have different sizes.");
            return;
        }

        int[][] resultMatrix = addMatrices(matrixA, matrixB);
        System.out.println("The result is:");
        printMatrix(resultMatrix);
    }

    public static void multiplyMatrixByConstantOperation(Scanner scanner) {
        System.out.println("Enter size of matrix:");
        int[][] matrix = readMatrix(scanner);

        System.out.println("Enter constant:");
        int constant = scanner.nextInt();

        int[][] resultMatrix = multiplyMatrixByConstant(matrix, constant);
        System.out.println("The result is:");
        printMatrix(resultMatrix);
    }

    public static void multiplyMatricesOperation(Scanner scanner) {
        System.out.println("Enter size of first matrix:");
        int[][] matrixA = readMatrix(scanner);

        System.out.println("Enter size of second matrix:");
        int[][] matrixB = readMatrix(scanner);

        if (!areMatricesMultipliable(matrixA, matrixB)) {
            System.out.println("The operation cannot be performed. Incompatible sizes of matrices.");
            return;
        }

        int[][] resultMatrix = multiplyMatrices(matrixA, matrixB);
        System.out.println("The result is:");
        printMatrix(resultMatrix);
    }

    public static void transposeMatrixOperation(Scanner scanner) {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");

        System.out.print("Your choice: ");
        int transposeType = scanner.nextInt();

        System.out.println("Enter matrix size:");
        int[][] matrix = readMatrix(scanner);

        int[][] transposedMatrix = transposeMatrix(matrix, transposeType);
        System.out.println("The result is:");
        printMatrix(transposedMatrix);
    }

    public static void calculateDeterminantOperation(Scanner scanner) {
        System.out.println("Enter matrix size:");
        int[][] matrix = readMatrix(scanner);

        if (!isSquareMatrix(matrix)) {
            System.out.println("The operation cannot be performed. Not a square matrix.");
            return;
        }

        int determinant = calculateDeterminant(matrix);
        System.out.println("The result is:");
        System.out.println(determinant);
    }

    public static void inverseMatrixOperation(Scanner scanner) {
        System.out.println("Enter matrix size:");
        int[][] matrix = readMatrix(scanner);

        if (!isSquareMatrix(matrix)) {
            System.out.println("The operation cannot be performed. Not a square matrix.");
            return;
        }

        double[][] inverseMatrix = inverseMatrix(matrix);
        if (inverseMatrix == null) {
            System.out.println("This matrix doesn't have an inverse.");
        } else {
            System.out.println("The result is:");
            printMatrix(inverseMatrix);
        }
    }

    public static void printMenu() {
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix by a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate a determinant");
        System.out.println("6. Inverse matrix");
        System.out.println("0. Exit");
    }

    public static int[][] readMatrix(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] resultMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        return resultMatrix;
    }

    public static int[][] multiplyMatrixByConstant(int[][] matrix, int constant) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] resultMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrix[i][j] * constant;
            }
        }

        return resultMatrix;
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;
        int[][] resultMatrix = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return resultMatrix;
    }

    public static int[][] transposeMatrix(int[][] matrix, int transposeType) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] resultMatrix = new int[rows][cols];

        switch (transposeType) {
            case 1: // Main diagonal
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        resultMatrix[i][j] = matrix[j][i];
                    }
                }
                break;
            case 2: // Side diagonal
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        resultMatrix[i][j] = matrix[cols - j - 1][rows - i - 1];
                    }
                }
                break;
            case 3: // Vertical line
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        resultMatrix[i][j] = matrix[i][cols - j - 1];
                    }
                }
                break;
            case 4: // Horizontal line
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        resultMatrix[i][j] = matrix[rows - i - 1][j];
                    }
                }
                break;
            default:
                System.out.println("Invalid transpose type.");
        }

        return resultMatrix;
    }

    public static int calculateDeterminant(int[][] matrix) {
        int size = matrix.length;

        if (size == 1) {
            return matrix[0][0];
        }

        if (size == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int determinant = 0;

        for (int i = 0; i < size; i++) {
            determinant += Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(getMinor(matrix, 0, i));
        }

        return determinant;
    }

    public static int[][] getMinor(int[][] matrix, int row, int col) {
        int size = matrix.length;
        int[][] minor = new int[size - 1][size - 1];

        for (int i = 0, newRow = 0; i < size; i++) {
            if (i == row) {
                continue;
            }

            for (int j = 0, newCol = 0; j < size; j++) {
                if (j == col) {
                    continue;
                }

                minor[newRow][newCol] = matrix[i][j];
                newCol++;
            }

            newRow++;
        }

        return minor;
    }

    public static boolean areMatricesAddable(int[][] matrixA, int[][] matrixB) {
        return matrixA.length == matrixB.length && matrixA[0].length == matrixB[0].length;
    }

    public static boolean areMatricesMultipliable(int[][] matrixA, int[][] matrixB) {
        return matrixA[0].length == matrixB.length;
    }

    public static boolean isSquareMatrix(int[][] matrix) {
        return matrix.length == matrix[0].length;
    }

    public static double[][] inverseMatrix(int[][] matrix) {
        int size = matrix.length;

        if (calculateDeterminant(matrix) == 0) {
            System.out.println("This matrix doesn't have an inverse.");
            return null;
        }

        double[][] inverseMatrix = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int[][] minor = getMinor(matrix, i, j);
                double cofactor = Math.pow(-1, i + j) * calculateDeterminant(minor);
                inverseMatrix[j][i] = cofactor / calculateDeterminant(matrix);
            }
        }

        return inverseMatrix;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
