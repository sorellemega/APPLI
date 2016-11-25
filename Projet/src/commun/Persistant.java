package commun;


	import java.awt.Dimension;
	import java.awt.Toolkit;
	import java.beans.Statement;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.ResultSetMetaData;
	import java.sql.SQLException;
	import java.util.ArrayList;

	public class Persistant {
		
		/**
		 * @author Hugues
		 *
		 */
		static final String DRIVER = "org.postgresql.Driver";
		static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/VideoClub";
		static final String USER = "postgres";
	    static final String PASSWD = "VideoClub";
	    static final Connection CONNECTION = getConnection();
	    static ArrayList result = null;
	    static Statement statement = null;
	   
		
		Persistant() 
		{
		
		} 
		


		 public static ArrayList getData(String sqlRequest, Connection connection){
			 ArrayList arraylist = new ArrayList();
			ResultSet resultat = null;
			java.sql.Statement statement = null;
			   try {
				       statement = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
				      resultat = statement.executeQuery(sqlRequest);
				      }

				      catch (SQLException slqException) 
					    {
					    	slqException.printStackTrace();
					    }
			 arraylist.add(0, statement);
			 arraylist.add(1, resultat);
		 return arraylist;    
					   
		 }
		 
		 public static Connection getConnection(){

		
			 Connection connection = null;
			   try {
				      Class.forName(DRIVER);
				       connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWD);
				      }
					    catch (ClassNotFoundException | SQLException e) 
					    {
					    	e.printStackTrace();
					    } 
					   return connection; 
		 }
		 

	public static int resourceSize( String sqlRequest)
	{
		 int count=0;
		 try{
			 
			  result = Persistant.getData(sqlRequest, Persistant.CONNECTION);
			  ((ResultSet) Persistant.result.get(1)).last();
			  count =  ((ResultSet) Persistant.result.get(1)).getRow();	
			}
		 catch (Exception e) {
		      e.printStackTrace();
		    }  
		 return count; 
		 
	}
	}

