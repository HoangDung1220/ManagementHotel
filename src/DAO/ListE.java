package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Bean.Employee;

public class ListE {
	public static void createList(Connection conn, List<Employee> list) {
		String query = "select *from employee";
		
		try {
			PreparedStatement ppst = conn.prepareStatement(query);
			ResultSet rs = ppst.executeQuery();
			while (rs.next()) {
				Employee e = new Employee();
				String id1 = rs.getString("IDEmployee");
				String fullname1 = rs.getString("Fullname");
				String icard1 = rs.getString("ICard");
				String sex1 = rs.getString("Sex");
				String phonenumber1 = rs.getString("Phonenumber");
				String address1 = rs.getString("Address");
				String email1 = rs.getString("Email");
				String idrole1 = rs.getString("Role");
				
				e.setAddress(address1);
				e.setEmail(email1);
				e.setFullname(fullname1);
				e.setiCard(icard1);
				e.setiDe(id1);
				e.setPhonenumber(phonenumber1);
				e.setRole(idrole1);
				e.setSex(sex1);
				
				list.add(e);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void del(List<Employee> list,String a) {
		for (Employee i:list) {
			if (i.getiDe().equalsIgnoreCase(a)) {
				list.remove(i);
			}
	}
	}
}
