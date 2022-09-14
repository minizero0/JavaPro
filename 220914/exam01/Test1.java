package exam01;

import java.sql.Date;
import java.util.ArrayList;

public class Test1 {

	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpVO> list = dao.searchEmp("develop1");
		for(EmpVO e: list) {
			String ename = e.getEname();
			int salary = e.getSalary();
			String addr = e.getAddr();
			Date date = e.getHiredate();
			String row = ename + "," + salary+","+addr+","+date;
			System.out.println(row);
		}
	}

}
