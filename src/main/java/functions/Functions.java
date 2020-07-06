package functions;

import core.Player;
import core.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Functions {
	
	

	public static double chanceOfWinning(double home, double away){
		double power = ((away-home)/400);
		return 1 / (1+ Math.pow(10, power));
	}
	
	public static double averageRating(List<Player> list){
		double sum = 0;
		for(Player p : list){
			sum += p.getRating();
		}
		return sum/list.size();
	}
	
	public static List<Team> createRandomTeams(List<Player> list){
		ArrayList<Team> teamList = new ArrayList<>();
		ArrayList<Player> copy = new ArrayList<>(list);
		Random rand = new Random();
		
		int indeks = 0;
		while(!copy.isEmpty()){
			if(copy.size() == 1){
				teamList.add(new Team(copy.get(indeks),new Player("Dummy")));
				break;
			}
			
			int rng = rand.nextInt(((copy.size()-1) - (indeks+1)) + 1) + (indeks+1);
			
			teamList.add(new Team(copy.get(indeks),copy.get(rng)));
			
			copy.remove(rng);
			copy.remove(indeks); 
			
		}
		return teamList;
	}
	
	public static double greatestRatingDifferance(List<Team> tl){
		double biggest = 2000;
		double lowest = 2000;
		for(Team t : tl){
			if(t.getRating()>biggest)
				biggest = t.getRating();
			else if(t.getRating() < lowest){
				lowest = t.getRating();
			}
		}
		return biggest - lowest;
	}
	
	public static boolean checkTeam(Player p1, Player p2, List<Team> exceptions){
		for(Team t : exceptions){
			if((t.getP1() == p1 || t.getP1() == p2) && (t.getP2() == p1 || t.getP2() == p1)){
				return true;
			}
		}
		return false;
	}
	
	public static List<Team> forceLowRatingDifferance(double value, List<Player> sl){
		List<Team> tl = new ArrayList<Team>();
		double diff = 2000;
		while(diff>value){
			tl = Functions.createRandomTeams(sl);
			diff = greatestRatingDifferance(tl);
		}
		
		System.out.println("Teams created!\nRating diff : " + Functions.greatestRatingDifferance(tl) + "\n");
		return tl;
	}
	
	public static List<Team> distrubuteBrackets(int brackets, List<Team> tl){
		Collections.sort(tl,(o1,o2) -> o1.getRating() > o2.getRating() ? -1 : 1);
		int bc = 1;
		for(int i = 0; i<tl.size();i++){
			if(bc>brackets) bc = 1;
			tl.get(i).setBracket(bc);
			bc++;
		}
		Collections.sort(tl,(o1,o2) -> o1.getBracket() > o2.getBracket() ? -1 : 1);
		return tl;
	}
	
	public static double calculateMatchesPrBracket(int brackets, List<Team> tl){
		double n = tl.size()/brackets;
		double s = n*(n-1)/2;
		return s;
	}
	
	public static String calculateTime(int brackets, List<Team> tl, int minutesPrMatch){
		double time = (((calculateMatchesPrBracket(brackets, tl))*brackets) + 3)*minutesPrMatch  ;
		double hours = time /60;
		double minutes = time%60;
		
		return "\nTime: " + (int)Math.floor(hours) + ":" + (int)minutes + ":" + "00";
	}
	
	public static void distributeStatsFromTeamPlayer(Player team_player, Player p1, Player p2){
		p1.setWins(p1.getWins() + team_player.getWins());
		p1.setLosses(p1.getLosses() + team_player.getLosses());
		p1.setRating(p1.getRating() + team_player.getRatingChange());
		p1.setRatingChange(team_player.getRatingChange());
		p1.setDraws(p1.getDraws() + team_player.getDraws());
		p1.appendToHistory(team_player.getGameHistory());
		
		p2.setWins(p2.getWins() + team_player.getWins());
		p2.setLosses(p2.getLosses() + team_player.getLosses());
		p2.setRating(p2.getRating() + team_player.getRatingChange());
		p2.setRatingChange(team_player.getRatingChange());
		p2.setDraws(p2.getDraws() + team_player.getDraws());
		p2.appendToHistory(team_player.getGameHistory());
		
	}
	
	
	
	
	
	
}
