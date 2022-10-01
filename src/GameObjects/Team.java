package GameObjects;
import java.util.ArrayList;

public class Team {	
	private int Id;		
	private Piece Piece;
	private String Name;
	protected ArrayList<Player> Players;
	protected Score Stats;
	
	public Team(int id) {
		this.Id = id;
		this.Stats = new Score(0,0,0);
		this.Players = new ArrayList<Player>();
	}
	
	public int GetId() {
		return this.Id;
	}
	
	public Piece GetPiece() {
		return this.Piece;
	}
	
	public Score GetStats() {
		return this.Stats;
	}
	
	public String GetName() {
		return this.Name;
	}
	
	public ArrayList<Player> GetPlayers() {
		return this.Players;
	}
	
	public void SetWin() {
		this.Stats.SetPlayerWin();
	}

	public void SetTie() {
		this.Stats.SetPlayerDraw();
	}

	public void SetTotal() {
		this.Stats.SetPlayerTotal();
	}
	
	public void SetPiece(Piece piece) {
		this.Piece = piece;
	}
	
	public void SetName(String name) {
		this.Name = name;
	}
	
	public void AddPlayer(Player player) {
		this.Players.add(player);
	}
	
	public void AddPlayerRange(ArrayList<Player> players) {
		this.Players.addAll(players);
	}
}
