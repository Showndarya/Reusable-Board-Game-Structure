package GameCommon;

import java.util.ArrayList;

import Common.IOWrapper;
import Common.Tuple;
import GameObjects.Board;
import GameObjects.Cell;
import GameObjects.Move;
import GameObjects.Player;
import GameObjects.Team;
import TicTacToe.TicTacToeMove;

public class GameUtilities {	
	public static Boolean CheckRow(Tuple move, Board b, int pieceId, int minimumMatch) {
		Boolean pieceMatch = false;
		Cell[][] board = b.GetBoard();
		for(int i=0;i<b.GetBoardSize();i++) {
			if(GetBoardMove(new Tuple(move.Key, i), board) != pieceId) {
				pieceMatch = false;
				break;
			}
			else if(minimumMatch == 1) {
				pieceMatch = true;
				break;
			}
			else {
				pieceMatch = true;
				minimumMatch--;
			}
		}
		
		return pieceMatch;
	}
	
	public static Boolean CheckColumn(Tuple move, Board b, int pieceId, int minimumMatch) {
		Boolean pieceMatch = false;
		Cell[][] board = b.GetBoard();
		for(int i=0;i<b.GetBoardSize();i++) {
			if(GetBoardMove(new Tuple(i, move.Value), board) != pieceId) {
				pieceMatch = false;
				break;
			}
			else if(minimumMatch == 1) {
				pieceMatch = true;
				break;
			}
			else {
				pieceMatch = true;
				minimumMatch--;
			}
		}
		
		return pieceMatch;
	}
	
	public static Boolean CheckForwardDiagonal(Tuple move, Board b, int pieceId, int minimumMatch) {
		Boolean pieceMatch = false;
		Cell[][] board = b.GetBoard();
		for(int i=0;i<b.GetBoardSize();i++) {
			if(GetBoardMove(new Tuple(i, i), board) != pieceId) {
				pieceMatch = false;
				break;
			}
			else if(minimumMatch == 1) {
				break;
			}
			else {
				pieceMatch = true;
				minimumMatch--;
			}
		}
		
		return pieceMatch;
	}
	
	public static Boolean CheckReverseDiagonal(Tuple move, Board b, int pieceId, int minimumMatch) {
		Boolean pieceMatch = false;
		Cell[][] board = b.GetBoard();
		for(int i=0;i<b.GetBoardSize();i++) {
			if(GetBoardMove(new Tuple(i, b.GetBoardSize()-1-i), board) != pieceId) {
				pieceMatch = false;
				break;
			}
			else if(minimumMatch == 1) {
				break;
			}
			else {
				pieceMatch = true;
				minimumMatch--;
			}
		}
		
		return pieceMatch;
	}
	
	public Boolean IsValidMove(String input, int boardLength, int boardWidth, Board b) {
		try {
			String[] userInputSplit = input.split(" "); 
			if(userInputSplit.length != 2) {
				return false;
			}
			
			int x_int = Integer.parseInt(userInputSplit[0]);
			int y_int = Integer.parseInt(userInputSplit[1]);
			if ((x_int-1) >= boardWidth || (y_int-1) >= boardLength
					|| (x_int-1) < 0 || (y_int-1) < 0) {
				return false;
			}

			Tuple move = new Tuple((x_int-1), (y_int-1));
			if (b.GetBoardMove(move) != 0) {
				return false;
			}
			
			return true;
		} catch(Exception e) { return false; }
	}
	
	public static Tuple UpdateBoard(String[] userInputSplit, Team currentPlayer, Board b) {
		b.SetFilledBoardPositionsCount();				
		Tuple position = new Tuple((Integer.parseInt(userInputSplit[0])-1), (Integer.parseInt(userInputSplit[1])-1));
		//currentPlayer.AddMove(position);	
		b.SetBoardMove(position,currentPlayer.GetPiece().GetKey());
		b.PrintBoard();
		return position;
	}
	
	public static Boolean DecideGameEnd(Move move, Tuple position, Team currentPlayer, Board b, ArrayList<Team> teams) {
		if(move.IsWinningMove(position, b, currentPlayer.GetPiece().GetKey())) {
			IOWrapper.SysOutNL(currentPlayer.GetName()+" wins");
			currentPlayer.SetWin();
			for(Team team : teams) {
				team.SetTotal();
			}
			return true;
		} else if(b.GetFilledBoardPositionsCount() == (b.GetBoardSize()*b.GetBoardSize())) {
			IOWrapper.SysOutNL("game ended in draw");
			for(Team team : teams) {
				team.SetTie();
				team.SetTotal();
			}
			
			return true;
		}
		
		return false;
	}
	
	public static void DisplayTeamSpecificStats(ArrayList<Team> teams) {
		for(Team team : teams) {
			IOWrapper.SysOut(team.GetName()+": ");
			team.GetStats().DisplayScore();
		}
	}
	
	public static void DisplayTeamSpecificStatsforOC(ArrayList<Team> teams) {
		for(Team team : teams) {
			if(team.GetId() == 1) {				
				IOWrapper.SysOut(team.GetName()+"(Order): ");
				IOWrapper.SysOutNL(Integer.toString(team.GetStats().GetWins()));
			} else {
				IOWrapper.SysOut(team.GetName()+"(Chaos): ");
				IOWrapper.SysOutNL(Integer.toString(team.GetStats().GetDraws()));
			}
		}
	}
	
	public static void DisplayTeamSpecificStatsForOC() {
		
	}
	
	public static int GetBoardMove(Tuple position, Board b) {		
		return GetBoardMove(position, b.GetBoard());
	}
	
	public static int GetBoardMove(Tuple position, Cell[][] boardLayout) {		
		try {
			return boardLayout[position.Key][position.Value].GetValue();
		}
		catch(Exception e) {
			return 0;
		}
	}
}
