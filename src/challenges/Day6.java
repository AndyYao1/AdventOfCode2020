package challenges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day6 {
	private int sum;
	
	public int solvePart1() {
		sum = 0;
		try {
			FileReader a = new FileReader("data/Day6Data");
			BufferedReader b = new BufferedReader(a);
			String c = b.readLine();
			int currentSum = 0;
			boolean[] questions = new boolean[26];
			while(c != null) {
				if(c.equals("")) {
					for(boolean bool: questions) {
						if(bool == true)
							currentSum++;
					}
					sum+=currentSum;
					currentSum = 0;
					for(int i = 0; i < questions.length; i++)
						questions[i] = false;
				} else {
					for(int i = 0; i < c.length(); i++) {
						questions[((int)c.charAt(i))-97] = true;
					}
				}
				c = b.readLine();
				if(c == null) {
					for(boolean bool: questions) {
						if(bool == true)
							currentSum++;
					}
					sum+=currentSum;
					currentSum = 0;
				}
			}
			b.close();
			a.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return sum;
	}
	
	public int solvePart2() {
		sum = 0;
		try {
			FileReader a = new FileReader("data/Day6Data");
			BufferedReader b = new BufferedReader(a);
			String c = b.readLine();
			int total = 0;
			int[] questions = new int[26];
			while(c != null) {
				if(c.equals("")) {
					for(int n: questions) {
						if(n == total)
							sum++;
					}
					for(int i = 0; i < questions.length; i++)
						questions[i] = 0;
					total = 0;
				} else {
					for(int i = 0; i < c.length(); i++) {
						questions[((int)c.charAt(i))-97]++;
					}
					total++;
				}
				c = b.readLine();
				if(c == null) {
					for(int n: questions) {
						if(n == total)
							sum++;
					}	
				}
			}
			b.close();
			a.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Day6 test = new Day6();
		System.out.println(test.solvePart1());
		System.out.println(test.solvePart2());
	}
}
