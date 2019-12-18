package JavaSBAProject_09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GradesHandler {
	
	//need a file in the root folder of project named "students.txt" with names
	//of students, one student on each line, no empty lines between
	public static void main(String[] args) throws FileNotFoundException, IOException {
		gradeStudents();
	}
	
	public static void gradeStudents() throws IOException, FileNotFoundException {
		
		ArrayList<Double> grades = new ArrayList<Double>(); 
		
		//creating filename String to pass into FileReader
		String fileName  = "students.txt";
		//creating FileReader on file and bufferedReader on FileReader
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		//create file output path and create the buffered writer
		String fileOut = "Grades.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
		
		//Scanner for grade input
		Scanner scan = new Scanner(System.in);
		
		//writing header of the grades file
		bw.write("Grades for class:\n");
		
		//creating string to hold student names
		String line;
		while(( line = br.readLine() ) != null) {
			System.out.println("Enter grade for " + line + ": ");
			double grade = scan.nextInt();
			bw.write(line + ":\t" + grade + "\n");
			grades.add(grade);			
		}
		bw.write("\n");
		double min = Collections.min(grades);
		double max = Collections.max(grades);
		double sum=0;
		for(int i=0; i<grades.size(); i++) {
			sum += grades.get(i);
		}
		double average = sum / grades.size();
		DecimalFormat df = new DecimalFormat("#0.00");
		String formattedAverage = df.format(average);
		bw.write("Minimum score: " + min + "\n");
		bw.write("Maximum score: " + max + "\n");
		bw.write("Average score: " + formattedAverage + "\n");
		
		br.close();
		bw.close();
		scan.close();				
	}
}
