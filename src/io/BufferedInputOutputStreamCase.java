package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * 字节缓冲流
 */
public class BufferedInputOutputStreamCase {

	@Test
	public void input() {
		int bt = 0;
		try {
			FileInputStream in = new FileInputStream("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\BufferedInputOutputStreamCase.java");
			BufferedInputStream bis = new BufferedInputStream(in);
			while ((bt = bis.read()) != -1) { // 读取内部缓冲区byte[]中pos++(下一位置)的字节值
				System.out.print((char) bt);
			}
			bis.close(); // 关闭字节缓冲流(都将关闭InputStream，in.close、bis.close任用其一即可)
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("read error");
		}
	}

	@Test
	public void output() {
		int bt = 0;
		try {
			FileInputStream in = new FileInputStream("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\BufferedInputOutputStreamCase.java");
			BufferedInputStream bis = new BufferedInputStream(in);
			FileOutputStream out = new FileOutputStream("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\copyfile.txt");
			BufferedOutputStream bos = new BufferedOutputStream(out);
			while ((bt = bis.read()) != -1) {
				out.write(bt);
			}
			bis.close();
			bos.flush();
			bos.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("write error");
		}
	}

}
