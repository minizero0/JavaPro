package homework;

import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class RandomFile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max,line,n;
		String fname;
		
		System.out.println("난수의 최대값을 입력 :");
		max = sc.nextInt();
		System.out.println("한줄에 출력할 난수의 개수 :");
		line = sc.nextInt();
		System.out.println("난수의 개수 :" );
		n = sc.nextInt();
		System.out.println("파일 이름");
		fname = sc.next();
		
		Random rand = new Random();		
		

		String str = "";
		for(int i = 1; i <= n; i++) {
//			str += rand.nextInt(max)+1;
			str += (int)(Math.random() * max + 1) + " ";
			if (i % line == 0) {
				str += "\n";
			}
		}
		try {
			FileWriter fw = new FileWriter(fname);
			fw.write(str);
			fw.close();
			System.out.println("파일 생성완료");
		}catch(Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
	}

}
