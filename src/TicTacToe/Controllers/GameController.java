package TicTacToe.Controllers;

import TicTacToe.Strategies.WinningStrategy;
import TicTacToe.models.Game;
import TicTacToe.models.GameState;
import TicTacToe.models.Player;

import java.util.List;

public class GameController {



    public Game startGame(
             int size,
     List<Player> players,
     List<WinningStrategy> winningStrategies
    ){
        return Game.getBuilder().setBoardSize(size).setPlayers(players)
                .setWinningStrategy(winningStrategies)
                .build();
    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }
    public void makeMove(Game game){

    }
}
