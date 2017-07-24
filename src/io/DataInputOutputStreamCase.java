package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * 数据处理流
 */
public class DataInputOutputStreamCase {

	@Test
	public void writeAndRead() {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		try {
			dos.writeDouble(Math.random());
			dos.writeBoolean(true);
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			DataInputStream dis = new DataInputStream(bis);
			System.out.println(dis.available()); // 可读的字节数
			System.out.println(dis.readDouble()); // DataInputStream只能按照写入的顺序进行读取
			System.out.println(dis.readBoolean());
			bos.close();
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
