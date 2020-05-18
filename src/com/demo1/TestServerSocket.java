package com.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端：
 * 		1.建立服务端的socket服务，ServSocket（）并监听一个端口。
 * 		2.获取连接过来的客户端对象
 * 		3.客户端发来数据，服务端用对应的客户端对象，并获取到该客户端对象的读取流来读取发过来的数据
 * 		4.关闭服务端(可以关也可以不关)
 * @author admin
 *
 */
public class TestServerSocket {
	public static void main(String[] args) throws IOException {
		//1.建立服务端Socket服务，监听一个端口号（最大值为65535）
		ServerSocket server = new ServerSocket(10086);
		//2.获取连接过来的客户对象
		Socket client = server.accept();
		System.out.println("ip"+client.getInetAddress().getHostAddress());
		//3.使用客户端对象的读取流来读取客户端发送的数据。
		InputStream in = client.getInputStream();
		
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));
		client.close();
		
	}
}
