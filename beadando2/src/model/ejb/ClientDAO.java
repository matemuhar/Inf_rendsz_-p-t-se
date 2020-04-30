package model.ejb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import model.Client;

/**
 * Session Bean implementation class ClientDAO
 */
@Stateless
@LocalBean
public class ClientDAO {
	
	@Resource(name="jdbc/clientDB")
	private DataSource ds;
	
	public void addClient(Client client) {
		String sql = "INSERT INTO CLIENT VALUES('"+ client.getClientID() +"', '"+ client.getName() +"', '"+ client.getPhoneNumber() +"', '"+ client.getAddress() + "')";
		executeModifyQuery(sql);
	}
	
	public void editClient(Client client) {
		String sql = "UPDATE CLIENT SET NAME='"+ client.getName() +"', PHONENUMBER= '"+ client.getPhoneNumber() +"', ADDRESS= '"+ client.getAddress() +"' WHERE CLIENTID='"+ client.getClientID();
		executeModifyQuery(sql);
	}
	
	public void deleteClient(Client client) {
		String sql = "DELETE FROM CLIENT WHERE CLIENTID='"+ client.getClientID() +"'";
		executeModifyQuery(sql);
	}
	
	public Client getClient(String id) {
		Client client = new Client();
		String sql = "SELECT * FROM CLIENT WHERE CLIENTID='"+ id +"'";
		System.out.println(sql);
		ResultSet rs = executeFetchQuery(sql);
		try {
			if (rs.next()) {
				client.setClientID(rs.getString("CLIENTID"));
				client.setName(rs.getString("NAME"));
				client.setPhoneNumber(rs.getString("PHONENUMBER"));
				client.setAddress(rs.getString("ADDRESS"));
			}			
		} catch (SQLException ex) {
			System.err.println("GS" + ex.getMessage());
		}
		return client;
	}
	
	public ArrayList<Client> getAllClient() {
		ArrayList<Client> list = new ArrayList<Client>();
		String sql = "SELECT * FROM CLIENT";
		ResultSet rs = executeFetchQuery(sql);
		try {
			while (rs.next()) {
				Client client = new Client();
				client.setClientID(rs.getString("CLIENTID"));
				client.setName(rs.getString("NAME"));
				client.setPhoneNumber(rs.getString("PHONENUMBER"));
				client.setAddress(rs.getString("ADDRESS"));
				list.add(client);
			}			
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return list;
	}
	
	public void executeModifyQuery(String sql) {
		try {
			Connection conn = ds.getConnection();
			conn.createStatement().execute(sql);
			conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public ResultSet executeFetchQuery(String sql) {
		ResultSet rs = null;
		try {
			Connection conn = ds.getConnection();
			rs = conn.createStatement().executeQuery(sql);
			conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return rs;
	}
}
