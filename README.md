# 网络编程

## 概述

- Java是 Internet 上的语言，它从语言级上提供了对网络应用程序的支持，程序员能够很容易开发常见的网络应用程序。
- Java提供的网络类库，可以实现无痛的网络连接，联网的底层细节被隐藏在 Java 的本机安装系统里，由 JVM 进行控制。并且 Java 实现了一个跨平台的网络库，程序员面对的是一个统一的网络编程环境。

### 1、TCP/IP协议

- TCP是**面向连接**的协议，在正式收发数据前，必须和对方建立可靠的连接，所以速度会**慢**；UDP是**面向无连接**的协议，不与对方建立连接，而是直接就发送数据包，相对速度**快**；

- TCP提供IP环境下的数据**可靠传输，**保证数据无差错的、按照顺序的进行传输；UDP的传输是**不可靠**的，不保证数据正确，不保证顺序等，也可能丢包；
- TCP使用**字节流模式**发送数据，UDP使用**数据报模式**; 
- TCP适用对**可靠性要求高**的应用环境；UDP适用于一次只传送**少量数据、对可靠性要求不高**的应用环境；

### 2、Socket

​		大部分计算机都已经连接到互联网，在此基础上只需考虑如何编写数据传输程序。操作系统提供了Socket，不需要对网络数据传输原理很熟悉，也能通过Socket来编程。Socket在编程中被翻译为“套接字”，它是计算机之间通信的一种约定或一种方式，一台pc可以接受其他pc的数据，也可想向其他pc发送数据。

​		例如把插头插到插座上就可以从电网中获得电力供应，同样与远程计算机数据传输，需要连接到因特网，而Socket就是连接到因特网的工具。

​		典型应用：web服务器、浏览器；浏览器获取用户输入的URL，向服务器发送请求，服务器分析接收到的URL，将对应的网页内容返回给浏览器，浏览器再经过解析和渲染，将文字、图片、视频等元素呈现給用户。

​		学习Scoket就是学习计算机之间如何通信，编写出便于使用的程序。

### 3、响应状态码

- 200 ：找到了该资源，并且一切正常；
- 401： 客户端无权访问该资源。这通常会使得浏览器要求用户输入用户名和密码，以登录到服务器；
- 403 ：客户端未能获得授权。通常是在401之后输入了不正确的用户名或密码；
- 404 ：在指定的位置不存在所申请的资源；
- 500： 内部服务器错误 ；

# Socket案例

创建客户端：

向服务端发送一个文本数据。

1.创建Socket服务。

2.指定要连接的主机和端口
```java
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
```


服务端：

1.建立服务端的socket服务，ServSocket（）并监听一个端口。

2.获取连接过来的客户端对象

3.客户端发来数据，服务端用对应的客户端对象，并获取到该客户端对象的读取流来读取发过来的数据

4.关闭服务端(可以关也可以不关)

​		

```java
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
```
