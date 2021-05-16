package es.upm.dit.isst.resumen.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.resumen.model.RESUMEN;


@WebServlet("/FormBorrarServlet")
public class FormBorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
        String title = request.getParameter("title");
        String name = request.getParameter("name");
        
		// JDBC driver name and database URL 
		   String JDBC_DRIVER = "org.h2.Driver";   
		   String DB_URL = "jdbc:h2:tcp://localhost/~/resumen";  
		   
		   //  Database credentials 
		   String USER = "sa"; 
		   String PASS = "sa"; 
		   
		      Connection conn = null; 
		      Statement stmt = null; 
		      try { 
		         // STEP 1: Register JDBC driver 
		         Class.forName(JDBC_DRIVER); 
		             
		         //STEP 2: Open a connection 
		         System.out.println("Connecting to database..."); 
		         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
		         
		         //STEP 3: Execute a query 
		         System.out.println("Creating table in given database..."); 
		         stmt = conn.createStatement(); 
		         String sql =  "DELETE FROM RESUMEN WHERE NAME='" + name +  "' AND TITLE='"+ title +"'";  
		         stmt.executeUpdate(sql);
		         System.out.println("Created table in given database..."); 
		         
		         // STEP 4: Clean-up environment 
		         stmt.close(); 
		         conn.close(); 
		      } catch(SQLException se) { 
		         //Handle errors for JDBC 
		         se.printStackTrace(); 
		      } catch(Exception e) { 
		         //Handle errors for Class.forName 
		         e.printStackTrace(); 
		      } finally { 
		         //finally block used to close resources 
		         try{ 
		            if(stmt!=null) stmt.close(); 
		         } catch(SQLException se2) { 
		         } // nothing we can do 
		         try { 
		            if(conn!=null) conn.close(); 
		         } catch(SQLException se){ 
		            se.printStackTrace(); 
		         } //end finally try 
		      } //end try 
		      System.out.println("Goodbye!");
    
        getServletContext().getRequestDispatcher("/FormLoginServlet?email=root&password=root").forward(request,response);
        return;

     }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
