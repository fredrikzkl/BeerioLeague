package gahk;

import java.util.ArrayList;
import java.util.List;

import core.Game;
import core.Player;
import functions.Excel;
import functions.IOFiles;

public class gahk1 {

	public static void main(String[] args) {
		IOFiles io = new IOFiles("gahkPlayers");
		List<Player> pl = new ArrayList<Player>();
		String tm = "Season Open";
		Excel ex = new Excel(tm);
		
		//Gruppe 1
		Player fredrik = new Player("Fredrik Kloster");
		pl.add(fredrik);
		Player kristoffer = new Player("Kristoffer Glahn");
		pl.add(kristoffer);
		Player karin = new Player("Karin Lindberg");
		pl.add(karin);
		Player soren = new Player("Søren Kaarsholm");
		pl.add(soren);
		Player anna = new Player("Anna Rasmussen");
		pl.add(anna);
		
		karin.addStrike();
		soren.addStrike();
		
		//Gruppe 2
		Player mike = new Player("Michael Ojiaku");
		pl.add(mike);
		Player lydia = new Player("Lydia Seba");
		pl.add(lydia);
		Player jacob = new Player("Jakob Ravnskjær");
		pl.add(jacob);
		Player shewit = new Player("Shewit");
		pl.add(shewit);
		Player troels = new Player("Troels Sindballe");
		pl.add(troels);
		
		//Gruppe1 Games
		new Game(kristoffer,1,karin,0,tm,1); // KARIN KRISTOFFEr
		new Game(kristoffer,2,karin,0,tm,2);
		
		new Game(soren,3,anna,0,tm,3); //SØREN ANNA
		new Game(soren,3,anna,0,tm,4);
		
		new Game(fredrik,8,kristoffer,0,tm,5); //Fredrik Kristoffer
		new Game(kristoffer,1,fredrik,0,tm,6);

		new Game(fredrik,2,karin,0,tm,7); //Fredrik Karin
		new Game(fredrik,8,karin,0,tm,8);
		
		new Game(fredrik,3,soren,0,tm,9); //Fredrik Søren
		new Game(fredrik,9,soren,0,tm,10);

		new Game(fredrik,8,anna,0,tm,11); // FREDRIK ANNA
		new Game(fredrik,9,anna,0,tm,12);
		
		new Game(anna,1,kristoffer,0,tm,13); //Kristoffer anna
		new Game(kristoffer,1,anna,0,tm,14);
		
		new Game(kristoffer,3,soren,0,tm,15,"Walkover"); // Kristoffer Søren
		new Game(kristoffer,3,soren,0,tm,16,"Walkover");
		
		new Game(anna,3,karin,0,tm,17,"Walkover"); //Karin Anna
		new Game(anna,3,karin,0,tm,18,"Walkover");
		
		new Game(soren,3,karin,0,tm,19,"Walkover"); // SØREN KARIN
		new Game(karin,3,soren,0,tm,20,"Walkover");
		
		//Gruppe 2 Games
		new Game(mike,2,troels,0,tm,21); //MIKE TROELS
		new Game(troels,6,mike,0,tm,22);
		
		new Game(jacob,1,shewit,0,tm,23); //Jacob Shewit
		new Game(jacob,5,shewit,0,tm,24);
		
		new Game(mike,5,lydia,0,tm,25); // Mike Lydia
		new Game(mike,4,lydia,0,tm,26);
		
		new Game(troels,1,lydia,0,tm,27); //TROELS LYDIA
		new Game(troels,1,lydia,0,tm,28);
		
		new Game(mike,9,jacob,0,tm,29); //Jacob mike
		new Game(mike,4,jacob,0,tm,30);
		
		new Game(jacob,5,lydia,0,tm,31); //Lydia Jacob
		new Game(jacob,7,lydia,0,tm,32);
		
		new Game(shewit,1,lydia,0,tm,33); //Shewit Lydia
		new Game(lydia,2,shewit,0,tm,34);
		
		new Game(mike,3,shewit,0,tm,35); //MIke Shewit
		new Game(mike,1,shewit,0,tm,36);
		
		new Game(troels,5,shewit,0,tm,37); //Troels Shewit
		new Game(shewit,4,troels,0,tm,38);
		
		new Game(troels,1,jacob,0,tm,39); // Troels Jacob
		new Game(troels,1,jacob,0,tm,40);
		
		//Semi
		new Game(mike,2,kristoffer,0,tm,41);
		new Game(fredrik,2,troels,0,tm,42);
		
		//Finals
		new Game(fredrik,2,mike,0,tm,42);
		
		io.savePlayers(pl);
		ex.WriteToBook(pl);
	}

}
