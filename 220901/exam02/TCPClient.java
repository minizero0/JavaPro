package exam02;

import java.io.InputStream;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.0.120", 12000);//서버 아이피 주소 , 포트번호를 매개변수로 서버호출 
																//적합하면 Sever의 socket.accept()가 반환
			InputStream is = socket.getInputStream();			//읽어오기 위한 스트림 생성 
			for (int i = 0; i < 10; i++) {
				System.out.print(is.read() + " ");
			}
			System.out.println(socket.getPort());
			is.close();			//작업이 끝나면 종료해준다.
			socket.close();
			
			
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
	}

}
