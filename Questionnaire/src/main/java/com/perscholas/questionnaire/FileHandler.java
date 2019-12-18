package com.perscholas.questionnaire;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//FileHandler class 
public class FileHandler {
	
	//field variables 
	//name to create unique file output names
	String name;
	//String arrays to hold questions and answers for output
	String[] qArr =  new String[5];
	String[] aArr =  new String[5];
	
	//FileHandler constructor with name input to use later for output file name
	public FileHandler(String name) {
		this.name = name;
	}
	
	//method to handle the file input, throws IO and FNF Exceptions 
	public void handle() throws IOException, FileNotFoundException {
		//create a scanner to handle answering the questions
		Scanner scIn = new Scanner(System.in);
		//creating filename String to pass into FileReader
		String fileName  = "questions.txt";
		//creating FileReader on file and bufferedReader on FileReader
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		//String to hold the questions, int i for an index in while loop
		String line;
		int i = 0;
		//while loop to read in the questions, stops reading when out of lines (!=null)
		while( ( line = br.readLine() ) != null) {
			//place line into question array at index
			this.qArr[i] = line;
			//print out question into console to prompt input
			System.out.println(line);
			
			//create new String array to hold the 4 possible answers
			String[] ans = new String[4];
			
			//loop through all of the answers to a question, saving the lines into the string array
			//and printing each possible answer on new line
			for(int r = 0; r<4; r++) {
				ans[r] = br.readLine();
				System.out.println(ans[r]);
			}
			//use scanner to accept the user picking a choice (a, b, c or d)
			String choice = scIn.next();
			//switch statement to save choice into answer array field
			switch (choice) {
			case "A":
			case "a":
				this.aArr[i] = ans[0];
				break;
			case "B":
			case "b":
				this.aArr[i] = ans[1];
				break;
			
			case "C":
			case "c":
				this.aArr[i] = ans[2];
				break;
			case "D":
			case "d":
				this.aArr[i] = ans[3];
				break;	
			
			}
			//increment i
			i++;
			
		}
		//close the resources
		scIn.close();
		br.close();	
	
	//call the file write method
	this.write();
	}
	
	//file write method
	public void write() throws IOException {
		//create file output path and create the buffered writer
		String fileOut = this.name + "Answers.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
		//write header of output file
		bw.write("Answers for: " + this.name + "\n");
		//loop through both field arrays, using bufferedwriter to output them into txt file
		for(int i = 0; i<5; i++) {
			bw.write(this.qArr[i] + "\n");
			bw.write("\t" + this.aArr[i] + "\n\n");
		}
		//close bufferedwriter
		bw.close();
	}
}
