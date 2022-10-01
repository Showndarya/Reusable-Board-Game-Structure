package GameCommon;
import GameObjects.*;
import Common.*;

import java.util.ArrayList;

public class GameBoard extends Board {	
	public GameBoard(int boardSize, int nextPlayer) {
		super(boardSize, nextPlayer, 2);
	}

	public void PrintBoard() {
		for(int i=1;i<=Width;i++) {
			IOWrapper.SysOut("|");
			for(int j=1;j<=Width;j++) {
				Piece tuple = Utilities.IterateList(Pieces, GetBoardMove(new Tuple(i-1,j-1)));
				IOWrapper.SysOut(tuple == null ? " " + "|": tuple.GetDisplayValue() + "|");  
			} 

			IOWrapper.SysOutNL("");
		}
	}	
	
	public void SetBoardMove(Tuple position, int m) {
		BoardLayout[position.Key][position.Value] = new Cell();
		BoardLayout[position.Key][position.Value].SetValue(m);
	}
	
	public int GetBoardMove(Tuple position) {		
		try {
			return GameUtilities.GetBoardMove(position,BoardLayout);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public Boolean IsValidPiece(String key) {
		for(Object item : GetBoardPieces()) {
			Piece piece = (Piece) item;
			if(piece.GetDisplayValue().toString().equalsIgnoreCase(key)) return true;
		}
		
		return false;
	}
	
	public ArrayList<Piece> GetBoardPieces() {
		return Pieces;
	}
	
	public int GetBoardSize() {
		return this.Width;
	}	
}
