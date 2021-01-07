package challenges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day1 {
	private ArrayList<Integer> data;
	
	public Day1(){
		data = new ArrayList<Integer>();
		try {
			FileReader a = new FileReader("data/Day1Data");
			BufferedReader b = new BufferedReader(a);
			String c = b.readLine();
			while(c != null) {
				data.add(Integer.parseInt(c));
				c = b.readLine();
			}
			b.close();
			a.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int solvePart1() {
		for(int i = 0; i < data.size(); i++) {
			for(int j = i + 1; j < data.size(); j++) {
				if(data.get(i) + data.get(j) == 2020)
					return data.get(i) * data.get(j);
			}
		}
		return 0;
	}
	
	public int solvePart2() {
		for(int i = 0; i < data.size(); i++) {
			for(int j = i + 1; j < data.size(); j++) {
				for(int k = j + 1; k < data.size(); k++) {
					if(data.get(i) + data.get(j) + data.get(k) == 2020)
						return data.get(i) * data.get(j) * data.get(k);
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Day1 test = new Day1();
		System.out.println(test.solvePart1());
		System.out.println(test.solvePart2());
	}
}