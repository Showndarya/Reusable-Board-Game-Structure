package GameObjects;

import java.util.ArrayList;

public abstract class Engine {
	protected Board Board;
	
	protected ArrayList<Team> Teams;
	
	protected Score Stats;
	
	public Board GetBoard() {
		return this.Board;
	}
	
	public void AddTeam(int id, String name, Piece piece, ArrayList<Player> players) {
		Team team = new Team(id);
		team.SetName(name);
		team.SetPiece(piece);
		team.AddPlayerRange(players);
		this.Teams.add(team);	
	}
	
	public ArrayList<Team> GetTeams() {
		return this.Teams;
	}
}
