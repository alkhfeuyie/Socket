package com.net.wy1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
	public static void main(String[] args) {
		try {
			InetAddress inet = InetAddress.getByName("localhost");
			System.out.println(inet);
			System.out.println(inet.getHostName());
			System.out.println(inet.getHostAddress());
			InetAddress inet1 = InetAddress.getLocalHost();
			System.out.println(inet1);
		} catch (UnknownHostException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
