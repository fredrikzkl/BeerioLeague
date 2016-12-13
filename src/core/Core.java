package core;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Core {

	public static void main(String[] args) {
		
		Game2 g2 = new Game2();
		
		
		List<String> lines = Arrays.asList("Test","Test2","Overwrite");
		Path file = Paths.get("./Files/Players.txt");
		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
