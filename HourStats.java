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
	    String line = bufferedReader.readLine(); // Skips first line
	    line = bufferedReader.readLine(); // Skips second line
	    List<Volunteer> hourData = new ArrayList<Volunteer>();
	    while ((line = bufferedReader.readLine()) != null) {
		String[] rawData = line.split(",");
		String ID = rawData[0];
		String hours = rawData[1];
		Volunteer row = new Volunteer(ID, hours);
		hourData.add(row);
	    }
	    Collections.sort(hourData, new checkVolunteer());
	    
	    print2DArray(hourData);
	} catch (Exception ex) {
	    System.out.println("ERROR: File not found.");
	}
    }

    private static void printRow(Volunteer v) {
	String storage = "[";
	storage += ("" + v.ID) + "," + ("" + v.hours) + "]";
	System.out.println(storage);
    }
    private static void print2DArray(List<Volunteer> l) {
	int i = 1;
	for (Volunteer v : l) {
	    printRow(v);
	    i++;
	    if (i > 10) {break;}
	}
    }
}

class checkVolunteer implements Comparator<Volunteer> {
    @Override
    public int compare(Volunteer v1, Volunteer v2) {
	if (v1.hours < v2.hours) {
	    return 1;
	} else {
	    return -1;
	}
    }
}

class Volunteer {
    public int ID = 0;
    public double hours = 0;

    public Volunteer() {
	ID = 0;
	hours = 0;
    }
    public Volunteer(String _id, String _hours) {
	ID = Integer.parseInt(_id);
	hours = Double.parseDouble(_hours);
    }
}
