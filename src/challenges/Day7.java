package challenges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class Day7 {
	private int numBags;
	
	public int solvePart1() {
		numBags = 0;
		try {
			FileReader a = new FileReader("data/Day7Data");
			BufferedReader b = new BufferedReader(a);
			String c = b.readLine();
			ArrayList<String> rules = new ArrayList<String>();
			ArrayList<String> currentBags = new ArrayList<String>();
			ArrayList<String> checkedBags = new ArrayList<String>();
			while(c != null) {
				rules.add(c);
				if(c.split("bags contain")[1].contains("shiny gold bag")) {
					currentBags.add(c.split("bags contain")[0]);
					checkedBags.add(c.split("bags contain")[0]);
					numBags++;
				}
				c = b.readLine();
			}			
			while(!currentBags.isEmpty()) {
				for(String s: rules) {
					if(s.split("bags contain")[1].contains(currentBags.get(0)) && !checkedBags.contains(s.split("bags contain")[0])) {
						currentBags.add(s.split("bags contain")[0]);
						checkedBags.add(s.split("bags contain")[0]);
						numBags++;
					}
				}
				currentBags.remove(0);
			}
			b.close();
			a.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return numBags;
	}
	
	public int solvePart2() {
		numBags = 0;
		try {
			FileReader a = new FileReader("data/Day7Data");
			BufferedReader b = new BufferedReader(a);
			String c = b.readLine();
			HashMap<String,String> rules = new HashMap<String,String>();
			while(c != null) {
				rules.put(c.split(" bags contain")[0], c.split("bags contain")[1].replace(" bags", "").replace(" bag", "").replace(",", "").replace(".", "").trim());
				c = b.readLine();
			}
			b.close();
			a.close();
			LinkedList<Integer> queue = new LinkedList<Integer>();
			LinkedList<String[]> stringQueue = new LinkedList<String[]>();
			queue.add(1);
			stringQueue.add(rules.get("shiny gold").split(" "));
			while (!queue.isEmpty()) {
				if(stringQueue.peek().length <= 2){
					queue.poll();
					stringQueue.poll();
				} else if(stringQueue.peek().length <= 3) {
					numBags+=queue.peek()*Integer.parseInt(stringQueue.peek()[0]);
					queue.add(queue.peek()*Integer.parseInt(stringQueue.peek()[0]));
					stringQueue.add(rules.get(stringQueue.peek()[1] + " " + stringQueue.peek()[2]).split(" "));
					queue.poll();
					stringQueue.poll();
				} else if(stringQueue.peek().length <= 6) {
					numBags+=queue.peek()*Integer.parseInt(stringQueue.peek()[0]);
					numBags+=queue.peek()*Integer.parseInt(stringQueue.peek()[3]);
					queue.add(queue.peek()*Integer.parseInt(stringQueue.peek()[0]));
					stringQueue.add(rules.get(stringQueue.peek()[1] + " " + stringQueue.peek()[2]).split(" "));
					queue.add(queue.peek()*Integer.parseInt(stringQueue.peek()[3]));
					stringQueue.add(rules.get(stringQueue.peek()[4] + " " + stringQueue.peek()[5]).split(" "));
					queue.poll();
					stringQueue.poll();
				} else if(stringQueue.peek().length <= 9) {
					numBags+=queue.peek()*Integer.parseInt(stringQueue.peek()[0]);
					numBags+=queue.peek()*Integer.parseInt(stringQueue.peek()[3]);
					numBags+=queue.peek()*Integer.parseInt(stringQueue.peek()[6]);
					queue.add(queue.peek()*Integer.parseInt(stringQueue.peek()[0]));
					stringQueue.add(rules.get(stringQueue.peek()[1] + " " + stringQueue.peek()[2]).split(" "));
					queue.add(queue.peek()*Integer.parseInt(stringQueue.peek()[3]));
					stringQueue.add(rules.get(stringQueue.peek()[4] + " " + stringQueue.peek()[5]).split(" "));
					queue.add(queue.peek()*Integer.parseInt(stringQueue.peek()[6]));
					stringQueue.add(rules.get(stringQueue.peek()[7] + " " + stringQueue.peek()[8]).split(" "));
					queue.poll();
					stringQueue.poll();
				} else {
					numBags+=queue.peek()*Integer.parseInt(stringQueue.peek()[0]);
					numBags+=queue.peek()*Integer.parseInt(stringQueue.peek()[3]);
					numBags+=queue.peek()*Integer.parseInt(stringQueue.peek()[6]);
					numBags+=queue.peek()*Integer.parseInt(stringQueue.peek()[9]);
					queue.add(queue.peek()*Integer.parseInt(stringQueue.peek()[0]));
					stringQueue.add(rules.get(stringQueue.peek()[1] + " " + stringQueue.peek()[2]).split(" "));
					queue.add(queue.peek()*Integer.parseInt(stringQueue.peek()[3]));
					stringQueue.add(rules.get(stringQueue.peek()[4] + " " + stringQueue.peek()[5]).split(" "));
					queue.add(queue.peek()*Integer.parseInt(stringQueue.peek()[6]));
					stringQueue.add(rules.get(stringQueue.peek()[7] + " " + stringQueue.peek()[8]).split(" "));
					queue.add(queue.peek()*Integer.parseInt(stringQueue.peek()[9]));
					stringQueue.add(rules.get(stringQueue.peek()[10] + " " + stringQueue.peek()[11]).split(" "));
					queue.poll();
					stringQueue.poll();
				}
				
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return numBags;
	}
	
	public static void main(String[] args) {
		Day7 test = new Day7();
		System.out.println(test.solvePart1());
		System.out.println(test.solvePart2());
	}
}
