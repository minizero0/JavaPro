package homework;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class DeCipher_Map {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(args[0]);
			FileWriter fw = new FileWriter(args[1]);
			
			String key = "DEFGHIJKLMNOPQRSTUVWXYZABC";
			String value = "abcdefghijklmnopqrstuvwxyz";
			
			
			HashMap<String, String> map = new HashMap<>();
			for (int i = 0; i < key.length(); i++) {
				map.put(key.charAt(i)+"", value.charAt(i)+"");
			}
			
			String str = "";
			int ch;
			while((ch = fr.read()) != -1) {
				if (ch >= 'A' && ch <= 'Z') {
					String s = ((char)ch)+"";
					str += map.get(s);
				}
				else {
					str += (char)ch;
				}
			}
			
			fw.write(str);
			fr.close();
			fw.close();
			System.out.println("변환성공");
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

}
