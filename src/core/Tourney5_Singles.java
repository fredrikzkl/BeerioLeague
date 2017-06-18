package core;

import java.util.ArrayList;
import java.util.List;

import functions.Event;

public class Tourney5_Singles {
	public static void main(String[] args) {
		ArrayList<Player> sl = new ArrayList<Player>();
		List<Team> tl = new ArrayList<Team>();
		
		Player jonas = new Player("Jonas",2109.81);
		Team jonas_t = new Team(jonas,jonas);
		tl.add(jonas_t);
		
		Player fredrik = new Player("Fredrik",2089.21);
		Team fredrik_t = new Team(fredrik,fredrik);
		tl.add(fredrik_t);
		
		Player lydia = new Player("Lydia",2031.34);
		Team lydia_t = new Team(lydia,lydia);
		tl.add(lydia_t);
		
		Player eivind = new Player("Eivind",2004.34);
		Team eivind_t = new Team(eivind,eivind);
		tl.add(eivind_t);
		
		Player grotting = new Player("Grøtting",2001.81);
		Team grotting_t = new Team(grotting,grotting);
		tl.add(grotting_t);
		
		Player runar = new Player("Runar",1994.92 );
		Team runar_t = new Team(runar,runar);
		tl.add(runar_t);
		
		Player nicholas = new Player("Nicholas",1988.09);
		Team nicholas_t = new Team(nicholas,nicholas);
		tl.add(nicholas_t);
		
		Player morten = new Player("Morten",1986.97);
		Team morten_t = new Team(morten,morten);
		tl.add(morten_t);
		
		Player henriksen = new Player("Henriksen");
		Team henriksen_t = new Team(henriksen,henriksen);
		tl.add(henriksen_t);
		
		Player samy = new Player("Samy");
		Team samy_t = new Team(samy,samy);
		tl.add(samy_t);
		
		
		for(Team t : tl){
			System.out.println(t);
		}
		
		//Games
		//gruppe 1
		Event.game(lydia_t, grotting_t);
		Event.game(henriksen_t, nicholas_t);
		Event.game(jonas_t, lydia_t);
		Event.game(grotting_t, nicholas_t);
		Event.game(jonas_t, henriksen_t);
		Event.game(grotting_t, jonas_t);
		Event.game(nicholas_t, lydia_t);
		Event.game(grotting_t, henriksen_t);
		Event.game(jonas_t, nicholas_t);
		Event.game(henriksen_t, lydia_t);
		
		//Gruppe 2
		Event.game(eivind_t, samy_t);
		Event.game(morten_t, runar_t);
		Event.game(eivind_t, fredrik_t);
		Event.game(morten_t, samy_t);
		Event.game(runar_t, fredrik_t);
		Event.game(eivind_t, morten_t);
		Event.game(fredrik_t, samy_t);
		Event.game(eivind_t, runar_t);
		Event.game(morten_t, fredrik_t);
		Event.game(samy_t, runar_t);
		
		//Semi
		Event.game(jonas_t, morten_t);
		Event.game(grotting_t, eivind_t);
		
		//Final
		Event.game(jonas_t, grotting_t);
		
		
		System.out.println("");
		for(Team t : tl){
			System.out.println(t);
		}
		
		
	}

}
