package in.ac.vce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
	protected static Connection initializeDatabase() throws Exception
	{
		
		
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cv","root","");
			System.out.println(con);
			Statement s = con.createStatement();
String str1 = "CREATE TABLE DETAILS (FULLNAME VARCHAR(20), OBJECTIVE VARCHAR(1000), COURSE VARCHAR(10),  BRANCH VARCHAR(10),COLLEGE VARCHAR(20), CGPA DOUBLE(5,2), YOP NUMERIC(4),IROLE VARCHAR(30), ICOMPANY VARCHAR(10),JROLE VARCHAR(30), JCOMPANY VARCHAR(10),JEXP NUMERIC(5)); ";
			s.execute(str1);
			System.out.println("Table DETAILS created!!");
			String str2 = "CREATE TABLE ACCOMPLISHMENTS (ACCOMPLISHMENTS VARCHAR(100));";
			s.execute(str2);
			System.out.println("Table ACCOMPLISHMENTS created!!");
			String str3 = "CREATE TABLE SKILLS (SKILLS VARCHAR(20));";
			s.execute(str3);
			System.out.println("Table SKILLS created!!");
			String str4 = "CREATE TABLE PROJECTS (PROJECTS VARCHAR(20));";
			s.execute(str4);
			System.out.println("Table PROJECTS created!!");

		return con;
	}

}
