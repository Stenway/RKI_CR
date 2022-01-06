package rkichangerequest;

import java.util.ArrayList;

public class Table {
	public ArrayList<ArrayList<String>> Lines = new ArrayList<>();
	
	public ArrayList<String> addLine() {
		ArrayList<String> line = new ArrayList<>();
		Lines.add(line);
		return line;
	}
	
	public void addLine(String... values) {
		ArrayList<String> line = addLine();
		for (String value : values) {
			line.add(value);
		}
	}
	
	public String[][] toArray() {
		int numLines = Lines.size();
		String[][] result = new String[numLines][0];
		for (int i=0; i<numLines; i++) {
			result[i] = Lines.get(i).toArray(new String[0]);
		}
		return result;
	}
}
