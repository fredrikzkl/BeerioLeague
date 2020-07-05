package hyttetur;

import java.util.ArrayList;
import java.util.List;

import core.Player;
import core.Team;
import functions.IOFiles;

public class Game1rmk {

	public static void main(String[] args) {
		IOFiles io = new IOFiles("hytteturPlayers");
		List<Player> pl = new ArrayList<>();
		String n = "BeerioLeague Tourney #1";
		
		Player jonas = new Player("Jonas");
		Player vetle = new Player("Vetle");
		Team bowser = new Team("Bowser",jonas,vetle);
		
		Player fredrik = new Player("Fredrik");
		Player morten = new Player("Morten");
		Team ganon = new Team("Ganondorf", fredrik,morten);
		
		Player myhre = new Player("Myhre");
		Player nicholas = new Player("Nicholas");
		Team azeroth = new Team("Azeroth",myhre,nicholas);
		
		Player eivind = new Player("Eivind");
		Player six = new Player("Sixten");
		Team jodene = new Team("Jodene",eivind,six);
		
		Player jo = new Player("Jo*");
		Player tk = new Player("TK*");
		Team ballsdeep = new Team("Ballsdeep", jo,tk);
		
		Player henriksen = new Player("Henriksen");
		
		
		

	}

}
