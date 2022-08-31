package TeamExam;

import java.io.FileReader;
import java.io.FileWriter;

public class CipherTest {

	public static void main(String[] args) {
		
		try {
			FileReader fr = new FileReader(args[0]);
			FileWriter fw = new FileWriter(args[1]);
			
			int ch;
			String str = "";
			while ((ch = fr.read()) != -1) {
				if (ch >= 120 && ch <= 122)
					ch -= 55;
				else if (ch == 32)
					ch = 32;
				else
					ch -= 29;
				str += (char)ch;
			}
			fw.write(str);
			fr.close();
			fw.close();
			System.out.println("시저 암호로 암호화하였습니다.");
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
	}
}
