package utils;

import core.Player;

import java.util.List;

public class JsonPackager {
    public List<Player> players;
    public List<Match> matches;
    public List<Tournament> tournaments;

    public JsonPackager(List<Player> players, List<Match> matches, List<Tournament> tournaments) {
        this.players = players;
        this.matches = matches;
        this.tournaments = tournaments;
    }


}
