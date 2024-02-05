public class WinningPlayer {
    private boolean isWinner;
    private String winningMark;

    public WinningPlayer() {
        isWinner = false;
    }

    public WinningPlayer(boolean isWinner, String winningMark) {
        this.isWinner = isWinner;
        this.winningMark = winningMark;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinningMark(String winningMark) {
        this.winningMark = winningMark;
    }

    public String getWinningMark() {
        return winningMark;
    }
}
