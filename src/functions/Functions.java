package functions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import core.Player;
import core.Team;

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
	
	
	
}
