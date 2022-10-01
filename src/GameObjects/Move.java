package GameObjects;
import Common.*;

public interface Move {	
	public Boolean IsValidMove(String move, int boardLength, int boardWidth, Board b);	
	public Boolean IsValidMove(String move, Board b);	
	public Boolean IsWinningMove(Tuple move, Board b, int pieceId);		
}