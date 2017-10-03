package tournements;

import java.util.ArrayList;
import java.util.List;

import core.Player;
import core.Team;
import functions.Event;
import functions.Functions;

public class Game2 {

	
	public Game2(){
		
		ArrayList<Player> sl = new ArrayList<Player>();
		
		Player vetle = new Player("Vetle",2047.39);
		Player lydia = new Player("Lydia",1985.52);
		
		Player bjorn = new Player("Bj�rn");
		Player snorre = new Player("Snorre");
		
		Player marius = new Player("Marius");
		Player simenD = new Player("Simen dyb",1985.52);
		
		Player brudevoll = new Player("Brudevoll");
		Player storla = new Player("Storla");
		
		Player runar = new Player("Runar");
		Player aaras = new Player("Aar�");
		
		Player sondre = new Player("Sondre");
		Player sven = new Player("Sven");
		
		Player fredrik = new Player("Fredrik",1986.97);
		Player jonas = new Player("Jonas",2047.39);
		
		Player nicholas = new Player("Nicholas",2000.76);
		Player morten = new Player("Morten",1986.97);
		
		Player lars = new Player("Lars");
		Player martin = new Player("martin");
		
		Player aksel = new Player("Aksel");
		Player andreas = new Player("Andreas");
		
		List<Team> tl = new ArrayList<Team>();
		
		Team george = new Team("George",vetle,lydia);
		tl.add(george);
		Team kongene = new Team("Kongene",bjorn,snorre);
		tl.add(kongene);
		Team BBC = new Team("BBC", marius,simenD);
		tl.add(BBC);
		Team Beerdong= new Team("Beerdong",brudevoll,storla);
		tl.add(Beerdong);
		Team erdeg = new Team("erdeg",runar,aaras);
		tl.add(erdeg);
		
		Team darthvader = new Team("Darthvader",fredrik,jonas);
		tl.add(darthvader);
		Team ullvene = new Team("Ullvene",nicholas,morten);
		tl.add(ullvene);
		Team cyalater = new Team("cyalater",lars,martin);
		tl.add(cyalater);
		Team AA = new Team("AA",aksel,andreas);
		tl.add(AA);
		Team starblazers = new Team("Starblazers",sven,sondre);
		tl.add(starblazers);
		
		for(Team t : tl){
			System.out.println(t);
		}
		
		//Gruppe 2
		Event.game(Beerdong, george);
		Event.game(BBC, kongene);
		Event.game(BBC, Beerdong);
		Event.game(george, kongene);
		Event.game(BBC, george);
		Event.game(erdeg, Beerdong);
		Event.game(kongene, Beerdong);
		Event.game(george, erdeg);
		Event.game(erdeg, BBC);
		Event.game(kongene, erdeg);
		//Gruppe1
		Event.game(darthvader, AA);
		Event.game(ullvene, starblazers);
		Event.game(cyalater, AA);
		Event.game(ullvene, darthvader);
		Event.game(cyalater, ullvene);
		Event.game(starblazers, darthvader);
		Event.game(darthvader, cyalater);
		Event.game(AA, starblazers);
		Event.game(AA, ullvene);
		Event.game(starblazers, cyalater);
		
		//Semis
		Event.game(AA, BBC);
		Event.game(darthvader, erdeg);
		
		//Finals
		Event.game(darthvader, AA);
		
		System.out.println("-----------");
		
		for(Team t : tl){
			System.out.println(t);
		}
		
		
	}
}
