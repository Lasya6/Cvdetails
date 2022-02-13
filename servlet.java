package in.ac.vce;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Assign2q2
 */
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		Connection con = jdbc.initializeDatabase();
		PreparedStatement s1=con.prepareStatement("insert into details values(?,?,?,?,?,?,?,?,?,?,?,?)");
		String fullname= request.getParameter("fullname");
		String objective= request.getParameter("objective");
		String branch =request.getParameter("branch");
		String course =request.getParameter("course");
		String college =request.getParameter("college");
		double cgpa =Double.parseDouble(request.getParameter("cgpa"));
		int yop =Integer.parseInt(request.getParameter("yop"));
		
		String role=request.getParameter("role");
		String company =request.getParameter("company");
		
		String role1=request.getParameter("role1");
		String company1 =request.getParameter("company1");
		int exp1 =Integer.parseInt(request.getParameter("exp1"));
		
		s1.setString(1,fullname);
		s1.setString(2,objective);
		s1.setString(3,course);
		s1.setString(4,branch);s1.setString(5,college);s1.setDouble(6,cgpa);s1.setInt(7,yop);
		s1.setString(8,role);s1.setString(9,company);
		s1.setString(10,role1);s1.setString(11,company1);s1.setInt(12,exp1);
	    s1.executeUpdate();

		PreparedStatement s2=con.prepareStatement("insert into accomplishments values(?)");
		String acc1=request.getParameter("acc1");
		String acc2=request.getParameter("acc2");
		String acc3=request.getParameter("acc3");
		String acc4=request.getParameter("acc4");
		s2.setString(1,acc1);s2.executeUpdate();s2.setString(1,acc2);s2.executeUpdate();s2.setString(1,acc3);s2.executeUpdate();s2.setString(1,acc4);
		s2.executeUpdate();
		
		PreparedStatement s3=con.prepareStatement("insert into skills values(?)");
		String skl1=request.getParameter("skl1");
		String skl2=request.getParameter("skl2");
		String skl3=request.getParameter("skl3");
		String skl4=request.getParameter("skl4");
		String skl5=request.getParameter("skl5");
		s3.setString(1,skl1);s3.executeUpdate();s3.setString(1,skl2);s3.executeUpdate();s3.setString(1,skl3);s3.executeUpdate();s3.setString(1,skl4);s3.executeUpdate();s3.setString(1,skl5);
		s3.executeUpdate();
		
		
		PreparedStatement s4=con.prepareStatement("insert into projects values(?)");
		
		String[] projects = request.getParameterValues("project");
		
		for(String s:projects) {
		s4.setString(1,s);
		s4.executeUpdate();
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}

