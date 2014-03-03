package mpkg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class Kadry  {

	static Scanner in = new Scanner(System.in);
	
      private static Connection conn = null;
	  private static Statement stat = null;
	  private static ResultSet rs = null;
	  
	  public static void connect(){
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
	  
	static void createTable() throws SQLException{
		connect();
		  	
		stat = conn.createStatement();
			try {
				 stat.execute("CREATE TABLE IF NOT EXISTS kadry (pesel CHAR(11) NOT NULL, brutto double NOT NULL, PRIMARY KEY(pesel))");
	
			 } catch (SQLException e) {
		            System.err.println("Blad przy tworzeniu tabeli");
		            e.printStackTrace();
		        }
		   
			}
	
	static void dodajStudenta(String p, double w) throws SQLException {
		connect();
		stat = conn.createStatement();
	    stat.executeUpdate(
	            "INSERT INTO kadry (pesel, brutto) "
	            + "values ('" + p + "'"+ "," + "'" + w + "')"  );
	}
	
	
	static void usun(String pes) {
		try{
			  
			  connect();
			  stat = conn.createStatement();
			  
			  stat.executeUpdate("DELETE FROM kadry WHERE pesel= '"+ pes+"'");
			 
			 
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
	
	static void szukaj(String pes) {
		String line= null;
		  try{
			  
			  connect();
			  stat = conn.createStatement();
			  
			  rs = stat.executeQuery("SELECT * FROM kadry WHERE pesel= '"+ pes+"'" );
			  while(rs.next()) {
				  line = "pesel: " + rs.getString(1) + ", brutto: " + rs.getDouble(2);
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
	
	static void pobierzBrutto(String p) {
		String line= null;
		  try{
			  
			  connect();
			  stat = conn.createStatement();
			  
			  rs = stat.executeQuery("SELECT * FROM kadry WHERE pesel= '"+ p+"'" );
			  while(rs.next()) {
				  line = "Wynagrodzenie brutto: " + rs.getDouble(2);
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
	
	static void nadpiszBrutto(String p, double nowy) {
	
		  try{
			  connect();
			  stat = conn.createStatement();
			  
			  stat.executeUpdate("UPDATE kadry SET brutto = '"+nowy+"'" + "WHERE pesel = " + p);
			 			 
			  
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
	
	static void pobierzNetto(String p) {
		String line= null;
		  try{
			  
			  connect();
			  stat = conn.createStatement();
			  
			  rs = stat.executeQuery("SELECT * FROM kadry WHERE pesel= '"+ p+"'" );
			  while(rs.next()) {
				  line = "Wynagrodzenie netto: " + ((rs.getDouble(2)*0.7)*100)/100;
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
	
	static void sortuj() {
		
		  try{
			  String line = null;
			  connect();
			  stat = conn.createStatement();
			  
			  rs = stat.executeQuery("SELECT * FROM kadry ORDER BY brutto DESC");
			  System.out.println("Po sortowaniu: ");
			  while(rs.next()) {
				  line = "pesel: " + rs.getString(1) + ", brutto: " + rs.getDouble(2);
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

	public static void wyswietl() {
		try{
			  String line;
			  connect();
			 stat = conn.createStatement();
		  
			  rs = stat.executeQuery("SELECT * FROM kadry");
		  
			  while(rs.next()) {
				  line = "pesel: " + rs.getString(1) + ", brutto: " + rs.getDouble(2);
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
	
	public static void main(String[] args) throws SQLException {
		createTable();
			
		boolean quit = false;
		int choice;
		
		
		do {
		    System.out.println("------Co chcesz zrobiæ?------");
		    System.out.println("Menu programu:");
		    System.out.println("1. Dodaj pracownika");
		    System.out.println("2. Usuñ pracownika");
		    System.out.println("3. Szukaj pracownika");
		    System.out.println("4. Zmieñ wynagrodzenie brutto");
		    System.out.println("5. Pobierz wynagrodzenie brutto");
		    System.out.println("6. Pobierz wynagrodzenie netto");
		    System.out.println("7. Wyœwietl listê pracowników");
		    System.out.println("8. Posortuj po wynagrodzeniu brutto");
		    System.out.println("9. Zakoñcz");
		    choice = in.nextInt();
		    
		    switch(choice){

		    case 1:
		    	System.out.print("Podaj pesel: ");
		    	String pes = in.next();
		    	if(Pesel.sprawdz(pes)) {
		    		System.out.print("Podaj jego wynagrodzenie brutto");
		    		double brutto = in.nextDouble();
		   
		    		
		    			dodajStudenta(pes, brutto);
		    	}
		    	else
		    		System.out.println("Niepoprawny pesel.");
			break;

		    case 2:
		    	System.out.print("Podaj pesel pracownika, którego chcesz usun¹æ: ");
		    	String p = in.next();
		 
		    	usun(p);
			
			break;

		    case 3:
		    	System.out.print("Podaj pesel pracownika, którego chcesz wyszukaæ: ");
				String pe = in.next();
				
				szukaj(pe);
			break;
			
		    case 4:
		    	System.out.print("Podaj pesel: ");
		    	String _p = in.next();
		    	System.out.print("Podaj jego nowe wynagrodzenie brutto");
		    	double _b = in.nextDouble();
			
				nadpiszBrutto(_p, _b);
			
			break;

		    case 5:
		    	System.out.print("Podaj pesel pracownika, zostanie wyœwietlona kwota brutto: ");
		    	String _pe = in.next();
		    	pobierzBrutto(_pe);
		    	
			break;

		    case 6:
		    	System.out.print("Podaj pesel pracownika, zostanie wyœwietlona kwota netto: ");
		    	String _pes = in.next();
			
		    	pobierzNetto(_pes);
		    	
			break;
			
		    case 7:
		    	wyswietl();
		    	
			break;
			
		    case 8:
		    	sortuj();
		    break;
		    
		    case 9:
			quit = true;
			break;
			
		    default:
			System.out.println("Nieznane polecenie.");
		    }
		    
		}while(!quit);
		System.out.println("Bye-bye!");
	    

	}	
	}
	
	
	

