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

    public static void printMenu() {
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix by a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate a determinant");
        System.out.println("0. Exit");
    }

    public static void addMatricesOperation(Scanner scanner) {
        System.out.println("Enter size of the first matrix:");
        int[][] matrixA = readMatrix(scanner);
        System.out.println("Enter size of the second matrix:");
        int[][] matrixB = readMatrix(scanner);

        if (!areMatricesCompatibleForAddition(matrixA, matrixB)) {
            System.out.println("The operation cannot be performed. Matrices have different sizes.");
            return;
        }

        int[][] resultMatrix = addMatrices(matrixA, matrixB);
        printMatrix(resultMatrix);
    }

    public static boolean areMatricesCompatibleForAddition(int[][] matrixA, int[][] matrixB) {
        return matrixA.length == matrixB.length && matrixA[0].length == matrixB[0].length;
    }

    public static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        return result;
    }

    public static void multiplyMatrixByConstantOperation(Scanner scanner) {
        System.out.println("Enter size of the matrix:");
        int[][] matrix = readMatrix(scanner);
        System.out.println("Enter constant:");
        int constant = scanner.nextInt();

        int[][] resultMatrix = multiplyMatrixByConstant(matrix, constant);
        printMatrix(resultMatrix);
    }

    public static int[][] multiplyMatrixByConstant(int[][] matrix, int constant) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * constant;
            }
        }

        return result;
    }

    public static void multiplyMatricesOperation(Scanner scanner) {
        System.out.println("Enter size of the first matrix:");
        int[][] matrixA = readMatrix(scanner);
        System.out.println("Enter size of the second matrix:");
        int[][] matrixB = readMatrix(scanner);

        if (!areMatricesCompatibleForMultiplication(matrixA, matrixB)) {
            System.out.println("The operation cannot be performed. Incompatible matrices.");
            return;
        }

        int[][] resultMatrix = multiplyMatrices(matrixA, matrixB);
        printMatrix(resultMatrix);
    }

    public static boolean areMatricesCompatibleForMultiplication(int[][] matrixA, int[][] matrixB) {
        return matrixA[0].length == matrixB.length;
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;
    }

    public static void transposeMatrixOperation(Scanner scanner) {
        System.out.println("1. Main diagonal\n2. Side diagonal\n3. Vertical line\n4. Horizontal line");
        System.out.print("Your choice: ");
        int transposeChoice = scanner.nextInt();

        System.out.println("Enter matrix size:");
        int[][] matrix = readMatrix(scanner);

        int[][] resultMatrix = transposeMatrix(matrix, transposeChoice);
        printMatrix(resultMatrix);
    }

    public static int[][] transposeMatrix(int[][] matrix, int transposeChoice) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        switch (transposeChoice) {
            case 1: // Main diagonal
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        result[i][j] = matrix[j][i];
                    }
                }
                break;
            case 2: // Side diagonal
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        result[i][j] = matrix[cols - 1 - j][rows - 1 - i];
                    }
                }
                break;
            case 3: // Vertical line
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        result[i][j] = matrix[i][cols - 1 - j];
                    }
                }
                break;
            case 4: // Horizontal line
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        result[i][j] = matrix[rows - 1 - i][j];
                    }
                }
                break;
            default:
                System.out.println("Invalid choice. Using main diagonal transpose.");
                return transposeMatrix(matrix, 1); // Default to main diagonal transpose
        }

        return result;
    }

    public static void calculateDeterminantOperation(Scanner scanner) {
        System.out.println("Enter matrix size:");
        int[][] matrix = readMatrix(scanner);

        if (!isSquareMatrix(matrix)) {
            System.out.println("The operation cannot be performed. Not a square matrix.");
            return;
        }

        int determinant = calculateDeterminant(matrix);
        System.out.println("The result is: " + determinant);
    }

    public static boolean isSquareMatrix(int[][] matrix) {
        return matrix.length == matrix[0].length;
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
            determinant += Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(getSubMatrix(matrix, i));
        }

        return determinant;
    }

    public static int[][] getSubMatrix(int[][] matrix, int excludingCol) {
        int size = matrix.length;
        int[][] subMatrix = new int[size - 1][size - 1];

        for (int i = 1; i < size; i++) {
            int jNew = 0;
            for (int j = 0; j < size; j++) {
                if (j == excludingCol) {
                    continue;
                }
                subMatrix[i - 1][jNew++] = matrix[i][j];
            }
        }

        return subMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static int[][] readMatrix(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }
}
