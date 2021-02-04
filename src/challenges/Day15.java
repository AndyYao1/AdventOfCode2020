package challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Day15 extends Day {
	private ArrayList<Integer> input;
	
	public Day15(int n) {
		super(n);
		input = new ArrayList<Integer>();
		for(String s:data.get(0).split(","))
			input.add(Integer.parseInt(s));
	}
	
	public int solvePart1() {
		return solve(input, 2020);
	}
	
	public int solvePart2() {
		return solve(input, 30000000);
	}
	
	public int solve(ArrayList<Integer> starting, int number) {
		HashMap<Integer,Integer> numbers = new HashMap<Integer,Integer>();
		for(int i = 0; i < data.get(0).split(",").length; i++) {
			numbers.put(Integer.parseInt(data.get(0).split(",")[i]),i);
		}
		int current = 0;
		for(int i = numbers.size(); i < number - 1; i++) {
			if(numbers.get(current) == null) {
				numbers.put(current, i);
				current = 0;
			} else {
				int temp = current;
				current = i - numbers.get(current);
				numbers.put(temp , i);
			}
		}
		return current;
	}

	public static void main(String[] args) {
		Day15 test = new Day15(15);
		System.out.println(test.solvePart1());
		System.out.println(test.solvePart2());
	}
}
