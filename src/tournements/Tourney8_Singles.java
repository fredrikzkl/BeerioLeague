package tournements;

import java.util.ArrayList;
import java.util.List;

import core.Game;
import core.Player;
import core.Team;
import functions.Excel;
import functions.Functions;
import functions.IOFiles;

public class Tourney8_Singles {

	public static void main(String[] args) {
		IOFiles io = new IOFiles("hytteturPlayers");
		List<Player> pl = io.getPlayers();
		List<Team> tl = new ArrayList<Team>();
		
		String tn = "Autumn Tour - 14oct 2017";
		Excel ex = new Excel(tn);
		
		Player fredrik = io.getPlayer("Fredrik");
		io.updatePlayerReferance(fredrik, pl);
		Player martin = io.getPlayer("Martin Grøtting");
		io.updatePlayerReferance(martin, pl);
		Player morten = io.getPlayer("Morten");
		io.updatePlayerReferance(morten, pl);
		Player bjorn = io.getPlayer("Bjørn");
		io.updatePlayerReferance(bjorn, pl);
		Player ullvar = io.getPlayer("Ullvar");
		io.updatePlayerReferance(ullvar, pl);
		Player runar = io.getPlayer("Runar");
		io.updatePlayerReferance(runar, pl);
		Player eivind = io.getPlayer("Eivind");
		io.updatePlayerReferance(eivind, pl);
		Player lydia = io.getPlayer("Lydia");
		io.updatePlayerReferance(lydia, pl);
		Player nicholas = io.getPlayer("Nicholas");
		io.updatePlayerReferance(nicholas, pl);
		
		Player team_ullnic = new Player("Team: Ullvar/Nicholas",ullvar,nicholas);
		
		Player miranda = new Player("Miranda");
		pl.add(miranda);
		Player kf = new Player("KF");
		pl.add(kf);
		Player anneline = new Player("Ann Eline");
		pl.add(anneline);
		Player jon = new Player("Jon");
		pl.add(jon);
		
		
		//Gruppe 1
		new Game(fredrik,6,kf,0,tn,1);
		new Game(fredrik,7,kf,0,tn,2);
		new Game(miranda,6,kf,0,tn,3);
		new Game(miranda,3,kf,0,tn,4);
		new Game(fredrik,8,miranda,0,tn,5);
		new Game(fredrik,1,miranda,0,tn,6);
		
		//Gruppe 2
		new Game(martin,4,jon,0,tn,7);
		new Game(martin,4,jon,0,tn,8);
		new Game(martin,1,anneline,0,tn,9);
		new Game(martin,1,anneline,0,tn,10);
		new Game(jon,2,anneline,0,tn,11);
		new Game(jon,2,anneline,0,tn,12);
		
		//Gruppe 3
		new Game(morten,3,eivind,0,tn,13);
		new Game(morten,5,eivind,0,tn,14);
		new Game(eivind,6,lydia,0,tn,15);
		new Game(lydia,2,eivind,0,tn,16);
		new Game(morten,2,lydia,0,tn,17);
		new Game(morten,6,lydia,0,tn,17);
		
		//Gruppe 4
		new Game(runar,6,bjorn,0,tn,18);
		new Game(runar,7,bjorn,0,tn,19);
		new Game(team_ullnic,3,runar,0,tn,20);
		new Game(runar,7,team_ullnic,0,tn,21);
		new Game(bjorn,2,team_ullnic,0,tn,22);
		new Game(bjorn,2,team_ullnic,0,tn,23);
		Functions.distributeStatsFromTeamPlayer(team_ullnic, ullvar, nicholas);
		
		//Kvart
		
		new Game(martin,2,bjorn,0,tn,24,"Kvartfinale");
		new Game(runar,2,jon,0,tn,25,"Kvartfinale");
		new Game(fredrik,2,eivind,1,tn,26,"Kvartfinale");
		new Game(morten,2,miranda,0,tn,27,"Kvartfinale");
		
		//Semi
		new Game(morten,2,runar,0,tn,28,"Semifinale");
		new Game(fredrik,2,martin,1,tn,29,"Semifinale");
		
		//Finale
		new Game(fredrik,2,morten,1,tn,30,"Finale");
		
		io.savePlayers(pl);
		ex.WriteToBook(pl);

		
	}

}
