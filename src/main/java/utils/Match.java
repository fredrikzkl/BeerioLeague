package utils;

public class Match {
    public String winner, looser;
    public int winnerCups, looserCups;
    public double winnerChance, looserChance, winnerPoints, looserPoints;
    public String tournament, gameId, type;

    public Match(String winner, String looser, int winnerCups, int looserCups, double winnerChance, double looserChance, double winnerPoints, double looserPoints, String tournament, String gameId, String type) {
        this.winner = winner;
        this.looser = looser;
        this.winnerCups = winnerCups;
        this.looserCups = looserCups;
        this.winnerChance = winnerChance;
        this.looserChance = looserChance;
        this.winnerPoints = winnerPoints;
        this.looserPoints = looserPoints;
        this.tournament = tournament;
        this.gameId = gameId;
        this.type = type;
    }

    public String getHash(){
        return tournament + gameId + type + winner + looser;
    }
}
