package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

/**
 * 随机访问文件的读取和写入
 */
public class RandomAccessFileCase {

	@Test
	public void wirteRecord() {
		try {
			RandomAccessFile raf = new RandomAccessFile(initFile("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\record.dat"), "rw");
			raf.writeUTF("maiyo");
			raf.writeChar(':');
			raf.writeInt(22);
			raf.seek(0); // 将文件指针移至文件起始处，开始读取数据
			System.out.println(raf.readUTF());
			raf.skipBytes(2); // 将指针跳过2个字节
			System.out.println("当前指针位置" + raf.getFilePointer()); // 显示当前指针位置
			System.out.println(raf.readInt());
			raf.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("write error");
		}
	}

	@Test
	public void copyFile() { // 比较与copyfile2运行性能
		int num = 0;
		byte[] buffer = new byte[1024];
		try {
			RandomAccessFile in = new RandomAccessFile(initFile("C:\\Windows\\explorer.exe"), "r");
			RandomAccessFile out = new RandomAccessFile(initFile("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\copyfile.txt"), "rw");
			long start = System.currentTimeMillis(); // 开始时间
			while ((num = in.read(buffer)) != -1) {
				out.write(buffer, 0, num);
			}
			long end = System.currentTimeMillis(); // 结束时间
			in.close();
			out.close();
			System.out.println("复制时间:" + (double) (end - start) / 1000);
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("copy error");
		}
	}

	@Test
	public void copyfile2() {
		int num = 0;
		byte[] buffer = new byte[1024];
		try {
			FileInputStream in = new FileInputStream("C:\\Windows\\explorer.exe");
			BufferedInputStream bis = new BufferedInputStream(in);
			FileOutputStream out = new FileOutputStream("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\copyfile.txt");
			BufferedOutputStream bos = new BufferedOutputStream(out);
			long start = System.currentTimeMillis(); // 开始时间
			while ((num = bis.read(buffer)) != -1) {
				out.write(buffer, 0, num);
			}
			long end = System.currentTimeMillis(); // 结束时间
			bis.close();
			bos.flush();
			bos.close();
			System.out.println("复制时间:" + (double) (end - start) / 1000);
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("copy error");
		}
	}

	public File initFile(String filePath) {
		File record = null;
		try {
			record = new File(filePath);
			if (!record.exists())
				record.createNewFile();
		} catch (IOException e1) {
			System.out.println("create file error");
		}
		return record;
	}

}
