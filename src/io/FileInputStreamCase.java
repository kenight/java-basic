package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

/**
 * 文件字节输入流
 */
public class FileInputStreamCase {

	@Test
	public void readFile() {
		int bt = 0;
		FileInputStream in = null;
		try {
			in = new FileInputStream("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\FileInputStreamCase.java");
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			System.exit(-1); // 终止程序
		}
		try {
			/**
			 * read()方法每次只能读取一个字节，返回 0 到 255 范围内的 int 字节值，所以也只能读取由ASCII码范围内的一些字符
			 * 这些字符主要用于显示现代英语和其他西欧语言 而对于汉字等unicode中的字符则不能正常读取。只能以乱码的形式显示
			 */
			while ((bt = in.read()) != -1) {
				System.out.print((char) bt); // 将读取到的字节转换成字符打印
			}
			in.close();
		} catch (IOException e) {
			System.out.println("read error");
		}
	}

	@Test
	public void readFileByBuffer() {
		int num = 0;
		byte[] buffer = new byte[1024];
		FileInputStream in = null;
		try {
			// in = new
			// FileInputStream("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\FileInputStreamCase.java");
			File file = new File("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\FileInputStreamCase.java");
			in = new FileInputStream(file);
			// read(byte[] buffer)方法以整数形式返回实际读取的<字节数>，而read()是返回字节值
			while ((num = in.read(buffer)) != -1) {
				for (int i = 0; i < num; i++) {
					System.out.print((char) buffer[i]); // 显示每次缓冲区内的内容
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("read error");
		}
	}

}
