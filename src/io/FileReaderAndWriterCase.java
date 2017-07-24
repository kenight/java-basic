package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * 文件字符输出输入流
 */
public class FileReaderAndWriterCase {

	@Test
	public void fileReader() {
		int bt = 0;
		FileReader rd = null;
		try {
			rd = new FileReader("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\FileReaderAndWriterCase.java");
			// 字符流能够正确读取中文字符
			while ((bt = rd.read()) != -1) {
				System.out.print((char) (bt));
			}
			rd.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("read error");
		}
	}

	@Test
	public void fileWriter() {
		String result = "sucess";
		int num = 0;
		char[] buffer = new char[1024];
		File fileIn = null;
		File fileOut = null;
		FileReader rd = null;
		FileWriter wt = null;
		try {
			fileIn = new File("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\FileReaderAndWriterCase.java");
			fileOut = new File("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\copyfile.txt");
			rd = new FileReader(fileIn);
			wt = new FileWriter(fileOut);
			while ((num = rd.read(buffer)) != -1) {
				wt.write(buffer, 0, num);
			}
			rd.close();
			wt.flush();
			wt.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			result = "faild";
		} catch (IOException e) {
			System.out.println("copy file error");
			result = "faild";
		}
		System.out.println(fileIn.getName() + " copied to " + fileOut.getName() + " was " + result);
	}

}
