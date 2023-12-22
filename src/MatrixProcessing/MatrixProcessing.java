package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Виберемо етап роботи програми
        System.out.println("Choose stage: 1 for matrix addition, 2 for multiplying by constant");
        int stage = scanner.nextInt();

        if (stage == 1) {
            // Етап 1: Додавання матриць

            // Зчитуємо матрицю A
            System.out.println("Enter matrix A:");
            int[][] matrixA = readMatrix(scanner);

            // Зчитуємо матрицю B
            System.out.println("Enter matrix B:");
            int[][] matrixB = readMatrix(scanner);

            // Виводимо суму матриць, якщо можливо
            int[][] sumMatrix = addMatrices(matrixA, matrixB);
            if (sumMatrix != null) {
                System.out.println("Sum of matrices:");
                printMatrix(sumMatrix);
            } else {
                System.out.println("ERROR: Matrices have different dimensions.");
            }
        } else if (stage == 2) {
            // Етап 2: Множення матриці на константу

            // Зчитуємо матрицю
            System.out.println("Enter the matrix:");
            int[][] matrix = readMatrix(scanner);

            // Зчитуємо константу
            System.out.println("Enter the constant:");
            int constant = scanner.nextInt();

            // Множимо матрицю на константу та виводимо результат
            int[][] resultMatrix = multiplyMatrixByConstant(matrix, constant);
            System.out.println("Result of multiplying by constant:");
            printMatrix(resultMatrix);
        } else {
            System.out.println("Invalid stage. Please choose 1 or 2.");
        }
    }

    public static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        // Перевіряємо, чи можна додавати матриці
        if (rowsA != rowsB || colsA != colsB) {
            return null;  // Матриці мають різні розміри
        }

        int[][] resultMatrix = new int[rowsA][colsA];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
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

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
