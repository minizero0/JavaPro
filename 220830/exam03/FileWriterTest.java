package exam03;

import java.io.FileWriter;

public class FileWriterTest {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("hello.txt");
			fw.write("hello java");
			fw.close();
			System.out.println("make file successfully");
		}catch (Exception e) {
			System.out.println("μμΈλ°μ: " +  e.getMessage());
		}
	}

}
