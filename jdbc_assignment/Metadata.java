package com.accolite.jdbc;

import java.sql.*;

public class Metadata {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		java.sql.ResultSet rs = null;
		try {

			// loading driver
			Class.forName("com.mysql.jdbc.Driver");
			// opening database connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/WorldCup?useSSL=false", "root", "root");

			stmt = con.createStatement();
			// retrieving rows from team table

			rs = stmt.executeQuery("select * from team");
			System.out.println("World Cup Summary:");
			System.out.println("Team_Id" + "\t" + "Team_Name" + "\t" + "Total_Wins");
			while (rs.next())
				System.out.println(
						rs.getInt("team_id") + "\t" + rs.getString("country") + "\t" + rs.getInt("tournament_win"));
			System.out.println("\n");

			// retrieving rows from players table
			rs = stmt.executeQuery("select * from Players");
			System.out.println("Performancen of players:");
			System.out
					.println("Player_Id" + "\t" + "Player_Name" + "\t" + "Score" + "\t" + "Wickets" + "\t" + "Innings");
			while (rs.next())
				System.out.println(rs.getInt("player_id") + "\t" + rs.getString("name") + "\t" + rs.getInt("score")
						+ "\t" + rs.getInt("wickets") + "\t" + rs.getInt("innings"));
			System.out.println("\n");
			// Using various metadata functions and printing the values
			System.out.println("Structural info/metadat of table TEAM: \n");
			DatabaseMetaData dmd = con.getMetaData();
			System.out.println("1)Numeric Functions that can be used: " + dmd.getNumericFunctions());
			System.out.println("\n");
			System.out.println("2)String Functions that can be used: " + dmd.getStringFunctions());
			System.out.println("\n");
			System.out.println("3)Keywords in SQL: " + dmd.getSQLKeywords());
			System.out.println("\n");
			System.out.println("4)Driver Version: " + dmd.getDriverVersion());
			System.out.println("\n");
			System.out.println("5)Database Product Version: " + dmd.getDatabaseProductVersion());
			System.out.println("\n");
			System.out.println("6)Metadata URL: " + dmd.getURL());
			System.out.println("\n");
			System.out.println("7)Metadata Username: " + dmd.getUserName());
			System.out.println("\n");
			System.out.println("8)Driver Name: " + dmd.getDriverName());
			System.out.println("\n");
			System.out.println("9)Database Product Name: " + dmd.getDatabaseProductName());
			System.out.println("\n");
			rs = dmd.getTables(null, null, "%", null);
			System.out.println("10)Tables Present in WORLDCUP database:");
			while (rs.next()) {
				System.out.println((rs.getString(3)));
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// closing the connection
			if (con != null)
				con.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}
	}
}
