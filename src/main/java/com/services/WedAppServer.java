package com.services;
import com.utilities.Area;
import com.utilities.Style;

import java.sql.*;
import java.time.DayOfWeek;
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

	//  Checks if id exists in tableName. If exists - return 1, else - returns 0
	public int checkIfIDExistInTable(String tableName, String id)
	{
        try {
            connect();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT 1 FROM WedAppServer.dbo."+tableName+" WHERE ID = "+id);
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

    //move to different class
    public static final int SUNDAY=1;
    public static final int MONDAY=2;
    public static final int TUESDAY=4;
    public static final int WEDNESDAY=8;
    public static final int THURSDAY=16;
    public static final int FRIDAY=32;
    public static final int SATURDAY=64;

    public static final int ANY_STYLE=1;
    public static final int CLASSIC=2;
    public static final int RURAL=4;
    public static final int URBAN=8;

    public static final int GUSH_DAN = 1;
    public static final int HAIFA = 2;
    public static final int JERUSALEM = 4;
    public static final int NORTH = 8;
    public static final int SHARON = 16;
    public static final int SHFELA = 32;
    public static final int SOUTH = 64;



    public static List<DayOfWeek> translateIntToDaysList(int days)
    {
        List<DayOfWeek> dayList=new ArrayList<>();
        if((SUNDAY&days)>0)
            dayList.add(DayOfWeek.SUNDAY);
        if((MONDAY&days)>0)
            dayList.add(DayOfWeek.MONDAY);
        if((TUESDAY&days)>0)
            dayList.add(DayOfWeek.TUESDAY);
        if((WEDNESDAY&days)>0)
            dayList.add(DayOfWeek.WEDNESDAY);
        if((THURSDAY&days)>0)
            dayList.add(DayOfWeek.THURSDAY);
        if((FRIDAY&days)>0)
            dayList.add(DayOfWeek.MONDAY);
        if((SATURDAY&days)>0)
            dayList.add(DayOfWeek.SATURDAY);

        return dayList;
    }

    public static int translateDayListToInt(List<DayOfWeek> dayList)
    {
        int result=0;
        for(DayOfWeek day: dayList)
        {
            switch (day)
            {
                case SUNDAY:{
                    result+=1;
                    break;
                }
                case MONDAY:{
                    result+=2;
                    break;
                }
                case TUESDAY:{
                    result+=4;
                    break;
                }
                case WEDNESDAY:{
                    result+=8;
                    break;
                }
                case THURSDAY:{
                    result+=16;
                    break;
                }
                case FRIDAY:{
                    result+=32;
                    break;
                }
                case SATURDAY:{
                    result+=64;
                    break;
                }
            }
        }
        return result;
    }

    public static List<Style> translateIntToStyleList(int styles)
    {
        List<Style> styleList=new ArrayList<>();
        if((ANY_STYLE&styles)>0)
            styleList.add(Style.AnyStyle);
        if((MONDAY&styles)>0)
            styleList.add(Style.Classic);
        if((TUESDAY&styles)>0)
            styleList.add(Style.Rural);
        if((WEDNESDAY&styles)>0)
            styleList.add(Style.Urban);

        return styleList;
    }

    public static int translateStyleListToInt(List<Style> styleList)
    {
        int result=0;
        for(Style style: styleList)
        {
            switch (style)
            {
                case AnyStyle:{
                    result+=1;
                    break;
                }
                case Classic:{
                    result+=2;
                    break;
                }
                case Rural:{
                    result+=4;
                    break;
                }
                case Urban:{
                    result+=8;
                    break;
                }
            }
        }
        return result;
    }

    public static List<Area> translateIntToAreaList(int areas)
    {
        List<Area> areaList=new ArrayList<>();
        if((GUSH_DAN&areas)>0)
            areaList.add(Area.GushDan);
        if((HAIFA&areas)>0)
            areaList.add(Area.Haifa);
        if((JERUSALEM&areas)>0)
            areaList.add(Area.Jerusalem);
        if((NORTH&areas)>0)
            areaList.add(Area.North);
        if((SHARON&areas)>0)
            areaList.add(Area.Sharon);
        if((SHFELA&areas)>0)
            areaList.add(Area.Shfela);
        if((SOUTH&areas)>0)
            areaList.add(Area.South);

        return areaList;
    }

    public static int translateAreaListToInt(List<Area> areaList)
    {
        int result=0;
        for(Area area: areaList)
        {
            switch (area)
            {
                case GushDan:{
                    result+=1;
                    break;
                }
                case Haifa:{
                    result+=2;
                    break;
                }
                case Jerusalem:{
                    result+=4;
                    break;
                }
                case North:{
                    result+=8;
                    break;
                }
                case Sharon:{
                    result+=16;
                    break;
                }
                case Shfela:{
                    result+=32;
                    break;
                }
                case South:{
                    result+=64;
                    break;
                }
            }
        }
        return result;
    }
}
