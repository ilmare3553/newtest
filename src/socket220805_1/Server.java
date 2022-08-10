package socket220805_1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket server=new ServerSocket(11115);
		System.out.println("학사 서버 대기중...");
		Socket client=server.accept();
		System.out.println("학사 클라이언트 접속");
		
		InputStream is=client.getInputStream();
		ObjectInputStream ois=new ObjectInputStream(is);
		
		Classinfo ci=(Classinfo) ois.readObject();
		String id=ci.getId();
		String name=ci.getName();
		int kor=ci.getKor();
		int eng=ci.getEng();
		int math=ci.getMath();
		System.out.println("학번:"+id+"\n이름:"+name+"\n국어성적:"+kor+"\n영어성적:"+eng+"\n수학성적:"+math);
		
		ClassinfoDAO.getInstance().insert(ci);
		
		
		ois.close();
		is.close();
		client.close();
		server.close();

	}

}
