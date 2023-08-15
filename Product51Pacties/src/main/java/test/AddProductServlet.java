package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/add")
@SuppressWarnings("serial")
public class AddProductServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ProductBean pb= new ProductBean();
		pb.setNo(req.getParameter("no"));
		pb.setName(req.getParameter("name"));
		pb.setPrice(Integer.parseInt(req.getParameter("price")));
		pb.setQty(Integer.parseInt(req.getParameter("qty")));
		
		AddProductDAO apd=new AddProductDAO();
		
		int k =apd.insert(pb);
		System.out.println("k = "+k);
		if(k>0)
		{
			pw.println("Product Addded Successfully...<br>");
			
			RequestDispatcher rd= req.getRequestDispatcher("link.html");
			rd.include(req, res);
		}
		else pw.print("No added into DB");
	}

	 

}
