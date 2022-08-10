package socket220805_1;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		Socket socket=new Socket("192.168.0.66",11115);
		System.out.println("학사 클라이언트");
		
		OutputStream os=socket.getOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(os);
		
		Classinfo ci=new Classinfo();
		ci.setId("030101");
		ci.setName("홍길동");
		ci.setKor(100);
		ci.setEng(90);
		ci.setMath(80);
		
		oos.writeObject(ci);
		
		oos.flush();
		oos.close();
		os.close();
		socket.close();

	}

}
