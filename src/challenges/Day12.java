package challenges;

import java.util.ArrayList;
import java.util.List;

public class Day12 extends Day {
	private List<Instruction> instructions;
	private int shipX,shipY,facing;

	public Day12(int n) {
		super(n);
		instructions = new ArrayList<Instruction>();
		shipX = shipY = 0;
		facing = 1000;
		for(String s: data) {
			if(s.charAt(0) != 'R') 
				instructions.add(new Instruction(s.charAt(0),Integer.parseInt(s.substring(1))));
			 else {
				int value = Integer.parseInt(s.substring(1));
				if(value == 90)
					value = 270;
				else if(value == 270) 
					value = 90;
				instructions.add(new Instruction('L', value));
			}
		}
	}
	
	public class Instruction{
		public char action;
		public int value;
		
		public Instruction(char a, int v) {
			action = a;
			value = v;
		}
	}
	
	public int solvePart1() {
		for(Instruction i: instructions) {
			if(i.action == 'N')
				shipY+=i.value;
			else if(i.action == 'S')
				shipY-=i.value;
			else if(i.action == 'E')
				shipX+=i.value;
			else if(i.action == 'W')
				shipX-=i.value;
			else if(i.action == 'L') 
				facing-=(i.value/90);
			else {
				if(facing % 4 == 0)
					shipX+=i.value;
				else if(facing % 4 == 1)
					shipY-=i.value;
				else if(facing % 4 == 2)
					shipX-=i.value;
				else shipY+=i.value;
			}
		}
		return Math.abs(shipX) + Math.abs(shipY);
	}
	
	public int solvePart2() {
		shipX = shipY = 0;
		int wayPointX = 10;
		int wayPointY = 1;
		int temp = 0;
		for(Instruction i: instructions) {
			if(i.action == 'N')
				wayPointY+=i.value;
			else if(i.action == 'S')
				wayPointY-=i.value;
			else if(i.action == 'E')
				wayPointX+=i.value;
			else if(i.action == 'W')
				wayPointX-=i.value;
			else if(i.action == 'L') { 
				if(i.value == 90) {
					temp = wayPointX;
					wayPointX = wayPointY*=-1;
					wayPointY = temp;
				} else if(i.value == 270) {
					temp = wayPointX;
					wayPointX = wayPointY;
					wayPointY = temp*=-1;
				} else {
					wayPointX*=-1;
					wayPointY*=-1;
				}
			}
			else {
				shipX += (wayPointX * i.value);
				shipY += (wayPointY * i.value);
			}
		}
		return Math.abs(shipX) + Math.abs(shipY);
	}
	
	public static void main(String[] args) {
		Day12 test = new Day12(12);
		System.out.println(test.solvePart1());
		System.out.println(test.solvePart2());
	}
}
