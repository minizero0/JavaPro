package exam01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Team {
	
	public Team() {
		Scanner sc = new Scanner(System.in);
		System.out.println("조회할 부서를 입력하세요.");
		String name = sc.next();
		String sql = "select ename, salary, addr, hiredate from emp e, dept d where e.dno = d.dno and dname = '"+name+"'";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##madang";
			String pwd = "madang";
			
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String a = rs.getString(1);
				int b = rs.getInt(2);
				String c = rs.getString(3);
				Date d = rs.getDate(4);
				System.out.println("이름: " +a+ ", 급여: " + b + ", 주소: " + c + ", 입사일: " + d);
			}
			conn.close();
			stmt.close();
			rs.close();
			
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new Team();
	}
}
