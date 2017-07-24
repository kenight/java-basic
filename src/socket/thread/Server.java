package socket.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// 多线程服务端，单独线程处理客户端连接，多个客户端之间不会阻塞
// 在终端启动服务端:
// package socket.simple
// javac Server.java 编译成 class 文件
// java Server 运行
public class Server {

	ServerSocket serverSocket;
	Socket socket;

	public Server() throws IOException {
		serverSocket = new ServerSocket(10086);
		while (true) {
			socket = serverSocket.accept();
			// 启动多线程处理 socket
			new SocketHandler(socket).start();
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
