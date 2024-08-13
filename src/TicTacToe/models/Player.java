package TicTacToe.models;

public abstract class Player {
    private  int id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    public Player(int id, String name, Symbol symbol,PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Symbol getSymbol() {
        return symbol;
    }
    public PlayerType getPlayerType() {
        return playerType;
    }

}
