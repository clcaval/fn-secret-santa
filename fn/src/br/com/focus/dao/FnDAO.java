package br.com.focus.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.focus.dto.Person;

public class FnDAO {
	
	public void teste() throws Exception
	{
				
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		Statement stat = conn.createStatement();
        ResultSet rs;
        rs = stat.executeQuery("select * from person");
        
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
        stat.close();
        conn.close();
			        
	}
	
	public List<Person> getPerson() throws Exception
	{
		
		List<Person> list = new ArrayList<Person>();
		Person p;
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		Statement stat = conn.createStatement();
        ResultSet rs;
        rs = stat.executeQuery("select * from person");
        
        while (rs.next()) {
            p = new Person();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setEmail(rs.getString("email"));
            list.add(p);
        }
        
        stat.close();
        conn.close();
        
		return list;
			        
	}
	
	public Person createPerson(Person p) throws Exception
	{
		
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		Statement stat = conn.createStatement();
		int maxId = getMaxId();
		p.setId(maxId+1);
        String q = String.format("insert into person values (%s, '%s', '%s')", 
        		p.getId(), p.getName(), p.getEmail());
        stat.executeUpdate(q);
                
        stat.close();
        conn.close();
		return p;
	}
	
	private int getMaxId() throws Exception
	{
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		Statement stat = conn.createStatement();
        ResultSet rs;
        rs = stat.executeQuery("select max(id) id from person");
        int maxId = 0;
        while (rs.next()) {
            maxId = rs.getInt("id");
        }
        stat.close();
        conn.close();
		return maxId;
	}
	
}
