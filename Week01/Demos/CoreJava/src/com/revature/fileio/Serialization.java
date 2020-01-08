package com.revature.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.revature.classes.Planet;

/*
 * We also have the option of writing data as Java byte code by using
 * serialization. In order to make a class serializable, we must
 * implement the serializable interface. So let's make our Planet
 * class serializable and write it to a file.
 * 
 * NOTE: The Serializable interface is a special type of interface that is
 * known as a marker interface. A marker interface is an interface with no
 * methods. It is essentially an empty interface.
 */
public class Serialization{
	
	public static FileOutputStream fos;
	/*
	 * An ObjectOutputStream allows us to write our object to some file,
	 * etc. quite easily.
	 */
	public static ObjectOutputStream oos;
	
	public static FileInputStream fis;
	/*
	 * This is the counterpart for the ObjectOutputStream.
	 */
	public static ObjectInputStream ois;

	public static void main(String[] args) {
		
		File f = new File("file2.txt");
		
		Planet p = new Planet("Yo", 7, 9, "Ayyye!");
		
		try {
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			Planet p2 = (Planet) ois.readObject();
			System.out.println(p2);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}
}
