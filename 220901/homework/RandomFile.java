package homework;

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
		
		
				

	}

}
