package com.accolite.jdbc;

import java.sql.*;

public class ResultSet {

		private static final int TYPE_FORWARD_ONLY = 0;
		private static final int CONCUR_UPDATABLE = 0;
		private static final int HOLD_CURSORS_OVER_COMMIT = 0;

		@SuppressWarnings("resource")
		public static void main(String[] args) throws SQLException {
			
			java.sql.ResultSet rs=null;
			Statement stmt=null;
			Connection con=null;
			// loading driver
			try {
				Class.forName("com.mysql.jdbc.Driver");
						
			// open db connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC?useSSL=false", "root", "root");
			stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
								ResultSet.CONCUR_UPDATABLE,
							    ResultSet.HOLD_CURSORS_OVER_COMMIT);
			//inserting using resultSet
			
			rs = stmt.executeQuery("select * from person");
			rs.moveToInsertRow();
			rs.updateInt(1, 30);
			rs.updateString(2, "jolly");
			rs.updateInt(3, 21);
			rs.insertRow();
			
			//updating using ResultSet
			
			rs = stmt.executeQuery("select * from person");
			while(rs.next()){
		         int newAge = rs.getInt("age") + 10;
		         rs.updateInt( "age", newAge );
		         rs.updateRow();
		      }	
			
			rs = stmt.executeQuery("select * from person");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getInt("age"));
			} 
			catch (Exception e) {
				System.out.println(e);
			}
			finally 
			{
				// close the connection
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			}
		}

	}


