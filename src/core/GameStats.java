package core;

import java.io.Serializable;

public class GameStats implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5797461658448633092L;
	
	private double winnerPoints, winnerChance;
	private double looserPoints, looserChance;
	
	public GameStats(double winnerPoints, double winnerChance, double looserPoints, double looserChance){
		this.winnerPoints = winnerPoints;
		this.winnerChance = winnerChance;
		
		this.looserPoints = looserPoints;
		this.looserChance = looserChance;
	}

	public double getWinnerPoints() {
		return winnerPoints;
	}

	public double getWinnerChance() {
		return winnerChance;
	}

	public double getLooserPoints() {
		return looserPoints;
	}

	public double getLooserChance() {
		return looserChance;
	}
	
	
}
