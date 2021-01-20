package challenges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day {
	protected ArrayList<String> data;
	
	public Day(int n) {
		try {
			String file = "data/Day" + n + "Data";
			FileReader a = new FileReader(file);
			BufferedReader b = new BufferedReader(a);
			String c = b.readLine();
			data = new ArrayList<String>();
			while(c != null) {
				data.add(c);
				c = b.readLine();
			}
			b.close();
			a.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}

