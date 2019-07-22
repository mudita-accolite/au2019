
package com.accolite.jdbc;

import java.util.HashMap;
import java.util.Map;
import java.sql.*;

public class HashMapOperations {

	public static void main(String[] args) throws SQLException {

		Student s1 = new Student("A", 21);
		Student s2 = new Student("B", 20);
		Student s3 = new Student("C", 23);
		Student s4 = new Student("D", 22);
		Student s5 = new Student("E", 23);
		HashMap<Integer, Student> hInsert = new HashMap<>();
		// inserting values in hashmap for performing insertion in database
		hInsert.put(1, s1);
		hInsert.put(2, s2);
		hInsert.put(3, s3);
		hInsert.put(4, s4);
		hInsert.put(5, s5);

		HashMap<Integer, Student> hUpdate = new HashMap<>();
		// values inserted in hashmap that are used for update operation
		Student s6 = new Student("F", 21);
		Student s7 = new Student("G", 22);
		Student s8 = new Student("H", 21);
		Student s9 = new Student("I", 22);
		Student s10 = new Student("J", 21);

		hUpdate.put(1, s6);
		hUpdate.put(2, s7);
		hUpdate.put(3, s8);
		hUpdate.put(4, s9);
		hUpdate.put(5, s10);

		HashMap<Integer, Student> hDelete = new HashMap<>();
		// values inserted in hashmap that will be used for performing delete operation
		hDelete.put(1, s6);
		hDelete.put(2, s7);
		hDelete.put(3, s8);

		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			// creating connection with database
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?useSSL=false", "root", "root");
			stmt = con.createStatement();

			// inserting the hmInsert values into the table Student
			PreparedStatement stmt1 = null;
			stmt1 = (PreparedStatement) con.prepareStatement("insert into student(id,name,age) values (?,?,?)");
			for (Map.Entry<Integer, Student> entry : hInsert.entrySet()) {
				Integer id = entry.getKey();
				Student s = entry.getValue();
				int ids = id.intValue();
				String name = s.getName();
				int age = s.getAge();
				stmt1.setInt(1, ids);
				stmt1.setString(2, name);
				stmt1.setInt(3, age);
				// Using Batch operations
				stmt1.addBatch();
			}
			stmt1.executeBatch();

			// updating the Student table using hmUpdate

			stmt1 = (PreparedStatement) con.prepareStatement("update student set name=? where id=?");
			for (Map.Entry<Integer, Student> entry1 : hUpdate.entrySet()) {

				Integer id = entry1.getKey();
				Student s = entry1.getValue();
				int ids = id.intValue();
				String name = s.getName();
				stmt1.setString(1, name);
				stmt1.setInt(2, ids);
				// Batch operation used
				stmt1.addBatch();

			}
			stmt1.executeBatch();

			// Deleting the Student table using hmDelete
			stmt1 = (PreparedStatement) con.prepareStatement("delete from student where name=? and id=?");
			for (Map.Entry<Integer, Student> entry1 : hDelete.entrySet()) {

				Integer id = entry1.getKey();
				Student s = entry1.getValue();
				int ids = id.intValue();
				String name = s.getName();

				stmt1.setString(1, name);
				stmt1.setInt(2, ids);
				// Batch operation used
				stmt1.addBatch();
			}
			stmt1.executeBatch();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// closing the connection
			if (con != null)
				con.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				((Connection) rs).close();
		}

	}

}
