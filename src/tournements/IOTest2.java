package tournements;

import java.util.ArrayList;
import java.util.List;

import core.Game;
import core.Player;
import functions.Excel;
import functions.IOFiles;

public class IOTest2 {

	public static void main(String[] args) {
		IOFiles io = new IOFiles("gahkPlayers");
		List<Player> playerList = io.getPlayers();
		Excel ex = new Excel("Season Open");
		//io.resetChangeRating(playerList);
		
		Player tmp = io.getPlayer("Lydia Seba");
		io.printHistoryPlayer(tmp);
		
		
		//io.savePlayers(playerList);
		
	}
	
	
	
}


