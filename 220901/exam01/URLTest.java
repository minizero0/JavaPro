package exam01;

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;


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
				Arrays.fill(data, (byte)0);   //배열 초기화
			}
			System.out.println(str);
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

}
