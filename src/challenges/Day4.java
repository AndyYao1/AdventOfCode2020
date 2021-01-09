package challenges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day4 {
	private int validPassports;
	
	public int solvePart1() {
		try {
			FileReader a = new FileReader("data/Day4Data");
			BufferedReader b = new BufferedReader(a);
			String[] fields = {"byr","iyr","eyr","hgt","hcl","ecl","pid"};
			validPassports = 0;
			int validFields = 0;
			String c = b.readLine();
			while(c != null) {
				if(c.equals("")) {
					if(validFields == 7)
						validPassports++;
					validFields = 0;
				} else {
					for(String s: fields) {
						if(c.contains(s))
							validFields++;
					}
				}
				c = b.readLine();
			}
			b.close();
			a.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return validPassports;
	}
	
	public int solvePart2() {
		try {
			FileReader a = new FileReader("data/Day4Data");
			BufferedReader b = new BufferedReader(a);
			validPassports = 0;
			int validFields = 0;
			String c = b.readLine();
			while(c != null) {
				if(c.equals("")) {
					if(validFields == 7)
						validPassports++;
					validFields = 0;
				} else {
					String[] data = c.split(" ");
					for(String s: data)	{
						switch(s.substring(0,3))
						{
							case "byr":
								if(Integer.parseInt(s.substring(4)) >= 1920 && Integer.parseInt(s.substring(4)) <= 2002)
									validFields++;
								break;
							case "iyr":
								if(Integer.parseInt(s.substring(4)) >= 2010 && Integer.parseInt(s.substring(4)) <= 2020)
									validFields++;
								break;
							case "eyr":
								if(Integer.parseInt(s.substring(4)) >= 2020 && Integer.parseInt(s.substring(4)) <= 2030)
									validFields++;
								break;
							case "hgt":
								if(s.substring(4).matches("1[5-8][0-9]cm|19[0-3]cm|59in|6[0-9]in|7[0-6]in"))
									validFields++;
								break;
							case "hcl":
								if(s.substring(4).matches("#[0-9|a-f]{6}"))
									validFields++;
								break;
							case "ecl":
								if(s.substring(4).matches("amb|blu|brn|gry|grn|hzl|oth"))
									validFields++;
								break;
							case "pid":
								if(s.substring(4).matches("[0-9]{9}"))
									validFields++;
								break;
						}
					}
				}
				c = b.readLine();
			}
			b.close();
			a.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return validPassports;
	}
	
	public static void main(String[] args) {
		Day4 test = new Day4();
		System.out.println(test.solvePart1());
		System.out.println(test.solvePart2());
	}
}
