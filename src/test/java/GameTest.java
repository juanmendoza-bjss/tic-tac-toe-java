import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    @DisplayName("Drawing an empty board")
    public void drawingEmptyBoard() {
        Board emptyBoard = new Board();
        Game.drawingBoard(emptyBoard);
    }

    @Test
    @DisplayName("Drawing a board with 2 cells from top row taken")
    public void drawingTopRowBoard() {
        Board topRowBoard = new Board();
        topRowBoard.setBoard(new String[][]{{"X", " ", "O"}, {" ", " ", " "}, {" ", " ", " "}});
        Game.drawingBoard(topRowBoard);
    }

    @Test
    @DisplayName("Drawing board with 2 cells from top & middle rows taken")
    public void drawingTopAndMiddleRowsBoard() {
        Board topAndMiddleRowsBoard = new Board();
        topAndMiddleRowsBoard.setBoard(new String[][]{{"X", " ", "O"}, {" ", "X", " "}, {" ", " ", "X"}});
        Game.drawingBoard(topAndMiddleRowsBoard);
    }

    @Test
    @DisplayName("Declare a winner with horizontal row")
    public void daclareAWinner() {
        Board board = new Board();
        board.setBoard(new String[][]{{"X", "X", "X"}, {" ", "X", " "}, {" ", " ", " "}});
        boolean winner = Game.isThereAWinner(board);
        Assertions.assertTrue(winner);
    }

    @Test
    @DisplayName("Cats Game")
    public void itsACatsGame() {
        Board board = new Board();
        board.setBoard(new String[][]{{"X", "O", "X"}, {"X", "O", "O"}, {"O", "X", "X"}});
        boolean fullBoard = Game.catsGame(board);
        Assertions.assertTrue(fullBoard);
    }

    @Test
    @DisplayName("Not a Cats Game")
    public void itsNotACatsGame() {
        Board board = new Board();
        board.setBoard(new String[][]{{"X", " ", "X"}, {"X", "O", "O"}, {"O", "X", "X"}});
        boolean fullBoard = Game.catsGame(board);
        Assertions.assertFalse(fullBoard);
    }
}
