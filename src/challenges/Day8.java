package challenges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day8 {
	private int accumulator;
	private ArrayList<String[]> instructions;
	
	public int solvePart1() {
		accumulator = 0;
		try {
			FileReader a = new FileReader("data/Day8Data");
			BufferedReader b = new BufferedReader(a);
			String c = b.readLine();
			instructions = new ArrayList<String[]>();
			ArrayList<Integer> lines = new ArrayList<Integer>();
			int current = 0;
			while(c != null) {
				instructions.add(c.split(" "));
				c = b.readLine();
			}
			b.close();
			a.close();
			while(true) {
				int number;
				if(lines.contains(current))
					return accumulator;
				if(instructions.get(current)[1].contains("+")) {
					number = Integer.parseInt(instructions.get(current)[1].replace("+", ""));
				} else {
					number = Integer.parseInt(instructions.get(current)[1].replace("-", "")) * -1;
				}
				if(instructions.get(current)[0].equals("acc")) {
					accumulator+=number;
					lines.add(current);
					current++;
				} else if(instructions.get(current)[0].equals("nop")) {
					lines.add(current);
					current++;
				} else {
					lines.add(current);
					current+=number;
				}
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return accumulator;
	}
	
	public int solvePart2() {
		ArrayList<Integer> lines = new ArrayList<Integer>();
		int current = 0;
		for(int i = 0; i < instructions.size(); i++) {
			ArrayList<String[]> changedList = changedData(instructions,i);
			current = 0;
			accumulator = 0;
			lines = new ArrayList<Integer>();
			while(true) {
				int number;
				if(current == changedList.size()) {
					return accumulator;
				}
				if(lines.contains(current)) {
					break;
				}
				if(changedList.get(current)[1].contains("+")) {
					number = Integer.parseInt(changedList.get(current)[1].replace("+", ""));
				} else {
					number = Integer.parseInt(changedList.get(current)[1].replace("-", "")) * -1;
				}
				
				if(changedList.get(current)[0].equals("acc")) {
					accumulator+=number;
					lines.add(current);
					current++;
				} else if(changedList.get(current)[0].equals("nop")) {
					
					lines.add(current);
					current++;
				} else {
					lines.add(current);
					current+=number;
				}
			}
			
		}
		return accumulator;
	}
	
	public ArrayList<String[]> changedData(ArrayList<String[]> a,int n){
		ArrayList<String[]> newData = new ArrayList<String[]>();
		for(String[] s : a)
			newData.add(s.clone());
		if(newData.get(n)[0].contains("nop"))
			newData.get(n)[0] = "jmp";
		else if(newData.get(n)[0].contains("acc")) {
			
		} else {
			newData.get(n)[0] = "nop";
		}
		return newData;
	}
	
	public static void main(String[] args) {
		Day8 test = new Day8();
		System.out.println(test.solvePart1());
		System.out.println(test.solvePart2());
	}
}
