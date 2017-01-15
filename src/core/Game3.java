package core;

import java.util.ArrayList;
import java.util.List;

import functions.Event;

public class Game3 {

	public static void main(String[] args) {
		ArrayList<Player> sl = new ArrayList<Player>();
		List<Team> tl = new ArrayList<Team>();
		
		Player jonas = new Player("Jonas",2076.5);
		Player brudevoll = new Player("Brudevoll",1967.65);
		Team darkside = new Team("Darkside",jonas,brudevoll);
		
		Player fredrik = new Player("Fredrik",2016.08);
		Player lydia = new Player("Lydia",1985.52);
		Team approved = new Team("Approved",fredrik,lydia);
		
		Player simendyb = new Player("Simen Dyb",1998.98);
		Player bineau = new Player("Bineau",1985.52);
		Team twoguys = new Team("Two Guys",simendyb,bineau);
		
		Player lars = new Player("Lars",1996.88);
		Player vetle = new Player("Vetle",2047.39);
		Team gerd = new Team("Gerd",vetle,lars);
		
		Player persch = new Player("Persch",2000.0);
		Player kjetland = new Player("Kjetland",2000);
		Team damatilvetle = new Team("Dama til Vetle",kjetland,persch);
		
		Player grøtting = new Player("Grøtting",1996.88);
		Player sixten = new Player("Sixten",1985.52);
		Team general = new Team("General",grøtting,sixten);
		
		tl.add(darkside);
		tl.add(approved);
		tl.add(twoguys);
		tl.add(gerd);
		tl.add(damatilvetle);
		tl.add(general);
		
		for(Team t : tl){
			System.out.println(t);
		}
		
		//Games
		
		Event.game(darkside, twoguys);
		Event.draw(approved, gerd);
		
		Event.game(gerd, general);
		Event.game(darkside, damatilvetle);
		
		Event.game(general, approved);
		Event.game(twoguys, damatilvetle);
		
		Event.game(damatilvetle, gerd);
		Event.game(approved, darkside);
		
		Event.game(darkside, general);
		Event.game(approved, twoguys);
		
		Event.game(darkside, gerd);
		Event.game(general, twoguys);
		
		Event.game(gerd, twoguys);
		Event.game(general, damatilvetle);

		Event.game(approved, damatilvetle);
		
		//Semi
		Event.game(gerd, darkside);
		Event.game(approved, general);
		
		//Final
		Event.game(approved, gerd);
		
		System.out.println("");
		for(Team t : tl){
			System.out.println(t);
		}
		
		
	}

}
