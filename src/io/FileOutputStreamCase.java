package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * 文件字节输出流
 */
public class FileOutputStreamCase {

	@Test
	public void copyFile() {
		String result = "sucess";
		int bt = 0;
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\FileOutputStreamCase.java");
			out = new FileOutputStream("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\copyfile.txt");
			while ((bt = in.read()) != -1) {
				out.write(bt);
			}
			in.close();
			out.flush(); // 刷新此输出流并强制写出所有缓冲在内存中的输出字节
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			result = "faild";
		} catch (IOException e) {
			System.out.println("copy file error");
			result = "faild";
		}
		System.out.println("file copy " + result);
	}

	@Test
	public void copyFileByBuffer() {
		String result = "sucess";
		int num = 0;
		byte[] buffer = new byte[1024];
		File file = null;
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			file = new File("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\FileOutputStreamCase.java");
			in = new FileInputStream(file);
			out = new FileOutputStream("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\copyfile.txt");
			while ((num = in.read(buffer)) != -1) {
				out.write(buffer, 0, num);
			}
			in.close();
			out.flush(); // 刷新此输出流并强制写出所有缓冲在内存中的输出字节
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			result = "faild";
		} catch (IOException e) {
			System.out.println("copy file error");
			result = "faild";
		}
		System.out.println(file.getName() + " copy " + result);
	}

}
