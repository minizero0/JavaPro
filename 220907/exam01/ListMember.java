package exam01;

import javax.swing.JFrame;

public class ListMember extends JFrame{

	public static void main(String[] args) {
		String sql = "select name,phone,addr from member";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			
			
		}catch(Exception e) {
			System.out.println("예외발생:"+ e.getMessage());
		}
	}

}
