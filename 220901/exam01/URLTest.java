package exam01;

import java.io.InputStream;
import java.net.URL;


public class URLTest {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.hanbit.co.kr/store/books/new_book_list.html");
			
			InputStream is = url.openStream();
			byte data[] = new byte[200];
			String str = "";
			String line = "";
			while (is.read(data) != -1) {
				line += new String(data);
				str += line;
			}
			System.out.println(str);
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

}
