package challenges;

import java.util.ArrayList;
import java.util.List;

public class Day13 extends Day {
	private int earliestDepart;
	private List<Integer> busses;

	public Day13(int n) {
		super(n);
		earliestDepart = Integer.parseInt(data.get(0));
		busses = new ArrayList<Integer>();
		for(String s: data.get(1).replace("x,", "").split(","))
			busses.add(Integer.parseInt(s));	
	}

	public int solvePart1() {
		int minutes = Integer.MAX_VALUE;
		int busID = 0;
		for(Integer i: busses) {
			if(i * (earliestDepart / i + 1) - earliestDepart < minutes) {
				busID = i;
				minutes =  i * (earliestDepart / i + 1) - earliestDepart;
			}
		}
		return busID * minutes;
	}
	
	public Long solvePart2() {
		Long time = 0L;
		Long step  = busses.get(0).longValue();
		int i = 1;
		List<Integer> busTimes = new ArrayList<Integer>();
		for(String s: data.get(1).split(",")) {
			if(s.equals("x"))
				busTimes.add(0);
			else
				busTimes.add(Integer.parseInt(s));
		}
		while(true) {
			if((time + busTimes.indexOf(busses.get(i))) % busses.get(i) == 0) {
				step*=busses.get(i);
				i++;
			}
			if(i == busses.size())
				return time;
			time+=step;
		}
	}
	
	public static void main(String[] args) {
		Day13 test = new Day13(13);
		System.out.println(test.solvePart1());
		System.out.println(test.solvePart2());
	}
}
