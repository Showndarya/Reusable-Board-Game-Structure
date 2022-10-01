package GameObjects;

import Common.IOWrapper;

public class Score {	
	private int Wins;	
	private int Draws;	
	private int Total;
	
	public Score(int wins, int draws, int total) {
		this.Wins = wins;
		this.Draws = draws;
		this.Total = total;
	}
	
	public int GetWins() {
		return this.Wins;
	}
	
	public int GetDraws() {
		return this.Draws;
	}
	
	public void SetPlayerWin() {
		this.Wins++;
	}
	
	public void SetPlayerDraw() {
		this.Draws++;
	}
	
	public void SetPlayerTotal() {
		this.Total++;
	}
	
	public void DisplayScore() {
		IOWrapper.SysOutNL("Total: "+this.Total+";Wins: "+this.Wins+"; Ties: "+this.Draws);
	}
}
