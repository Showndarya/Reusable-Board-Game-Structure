package OrderAndChaos;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

import Common.IOWrapper;
import Common.Tuple;
import Common.Utilities;
import GameCommon.GameUtilities;
import GameObjects.Board;
import GameObjects.Move;
import GameObjects.Player;
import GameObjects.Team;
import GameObjects.Turn;
import TicTacToe.TicTacToeMove;

public class OrderAndChaosTurn implements Turn {

	public void PromptTurn(ArrayList<Team> teams, Board b) {
		IOWrapper io = new IOWrapper();
		Random RandomGenerator = new Random();
		String userInput="P";
		ListIterator<Team> iter = teams.listIterator();
		Team currentTeam = Utilities.SetNextPlayer(iter, b);
		b.ResetFilledBoardPositionsCount(); 
		do {
			String userPiece = io.GetUserInputTypeLine(currentTeam.GetName()+", choose X or O:");
			if(!b.IsValidPiece(userPiece)) {
				Utilities.DisplayInvalidEntry();
				continue;
			}
			
			currentTeam.SetPiece(Utilities.IterateList(b.GetBoardPieces(), userPiece));
			int playerIndex = RandomGenerator.nextInt(currentTeam.GetPlayers().size());
			userInput = io.GetUserInputTypeLine(
					currentTeam.GetPlayers().get(playerIndex).GetName()+" of "+currentTeam.GetName()+", your move, enter 'Q' to quit:");  
			OrderAndChaosMove move = new OrderAndChaosMove();
			if(move.IsValidMove(userInput,b)) {			
				Tuple position = UpdateBoard(userInput.split(" "), currentTeam, b);
				if(DecideGameEnd(move,position,currentTeam,b,teams)) {
					break;
				}
				
				if(b.GetNextPlayer() >= b.GetTotalPlayersCount()) iter = teams.listIterator();	
				currentTeam = Utilities.SetNextPlayer(iter, b);		
			} else {
				Utilities.DisplayInvalidEntry();
				continue;
			}
			
		} while (userInput.split(" ")[0].charAt(0) != 'Q');
	}
	
	public Tuple UpdateBoard(String[] userInputSplit, Team currentPlayer, Board b) {
		return GameUtilities.UpdateBoard(userInputSplit, currentPlayer, b);
	}
	
	public Boolean DecideGameEnd(Move move, Tuple position, Team currentPlayer, Board b, ArrayList<Team> teams) {
		return GameUtilities.DecideGameEnd(move, position, currentPlayer, b, teams);
	}
}
