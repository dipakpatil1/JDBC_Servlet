package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProduct extends GenericServlet {
	
	public void service(ServletRequest req,ServletResponse res)throws ServletException ,IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		RetrieveProductDAO ob = new RetrieveProductDAO();
		 ArrayList<ProductBean> al = ob.retrieve();
		 
		 if(al.size()==0)
		 {
			 pw.println("Product Not Available...<br>");
		 }
		 else
		 {
			 Iterator<ProductBean> it=al.iterator();
			 while(it.hasNext())
			 {
				 ProductBean pb=it.next();
				 pw.println(pb.getNo()+"&nbsp&nbsp"+pb.getName()+"&nbsp&nbsp"+pb.getPrice()+"&nbsp&nbsp"+pb.getQty()+"<br");
			 }
		 }
		 RequestDispatcher rd = req.getRequestDispatcher("link.html");
		 rd.include(req, res);
	}

}
