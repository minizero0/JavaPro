package exam02;

import java.io.FileReader;
import java.io.FileWriter;

public class ConcatTest {

	public static void main(String[] args) {
		
		try {
			FileReader fr1 = new FileReader(args[0]);
			FileReader fr2 = new FileReader(args[1]);
			FileWriter fw = new FileWriter(args[2]);
			
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
