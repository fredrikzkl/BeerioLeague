package functions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import core.Game;
import core.GameStats;
import core.Player;
import core.Team;

public class IOFiles {
	
	public void savePlayers(List<Player> playerlist) {

		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			fout = new FileOutputStream("./Files/Players.ser");
			oos = new ObjectOutputStream(fout);
			
			
				oos.writeObject(playerlist);
			
			

			System.out.println("Saving completed");

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
	
	public String updatePlayer(Player player, Game game){
		List<Player> pl = getPlayers();
		for(Player p : pl){
			if(p == player){
				p.addGame(game);
			}
		}
		return player.toString();
	}
	
	public Player getPlayer(String name){
		List<Player> pl = getPlayers();
		
		for(Player p : pl){
			if(p.getName().equals(name)) return p;
		}
		System.out.println("Player not found");
		return null;
	}
	
	public void printPlayers(){
		List<Player> pl = getPlayers();
		for(Player p : pl){
			System.out.println("" + p.getName() + " - " + p.getRating() + " | W/L: " + p.getWins() + "/" + p.getLosses() + " (" + p.getWinratio() + ")");
		}
	}
	
	public void printPLayersWithHistory(){
		List<Player> pl = getPlayers();
		for(Player p : pl){
			System.out.println("" + p.getName() + " - " + p.getRating() + " | W/L: " + p.getWins() + "/" + p.getLosses() + " (" + p.getWinratio() + ")");
			p.printGameHistory();
		}
	}
	
	public void printHistoryPlayer(String name){
		Player p = getPlayer(name);
		printHistoryPlayer(p);
	}
	
	public void printHistoryPlayer(Player player){
		List<Game> h = player.getGameHistory();
		for(Game g : h){
			System.out.println(g);
		}
	}
	
	
	public List<Player> getPlayers() {

		List<Player> pl = null;

		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {

			fin = new FileInputStream("./Files/Players.ser");
			ois = new ObjectInputStream(fin);
			
	        pl = (List<Player>) ois.readObject();
	        

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return pl;

	}
}
