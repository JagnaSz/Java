package l7cw1;

import java.sql.*;

public class DB{
  private Connection conn = null;
  private Statement stat = null;
  private ResultSet rs = null;
  public void connect(){
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
    
    conn =  DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/jagnasz","jagnasz","TJ28Mo9X");
 
    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }catch(Exception e){e.printStackTrace();}
    
  }
  
  
  public void printAll(){
	  try{
		  String line;
		  connect();
		 stat = conn.createStatement();
	  
		  rs = stat.executeQuery("SELECT * FROM books");
	  
		  while(rs.next()) {
			  line = rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4);
			  System.out.println(line);
		  }
		 
	  }catch (SQLException ex){
		  System.out.println("SQLException: " + ex.getMessage());
	  }finally {
	      // zwalniamy zasoby, które nie bêd¹ potrzebne
	      if (rs != null) {
	        try {
	          rs.close();
	        } catch (SQLException sqlEx) { } // ignore
	        rs = null;
	      }
	 
	      if (stat != null) {
	        try {
	          stat.close();
	        } catch (SQLException sqlEx) { } // ignore
	 
	        stat = null;
	      }
	  }
  }
  
  public void findByAuthor(String name) {
	  String line= null;
	  try{
		  
		  connect();
		  stat = conn.createStatement();
		  
		  rs = stat.executeQuery("SELECT * FROM books WHERE author= '"+ name+"'" );
		 
		  while(rs.next()) {
		  line = rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4);
		  System.out.println(line);
		  }
		  
	  }catch (SQLException ex){
		  System.out.println("SQLException: " + ex.getMessage());
	  }finally {
	      // zwalniamy zasoby, które nie bêd¹ potrzebne
	      if (rs != null) {
	        try {
	          rs.close();
	        } catch (SQLException sqlEx) { } // ignore
	        rs = null;
	      }
	 
	      if (stat != null) {
	        try {
	          stat.close();
	        } catch (SQLException sqlEx) { } // ignore
	 
	        stat = null;
	      }
	  }
  }
  
  public void findById(String id) {
	  String line= null;
	  try{
		  
		  connect();
		  stat = conn.createStatement();
		  
		  rs = stat.executeQuery("SELECT * FROM books WHERE isbn= '"+ id+"'" );
		  while(rs.next()) {
		  line = rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4);
		  System.out.println(line);
		  }
	  }catch (SQLException ex){
		  System.out.println("SQLException: " + ex.getMessage());
	  }finally {
	      // zwalniamy zasoby, które nie bêd¹ potrzebne
	      if (rs != null) {
	        try {
	          rs.close();
	        } catch (SQLException sqlEx) { } // ignore
	        rs = null;
	      }
	 
	      if (stat != null) {
	        try {
	          stat.close();
	        } catch (SQLException sqlEx) { } // ignore
	 
	        stat = null;
	      }
	  }
	   
  }
  
  public void delByName(String name) {
	  try{
		  
			  connect();
			  stat = conn.createStatement();
			  
			  int row = stat.executeUpdate("DELETE FROM books WHERE author= '"+ name+"'");
			  System.out.println(row);
			 
		  }catch (SQLException ex){
			  System.out.println("SQLException: " + ex.getMessage());
		  }finally {
		      // zwalniamy zasoby, które nie bêd¹ potrzebne
		      if (rs != null) {
		        try {
		          rs.close();
		        } catch (SQLException sqlEx) { } // ignore
		        rs = null;
		      }
		 
		      if (stat != null) {
		        try {
		          stat.close();
		        } catch (SQLException sqlEx) { } // ignore
		 
		        stat = null;
		      }
		  }
		
  }
  
  public void delById(String id) {
	  try{
		  
			  connect();
			  stat = conn.createStatement();
			  
			  int row = stat.executeUpdate("DELETE FROM books WHERE isbn= '"+ id+"'");
			  System.out.println(row);
			  
		  }catch (SQLException ex){
			  System.out.println("SQLException: " + ex.getMessage());
		  }finally {
		      // zwalniamy zasoby, które nie bêd¹ potrzebne
		      if (rs != null) {
		        try {
		          rs.close();
		        } catch (SQLException sqlEx) { } // ignore
		        rs = null;
		      }
		 
		      if (stat != null) {
		        try {
		          stat.close();
		        } catch (SQLException sqlEx) { } // ignore
		 
		        stat = null;
		      }
		  }
		
  }
}

