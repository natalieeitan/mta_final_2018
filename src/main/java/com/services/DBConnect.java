package com.services;

import java.sql.*;

public class DBConnect {

    public Connection con = null;
    public Statement stmt = null;
    public ResultSet rs = null;

    public void InsertToDB(String query) {
        String connectionUrl = "jdbc:sqlserver://vmedu155.mtacloud.co.il\\sqlexpress:49170;database=WedAppServer";
        String user = "test";
        String password = "";

        try {
            // Establish the connection
            con = DriverManager.getConnection(connectionUrl, user, password);
            // Create and execute an SQL statement that inserts data.
            stmt = con.createStatement();

            stmt.executeUpdate(query);
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            if (stmt != null) try {
                stmt.close();
            }
                catch (Exception e) {
            }
            if (con != null) try {
                con.close(); }
                catch (Exception e) {
                }
            }
        }

        public ResultSet GetDataFromDB(String query) {
            // Create a variable for the connection string.
            String connectionUrl = "jdbc:sqlserver://vmedu155.mtacloud.co.il\\sqlexpress:49170;database=WedAppServer";
            String user = "test";
            String password = "";

            try {
                // Establish the connection
                con = DriverManager.getConnection(connectionUrl,user,password);

                // Create and execute an SQL statement that returns some data.
                stmt = con.createStatement();
                rs = stmt.executeQuery(query);
            }

            // Handle any errors that may have occurred.
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                //if (rs != null) try { rs.close(); } catch(Exception e) {}
                //if (stmt != null) try { stmt.close(); } catch(Exception e) {}
                //if (con != null) try { con.close(); } catch(Exception e) {}
            }

            return rs;
        }

        public void closeConnection()
        {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }
