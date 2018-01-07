package tournements;

import java.util.ArrayList;
import java.util.List;

import core.Player;
import functions.Excel;
import functions.IOFiles;

public class TmpScript {

	public static void main(String[] args) {
		IOFiles io = new IOFiles("hytteturPlayers");
		List<Player> pl = io.getPlayers();
		Excel e = new Excel("Autumn Tour");
		
		io.printHistoryPlayer("Miranda");
	
		
	}

}
