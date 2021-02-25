package kr.green.spring.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;


public class SampleTest {
	
	
	@Test
	public void testExist() {
		Connection con = null;
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =
					DriverManager.getConnection("jdbc:mysql://localhost:3306/spring?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","cjgreen");
			System.out.println("성공");
			Statement stmt = con.createStatement();

		}catch(Exception e) {
			System.out.println("실패");
			System.out.println(e.getMessage());
		}

	}
}
