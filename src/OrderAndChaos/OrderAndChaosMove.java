package OrderAndChaos;
import Common.Tuple;
import GameCommon.GameUtilities;
import GameObjects.*;

public class OrderAndChaosMove extends GameUtilities implements Move {
	public Boolean IsValidMove(String input, int boardLength, int boardWidth, Board b) {
		return super.IsValidMove(input,boardLength,boardWidth,b);
	}

	public Boolean IsValidMove(String input, Board b) {
		return IsValidMove(input, b.GetBoardSize(), b.GetBoardSize(), b);
	}	

	public Boolean IsWinningMove(Tuple move, Board b, int pieceId) {
		if(CheckRow(move,b,pieceId,5)) return true;
		else if(CheckColumn(move,b,pieceId,5)) return true;
		else if(CheckForwardDiagonal(move,b,pieceId,5)) return true;
		else if(CheckReverseDiagonal(move,b,pieceId,5)) return true;
		else return false;
	}
}
