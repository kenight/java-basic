package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * 转换流 将字节流装饰一层转换为字符流
 */
public class InputOutputStreamReaderAndWriter {

	@Test
	public void simpleOutputStreamWriter() {
		File file = new File("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\copyfile.txt");
		try {
			FileOutputStream out = new FileOutputStream(file, true); // 追加方式写文件
			OutputStreamWriter osw = new OutputStreamWriter(out); // 将字节输出流转换为字符输出流
			osw.write("I was write something here");
			osw.flush();
			osw.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("write error");
		}
	}

	@Test
	public void transformOutputStreamWriter() {
		File file = new File("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\copyfile.txt");
		try {
			FileOutputStream out = new FileOutputStream(file, true);
			OutputStreamWriter osw = new OutputStreamWriter(out); // 将字节流转换为字符流，可以输出中文
			BufferedWriter bw = new BufferedWriter(osw); // 将字符流装饰为带缓冲的字符流
			bw.write("I was write something here at ");
			bw.write(getTime());
			bw.write(" with ");
			bw.write(osw.getEncoding());
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("write error");
		}
	}

	@Test
	public void transformInputStreamWriter() {
		String input = null;
		InputStream in = System.in; // 建立标准输入流
		InputStreamReader isr = new InputStreamReader(in); // 转换为字符流
		BufferedReader br = new BufferedReader(isr); // 装饰为带缓冲的字符流，可调用readLine方法
		try {
			while ((input = br.readLine()) != null) {
				if (input.equalsIgnoreCase("exit"))
					break;
				System.out.println(input.toUpperCase());
			}
			br.close();
		} catch (IOException e) {
			System.out.println("read error");
		}
	}

	public String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy/MM/dd HH:mm:ss");
		return sdf.format(new Date());
	}

}
