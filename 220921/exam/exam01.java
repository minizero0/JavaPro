package exam;

import javax.swing.JFrame;

public class exam01 extends JFrame{
	
	public void book_insert() {
		String sql = "insert into book values(?,?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url 
			
		}catch(Exception e) {
			System.out.println("예외발생"+ e.getMessage());
		}
		
	}
	
	public exam01() {
		
	}
	
	public static void main(String[] args) {
		new exam01();
	}

}
