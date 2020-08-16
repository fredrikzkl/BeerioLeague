package tournements;

import core.Game;
import core.Player;
import functions.Excel;
import functions.IOFiles;

import java.util.ArrayList;
import java.util.List;

public class LassisLeague2 {

	public static void main(String[] args) {

		IOFiles io = new IOFiles("lassisLeagueSeason2");

		String tn = "Pussy Palace";

		Excel ex = new Excel(tn);

		List<Player> pl = io.getPlayers();

		Player ida  = new Player("Ida");
		Player sanna = new Player("Sanna");
		pl.add(ida);
		pl.add(sanna);

		Player fredrik = io.getPlayer("Fredrik Kloster");

		io.updatePlayerReferance(fredrik, pl);
		Player eivind = io.getPlayer("Eivind");
		io.updatePlayerReferance(eivind, pl);
		Player martin = io.getPlayer("Martin");
		io.updatePlayerReferance(martin, pl);
		Player simenp = io.getPlayer("Simen Persch");
		io.updatePlayerReferance(simenp, pl);
		Player marius = io.getPlayer("Marius");
		io.updatePlayerReferance(marius, pl);
		Player sixten = io.getPlayer("Sixten");
		io.updatePlayerReferance(sixten, pl);
		Player bjorn = io.getPlayer("Bjørn");
		io.updatePlayerReferance(bjorn, pl);
		Player brudevoll = io.getPlayer("Fredrik Brudevoll");
		io.updatePlayerReferance(brudevoll, pl);

		Player morten = io.getPlayer("Morten");
		io.updatePlayerReferance(morten, pl);
		morten.addStrike();

		io.resetChangeRating(pl);

		/*
			GRUPPE ALPHA
		 */

		new Game(bjorn, 5, sixten, 0, tn, 1);
		new Game(bjorn, 5, sanna, 0, tn, 2);
		new Game(martin, 3, sanna, 0, tn, 3);
		new Game(martin, 2, fredrik, 0, tn, 4);
		new Game(fredrik, 1, bjorn, 0, tn, 5);
		new Game(martin, 1, bjorn, 0, tn, 6);
		new Game(sanna, 1, sixten, 0, tn, 7);
		new Game(fredrik, 4, sanna, 0, tn, 8);
		new Game(fredrik, 1, sixten, 0, tn, 9);
		new Game(sixten, 5, martin, 0, tn, 10);





		/*
			Gruppe Betæ
		 */

		new Game(brudevoll, 2, simenp, 0, tn, 11);
		new Game(eivind, 7, simenp, 0, tn, 12);
		new Game(eivind, 4, ida, 0, tn, 13);
		new Game(brudevoll, 3, ida, 0, tn, 14);
		new Game(brudevoll, 6, marius, 0, tn, 15);
		new Game(eivind, 1, marius, 0, tn, 16);
		new Game(brudevoll, 1, eivind, 0, tn, 17);
		new Game(simenp, 1, ida, 0, tn, 18);
		new Game(marius, 4, ida, 0, tn, 19);
		new Game(marius, 1, simenp, 0, tn, 20);



		/*
			Kvart
		 */

		new Game(sixten, 2, brudevoll, 1, tn, 21, "Kvartfinale");
		new Game(martin, 2, simenp, 0, tn, 22, "Kvartfinale");
		new Game(fredrik, 2, marius, 0, tn, 23,"Kvartfinale");
		new Game(eivind, 2, bjorn, 1, tn, 24, "Kvartfinale");


		new Game(martin, 2, sixten, 0, tn, 25, "Semifinale");
		new Game(eivind, 2, fredrik, 0, tn, 26, "Semifinale");

		new Game(eivind, 2, martin, 0, tn, 27, "Finale");



		//io.printHistoryPlayer(fredrik);


		io.savePlayers(pl);
		ex.WriteToBook(pl);
		io.writeToJson(pl);

		
	}

}
