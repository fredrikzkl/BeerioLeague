package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable, Comparable<Player>{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private double rating;
	
	private int wins;
	private int losses;
	private double winratio;
	
	private List<Game> gameHistory;
	
	private int strikes;
	
	public Player(String name){
		this.name = name;
		rating = 2000;//Standard rating
		wins = 0;
		losses = 0;
		winratio = 0;
		
		this.gameHistory = new ArrayList<Game>();
	}
	
	public String toString(){
		return "" + getName() + " - " + getRating();
	}
	
	public Player(String name, double currentRating){
		this.name = name;
		rating = currentRating;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void addWin(){
		wins++;
		updateWinRatio();
	}
	
	public int getWins() {
		return wins;
	}
	
	public void addLoss(){
		losses++;
		updateWinRatio();
	}
	
	public int getLosses() {
		return losses;
	}
	

	public void updateWinRatio(){
		int totalGames = wins + losses;
		winratio = wins / totalGames;
	}
	
	public double getWinratio() {
		return winratio;
	}
	
	public void addGame(Game game){
		gameHistory.add(game);
	}
	
	public void printGameHistory(){
		for(Game g : gameHistory){
			System.out.println(g);
		}
	}

	public List<Game> getGameHistory() {
		return gameHistory;
	}

	public int getStrikes() {
		return strikes;
	}

	public void addStrike() {
		this.strikes++;
	}
	
	public void removeStrike(){
		this.strikes--;
	}

	@Override
	public int compareTo(Player o) {
		return -(Double.compare(this.getRating(), o.getRating()));
	}
	
	
}
