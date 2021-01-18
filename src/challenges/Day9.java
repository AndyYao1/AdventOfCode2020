package challenges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9 {
	private Long number;
	private int lastPosition;
	
	public Long solvePart1() {
		try {
			FileReader a = new FileReader("data/Day9Data");
			BufferedReader b = new BufferedReader(a);
			String c = b.readLine();
			List<Long> list = new ArrayList<Long>();
			while(c != null) {
				list.add(Long.parseLong(c));
				c = b.readLine();
			}
			b.close();
			a.close();
			for(int i = 25; i < list.size(); i++) {
				boolean contains = false;
				for(int j = 1; j < 26; j++){
					if(list.subList(i - 25, i).contains(list.get(i) - list.get(i-j))) {
						contains = true;
						break;
					}
				}
				if(!contains) {
					number = list.get(i);
					lastPosition = i;
					return list.get(i);
				}
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Long solvePart2() {
		Long smallest = new Long(0);
		Long largest = new Long(0);
		Long sum;
		try {
			FileReader a = new FileReader("data/Day9Data");
			BufferedReader b = new BufferedReader(a);
			String c = b.readLine();
			List<Long> list = new ArrayList<Long>();
			while(c != null) {
				list.add(Long.parseLong(c));
				c = b.readLine();
			}
			b.close();
			a.close();
			
			for(int i = 2; i < lastPosition; i++) {
				for(int j = 0; j < lastPosition - i + 1; j++) {
					sum = 0L;
					List<Long> set = list.subList(j,j+i);
					for(Long l : set) {
						sum+=l;
					}
					if(number.equals(sum)) {
						Collections.sort(set);
						largest = set.get(set.size()-1);
						smallest = set.get(0);
						return largest + smallest;
					}
				}
			}
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static void main(String[] args) {
		Day9 test = new Day9();
		System.out.println(test.solvePart1());
		System.out.println(test.solvePart2());
	}
}
