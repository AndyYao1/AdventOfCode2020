package challenges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {
	
	private int count;
	
	public int solvePart1() {
		count = 0;
		try {
			FileReader a = new FileReader("data/Day2Data");
			BufferedReader b = new BufferedReader(a);
			String c = b.readLine();
			while(c != null) {
				String[] info = c.split("[-[\\s]]");
				String character = info[2].substring(0,1);
				int low = Integer.parseInt(info[0]);
				int high = Integer.parseInt(info[1]);
				String password = info[3];
				int number = 0;
				for(String s: password.split("")) {
					if (s.equals(character))
						number++;
				}
				if(number >= low && number <= high)
					count++;
				c = b.readLine();
			}
			b.close();
			a.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return count;
	}
	
	public int solvePart2() {
		count = 0;
		try {
			FileReader a = new FileReader("data/Day2Data");
			BufferedReader b = new BufferedReader(a);
			String c = b.readLine();
			while(c != null) {
				String[] info = c.split("[-[\\s]]");
				char character = info[2].charAt(0);
				int firstPosition = Integer.parseInt(info[0]) - 1;
				int secondPosition = Integer.parseInt(info[1]) - 1;
				String password = info[3];
				if(password.charAt(firstPosition) == character ^ password.charAt(secondPosition) == character)
					count++;
				c = b.readLine();
			}
			b.close();
			a.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return count;
	}
	
	public static void main(String[] args) {
		Day2 test = new Day2();
		System.out.println(test.solvePart1());
		System.out.println(test.solvePart2());
	}
}
