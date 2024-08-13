import TicTacToe.Controllers.GameController;
import TicTacToe.Strategies.RowWinningStrategy;
import TicTacToe.Strategies.WinningStrategy;
import TicTacToe.models.*;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        GameController gc = new GameController();

        List<Player> players = new ArrayList<Player>();
        players.add(new HumanPlayer(1,"Pavan",new Symbol('p',"red"), PlayerType.HUMAN));
        players.add(new BotPlayer(1,"Harsi",new Symbol('h',"red"), PlayerType.HUMAN,DifficultyLevel.MEDIUM));

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
       Game game = gc.startGame(3,players,winningStrategies);

        while(gc.checkState(game).equals(GameState.INPROGRESS)){
            gc.makeMove(game);
        }

        if(gc.checkState(game).equals(GameState.SUCCESS)){
            System.out.println(gc.getWinner(game).getName() + " won the game");
        }else if(gc.checkState(game).equals(GameState.DRAW)){
            System.out.println("Game results in a draw");
        }
    }
}