package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * 打印流 提供重载的print、println方法用于多种数据类型的输出
 * PrintWriter、printStream有自动flush功能
 */
public class PrintCase {

	// 修改默认system.out的输出方式(默认是控制台打印)
	@Test
	public void print1() {
		try {
			FileOutputStream out = new FileOutputStream("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\copyfile.txt");
			PrintStream ps = new PrintStream(out);
			System.setOut(ps);
			System.out.println((char) 112); // 打印一个ASCII字符p
			ps.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
	}

	// 将指定文件内容通过指定的输出流进行打印
	@Test
	public void print2() {
		// 指定文件
		String fileName = "E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\PrintCase.java";
		// 指定输出流
		PrintStream ps = null;
		try {
			ps = new PrintStream("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\copyfile.txt");
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		// if (fileName != null) printOut(fileName, System.out);
		if (fileName != null)
			printOut(fileName, ps);
	}

	// 接受键盘输入，并记录在指定文件中
	@Test
	public void print3() {
		String s = null;
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		try {
			PrintWriter log = new PrintWriter("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\copyfile.txt");
			while ((s = br.readLine()) != null) {
				if (s.equalsIgnoreCase("exit")) break; // exit结束程序
				log.println(s);
			}
			log.println("------------------");
			log.println(getTime());
			log.flush();
			log.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("read error");
		}
	}

	private String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy/MM/dd HH:mm:ss");
		return sdf.format(new Date());
	}

	private static void printOut(String fileName, PrintStream out) {
		String s = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((s = br.readLine()) != null) {
				out.println(s);
			}
			br.close();
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("read error");
		}
	}

}
