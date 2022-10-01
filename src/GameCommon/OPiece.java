package GameCommon;
import GameObjects.Piece;

public class OPiece implements Piece {
	private int Key;
	 
	 private String DisplayValue;	
	 
	 public OPiece(int key) {
		 this.Key = key;
		 this.DisplayValue = "O";
	 }
	 
	 public int GetKey()
	 {
		 return this.Key;
	 }
	 
	 public String GetDisplayValue()
	 {
		 return this.DisplayValue;
	 }
}