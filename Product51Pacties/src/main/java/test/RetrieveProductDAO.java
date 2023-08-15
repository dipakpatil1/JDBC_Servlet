package test;

import java.util.*;
import java.sql.*;
public class RetrieveProductDAO {
	
	public ArrayList< ProductBean> al= new ArrayList<ProductBean>();
	
	public ArrayList<ProductBean> retrieve()
	{
		try
		{
			Connection con= DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement("select * from Product");
			ResultSet rs= ps.executeQuery();	
			
			while(rs.next())
			{
				ProductBean pb = new ProductBean();
				pb.setNo(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getInt(3));
				pb.setQty(rs.getInt(4));
				
				al.add(pb);
			}
			
			}
		catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		return al;
	}

}
