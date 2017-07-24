package io;

import java.io.Serializable;

// 定义一个测试类
// 只有支持 java.io.Serializable 或 java.io.Externalizable 接口的对象才能被存储或从流读取（序列化与反序列化）
public class T implements Serializable {

	private static final long serialVersionUID = 1L;
	int i = 3;
	int k = 1;
	double j = 7.0;
	transient int x = 10; // transient关键字的作用是序列化时忽略该成员变量

}
