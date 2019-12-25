package daos;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;


public class ShoppingDao 
{

	private DataSource dataSource;
	
	public ShoppingDao()
	{
		try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            this.dataSource = (DataSource) envContext.lookup("jdbc/ridesharedb");
        } catch (NamingException e) {
            System.err.println(e);
        }
	}
	
	
	public Customer getCustomer(int uniqueid)
	{
		Customer data = null;
		try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT id, firstName, lastName, username, password, balance FROM `ridesharedb`.rides WHERE  id ='"+uniqueid+"'");                                                                 
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                double balance = rs.getDouble("balance");
                String username = rs.getString("username");
                String password = rs.getString("password");
                data = new Customer(id,firstName,lastName,username,password,balance);
            }
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
		return data;
	}
	
	
	
	public void updateCustomer(Customer customer)
	{
		try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("UPDATE  `ridesharedb`.rides SET firstName='"+ride.getOrigin()+"' , lastName='"+ride.getDestination()+"' , username='"+ride.getDate()+"' , password='"+ride.getTime()+"' , balance='"+ride.getFare()+"'   WHERE  id ='"+Customer.getId()+"'");                                                                 
            pstmt.executeUpdate();
            
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
		
		
	}
	
	public void deleteRide(int id)
	{
		try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM `ridesharedb`.rides WHERE  id ='"+id+"'");                                                                 
            pstmt.executeUpdate();
            pstmt.close();
            connection.close();
            
        } catch (SQLException e) {
            System.err.println(e);
        }
		
	
	}
	

	public User getUser(int uniqueid)
	{
		User data = null;
		try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT id, username, password, phone, firstname , lastname, role  FROM `ridesharedb`.users WHERE  id ='"+uniqueid+"'");                                                                 
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String role = rs.getString("role");
                data = new User(id,username,password,phone,firstname,lastname,role);
            }
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
		return data;
		
	}
	
	
	
	
	
	
	public User getUserByUserName(String un)
	{
		User data = null;
		
		try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT *  FROM `ridesharedb`.users WHERE  username ='"+un+"'");                                                                 
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
            	int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String role = rs.getString("role");
                data = new User(id,username,password,phone,firstname,lastname,role);
            }
            
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
		
		return data;
	}
	

	
	public List<Ride> getSearchedRides(String from,String to,String date) 
	{
        List<Ride> result = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT id, origin, destination, fare, date , time , user , message FROM `ridesharedb`.rides WHERE origin LIKE '%"+from+"%' AND destination LIKE '%"+to+"%' AND date ='"+date+"'");                                                                 
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String origin = rs.getString("origin");
                String destination = rs.getString("destination");
                double fare = rs.getDouble("fare");
                String travelDate = rs.getString("date");
                String time = rs.getString("time");
                int user = rs.getInt("user");
                String message = rs.getString("message");
                Ride data = new Ride(id,travelDate,origin,destination,fare,time,user,message);
                result.add(data);
            }
            
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return result;
    }
	
	
	
	public Ride saveRide(Ride ride)
	{		
		try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into `ridesharedb`.rides (origin, destination, fare, date, time, user, message) values (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, ride.getOrigin());
            pstmt.setString(2, ride.getDestination());
            pstmt.setDouble(3, ride.getFare());
            pstmt.setString(4, ride.getDate());
            pstmt.setString(5, ride.getTime());
            pstmt.setInt(6, ride.getUser());
            pstmt.setString(7, ride.getMessage());
            pstmt.executeUpdate();
            
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }		
		return ride;
	}
	
	
	public void saveReservation(int rideid,int customerid)
	{
		try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into `ridesharedb`.reservations (rideid, customerid) values (?, ?)");
            pstmt.setInt(1, rideid);
            pstmt.setInt(2, customerid);
            pstmt.executeUpdate();
            
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }	
		
	}
	
	
	
	
	public User saveUser(User user)
	{		
		try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into `ridesharedb`.users (username, password, phone, firstname, lastname, role) values (?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getPhone());
            pstmt.setString(4, user.getFirstname());
            pstmt.setString(5, user.getLastname());
            pstmt.setString(6, user.getRole());
            pstmt.executeUpdate();
            
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }		
		return user;
	}
	
	
	public List<Ride> getRidesByUserName(String username)
	{
		List<Ride> result = new ArrayList<Ride>();
		int userid = getUserByUserName(username).getId();
		
		try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `ridesharedb`.rides WHERE user ='"+userid+"'");                                                                 
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String origin = rs.getString("origin");
                String destination = rs.getString("destination");
                double fare = rs.getDouble("fare");
                String travelDate = rs.getString("date");
                String time = rs.getString("time");
                int user = rs.getInt("user");
                String message = rs.getString("message");
                Ride data = new Ride(id,travelDate,origin,destination,fare,time,user,message);
                result.add(data);
                
                
            }
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
		
		
		return result;
		
	}
	
	public boolean registered(String username,String password)
	{
		
		try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `ridesharedb`.users WHERE  username = '"+username+"'");                                                                 
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	
            	PreparedStatement pstmt2 = connection.prepareStatement("SELECT * FROM `ridesharedb`.users WHERE username = '"+username+"' AND password = '"+password+"'");                                                                 
            	ResultSet rs2 = pstmt2.executeQuery();
            	
            	if(rs2.next() ==false)
            	{
            		return false;
            	}
            	else
            	{
            		return true;
            	}
            	
            }
            
            if(rs.next() == false)
            {
            	return false;
            }
            
            pstmt.close();
            connection.close();
            
        } catch (SQLException e) {
            System.err.println(e);
        }
		
		return true;
	}
	
	/*-----------------*/
	public List<String> getUsersByUserName()
	{
		List<String> result = new ArrayList<String>();
		
		try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `ridesharedb`.users WHERE username =\"username \"");                                                                 
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
               System.out.println(rs.getString("username"));
                String name = rs.getString("username");
                result.add(name);
                
            }
            pstmt.close();
            connection.close();
            
        } catch (SQLException e) {
            System.err.println(e);
        }
		
		
		return result;
		
	}
	
}
