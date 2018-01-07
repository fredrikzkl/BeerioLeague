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
	private int draws;
	private double winratio;
	private double ratingChange;
	
	private List<Game> gameHistory;
	
	private int strikes;
	
	public Player(String name){
		this.name = name;
		rating = 2000;//Standard rating
		wins = 0;
		losses = 0;
		winratio = 0;
		ratingChange = 0;
		
		this.gameHistory = new ArrayList<Game>();
	}

	
	
	
	public String toString(){
		return "" + getName() + " - " + getRating();
	}
	
	public Player(String name, double currentRating){
		this.name = name;
		rating = currentRating;
	}
	
	public Player(String name, Player p1, Player p2){
		this(name);
		this.rating = (p1.getRating()+p2.getRating())/2; //Average
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
		double totalGames = wins + losses;
		winratio = wins / totalGames;
	}
	
	public double getWinratio() {
		double totalGames = wins + losses;
		return wins / totalGames;
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

	public double getRatingChange() {
		return ratingChange;
	}

	public void setRatingChange(double ratingChange) {
		this.ratingChange = ratingChange;
	}

	@Override
	public int compareTo(Player o) {
		return -(Double.compare(this.getRating(), o.getRating()));
	}
	
	public double getAverageCupsPrgame(){
		double totalGames = (wins + losses);
		double cups = 0;
		
		for(Game g : gameHistory){
			double remainingCup = (int) (g.getWinner().getName().equals(this.getName()) ? g.getLooserCups() : g.getWinnerCups());
			cups += 10-remainingCup;
		}
		return cups/totalGames;
	}
	
	public Player getArchEnemy(){
		List<Object> l = new ArrayList<>();
		for(Game g: gameHistory){
			if(g.getLooser().getName().equals(this.getName())){
				if(l.contains(g.getWinner())){
					int i = l.indexOf(g.getWinner()) + 1;
					int t = (int) l.get(i);
					l.set(i, t+1);
				}else{
					l.add(g.getWinner());
					l.add(1);
				}
			}
		}
		int indexOfHighest = 0;
		int highest = 0;
		if(l.size() > 0){
			for(int i = 1; i < l.size(); i+=2){
				if((int)l.get(i) > highest){
					highest = (int)l.get(i);
					indexOfHighest = i;
				}
			}
		}else{
			return new Player("Undefeated");
		}
		
		return (Player)l.get(indexOfHighest-1);
	}
	
	public Player getBitch(){
		List<Object> l = new ArrayList<>();
		for(Game g: gameHistory){
			if(g.getWinner().getName().equals(this.getName())){
				if(l.contains(g.getLooser())){
					int i = l.indexOf(g.getLooser()) + 1;
					int t = (int) l.get(i);
					l.set(i, t+1);
				}else{
					l.add(g.getLooser());
					l.add(1);
				}
			}
		}
		int indexOfHighest = 0;
		int highest = 0;
		if(l.size() > 0){
			for(int i = 1; i < l.size(); i+=2){
				if((int)l.get(i) > highest){
					highest = (int)l.get(i);
					indexOfHighest = i;
				}
			}
		}else{
			return new Player("TBA");
		}
		
		return (Player)l.get(indexOfHighest-1);
	}
	
	public int getLongestWinStreak(){
		int longestStreak = 0;
		int tempStreak = 0;
		for(Game h : gameHistory){
			if(h.getWinner().getName().equals(this.name)){
				tempStreak++;
			}else{
				if(tempStreak > longestStreak) longestStreak = tempStreak;
				tempStreak = 0;
			}
		}
		if(tempStreak > longestStreak) longestStreak = tempStreak;
		return longestStreak;
	}



	public void setName(String name) {
		this.name = name;
	}


	public void setWins(int wins) {
		this.wins = wins;
	}


	public void setLosses(int losses) {
		this.losses = losses;
	}




	public int getDraws() {
		return draws;
	}


	public void setDraws(int draws) {
		this.draws = draws;
	}
	
	public void addepndToHistory(List<Game> a){
		gameHistory.addAll(a);
	}
	
	
}
