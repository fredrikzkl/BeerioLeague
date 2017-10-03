package core;

import java.io.Serializable;

import functions.Event;

public class Game implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1097042844383846336L;
	
	private Player winner;
	private Player looser;
	
	
	private GameStats stats; 
	
	private double winnerCups;
	private int looserCups;
	
	public Game(Player winner,int cupsWinner, Player looser, int cupsLooser){
		this.winner = winner;
		this.looser = looser;
		
		this.winnerCups = cupsWinner;
		this.looserCups = cupsLooser;
		
		this.stats = Event.game(winner, looser);
		
		winner.addWin();
		looser.addLoss();
		
		winner.addGame(this);
		looser.addGame(this);
	}
	
	public String toString(){
		return "Winner: " + winner.getName() + "(" + winnerCups +")[" + stats.getWinnerPoints() + ", " + stats.getWinnerChance() + "] Looser: " + looser.getName() + " (" + looserCups
				+ ") [" + stats.getLooserPoints() + ", " + stats.getLooserChance() + "]";
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
	
	
}
