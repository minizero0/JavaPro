package exam01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpDAO {
	ArrayList<EmpVO> list;
	
	/*
	 * select ename, salary, addr, hiredate
	 * from dept d, emp e
	 * where d.dno = e.dno and dnme = 'deveop1'
	 * 
	 * 부서명을 매개변수로 전달받아 위의 sql을 실행한 결과를
	 * ArrayList에 담아 반환하는 메소드를 정의한다.
	 * ArrayList에 담기는 자료형은 EmpVO로 한다.
	 */
	
	public ArrayList<EmpVO> searchEmp(String dname) {
		String sql = "select ename, salary, addr, hiredate"
				+ "from dept d, emp e"
				+ "where d.dno = e.dno and dname = '"+dname+"'";
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@172.30.1.3:1521:XE";
			String usr = "c##madang";
			String pwd = "madang";
			
			Connection conn = DriverManager.getConnection(url,usr,pwd);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String ename = rs.getString(1);
				int salary = rs.getInt(2);
				String addr = rs.getString(3);
				Date date = rs.getDate(4);
				list.add(new EmpVO(ename, salary, addr, date));
			}
			
			conn.close();
			stmt.close();
			rs.close();
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}

}
