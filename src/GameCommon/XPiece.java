package GameCommon;
import GameObjects.Piece;

public class XPiece implements Piece {
	private int Key;
	 
	 private String DisplayValue;	
	 
	 public XPiece(int key) {
		 this.Key = key;
		 this.DisplayValue = "X";
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
