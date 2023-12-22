package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] gameBoard = new char[3][3];

        System.out.print("Enter cells: ");
        String userInput = scanner.nextLine().toUpperCase();
        initializeGameBoard(gameBoard, userInput);

        while (true) {
            printGameBoard(gameBoard);
            makeMove(scanner, gameBoard);
            analyzeGameState(gameBoard);
        }
    }

    public static void initializeGameBoard(char[][] board, String userInput) {
        int index = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (index < userInput.length()) {
                    char symbol = userInput.charAt(index);
                    if (symbol == 'X' || symbol == 'O' || symbol == '_') {
                        board[i][j] = symbol;
                    } else {
                        // Handle invalid input
                        System.out.println("Invalid input. Please use only 'X', 'O', or '_'.");
                        System.exit(0);
                    }
                    index++;
                }
            }
        }
    }

    public static void printGameBoard(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static void makeMove(Scanner scanner, char[][] board) {
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
                board[row - 1][col - 1] = 'X';
                break;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        }
    }

    public static boolean isValidMove(int row, int col, char[][] board) {
        return row >= 1 && row <= 3 && col >= 1 && col <= 3 && board[row - 1][col - 1] == '_';
    }

    public static void analyzeGameState(char[][] board) {
        boolean xWins = checkForWinner(board, 'X');
        boolean oWins = checkForWinner(board, 'O');
        boolean gameNotFinished = checkGameNotFinished(board);
        boolean isImpossible = isImpossible(board);

        if (xWins && oWins || isImpossible) {
            System.out.println("Impossible");
            System.exit(0);
        } else if (xWins) {
            printGameBoard(board);
            System.out.println("X wins");
            System.exit(0);
        } else if (oWins) {
            printGameBoard(board);
            System.out.println("O wins");
            System.exit(0);
        } else if (!gameNotFinished) {
            printGameBoard(board);
            System.out.println("Draw");
            System.exit(0);
        }
    }

    public static boolean checkForWinner(char[][] board, char symbol) {
        // Check rows, columns, and diagonals for a winner
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    public static boolean checkGameNotFinished(char[][] board) {
        // Check if there are still empty cells on the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isImpossible(char[][] board) {
        int countX = countSymbol(board, 'X');
        int countO = countSymbol(board, 'O');

        int diff = Math.abs(countX - countO);

        if (diff > 1 || (countX > countO && checkForWinner(board, 'O')) ||
                (countO > countX && checkForWinner(board, 'X'))) {
            return true;
        }

        return (countX == countO && (checkForWinner(board, 'X') || checkForWinner(board, 'O')));
    }

    public static int countSymbol(char[][] board, char symbol) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == symbol) {
                    count++;
                }
            }
        }
        return count;
    }
}
