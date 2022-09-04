package exam01;

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

public class UrlTest1 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.hanbit.co.kr/store/books/new_book_list.html");
			
			InputStream is = url.openStream();
			byte data[] = new byte[200];
			String s = "";
			String line = "";
			
			while(is.read(data)!=-1) {
				line += new String(data);
				s += line;
				Arrays.fill(data, (byte)0);
			}
			System.out.println(s);
			is.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
