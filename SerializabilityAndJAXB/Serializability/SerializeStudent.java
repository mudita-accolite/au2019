package com.accolite.au.serializable;

import java.io.*;
public class SerializeStudent {
	public static void main(String[] args) {
		Address address=new Address("Panden Tola","Rewa","	Madhya Pradesh",486001);
		Student s1=new Student("Mudita","Saxena",1911,10,"A",100,address);
		SerializeStudent ss=new SerializeStudent();
		ss.writObjectToFile(s1);
		ss.readObjectFromFile();
		System.out.println("\n");
		System.out.println("Second object Details....\n");
		Student s2=new Student("Shriya","Pandey",2005,11,"B",98,address);
		ss.writObjectToFile(s2);
		ss.readObjectFromFile();

	}

		String pathName = "C:\\Users\\mudita.saxena\\Desktop\\Week3_assignment\\SerializedStudentFile.ser";

		public void writObjectToFile(Student s) {
			try {

				FileOutputStream fos = new FileOutputStream(pathName);
				ObjectOutputStream out = new ObjectOutputStream(fos);
				out.writeObject(s);
				out.close();
				out.flush();
				fos.close();
				System.out.println("Object has been successfully SERIALIZED\n\n" + "Data before Deserialization:");
				printdata(s);
			} catch (IOException ex) {
				System.out.println("IOException is caught");
			}
		}

		public Student readObjectFromFile() {
			Student s = null;
			try {
				FileInputStream fis = new FileInputStream(pathName);
				ObjectInputStream in = new ObjectInputStream(fis);
				s = (Student) in.readObject();
				in.close();
				fis.close();
				System.out.println("Object has been successfully DESERIZLIZED\n" + "Data after Deserialization: ");
				printdata(s);
			} catch (IOException ex) {
				System.out.println("IOException is caught");
			} catch (ClassNotFoundException ex) {
				System.out.println("ClassNotFoundException" + " is caught");
			}
			return s;
		}

		public static void printdata(Student stu) {
			System.out.println(stu);
		}


}
