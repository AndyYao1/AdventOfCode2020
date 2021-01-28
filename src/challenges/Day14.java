package challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day14 extends Day {
	private HashMap<Long,Long> memory;
	private Long sum;
	
	public Day14(int n) {
		super(n);
		memory = new HashMap<Long,Long>();
		sum = 0L;
	}
	
	public Long solvePart1() {
		String[] mask = null;
		List<String> valueString;
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i).contains("mask"))
				mask = data.get(i).split(" = ")[1].split("");
			else {
				Long address = Long.parseLong(data.get(i).substring(4, data.get(i).indexOf("]")));
				Long value = Long.parseLong(data.get(i).split(" = ")[1]);
				valueString = new ArrayList<String>();
				for(String s : Long.toBinaryString(value).split(""))
					valueString.add(s);
				for(int j = 35 - valueString.size(); j >= 0; j--) {
					valueString.add(0,"0");
				}
				for(int j = 0; j < 36; j++) {
					if(!mask[j].equals("X")) 
						valueString.set(j, mask[j]);
				}
				memory.put(address, Long.parseLong(String.join("",valueString),2));
			}
		}
		for(Long values: memory.values())
			sum+=values;
		return sum;
	}
	
	public Long solvePart2() {
		memory = new HashMap<Long,Long>();
		String[] mask = null;
		List<String> addressBinary, addresses = null;
		Long value = sum = 0L;
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i).contains("mask"))
				mask = data.get(i).split(" = ")[1].split("");
			else {
				Long address = Long.parseLong(data.get(i).substring(4, data.get(i).indexOf("]")));
				value = Long.parseLong(data.get(i).split(" = ")[1]);
				addressBinary = new ArrayList<String>();
				addresses = new ArrayList<String>();
				for(String s : Long.toBinaryString(address).split(""))
					addressBinary.add(s);
				for(int j = 35 - addressBinary.size(); j >= 0; j--) 
						addressBinary.add(0,"0");
				for(int j = 0; j < 36; j++) {
					if(mask[j].equals("1")) 
						addressBinary.set(j, "1");
				}
				
				for(int j = 0; j < 36; j++) {
					if(mask[j].equals("X") && addresses.isEmpty()) {
						addressBinary.set(j, "0");
						addresses.add(String.join("", addressBinary));
						addressBinary.set(j, "1");
						addresses.add(String.join("", addressBinary));
					} else if(mask[j].equals("X")) {
						int size = addresses.size();
						for(int k = 0; k < size; k++) {
							addresses.add(addresses.get(k).substring(0,j) + "0" + addresses.get(k).substring(j+1));
							addresses.add(addresses.get(k).substring(0,j) + "1" + addresses.get(k).substring(j+1));
						}
					}
				}
			}
			if(i > 0) {
				for(String s: addresses)
					memory.put(Long.parseLong(s,2), value);
			}
		}
		for(Long values: memory.values())
			sum+=values;
		return sum;
	}
	
	public static void main(String[] args) {
		Day14 test = new Day14(14);
		System.out.println(test.solvePart1());
		System.out.println(test.solvePart2());
	}
}
