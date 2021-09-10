import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class TheMainClass {
	public static void main(String [] args) {
		insert(11, "Kathi", "vijay", "Samantha",2013,"A.R.Murugados");
		readAllData();
	}
	private static void insert(Integer Id, String Movie_Name , String Actor, String Actress, Integer Year_Of_Release, String Director) {
		  Connection con = DbConnection.connect();
		  PreparedStatement ps = null; 
		  try {
		    String sql = "INSERT INTO Fav_Movie(Id, Movie_Name, Actor, Actress,Year_Of_Release, Director) VALUES(?,?,?,?,?,?) ";
		    ps = con.prepareStatement(sql);
		    ps.setInt(1, Id);
		    ps.setString(2, Movie_Name);
		    ps.setString(3, Actor);
		    ps.setString(4, Actress);
		    ps.setInt(5, Year_Of_Release);
		    ps.setString(6, Director);
		    ps.execute();
		    System.out.println("Data has been inserted!");
		  } catch(SQLException e) {
		    System.out.println(e.toString());
		    // always remember to close database connections
		  } finally {
		    try{
//		      ps.close();
		      con.close();
		    } catch(SQLException e) {
		      System.out.println(e.toString());
		    }
		    
		  }
		}
	private static void readAllData() {
	    Connection con = DbConnection.connect(); 
	    PreparedStatement ps = null; 
	    ResultSet rs = null; 
	    
	    try {
	      String sql = "SELECT * FROM Fav_Movie";
	      ps = con.prepareStatement(sql); 
	      rs = ps.executeQuery();
	      System.out.println("ALL USERS\n");
	      while(rs.next()) {
	        Integer Id = rs.getInt("Id"); 
	        String Movie_Name = rs.getString("Movie_Name"); 
	        String Actor = rs.getString("Actor"); 
	        String Actress = rs.getString("Actress");
	        Integer Year_Of_Release = rs.getInt("Year_Of_Release"); 
	        String Director = rs.getString("Director"); 
	        
	        
	        
	        System.out.println("Id: "+Id);
	        System.out.println("Movie_Name: "+Movie_Name);
	        System.out.println("Actor: "+Actor);
	        System.out.println("Actress: "+Actress);
	        System.out.println("Year_Of_Release: "+Year_Of_Release);
	        System.out.println("Director: "+Director+"\n\n");
	        
	      }
	    } catch(SQLException e) {
	      System.out.println(e.toString());
	    } finally {
	      try {
	        rs.close();
	        ps.close();
	        con.close(); 
	      } catch(SQLException e) {
	        System.out.println(e.toString());
	      }
	    }
	    
	    
	  }


	

}
