package functions;


import core.Player;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;



public class Excel {
	
	
	private static final String FILE_NAME = "./Files/ExcelSheets/LassisLeague.xls";
	
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	
	public enum Columns{
		Name,
		Rank,
		Rating,
		Wins,
		Losses,
		Winrating,
		Rankchange,
		Winstreak,
		AverageCups,
		ArchEnemy,
		Bitch,
		Strikes
	}
	
	public Excel(String bookname){
		
		workbook = new HSSFWorkbook();
        sheet = workbook.createSheet(bookname);
        
	}
	
	public void WriteToBook(List<Player> playerList){
		Collections.sort(playerList);
		
		HSSFRow headerRow = sheet.createRow(0);
		for(int i = 0; i < Columns.values().length;i++ ){
			HSSFCell cell = headerRow.createCell(i);
			cell.setCellValue(Columns.values()[i].toString());
		}
		
		for(int i = 1; i < playerList.size()+1; i++){
			HSSFRow row = sheet.createRow(i);
			for(int j = 0; j < Columns.values().length ; j++){
				HSSFCell cell = row.createCell(j);
				String value = "";
				switch(Columns.values()[j].toString()){
					case "Name":
						value = playerList.get(i-1).getName();
						break;
					case "Rank":
						value = Integer.toString(i);
						break;
					case "Rating":
						value = String.format("%.2f", playerList.get(i-1).getRating());
						break;
					case "Wins":
						value = Integer.toString(playerList.get(i-1).getWins());
						break;
					case "Losses":
						value = Integer.toString(playerList.get(i-1).getLosses());
						break;
					case "Winrating":
						value = String.format("%.2f", playerList.get(i-1).getWinratio());
						break;
					case "Rankchange":
						value = String.format("%.2f", playerList.get(i-1).getRatingChange());
						break;
					case "Strikes":
						value = Integer.toString(playerList.get(i-1).getStrikes());
						break;
					case "AverageCups":
						value = String.format("%.2f", playerList.get(i-1).getAverageCupsPrgame());
						break;
					case "ArchEnemy":
						value = playerList.get(i-1).getArchEnemy().getName(); 
						break;
					case "Bitch":
						value = playerList.get(i-1).getBitch().getName();
						break;
					case "Winstreak":
						value = Integer.toString(playerList.get(i-1).getLongestWinStreak());
						break;
					default:
						value = "Value not found";
						break;
				}
				cell.setCellValue(value);
			}
		}


        
        try {
			workbook.write(new FileOutputStream(FILE_NAME));

			System.out.println("Writing to Excel Completed");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
	
	
	
	
}
