public class Board {
    private String[][] board;
    public Board() {
        this.board = new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public String[][] getBoard() {
        return this.board;
    }
}
