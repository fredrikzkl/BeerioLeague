package core;

import java.util.ArrayList;
import java.util.List;

import functions.Functions;

public class Game2 {

	
	public Game2(){
		
		ArrayList<Player> sl = new ArrayList<Player>();
		
		//sl.add(new Player("Eivind",2004.11));
		//OldSchools
		sl.add(new Player("Jonas", 2047.39));
		sl.add(new Player("Vetle",2047.39));
		sl.add(new Player("Sixten",2004.11));
		sl.add(new Player("Nicholas",2000.76));
		sl.add(new Player("Kloster",1986.97));
		sl.add(new Player("Morten",1986.97));
		sl.add(new Player("Lydia",1985.52));
		
		sl.add(new Player("Stian Myhre",2000.76));
		//Nye spelare
		sl.add(new Player("Bård"));
		sl.add(new Player("Andreas"));
		sl.add(new Player("Storla"));
		sl.add(new Player("Brudevoll"));
		sl.add(new Player("Aksel"));
		sl.add(new Player("Marius"));
		sl.add(new Player("Edvard"));
		sl.add(new Player("Lars")); 
		sl.add(new Player("Martin"));
		sl.add(new Player("Jon"));
		sl.add(new Player("Bjørn"));
		
		sl.add(new Player("Snorre*"));
		
		List<Team> tl = Functions.forceLowRatingDifferance(25, sl);
		
		Functions.distrubuteBrackets(2,tl);
		for(Team t : tl) System.out.println(t);
		
		System.out.println("Matches pr bracket: " + Functions.calculateMatchesPrBracket(2, tl));
	}
}
