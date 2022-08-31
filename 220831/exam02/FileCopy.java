package exam02;

import java.io.FileReader;
import java.io.FileWriter;

//java FileCopy a.txt b.txt
public class FileCopy {

	public static void main(String[] args) {
		String from = args[0];
		String to = args[1];
		
		try {
			FileReader fr = new FileReader(from);
			FileWriter fw = new FileWriter(to);
			
			int ch;
			String str = "";
			while ((ch = fr.read()) != -1) {
				str += (char)ch;
			}
			
			fw.write(str);
			
			fr.close();
			fw.close();
			
			System.out.println("파일복사완료.");
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

}
