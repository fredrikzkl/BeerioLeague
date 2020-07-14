package functions;

import com.google.gson.Gson;
import core.Game;
import core.Player;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import utils.JsonPackager;
import utils.Match;
import utils.Tournament;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IOFiles {

	private final String filePath = "./Files/";
	private String filename;
	private String json_filename;
	
	public IOFiles(String filename){
		this.filename = filePath + filename + ".ser";
		this.json_filename = filePath + filename + ".json";
	}

	public void writeToJson(List<Player> players){

		List<Tournament> tours = new ArrayList<>();
		List<Player> copy_players = new ArrayList<Player>(players);
		Collections.sort(copy_players);

		for(Player p : copy_players){
			p.updateMiscellaneousStats();
		}

		List<Match> matches = new ArrayList<>();
		for(Player p : copy_players){
			/*
			for(Game g : p.getGameHistory()){
				Match temp = g.getJsonMatch();
				if(!matches.contains(temp)){
					matches.add(temp);
				}
			}
			*/
			p.convertGamesToJSONMatches();
		}




		Gson gson = new Gson();
		try {
			Writer w =  new FileWriter(json_filename);
			gson.toJson(copy_players,w);
			w.flush();
			w.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	public boolean readFromOldExcel(String excelFileName, String outputFilename){
		try {
			List<Player> playerList = new ArrayList<>();
			
			String directory = "./Files/";
			
	        FileInputStream file = new FileInputStream(new File(directory + excelFileName));

		    HSSFWorkbook wb = new HSSFWorkbook(file);
		    HSSFSheet sheet = wb.getSheetAt(0);
		    HSSFRow row;
		    HSSFCell cell;

		    int rows; // No of rows
		    rows = sheet.getPhysicalNumberOfRows();

		    int cols = 0; // No of columns
		    int tmp = 0;

		    // This trick ensures that we get the data properly even if it doesn't start from first few rows
		    for(int i = 0; i < 10 || i < rows; i++) {
		        row = sheet.getRow(i);
		        if(row != null) {
		            tmp = sheet.getRow(i).getPhysicalNumberOfCells();
		            if(tmp > cols) cols = tmp;
		        }
		    }

		    for(int r = 1; r < rows; r++) {
		        row = sheet.getRow(r);
		        if(row != null) {
		        	Player temp = new Player("tmp");
		            for(int c = 0; c < cols; c++) {
		                cell = row.getCell((short)c);
		                if(cell != null) {
		                    System.out.println(cell);
		                    if(c == 0) temp.setName(cell.toString());
		                    if(c == 2) temp.setRating(cell.getNumericCellValue());
		                    if(c == 3) temp.setWins((int)cell.getNumericCellValue());
		                    if(c == 4) temp.setLosses((int) cell.getNumericCellValue());
		                    if(c == 6) temp.setDraws((int)cell.getNumericCellValue());
		                }
		               
		            }
		            playerList.add(temp);
		        }
		       
		    }
		    
		    savePlayers(playerList);
		} catch(Exception ioe) {
		    ioe.printStackTrace();
		}
		
		return true;
	}
}
