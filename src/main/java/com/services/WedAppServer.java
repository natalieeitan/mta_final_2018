package com.services;
import com.entities.User;
import com.exceptions.EmailDoesNotExistException;
import com.exceptions.WrongPasswordException;
import com.utilities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class WedAppServer {

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	private String connectionUrl;
	private String user;
	private String password;

	public WedAppServer() {
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

	//  Checks if id exists in tableName. If exists - return 1, else - returns 0
	public int checkIfIDExistInTable(String tableName, String id)
	{
		return checkIfAttributeExistInTable(tableName, "ID", id);
    }

    public int checkIfIDExistInUsersTable(String id)
    {
        return checkIfIDExistInTable("Users", id);
    }

    public int checkIfEmailExistInUsersTable(String email)
    {
        return checkIfAttributeExistInTable("Users", "Email", email);
    }

    //return userTypeBitValue if exists, 0 else
    public int VerifyEmailAndPassword(String email, String password)
    {
        //email doesn't exist
        if(checkIfEmailExistInUsersTable(email)==0)
            //throw exception?
            return 0;

        WedAppServer db=new WedAppServer();
        ResultSet rs = null;

        try {
            User user=UserService.getUserByEmail(email);

            if(!(user.getPassword().equals(password)))
                //throw exception?
                return 0;

            if(user.getType().equals(UserType.COUPLE))
                return UserType.COUPLE.getBitValue();
            else
                return UserType.SUPPLIER.getBitValue();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }



	public int checkIfAttributeExistInTable(String tableName, String AttributeName, String parameter)
	{
		try {
			connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT 1 FROM WedAppServer.dbo."+tableName+" WHERE "+ AttributeName+" = '"+parameter+"'");
			if(rs.next())
			{
				closeConnection();
				return 1;
			}
			else{
				closeConnection();
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
