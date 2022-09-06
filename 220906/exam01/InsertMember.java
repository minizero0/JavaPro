package exam01;

import java.util.Scanner;

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
		
		try {
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

}
