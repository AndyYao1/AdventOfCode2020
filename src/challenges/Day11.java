package challenges;

import java.util.Arrays;

public class Day11 extends Day {
	private int result;
	private char[][] seats, original;

	public Day11(int n) {
		super(n);
		result = 0;
		seats = new char[data.size()][data.get(0).length()];
		original = new char[data.size()][data.get(0).length()];
		for(int i = 0; i < seats.length; i++) {
			for(int j = 0; j < seats[0].length; j++) {
				seats[i][j] = data.get(i).charAt(j);
				original[i][j] = data.get(i).charAt(j);
			}
		}
	}
	
	public int solvePart1() {
		boolean unchanged = false;
		seats[0][0] = '#';
		seats[0][seats[0].length - 1] = '#';
		seats[seats.length - 1][0] = '#';
		seats[seats.length - 1][seats[0].length - 1] = '#';
		while(!unchanged) {
			unchanged = true;
			for(int i = 1; i < seats.length - 1; i++) {
				for(int j = 1; j < seats[0].length - 1; j++) {
					if(original[i][j] == 'L' && occupiedAdjacent(i, j, "center") == 0) {
						seats[i][j] = '#';
						unchanged = false;
					} else if(original[i][j] == '#' && occupiedAdjacent(i, j, "center") >= 4) {
						seats[i][j] = 'L';
						unchanged = false;
					}
				}
			}
			for(int i = 1; i < seats[0].length - 1; i++) {
				if(original[0][i] == 'L' && occupiedAdjacent(0,i, "top") == 0) {
					seats[0][i] = '#';
					unchanged = false;
				} else if(original[0][i] == '#' && occupiedAdjacent(0,i, "top") >= 4) {
					seats[0][i] = 'L';
					unchanged = false;
				}
				if(original[seats.length - 1][i] == 'L' && occupiedAdjacent(seats.length - 1,i, "bot") == 0) {
					seats[seats.length - 1][i] = '#';
					unchanged = false;
				}
				if(original[seats.length - 1][i] == '#' && occupiedAdjacent(seats.length - 1,i, "bot") >= 4) {
					seats[seats.length - 1][i] = 'L';
					unchanged = false;
				}
			}
			for(int i = 1; i < seats.length - 1; i++) {
				if(original[i][0] == 'L' && occupiedAdjacent(i,0, "left") == 0) {
					seats[i][0] = '#';
					unchanged = false;
				}
				if(original[i][0] == '#' && occupiedAdjacent(i,0, "left") >= 4) {
					seats[i][0] = 'L';
					unchanged = false;
				}
				if(original[i][seats[0].length - 1] == 'L' && occupiedAdjacent(i,seats[0].length - 1, "right") == 0) {
					seats[i][seats[0].length - 1] = '#';
					unchanged = false;
				}
				if(original[i][seats[0].length - 1] == '#' && occupiedAdjacent(i,seats[0].length - 1, "right") >= 4) {
					seats[i][seats[0].length - 1] = 'L';
					unchanged = false;
				}
			}
			for(int i = 0; i < seats.length; i++) {
				for(int j = 0; j < seats[0].length; j++) {
					original[i][j] = seats[i][j];
				}
			}
		}
		for(int i = 0; i < seats.length; i++) {
			for(int j = 0; j < seats[0].length; j++) {
				if(original[i][j] == '#')
					result++;
			}
		}
		return result;
	}
	
	public int occupiedAdjacent(int row, int col, String side) {
		int count = 0;
		if((side.equals("center") || side.equals("bot") || side.equals("right")) && original[row - 1][col - 1] == '#')
			count++;
		if((side.equals("center") || side.equals("bot") || side.equals("right") || side.equals("left")) && original[row - 1][col] == '#')
			count++;
		if((side.equals("center") || side.equals("bot") || side.equals("left")) && original[row - 1][col + 1] == '#')
			count++;
		if((side.equals("center") || side.equals("bot") || side.equals("right") || side.equals("top")) && original[row][col - 1] == '#')
			count++;
		if((side.equals("center") || side.equals("bot") || side.equals("left") || side.equals("top")) && original[row][col + 1] == '#')
			count++;
		if((side.equals("center") ||side.equals("right") || side.equals("top")) && original[row + 1][col - 1] == '#')
			count++;
		if((side.equals("center") || side.equals("top") || side.equals("right") || side.equals("left")) && original[row + 1][col] == '#')
			count++;
		if((side.equals("center") ||side.equals("left") || side.equals("top")) && original[row + 1][col + 1] == '#')
			count++;
		return count;
	}
	
	public int solvePart2() {
		result = 0;
		
		return result;
	}
	
	public static void main(String[] args) {
		Day11 test = new Day11(11);
		System.out.println(test.solvePart1());
		System.out.println(test.solvePart2());
	}
}
