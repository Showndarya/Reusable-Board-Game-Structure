package Common;

import java.util.ArrayList;
import java.util.ListIterator;

import GameCommon.Constants;
import GameObjects.Board;
import GameObjects.Piece;
import GameObjects.Player;
import GameObjects.Team;

public class Utilities {
	public static Piece IterateList(ArrayList<Piece> pieces, int key) {
		for(Object item : pieces) {
			Piece piece = (Piece) item;
			if(piece.GetKey() == key)  {
				return piece;
			}
			else continue;
		}
		
		return null;
	}
	
	public static Piece IterateList(ArrayList<Piece> pieces, String key) {
		for(Object item : pieces) {
			Piece piece = (Piece) item;
			
			if(piece.GetDisplayValue().toString().equalsIgnoreCase(key))  {
				return piece;
			}
			else continue;
		}
		
		return null;
	}
	
	public static Team SetNextPlayer(ListIterator<Team> iter, Board b) {
		Team currentTeam = iter.next();
		b.SetNextPlayer(currentTeam.GetId());
		return currentTeam;
	}
	
	public static ArrayList<Player> PromptPlayersOfTeam(int count, String teamName) {
		ArrayList<Player> players = new ArrayList<Player>();
		IOWrapper io = new IOWrapper();
		for(int i=0;i<count;i++) {
			String playerName = io.GetUserInputTypeLine(String.format(Constants.PromptPlayerName, (i+1)));
			Player player = new Player(i);
			player.SetName(playerName);
			players.add(player);
		}
		return players;
	}
	
	public static Boolean CompareIntegerRange(int value, int max, int min) {
		return Math.max(min,value) == Math.min(value, max);
	}
	
	public static void DisplayInvalidEntry() {
		IOWrapper.SysOutNL(Constants.InvalidEntry);
	}
}
