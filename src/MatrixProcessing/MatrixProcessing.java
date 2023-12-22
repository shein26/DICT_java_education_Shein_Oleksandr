package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addMatricesOperation(scanner);
                    break;
                case 2:
                    multiplyByConstantOperation(scanner);
                    break;
                case 3:
                    multiplyMatricesOperation(scanner);
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);
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

    public static void multiplyByConstantOperation(Scanner scanner) {
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

        int[][] resultMatrix = multiplyMatrices(matrixA, matrixB);
        if (resultMatrix != null) {
            System.out.println("The result is:");
            printMatrix(resultMatrix);
        } else {
            System.out.println("The operation cannot be performed.");
        }
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

    public static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        if (rowsA != rowsB || colsA != colsB) {
            return null;  // Неможливо додати матриці різних розмірів
        }

        int[][] sumMatrix = new int[rowsA][colsA];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        return sumMatrix;
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

        if (colsA != rowsB) {
            return null;  // Кількість стовпців матриці A не дорівнює кількості рядків матриці B
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

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
