package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * 字符缓冲流
 */
public class BufferedReaderAndWriterCase {

	@Test
	public void write() {// 写入内容到文件
		try {
			FileWriter out = new FileWriter("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\copyfile.txt");
			BufferedWriter bw = new BufferedWriter(out);
			bw.write("你好");
			bw.newLine();
			bw.write("maiYo");
			bw.flush();
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("writer error");
		}
	}

	@Test
	public void read() {// 读取文件内容
		String str = null;
		try {
			FileReader in = new FileReader("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\copyfile.txt");
			BufferedReader br = new BufferedReader(in);
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("reader error");
		}
	}

}
