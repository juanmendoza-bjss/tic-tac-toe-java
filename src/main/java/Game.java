import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String name;

        Player playerX = new Player();
        Player playerO = new Player();
        Board board = new Board();

        System.out.print("Player X, what's your name?: ");
        name = keyboard.nextLine();
        playerX.setName(name);

        System.out.print("Player O, what's your name?: ");
        name = keyboard.nextLine();
        playerO.setName(name);
        playerO.setPlayerX(false);

        drawingBoard(board);

        boolean winner = isThereAWinner(board);

//        if (winner) {
//            // print out who won the game
//        }
//        else if (catsGame) {
//            // print out msg
//        }
//        else {
//            // make a move
//        }
    }
    public static void drawingBoard(Board board) {
        String[][] b = board.getBoard();

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            if (i < 2) {
                System.out.println();
                System.out.println("---------");
            }
        }
    }

    public static boolean isThereAWinner(Board board) {
        String[][] b = board.getBoard();
        boolean winner = false;

        // check rows and columns
        for (int i = 0; i < b.length; i++) {
            if (checkLine(b[i][0], b[i][1], b[i][2]) || checkLine(b[0][i], b[1][i], b[2][i])) {
                 winner = true;
            }
        }

        // check diagonals
        if (checkLine(b[0][0], b[1][1], b[2][2]) || checkLine(b[2][2], b[1][1], b[0][0])) {
            winner = true;
        }

        return winner;
    }

    public static boolean catsGame(Board board) {
        String[][] b = board.getBoard();
        boolean fullBoard = true;

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if (b[i][j].equals(" ")) {
                    fullBoard = false;
                    break;
                }
            }
            if (!fullBoard) {
                break;
            }
        }

        return fullBoard;
    }

    public static void move(Board board, String cellSelected, Player player, Scanner keyboard) {
        String[][] b = board.getBoard();
        boolean isPlayerXTurn = player.isPlayerX();
        String playerMark = "X";

        int indexOfSpace = cellSelected.indexOf(" ");
        int row = Integer.parseInt(cellSelected.substring(0, indexOfSpace)) - 1;
        int column = Integer.parseInt(cellSelected.substring(2)) - 1;

        if (!isPlayerXTurn) {
            playerMark = "O";
        }

        while (!b[row][column].equals(" ")) {
            System.out.println("Your selection is not valid. Choose another cell: ");
            cellSelected = keyboard.nextLine();
            row = Integer.parseInt(cellSelected.substring(0, indexOfSpace)) - 1;
            column = Integer.parseInt(cellSelected.substring(2)) - 1;
        }

        b[row][column] = playerMark;
        board.setBoard(b);
    }

    private static boolean checkLine(String a, String b, String c) {
        return a.equals(b) && b.equals(c) && !a.equals(" ");
    }
}
