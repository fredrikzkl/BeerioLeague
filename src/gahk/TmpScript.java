package gahk;

import java.util.ArrayList;
import java.util.List;

import core.Player;
import functions.Excel;
import functions.IOFiles;

public class TmpScript {

	public static void main(String[] args) {
		IOFiles io = new IOFiles("gahkPlayers");
		List<Player> pl = io.getPlayers();
		
		Player tmp = io.getPlayer("Lydia Seba");
		io.writeHistory(tmp,"LydiaHistory");
	}

}
