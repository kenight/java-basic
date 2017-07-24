package socket.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

// 启动多线程处理 accept 到的 socket
public class SocketHandler extends Thread {

	private Socket socket;

	public SocketHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			accept(this.socket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void accept(Socket socket) throws IOException {
		BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String msg = socketIn.readLine();
		System.out.println("Client: " + msg);
		socketIn.close();
	}

}
