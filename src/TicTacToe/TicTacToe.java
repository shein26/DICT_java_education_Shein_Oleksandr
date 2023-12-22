package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] gameBoard = new char[3][3];

        System.out.print("Enter cells: ");
        String userInput = scanner.nextLine().toUpperCase();

        initializeGameBoard(gameBoard, userInput);
        printGameBoard(gameBoard);
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
}
