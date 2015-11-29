// Hours Statistics Tool
// Created by Zicheng Zhen

import java.io.*;
import java.util.*;

public class HourStats {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Please enter the filename: ");
	try {
	    String fileName = (String)(sc.next());
	    
	    FileReader fileReader =
		new FileReader(fileName);
	    BufferedReader bufferedReader =
		new BufferedReader(fileReader);
	    String line = null;
	    List<String[]> hourData = new ArrayList<String[]>();
	    while ((line = bufferedReader.readLine()) != null) {
		String[] rawData = line.split(",");
		String[] row = new String[]{rawData[0], rawData[1]};
		hourData.add(row);
	    }
	    print2DArray(hourData);
	} catch (Exception ex) {
	    System.out.println("ERROR: File not found.");
	}
    }

    private static void printRow(String[] a) {
	String storage = "[";
	for (String s : a) {
	    storage += s + ",";
	}
	if (storage.equals("[")) {
	    System.out.println(storage + "]");
	} else {
	    System.out.println(storage.substring(0,storage.length()-1) + "]");
	}
    }
    private static void print2DArray(List<String[]> l) {
	for (String[] s : l) {
	    printRow(s);
	}
    }
}
