package functions;

import core.Team;

public class Event {

	
	public static void game(Team winner, Team looser){
		double winnerChance = Functions.chanceOfWinning(winner.getRating(),looser.getRating());
		double looserChance = Functions.chanceOfWinning(looser.getRating(), winner.getRating());
		
		winner.setRating(winner.getRating() + (32*(1-winnerChance)));
		looser.setRating(looser.getRating() + (32*(1-looserChance)));
	}
	
	public void draw(Team t1, Team t2){
		double t1c = Functions.chanceOfWinning(t1.getRating(),t2.getRating());
		double t2c = Functions.chanceOfWinning(t2.getRating(), t1.getRating());
		
		t1.setRating(t1.getRating() + (32*(0.5-t1c)));
		t2.setRating(t2.getRating() + (32*(0.5-t2c)));
	}
}
