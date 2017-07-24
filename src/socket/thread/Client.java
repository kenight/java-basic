package socket.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	Socket socket;

	public Client() throws UnknownHostException, IOException {
		// 连续发送
		while (true) {
			send();
		}
	}

	private void send() throws IOException {
		socket = new Socket("localhost", 10086);
		PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
		System.out.print("Say: ");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		socketOut.write(input.readLine());
		socketOut.close();
	}

	public static void main(String[] args) {
		try {
			new Client();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
