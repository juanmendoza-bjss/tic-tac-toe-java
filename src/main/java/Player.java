public class Player {
    private String name;
    private boolean playerX;

    public Player() {
        this.playerX = true;
    }

    public Player(String name) {
        this.name = name;
        this.playerX = true;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPlayerX() {
        return this.playerX;
    }

    public void setPlayerX(boolean value) {
        this.playerX = value;
    }
}
