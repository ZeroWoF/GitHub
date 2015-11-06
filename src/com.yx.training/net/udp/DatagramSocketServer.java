package com.yx.training.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by yangxin on 2015/11/5 0005.
 * UDP连接  服务端简单实现（接收客户端数据，发送数据到客户端）
 */
public class DatagramSocketServer {
    public static void main(String[] args) {

        DatagramSocket ds = null; //连接对象
        DatagramPacket sendDp; //发送数据包对象
        DatagramPacket receiveDp; //接收数据包对象
        final int PORT = 10000; //端口

        try {
            //建立连接，监听端口
            ds = new DatagramSocket(PORT);
            System.out.println("服务器端已启动：");

            //初始化接收数据
            byte[] b = new byte[1024];
            receiveDp = new DatagramPacket(b, b.length);

            //接收
            ds.receive(receiveDp);

            //读取反馈内容，并输出
            InetAddress clientIP = receiveDp.getAddress();

            int clientPort = receiveDp.getPort();
            byte[] data = receiveDp.getData();
            int len = receiveDp.getLength();

            System.out.println("客户端IP：" + clientIP.getHostAddress());
            System.out.println("客户端端口：" + clientPort);
            System.out.println("客户端发送内容：" + new String(data, 0, len));

            //发送反馈
            String response = "OK";
            byte[] bData = response.getBytes();
            sendDp = new DatagramPacket(bData, bData.length, clientIP, clientPort);

            //发送
            ds.send(sendDp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭连接
                ds.close();
            } catch (Exception e) {
            }
        }
    }
}