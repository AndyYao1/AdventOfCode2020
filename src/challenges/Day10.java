package challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day10 extends Day{
	private int result, oneJolt, threeJolt;
	List<Integer> joltages;
	
	public Day10(int n) {
		super(n);
		joltages = new ArrayList<Integer>();
		oneJolt = 0;
		threeJolt = 0;
		joltages.add(0);
		for(String s : data) {
			joltages.add(Integer.parseInt(s));
		}
		Collections.sort(joltages);
		joltages.add(joltages.get(joltages.size() - 1) + 3 );
	}
	
	public int solvePart1() {
		for(int i = 0; i < joltages.size() - 1; i++) {
			if(joltages.get(i + 1) - joltages.get(i) == 1)
				oneJolt++;
			else {
				threeJolt++;
			}
		}
		result = oneJolt * threeJolt;
		return result;
	}
	
	public Long solvePart2() {
		Long result = 1L;
		List<Integer> sizes = new ArrayList<Integer>();
		int count = 0;
		for(int i = 0; i < joltages.size() - 1; i++) {
			if(joltages.get(i+1) - joltages.get(i) == 1) {
				count++;
			} else {
				if(count > 1)
					sizes.add(count - 1);
				count = 0;
			}
		}
		for(Integer i : sizes) {
			if(i <= 2)
				result*= 2*i;
			else 
				result = (long) (result * (Math.pow(2, i) - 1));
		}
		return result;
	}
	
	public static void main(String[] args) {
		Day10 test = new Day10(10);
		System.out.println(test.solvePart1());
		System.out.println(test.solvePart2());
	}
}
