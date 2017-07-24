package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

/**
 * 对象流（ObjectInputStream序列化、ObjectOutputStream反序列化）
 */
public class ObjectInputOutputStreamCase {

	@Test
	public void writeObject() {
		T t = new T(); // 将T对象写入文件存储（就是对它作序列化）
		t.k = 20;
		try {
			FileOutputStream fos = new FileOutputStream("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\copyfile.txt");
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(t);
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("write error");
		}
	}

	@Test
	public void readObject() {
		try {
			FileInputStream in = new FileInputStream("E:\\jeeroot\\maiyo-demo-commons\\src\\org\\j2se\\io\\copyfile.txt");
			ObjectInputStream ois = new ObjectInputStream(in);
			T t = (T) ois.readObject();
			System.out.println("i = " + t.i);
			System.out.println("k = " + t.k);
			System.out.println("j = " + t.j);
			System.out.println("x = " + t.x);
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("read error");
		} catch (ClassNotFoundException e) {
			System.out.println("class not found");
		}
	}

}
