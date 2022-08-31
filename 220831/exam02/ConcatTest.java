package exam02;

import java.io.FileReader;
import java.io.FileWriter;

public class ConcatTest {

	public static void main(String[] args) {
		String s1 = args[0];
		String s2 = args[1];
		String s3 = args[2];
		
		try {
			FileReader fr1 = new FileReader(s1);
			FileReader fr2 = new FileReader(s2);
			FileWriter fw = new FileWriter(s3);
			
			int ch;
			String str = "";
			while((ch = fr1.read()) != -1) {
				str += (char)ch;
			}
			
			while((ch = fr2.read()) != -1) {
				str += (char)ch;
			}
			fw.write(str);
			
			
			fr1.close();
			fr2.close();
			fw.close();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}

	}

}
