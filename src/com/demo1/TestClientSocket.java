package com.demo1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端：
 * 			向服务端发送一个文本数据。
 * 1.创建Socket服务。
 * 2.指定要连接的主机和端口
 * @author admin
 *
 */
public class TestClientSocket {
	public static void main(String[] args) throws IOException, IOException {
		//1，创建客户端的socket服务，指定目的主机和端口。
		Socket s = new Socket("127.0.0.1",10086);
		//2.获取Socket流中的输出流发送数据。
		OutputStream out = s.getOutputStream();
		out.write("hello,world！".getBytes());
		s.close();
	}
}
