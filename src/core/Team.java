package core;

import java.util.Comparator;

public class Team implements Comparator<Team>{
	
	private String name;
	private double rating;
	private double initRating;
	private int bracket;
	
	public int wins, losses, draws;
	
	
	private Player p1, p2;
	
	
	
	public Team(String name){
		this.name = name;
		rating = 2000; // Standard rating
	}
	
	public Team(String name, double startRating){
		this.name = name;
		rating = startRating;
		initRating = startRating;
	}
	
	public Team(String name, Player p1, Player p2){
		this.name = name;
		this.p1 = p1;
		this.p2 = p2;
		rating = initRating = determineTeamRating(p1, p2);
	}
	
	public Team(Player p1, Player p2){
		this.p1 = p1;
		this.p2 = p2;
		rating = initRating = determineTeamRating(p1, p2);
	}
	
	public boolean addPlayers(Player player1, Player player2){
		if(player1 != null)p1 = player1;
		if(player2 != null)p2 = player2;
		return true;
	}
	
	public static double determineTeamRating(Player p1, Player p2) {
		return (p1.getRating()+p2.getRating())/2;
	}
	
	public String toString(){
		String s = "";
		if(name != null) s+= "-" + getName() + "- | ";
		s += "" + p1.getName() + " - " + p2.getName() + " [" + getRating() + "]";
		if(bracket != 0) s += " {" + getBracket() + "}";
		s += "[" + (getRating()-initRating) + "]";
		s += " - W/L/D: " + wins +"/" + losses + "/" + draws;
		return s;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getBracket() {
		return bracket;
	}

	public void setBracket(int bracket) {
		this.bracket = bracket;
	}

	@Override
	public int compare(Team t1, Team t2) {
		return t1.getRating() > t2.getRating() ? 1 : -1;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public void setDraws(int draws) {
		this.draws = draws;
	}

	public int getWins() {
		return wins;
	}

	public int getLosses() {
		return losses;
	}

	public int getDraws() {
		return draws;
	}

	
	
	
}
