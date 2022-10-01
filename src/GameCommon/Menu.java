package GameCommon;
import GameObjects.*;
import OrderAndChaos.OrderAndChaosTurn;
import TicTacToe.TicTacToeTurn;

import java.util.ArrayList;
import Common.*;

public class Menu {
	public static void main(String[] args) {
		GameEngine engine = new GameEngine();
		IOWrapper io = new IOWrapper();
		GameType ttt = GameType.TicTacToe;
		GameType oc = GameType.OrderAndChaos;
		
		IOWrapper.SysOutNL("-----");
		IOWrapper.SysOutNL("Welcome!");
		IOWrapper.SysOutNL("-----");
		try {
			String t1_name=io.GetUserInputTypeString(String.format(Constants.PromptTeamName, "1"));
			int t1_players_count = io.GetUserInputTypeInt(String.format(Constants.PromptTeamSize, "1"));
			while(!Utilities.CompareIntegerRange(t1_players_count,Constants.MaximumTeamSize,Constants.MinimumTeamSize)) {
				Utilities.DisplayInvalidEntry();
				t1_players_count = io.GetUserInputTypeInt(String.format(Constants.PromptTeamSize, "1"));
			}
			
			ArrayList<Player> t1_players = Utilities.PromptPlayersOfTeam(t1_players_count, t1_name);
			
			String t2_name=io.GetUserInputTypeString(String.format(Constants.PromptTeamName, "2"));
			int t2_players_count = io.GetUserInputTypeInt(String.format(Constants.PromptTeamSize, "2"));
			while(!Utilities.CompareIntegerRange(t2_players_count,Constants.MaximumTeamSize,Constants.MinimumTeamSize)) {
				Utilities.DisplayInvalidEntry();
				t2_players_count = io.GetUserInputTypeInt(String.format(Constants.PromptTeamSize, "2"));
			}
			ArrayList<Player> t2_players = Utilities.PromptPlayersOfTeam(t2_players_count, t2_name);
			engine.AddTeam(1, t1_name,null, t1_players); 
			engine.AddTeam(2, t2_name,null, t2_players);
			
			IOWrapper.SysOutNL("-----");
			String GameCycle;
			do {
				int gameType = io.GetUserInputTypeInt(Constants.PromptGameType);
				while(!Utilities.CompareIntegerRange(gameType,oc.getValue(),ttt.getValue())) {
					Utilities.DisplayInvalidEntry();
					gameType = io.GetUserInputTypeInt(Constants.PromptGameType);
				}
				
				if(gameType == ttt.getValue() ) {
					int n = io.GetUserInputTypeInt(Constants.PromptBoardSize);
					while(!Utilities.CompareIntegerRange(n,Constants.MaximumBoardSize,Constants.MinimumBoardSize)) {
						Utilities.DisplayInvalidEntry();
						n = io.GetUserInputTypeInt(Constants.PromptBoardSize);			
					}		
					IOWrapper.SysOutNL("-----");		
					engine.InitBoard(n, 1);
					engine.SetTeamPiece(1, Utilities.IterateList(engine.GetBoard().GetBoardPieces(), 1));
					engine.SetTeamPiece(2, Utilities.IterateList(engine.GetBoard().GetBoardPieces(), 2));

					TicTacToeTurn tttTurn = new TicTacToeTurn();
					tttTurn.PromptTurn(engine.GetTeams(), engine.GetBoard());
					GameUtilities.DisplayTeamSpecificStats(engine.GetTeams());
				} else if(gameType == oc.getValue()) {
					IOWrapper.SysOutNL(t1_name+" plays Order, "+t2_name+" plays Chaos");
					IOWrapper.SysOutNL("-----");
					engine.InitBoard(6, 1);
					engine.SetTeamPiece(1, null);
					engine.SetTeamPiece(2, null);

					
					OrderAndChaosTurn ocTurn = new OrderAndChaosTurn();
					ocTurn.PromptTurn(engine.GetTeams(), engine.GetBoard());		
					GameUtilities.DisplayTeamSpecificStatsforOC(engine.GetTeams());
				}
				
				GameCycle = io.GetUserInputTypeString("Another game, Y or N:");
			} while(!GameCycle.equalsIgnoreCase("N") && GameCycle.equalsIgnoreCase("Y"));
		} catch(Exception e) {
			Utilities.DisplayInvalidEntry();
		}
	}
}
