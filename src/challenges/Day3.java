package challenges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day3 {
	private int trees;
	
	public int solvePart1() {
		try {
			FileReader a = new FileReader("data/Day3Data");
			BufferedReader b = new BufferedReader(a);
			String c = b.readLine();
			int horizontal = 0;
			while(c != null) {
				String[] row = c.split("");
				if(row[horizontal % 31].equals("#"))
					trees++;
				horizontal+=3;
				c = b.readLine();
			}
			b.close();
			a.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return trees;
	}
	
	public long solvePart2() {
		int slope1, slope3 , slope5 , slope7 , halfslope;
		long trees1, trees3 , trees5, trees7, treeshalf;
		trees1 = trees3 = trees5 = trees7 = treeshalf = slope1 = slope3 = slope5 = slope7 = halfslope = 0;
		try {
			FileReader a = new FileReader("data/Day3Data");
			BufferedReader b = new BufferedReader(a);
			String c = b.readLine();
			boolean half = false;
			while(c != null) {
				String[] row = c.split("");
				if(row[slope1 % 31].equals("#"))
					trees1++;
				if(row[slope3 % 31].equals("#"))
					trees3++;
				if(row[slope5 % 31].equals("#"))
					trees5++;
				if(row[slope7 % 31].equals("#"))
					trees7++;
				if(half = !half) {
					if(row[halfslope % 31].equals("#"))
						treeshalf++;
					halfslope++;
				}
				slope1++;
				slope3+=3;
				slope5+=5;
				slope7+=7;
				c = b.readLine();
			}
			b.close();
			a.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return trees1 * trees3 * trees5 * trees7 * treeshalf;
	}
	
	public static void main(String[] args) {
		Day3 test = new Day3();
		System.out.println(test.solvePart1());
		System.out.println(test.solvePart2());
	}
}
