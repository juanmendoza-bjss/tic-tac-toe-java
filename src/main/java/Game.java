import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String name;

        Player playerX = new Player();
        Player playerO = new Player();
        boolean isPlayersXTurn = true;
        Board board = new Board();

        System.out.print("Player X, what's your name?: ");
        name = keyboard.nextLine();
        playerX.setName(name);

        System.out.print("Player O, what's your name?: ");
        name = keyboard.nextLine();
        playerO.setName(name);
        playerO.setPlayerX(false);

        WinningPlayer winningPlayer = new WinningPlayer();
        isThereAWinner(board, winningPlayer);

        while (!winningPlayer.isWinner()) {
            // Initial board
            drawingBoard(board);

            if (catsGame(board)) {
//                System.out.println("The game is a tie!");
                winningPlayer.setWinner(true);
                winningPlayer.setWinningMark("");
                break;
            }
            else {
                if (isPlayersXTurn) {
                    System.out.println("It is player X's turn");
                    System.out.println("Please enter the row THEN the column, each from 1, 2 or 3, separated by a space");
                    String playersInput = keyboard.nextLine();
                    move(board, playersInput, playerX, keyboard);
                    isPlayersXTurn = false;
                }
                else {
                    System.out.println("It is player O's turn");
                    System.out.println("Please enter the row THEN the column, each from 1, 2 or 3, separated by a space");
                    String playersInput = keyboard.nextLine();
                    move(board, playersInput, playerO, keyboard);
                    isPlayersXTurn = true;
                }
            }

            isThereAWinner(board, winningPlayer);
        }

        // Final board
        drawingBoard(board);

        switch (winningPlayer.getWinningMark()) {
            case "O":
                System.out.println(playerO.getName() + " you've won!");
                break;
            case "X":
                System.out.println(playerX.getName() + " you've won!");
                break;
            default:
                System.out.println("The game is a tie!");
                break;
        }

//        if (winningPlayer.getWinningMark().equals("X")) {
//            System.out.println(playerX.getName() + " you've won!");
//        }
//        else {
//            System.out.println(playerO.getName() + " you've won!");
//        }
//        keyboard.close();
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
        System.out.println("\n");
    }

    public static void isThereAWinner(Board board, WinningPlayer winningPlayer) {
        String[][] b = board.getBoard();

        // check rows and columns
        for (int i = 0; i < b.length; i++) {
            if (checkLine(b[i][0], b[i][1], b[i][2])) {
                winningPlayer.setWinner(true);
                winningPlayer.setWinningMark(b[i][0]);
            }

            if (checkLine(b[0][i], b[1][i], b[2][i])) {
                 winningPlayer.setWinner(true);
                 winningPlayer.setWinningMark(b[0][i]);
            }
        }

        // check diagonals
        if (checkLine(b[0][0], b[1][1], b[2][2]) || checkLine(b[2][2], b[1][1], b[0][0])) {
            winningPlayer.setWinner(true);
            winningPlayer.setWinningMark(b[0][0]);
        }

//        return winningMark;
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
        boolean isPlayerXsTurn = player.isPlayerX();
        String playersMark;

        int indexOfSpace = cellSelected.indexOf(" ");
        int row = Integer.parseInt(cellSelected.substring(0, indexOfSpace)) - 1;
        int column = Integer.parseInt(cellSelected.substring(2)) - 1;

        if (isPlayerXsTurn) {
            playersMark = "X";
        }
        else {
            playersMark = "O";
        }

        while (!b[row][column].equals(" ")) {
            System.out.println("Your selection is not valid. Choose another cell: ");
            cellSelected = keyboard.nextLine();
            row = Integer.parseInt(cellSelected.substring(0, indexOfSpace)) - 1;
            column = Integer.parseInt(cellSelected.substring(2)) - 1;
        }

        b[row][column] = playersMark;
        board.setBoard(b);
    }

    private static boolean checkLine(String a, String b, String c) {
        return a.equals(b) && b.equals(c) && !a.equals(" ");
    }
}
