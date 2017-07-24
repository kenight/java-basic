package socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 单线程，在同时连接两个以上客户端时，只能按顺序接受客户端 socket
// 如两个客户端连接后，后面的先发送信息，则会阻塞
// 在终端启动服务端:
// 移除 package socket.simple
// javac Server.java 编译成 class 文件
// java Server 运行
public class Server {

	ServerSocket serverSocket;
	Socket socket;

	public Server() throws IOException {
		serverSocket = new ServerSocket(10086);
		// 调用 accept 时才开始监听，等待客户端 socket 连接并将得到的信息包装成 socket 对象返回，否则一直阻塞
		while (true) {
			socket = serverSocket.accept();
			// 接受客户端信息
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("Client : " + br.readLine());
			// 反馈
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.write("Received.");
			pw.flush();
			// 关闭
			br.close();
			pw.close();
		}
	}

	public static void main(String[] args) {
		try {
			new Server();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
