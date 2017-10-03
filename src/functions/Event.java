package functions;

import core.GameStats;
import core.Player;
import core.Team;

public class Event {

	
	public static GameStats game(Team winner, Team looser){
		winner.addWin();
		looser.addLoss();
		double winnerChance = Functions.chanceOfWinning(winner.getRating(),looser.getRating());
		double looserChance = Functions.chanceOfWinning(looser.getRating(), winner.getRating());
		
		double winnerPoints = (32*(1-winnerChance));
		double looserPoints = (32*(0-looserChance));
		winner.setRating(winner.getRating() + winnerPoints);
		looser.setRating(looser.getRating() + looserPoints);
		
		return new GameStats(winnerPoints,winnerChance,looserPoints,looserChance);
	}
	
	public static GameStats game(Player winner, Player looser){
		double winnerChance = Functions.chanceOfWinning(winner.getRating(),looser.getRating());
		double looserChance = Functions.chanceOfWinning(looser.getRating(), winner.getRating());
		
		double winnerPoints = (32*(1-winnerChance));
		double looserPoints = (32*(0-looserChance));
		winner.setRating(winner.getRating() + winnerPoints);
		looser.setRating(looser.getRating() + looserPoints);
		
		return new GameStats(winnerPoints,winnerChance,looserPoints,looserChance);
	}
	
	public static void draw(Team t1, Team t2){
		t1.draws++;t2.draws++;
		double t1c = Functions.chanceOfWinning(t1.getRating(),t2.getRating());
		double t2c = Functions.chanceOfWinning(t2.getRating(), t1.getRating());
		
		t1.setRating(t1.getRating() + (32*(0.5-t1c)));
		t2.setRating(t2.getRating() + (32*(0.5-t2c)));
	}
}
