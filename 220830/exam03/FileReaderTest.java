package exam03;

import java.io.FileReader;

public class FileReaderTest {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("hello.txt");
			int ch;
			while (true) {
				ch = fr.read();
				if (ch == -1)
					break;
				System.out.print((char)ch);
			}
			fr.close();
			
		}catch(Exception e) {
			System.out.println("예외 발생 : " + e.getMessage());
		}

	}

}
