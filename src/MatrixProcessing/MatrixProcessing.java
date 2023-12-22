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
        System.out.println("0. Exit");
    }

    public static void addMatricesOperation(Scanner scanner) {
        System.out.println("Enter size of first matrix:");
        int[][] matrixA = readMatrix(scanner);

        System.out.println("Enter size of second matrix:");
        int[][] matrixB = readMatrix(scanner);

        int[][] sumMatrix = addMatrices(matrixA, matrixB);
        if (sumMatrix != null) {
            System.out.println("The result is:");
            printMatrix(sumMatrix);
        } else {
            System.out.println("The operation cannot be performed.");
        }
    }

    public static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        if (rowsA != rowsB || colsA != colsB) {
            return null;
        }

        int[][] resultMatrix = new int[rowsA][colsA];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        return resultMatrix;
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

    public static void multiplyMatricesOperation(Scanner scanner) {
        System.out.println("Enter size of first matrix:");
        int[][] matrixA = readMatrix(scanner);

        System.out.println("Enter size of second matrix:");
        int[][] matrixB = readMatrix(scanner);

        int[][] productMatrix = multiplyMatrices(matrixA, matrixB);
        if (productMatrix != null) {
            System.out.println("The result is:");
            printMatrix(productMatrix);
        } else {
            System.out.println("The operation cannot be performed.");
        }
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        if (colsA != rowsB) {
            return null;
        }

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

    public static void transposeMatrixOperation(Scanner scanner) {
        System.out.println("1. Main diagonal\n2. Side diagonal\n3. Vertical line\n4. Horizontal line");
        System.out.print("Your choice: ");
        int transposeType = scanner.nextInt();

        System.out.println("Enter matrix size:");
        int[][] matrix = readMatrix(scanner);

        int[][] transposedMatrix = transposeMatrix(matrix, transposeType);
        if (transposedMatrix != null) {
            System.out.println("The result is:");
            printMatrix(transposedMatrix);
        } else {
            System.out.println("The operation cannot be performed.");
        }
    }

    public static int[][] transposeMatrix(int[][] matrix, int transposeType) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] resultMatrix;

        switch (transposeType) {
            case 1: // Main diagonal
                resultMatrix = new int[cols][rows];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        resultMatrix[j][i] = matrix[i][j];
                    }
                }
                break;
            case 2: // Side diagonal
                resultMatrix = new int[cols][rows];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        resultMatrix[cols - j - 1][rows - i - 1] = matrix[i][j];
                    }
                }
                break;
            case 3: // Vertical line
                resultMatrix = new int[rows][cols];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        resultMatrix[i][cols - j - 1] = matrix[i][j];
                    }
                }
                break;
            case 4: // Horizontal line
                resultMatrix = new int[rows][cols];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        resultMatrix[rows - i - 1][j] = matrix[i][j];
                    }
                }
                break;
            default:
                System.out.println("Invalid transpose type.");
                return null;
        }

        return resultMatrix;
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
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
