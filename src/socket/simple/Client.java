package socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	Socket socket;

	public Client() throws UnknownHostException, IOException {
		// 使用 socket 对服务器发起连接
		socket = new Socket("localhost", 10086);
		// 请求内容
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		System.out.print("Say:");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		pw.write(input.readLine());
		pw.flush();
		// 只关闭流，pw.close 等会直接关闭 socket
		socket.shutdownOutput(); // 不调用此方法，客户端一直处于等待(等待输出流完成)
		// 服务器响应
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println("Server : " + br.readLine());
		// 关闭
		pw.close();
		input.close();
		br.close();
	}

	public static void main(String[] args) {
		try {
			new Client();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
