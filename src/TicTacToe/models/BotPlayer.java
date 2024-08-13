package TicTacToe.models;

public class BotPlayer  extends Player {
    private DifficultyLevel difficultyLevel;

    public BotPlayer(int id, String name, Symbol symbol, PlayerType playerType,DifficultyLevel difficultyLevel) {
        super(id, name, symbol, playerType);
        this.difficultyLevel = difficultyLevel;
    }
}
