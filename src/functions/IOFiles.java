package functions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

import core.Game;
import core.GameStats;
import core.Player;
import core.Team;

public class IOFiles {
	
	private String filename;
	
	public IOFiles(String filename){
		this.filename = "./Files/" + filename + ".ser";
	}
	
	public void savePlayers(List<Player> playerlist) {

		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			fout = new FileOutputStream(filename);
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
	
	public boolean updatePlayerReferance(Player player, List<Player> list){
		for(int i = 0; i < list.size(); i++){
			if(player.getName().equals(list.get(i).getName())){
				list.set(i, player);
				return true;
			}
				
		}
		System.out.println("updatePlayer: Player not found!");
		return false;
	}
	
	public void printPlayers(){
		List<Player> pl = getPlayers();
		Collections.sort(pl);
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
	
	public void writeHistory(Player player, String filename){
		String directory = "Files/Output";
		String path = "./" + directory + "/";
		PrintWriter writer;
		try {
			writer = new PrintWriter(path + filename + ".txt", "UTF-8");
			List<Game> h = player.getGameHistory();
			for(Game g : h){
				writer.println(g);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("Writing to file: " + filename + " is completed! The fresh text file is found in '" + directory + "'");
	}
	
	
	public List<Player> getPlayers() {

		List<Player> pl = null;

		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {

			fin = new FileInputStream(filename);
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
	
	public void resetChangeRating(List<Player> playerList){
		for(Player p : playerList){
			p.setRatingChange(0);
		}
	}
}
