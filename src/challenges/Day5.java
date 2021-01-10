package challenges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day5 {
	private int highestSeatID;
	private int mySeatID;
	
	public int solvePart1() {
		highestSeatID = 0;
		try {
			FileReader a = new FileReader("data/Day5Data");
			BufferedReader b = new BufferedReader(a);
			String c = b.readLine();
			while(c != null) {
				String binaryRow = c.substring(0,7).replace("B","1").replace("F", "0");
				String binaryColumn = c.substring(7).replace("R", "1").replace("L", "0");
				int row = Integer.parseInt(binaryRow, 2);
				int column = Integer.parseInt(binaryColumn,2);
				if(8 * row + column > highestSeatID)
					highestSeatID = 8 * row + column;
				c = b.readLine();
			}
			b.close();
			a.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return highestSeatID;
	}
	
	public int solvePart2() {
		try {
			FileReader a = new FileReader("data/Day5Data");
			BufferedReader b = new BufferedReader(a);
			String c = b.readLine();
			int[] allIDs = new int[960];
			while(c != null) {
				String binaryRow = c.substring(0,7).replace("B","1").replace("F", "0");
				String binaryColumn = c.substring(7).replace("R", "1").replace("L", "0");
				int row = Integer.parseInt(binaryRow, 2);
				int column = Integer.parseInt(binaryColumn,2);
				allIDs[8 * row + column]++;
				c = b.readLine();
			}
			for(int i = 40; i < allIDs.length; i++) {
				if(allIDs[i] == 0)
					mySeatID = i;
			}
			b.close();
			a.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return mySeatID;
	}
	
	public static void main(String[] args) {
		Day5 test = new Day5();
		System.out.println(test.solvePart1());
		System.out.println(test.solvePart2());
	}
}
