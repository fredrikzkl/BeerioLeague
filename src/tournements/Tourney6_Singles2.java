package tournements;

import java.util.ArrayList;
import java.util.List;

import core.Player;
import core.Team;
import functions.Event;
import functions.IOFiles;

public class Tourney6_Singles2 {
	public static void main(String[] args) {
		List<Player> pl = new ArrayList<Player>();
		List<Team> tl = new ArrayList<Team>();
		
		Player jonas = new Player("Jonas",2146.38);
		Player nicholas = new Player("Nicholas",1966.67);
		Team jonas_t = new Team(jonas,nicholas);
		tl.add(jonas_t);
		
		
		
		Player grotting = new Player("Gr�tting",2044.16);
		Player simenP = new Player("Simen P",1985);
		Team grotting_t = new Team(grotting,simenP);
		tl.add(grotting_t);
		
		
		
		Player fredrik = new Player("Fredrik",2043.62);
		Team fredrik_t = new Team(fredrik,fredrik);
		tl.add(fredrik_t);
		
		Player lydia = new Player("Lydia",1996.34);
		Team lydia_t = new Team(lydia,lydia);
		tl.add(lydia_t);
		
		Player eivind = new Player("Eivind",2050.47);
		Team eivind_t = new Team(eivind,eivind);
		tl.add(eivind_t);
		
		Player runar = new Player("Runar",1967.91);
		Team runar_t = new Team(runar,runar);
		tl.add(runar_t);
		
		Player vetle = new Player("Vetle",2082.26);
		Team vetle_t = new Team(vetle,vetle);
		tl.add(vetle_t);
		
		Player marius = new Player("Marius",2040.65);
		Team marius_t = new Team(marius,marius);
		tl.add(marius_t );
		
		Player andreas = new Player("Andreas",1992.69);
		Team andreas_t = new Team(andreas,andreas);
		tl.add(andreas_t);
		
		Player henrik = new Player("Henrik",1997.59);
		Team henrik_t = new Team(henrik,henrik);
		tl.add(henrik_t);
		
		Player simendyb = new Player("simendyb",1967.53);
		Team simendyb_t = new Team(simendyb,simendyb);
		tl.add(simendyb_t);
		
		Player aksel = new Player("aksel",1967.53);
		Team aksel_t = new Team(aksel,aksel);
		tl.add(aksel_t);
		
		
		
		for(Team t : tl){
			System.out.println(t);
		}
		
		//Games
		//Gruppe1
		Event.game(marius_t, vetle_t);
		Event.game(vetle_t, marius_t);
		Event.game(marius_t, andreas_t);
		Event.game(andreas_t, vetle_t);
		Event.game(andreas_t, marius_t);
		Event.game(andreas_t, vetle_t);
		
		//Gruppe2
		Event.game(eivind_t, henrik_t);
		Event.game(runar_t, eivind_t);
		Event.game(henrik_t, runar_t);
		Event.game(henrik_t, eivind_t);
		Event.game(runar_t, eivind_t);
		Event.game(runar_t, henrik_t);
		
		//Gruppe 3
		Event.game(simendyb_t, lydia_t);
		Event.game(simendyb_t, lydia_t);
		Event.game(fredrik_t,lydia_t);
		Event.game(fredrik_t, simendyb_t);
		Event.game(fredrik_t, simendyb_t);
		Event.game(fredrik_t, lydia_t);
		
		//Gruppe4
		Event.game(jonas_t, grotting_t);
		Event.game(aksel_t, jonas_t);
		Event.game(aksel_t, grotting_t);
		Event.game(jonas_t, grotting_t);
		Event.game(aksel_t, jonas_t);
		Event.game(grotting_t, aksel_t);
		
		//Kvart
		Event.game(marius_t, runar_t);
		Event.game(andreas_t, henrik_t);
		Event.game(fredrik_t, jonas_t);
		Event.game(simendyb_t, aksel_t);
		
		//Semi
		Event.game(marius_t, fredrik_t);
		Event.game(simendyb_t, andreas_t);
		
		//Finals
		Event.game(marius_t, simendyb_t);
		
		
		
		
		System.out.println("");
		for(Team t : tl){
			System.out.println(t);
		}
	
		
	}

}
