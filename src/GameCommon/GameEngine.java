package GameCommon;

import java.util.ArrayList;

import GameObjects.Engine;
import GameObjects.Piece;
import GameObjects.Team;
import GameObjects.Score;

public class GameEngine extends Engine {

	public GameEngine() {
		Teams = new ArrayList<Team>();
		Stats = new Score(0,0,0);
	}
	
	public void InitBoard(int boardSize, int nextPlayer) {
		Board = new GameBoard(boardSize, nextPlayer);
		Board = Board.SetBoardPieces(new OPiece(2));
		Board = Board.SetBoardPieces(new XPiece(1));
	}
	
	public void SetTeamPiece(int id, Piece piece) {
		for(Team team: Teams) {
			if(team.GetId() == id) team.SetPiece(piece);
		}
	}

}
