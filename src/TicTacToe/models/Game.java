package TicTacToe.models;

import TicTacToe.Strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> player;
    private List<Move> moves;
    private Player winner;
    private int nextPlayerIdx;
    private List<WinningStrategy> winningStrategies;
    private GameState gameState;


    private Game(Builder builder) {
        board = new Board(builder.boardSize);
        player = builder.players;
        winningStrategies = builder.winningStrategy;
        moves = new ArrayList<Move>();
        gameState = GameState.INPROGRESS;
        nextPlayerIdx = 0;
        winner = null;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    public Board getBoard() {
        return board;
    }
    public List<Player> getPlayer() {
        return player;
    }
    public List<Move> getMoves() {
        return moves;
    }
    public Player getWinner() {
        return winner;
    }
    public int getNextPlayerIdx() {
        return nextPlayerIdx;
    }
    public void setNextPlayerIdx(int nextPlayerIdx) {
        this.nextPlayerIdx = nextPlayerIdx;
    }
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    public void setWinner(Player winner) {
        this.winner = winner;
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
    public GameState getGameState() {
        return gameState;
    }
    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        private int boardSize;
        private List<WinningStrategy> winningStrategy;
        private List<Player> players;

        public Builder setBoardSize(int boardSize){
            this.boardSize = boardSize;
            return this;
        }
        public Builder setWinningStrategy(List<WinningStrategy> winningStrategy){
            this.winningStrategy = winningStrategy;
            return this;
        }
        public Builder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }

        public void validate(){
            if(boardSize <= 0){
                throw new IllegalArgumentException("Board size must be greater than 0");
            }

            int botCounter = 0;
            for(Player player : players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCounter++;
                }
            }
            if(botCounter >1){
                throw new IllegalArgumentException("More than 1 bot is not allowed");
            }

            HashSet<Character> set = new HashSet<>();

            for(Player player : players){
                if(set.contains(player.getSymbol().getSymbol())){
                    throw new IllegalArgumentException("Player " + player.getSymbol().getSymbol() + " is already in use");
                }
                set.add(player.getSymbol().getSymbol());
            }
        }

        public Game build(){
            validate();
            return new Game(this);
        }


    }
}
