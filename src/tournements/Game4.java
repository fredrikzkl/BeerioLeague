package tournements;

import java.util.ArrayList;
import java.util.List;

import core.Player;
import core.Team;
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
		
		Player sixten = new Player("Sixten", 2009.03);
		sl.add(sixten);
		
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
		
		Player bard = new Player("Bård Spein");
		sl.add(bard);
		
		Player snorre = new Player("Snorre",2002.61);
		sl.add(snorre);
		
		Player dyb = new Player("Dyb Arseth",1954.99);
		sl.add(dyb);
		
		Team moonlight = new Team(dyb,jonas);
		tl.add(moonlight);
		
		Team george = new Team(marius,sixten);
		tl.add(george);
		
		Team cuckBrigade = new Team(bard,aksel);
		tl.add(cuckBrigade);
		
		Team faggots = new Team(snorre,persch);
		tl.add(faggots);
		
		Team warriors = new Team(runar,kloster);
		tl.add(warriors);
		Team queerPong = new Team(lydia,brudevoll);
		tl.add(queerPong);
		Team dabAlly = new Team(andreas,nicolas);
		tl.add(dabAlly);
		Team fratBoyz = new Team(vetle,kjetland);
		tl.add(fratBoyz);
	
		//Games
		Event.game(warriors, dabAlly);
		Event.game(moonlight, cuckBrigade);
		
		Event.draw(queerPong, fratBoyz);
		Event.game(george, faggots);
		
		Event.draw(warriors,fratBoyz);
		Event.game(george, moonlight);
		
		Event.draw(queerPong,dabAlly);
		Event.game(george, cuckBrigade);
		
		Event.game(faggots, cuckBrigade);
		Event.game(warriors, queerPong);
		
		Event.game(moonlight, faggots);
		Event.draw(fratBoyz, dabAlly);
		
		//Semis
		Event.game(moonlight, warriors);
		Event.game(fratBoyz, george);
		//Finals
		Event.game(fratBoyz, moonlight);
		
		for(Team t : tl){
			System.out.println(t);
		}
		
		
	  
		
	}

}
