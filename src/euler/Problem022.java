package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem022 extends ProblemBase {
	
	private List<String> names;
	
	private BigInteger sum;
	
	public Problem022() {
		super(22, "Names scores");
		names = new ArrayList<>();
	}
	
	@Override
	public void solve() {
		String line;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/problem022.txt")))) {
			line = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		String[] nameList = line.split(",");
		line = null;
		for(int i = 0; i < nameList.length; i++) {
			names.add(nameList[i].substring(1, nameList[i].length() - 1));
		}
		
		Collections.sort(names);
		
		sum = new BigInteger("0");
		
		for(int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			int nameSum = 0;
			for (int j = 0; j < name.length(); j++) {
				char c = name.charAt(j);
				nameSum += (c - 64);
			}
			int nameScore = (i + 1) * nameSum;
			sum = sum.add(new BigInteger(Integer.toString(nameScore)));
		}
	}
	
	@Override
	protected String getSolution() {
		return sum == null ? "null" : sum.toString();
	}

}
