package tournements;

import java.util.ArrayList;
import java.util.List;

import core.Game;
import core.Player;
import functions.ExcelConvert;
import functions.IOFiles;

public class IOTest {

	public static void main(String[] args) {
		List<Player> pl = new ArrayList<Player>();
		Player arne = new Player("Arne");
		Player ash = new Player("Ash");
		Player thrall = new Player("Thrall");
		
		pl.add(arne);
		pl.add(ash);
		pl.add(thrall);
	
		
		IOFiles io = new IOFiles();
		io.savePlayers(pl);
		io.printPlayers();
		pl.removeAll(pl);
		
		Player arne2 = io.getPlayer("Arne");
		pl.add(arne2);
		Player ash2 = io.getPlayer("Ash");
		pl.add(ash2);
		
		Player lydia = new Player("Lydia");
		pl.add(lydia);
		
		new Game(arne2,4,ash2,0);
		new Game(arne2,2,ash2,0);
		
		new Game(lydia,3,ash2,0);
		new Game(lydia,2,arne2,0);
		
		io.savePlayers(pl);
		io.printPLayersWithHistory();
		
		ExcelConvert exel = new ExcelConvert("Test2");
		exel.WriteToBook(io.getPlayers());
	}

}
