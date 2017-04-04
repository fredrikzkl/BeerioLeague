package core;

import java.util.ArrayList;
import java.util.List;

import functions.Event;
import functions.Functions;

public class Game4 {

	public static void main(String[] args) {
		ArrayList<Player> sl = new ArrayList<Player>();
		List<Team> tl = new ArrayList<Team>();
		
		
		Player jonas = new Player("Jonas",2097.27);
		sl.add(jonas);
		
		Player kloster = new Player("Kloster",2078.71);
		sl.add(kloster);
		
		Player lydia = new Player("Lydia",2048.14);
		sl.add(lydia);
		
		Player vetle = new Player("Vetle",2044.23);
		sl.add(vetle);
		
		Player marius = new Player("Marius",2013.41);
		sl.add(marius);
		
		Player aksel = new Player("Aksel",2005.36);
		sl.add(aksel);
		
		Player andreas = new Player("Andreas", 2005.36);
		sl.add(andreas);
		
		Player grotting = new Player("Grøtting", 2001.81);
		sl.add(grotting);
		
		Player nicolas = new Player ("Nicholas",2000.76);
		sl.add(nicolas);
		
		Player brudevoll = new Player("Brudevoll",1988.42);
		sl.add(brudevoll);
		
		Player runar = new Player("Ola Runar",1984.42);
		sl.add(runar);
		
		Player kjetland = new Player("Kjetland",1959.56);
		sl.add(kjetland);
		
		Player persch = new Player("Persch",2000.0);
		sl.add(persch);
		
		
		tl = Functions.forceLowRatingDifferance(50, sl); //40
		tl = Functions.distrubuteBrackets(2, tl);
		
		for(Team t : tl){
			System.out.println(t);
		}
		
		System.out.println(Functions.calculateTime(2, tl, 10));
		
		//Games
		
	}

}
