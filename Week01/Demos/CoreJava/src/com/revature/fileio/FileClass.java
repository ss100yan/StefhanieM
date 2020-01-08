package com.revature.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileClass {

	public static final String fileName = "file.txt";
	//A FileOutputStream is a stream that writes in bytes
	public static FileOutputStream fos;
	//A FileWriter is a character stream. This is a convenience
	//class that allows us to write in characters rather than bytes.
	public static FileWriter fw;
	//A BufferedWriter wraps around a stream and allows us to write
	//in sequences of characters. Note that a BufferedWriter is thread
	//safe.
	public static BufferedWriter bw;
	
	/*
	 * Our counterparts to our FileOutputStream, FileWriter, and BufferedWriter:
	 */
	
	public static FileInputStream fis;
	public static FileReader fr;
	public static BufferedReader br;
	
	/*
	 * This is the Scanner class. While it is often used to parse
	 * user input, it is generally for parsing in general.
	 */
	public static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		/*
		 * In order to create a file (or read/write to an existing one),
		 * we use the File class, passing in the name of the file we
		 * want to work with.
		 */
		
		File f = new File(fileName);
		
		String s1 = "";
		int age = 0;
		
		/*
		 * The scanner class provides many convenient ways of parsing
		 * whatever is in the stream. Note, however, that certain
		 * methods demand that whatever is in the stream is of a certain
		 * type, so be wary of exceptions.
		 */
		System.out.println("Please enter your name: ");
		s1 = s.nextLine();
		System.out.println("Please enter your age: ");
		age = s.nextInt();
		
		try {
//			fos = new FileOutputStream(f);
			fw = new FileWriter(f, true); //the boolean parameter
										  //allows us to open the file
										  //in append mode
			bw = new BufferedWriter(fw);
			bw.write("The user's name is " + s1 + " and the user is " + age + ". \n");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
//			fis = new FileInputStream(f);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			System.out.println(br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
