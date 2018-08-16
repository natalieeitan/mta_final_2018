package com.services;
import java.sql.*;


public class WedAppServer {

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	private String connectionUrl;
	private String user;
	private String password;

	public WedAppServer() {
	//	this.connectionUrl = "jdbc:sqlserver://vmedu155.mtacloud.co.il:49170;databaseName=WedAppServer";
		this.connectionUrl = "jdbc:sqlserver://vmedu155.mtacloud.co.il\\SQLEXPRESS:49170;databaseName=WedAppServer";
		this.user = "test";
		this.password = "";
		this.con = null;
		this.stmt = null;
		this.rs = null;
	}

	private void connect() throws SQLException{
		try {
			//Class.forName("org.sqlite.JDBC");
			//Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		con = DriverManager.getConnection(this.connectionUrl, this.user, this.password);
	}

	public void insertToDB(String query) throws SQLException {
		try {
			// Establish the connection
			connect();
			// Create and execute an SQL statement that inserts data.
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		}

		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			con.close();
		}
	}

	public ResultSet getDataFromDB(String query) throws SQLException {
		// Create a variable for the connection string.
		try {
			// Establish the connection
			connect();
			// Create and execute an SQL statement that returns some data.
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}
		/////////////////// DO NOT CLOSE rs,stmt and con!!!! Returned Value must have all of them!
		/////////////////// After ending with returned value, use CloseConnection()!!!
		finally {
			//rs.close();
			//stmt.close();
			//con.close();
		}

		return rs;
	}

	public void executeQuery(String query) {
		try {
			// Establish the connection
			connect();
			// Create and execute an SQL statement that returns some data.
			stmt = con.createStatement();
			stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		if (rs != null)
			try {
				rs.close();
			} catch (Exception e) {
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (Exception e) {
			}
		if (con != null)
			try {
				con.close();
			} catch (Exception e) {
			}
	}
}
