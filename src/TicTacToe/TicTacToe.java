package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] gameBoard = createEmptyGameBoard();

        printGameBoard(gameBoard);

        while (true) {
            makeMove(scanner, gameBoard, 'X');
            printGameBoard(gameBoard);

            if (checkGameResult(gameBoard, 'X')) {
                break;
            }

            makeMove(scanner, gameBoard, 'O');
            printGameBoard(gameBoard);

            if (checkGameResult(gameBoard, 'O')) {
                break;
            }
        }
    }

    public static char[][] createEmptyGameBoard() {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        return board;
    }

    public static void printGameBoard(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static void makeMove(Scanner scanner, char[][] board, char symbol) {
        int row, col;

        while (true) {
            System.out.print("Enter the coordinates: ");
            try {
                row = scanner.nextInt();
                col = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine(); // Clear the buffer
                continue;
            }

            if (isValidMove(row, col, board)) {
                board[row - 1][col - 1] = symbol;
                break;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        }
    }

    public static boolean isValidMove(int row, int col, char[][] board) {
        return row >= 1 && row <= 3 && col >= 1 && col <= 3 && board[row - 1][col - 1] == ' ';
    }

    public static boolean checkGameResult(char[][] board, char symbol) {
        if (checkForWinner(board, symbol)) {
            printGameBoard(board);
            System.out.println(symbol + " wins");
            return true;
        } else if (isBoardFull(board)) {
            printGameBoard(board);
            System.out.println("Draw");
            return true;
        }
        return false;
    }

    public static boolean checkForWinner(char[][] board, char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
