package exam02;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(13000);  //포트번호 설정 휘발성 메모리 할당
			System.out.println("Server Started");
			Thread.sleep(3000);
			while(true) {							//client가 접속할때 까지 무한대기상태 
				Socket socket = server.accept();   //client 접속되면 가동
				System.out.println("Client connect");
				OutputStream os = socket.getOutputStream();	//출력하기위한 스트림 생성
				
				for (int i = 0; i < 10; i++) {
					int r = (int)(Math.random() * 100 + 1);
					os.write(r);
					Thread.sleep(100);
				}
				os.close();					//작업이 끝나면 종료해준다.
				socket.close();
			}
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
	}

}
	