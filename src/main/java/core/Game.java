package core;

import functions.Event;
import utils.Match;

import java.io.Serializable;

public class Game implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1097042844383846336L;
	
	private Player winner;
	private Player looser;
	
	
	private GameStats stats; 
	
	private int winnerCups;
	private int looserCups;
	
	private double winnerRating,looserRating;
	
	private String tourneyName;
	private int gameNr;
	
	private String comment;
	
	public Game(Player winner, int cupsWinner, Player looser, int cupsLooser, String tourneyName, int gameNumber){
		this.winner = winner;
		this.looser = looser;
		
		this.winnerCups = cupsWinner;
		this.looserCups = cupsLooser;
		
		this.tourneyName = tourneyName;
		this.gameNr = gameNumber;
		
		this.winnerRating = winner.getRating();
		this.looserRating = looser.getRating();
		
		this.stats = Event.game(winner, looser);
		
		winner.addWin();
		looser.addLoss();
		
		winner.addGame(this);
		looser.addGame(this);
	}
	
	public Game(Player winner,int cupsWinner, Player looser, int cupsLooser, String tourneyName, int gameNumber, String comment){
		this(winner,cupsWinner,looser,cupsLooser,tourneyName,gameNumber);
		this.comment = comment;
	}



	public String toString(){
		//
		String id = tourneyName + " - Game: " + gameNr +"\n";
		String winner = "Winner: " + this.winner.getName() + " (" + String.format("%.2f", this.winnerRating) +  ") - Cups: " + winnerCups +" [" + String.format("%.2f", stats.getWinnerPoints()) + " Points, " + String.format("%.2f", stats.getWinnerChance()*100) + "%]\n";
		String looser = "Looser: " + this.looser.getName() + " (" + String.format("%.2f", this.looserRating) +  ") - Cups: " + looserCups + " [" + String.format("%.2f", stats.getLooserPoints()) + " Points, " + String.format("%.2f", stats.getLooserChance()*100) + "%]\n";
		if(comment != null) looser += comment + "\n";
		
		return  id + winner + looser;
	}

	public Player getWinner() {
		return winner;
	}

	public Player getLooser() {
		return looser;
	}

	public GameStats getStats() {
		return stats;
	}

	public double getWinnerCups() {
		return winnerCups;
	}

	public int getLooserCups() {
		return looserCups;
	}

	public String getIdentification() {
		return tourneyName + " - " + gameNr;
	}
	
	public Match getJsonMatch(){

		return new Match(winner.getName(), looser.getName(), winnerCups, looserCups, stats.getWinnerChance()*100, stats.getLooserChance() * 100, stats.getWinnerPoints(), stats.getLooserPoints(), tourneyName, gameNr + "", comment );
	}
	
}
