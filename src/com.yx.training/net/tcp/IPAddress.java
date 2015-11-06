package com.yx.training.net.tcp;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by yangxin on 2015/11/4 0004.
 */
public class IPAddress {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getLocalHost();
            System.out.println(inet3);

            String host = inet3.getHostName();
            System.out.println("域名：" + host);

            String ip = inet3.getHostAddress();
            System.out.println("IP：" + ip);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
