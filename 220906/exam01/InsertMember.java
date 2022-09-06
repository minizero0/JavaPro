package exam01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
//insert into member values('hong', ;010-111-111','서울시 마포구 서교동');
public class InsertMember {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name,phone,addr;
		System.out.println("setName");
		name = sc.next();
		System.out.println("setPhone");
		phone = sc.next();
		System.out.println("setAddr");
		addr = sc.next();
		
//		System.out.println("이름: " +name+ ",전화: " +phone+",주소: "+addr);
		
		String sql = "insert into member values('"+name+"', '"+phone+"','"+addr+"')";
		
		try {
			//1. jdbc(java database connection)드라이버를 메모리로 로드한
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. db Server에 연결한다.
			Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@172.30.1.3:1521:XE","c##sist0307","sist0307");
			
			//3. SQ명령어를 실행시키기 위한 Statement 객체 생성.
			Statement stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			
			if (re==1) {
				System.out.println("회원의 정보를 추가하였습니다.");
			}else {
				System.out.println("회원의 정보 추가에 실패하였습니다.");
			}
			
			//5. 사용했던 자원들을닫아 준다.
			stmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

}
