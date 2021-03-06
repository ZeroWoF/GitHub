package com.yx.training.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

/**
 * Created by yangxin on 2015/11/5 0005.
 * UDP连接 客户端简单实现（发送数据到服务端，接收服务端数据）
 */
public class DatagramSocketClient {
    public static void main(String[] args) {

        DatagramSocket ds = null; //连接对象
        DatagramPacket sendDp; //发送数据包对象
        DatagramPacket receiveDp; //接收数据包对象
        String serverHost = "127.0.0.1"; //服务器IP
        int serverPort = 10000; //服务器端口号

        try {
            //建立连接
            ds = new DatagramSocket();
            //初始化发送数据
            Date d = new Date(); //当前时间
            String content = d.toString(); //转换为字符串
            byte[] data = content.getBytes();

            //初始化发送包对象
            InetAddress address = InetAddress.getByName(serverHost);
            sendDp = new DatagramPacket(data, data.length, address, serverPort);

            //发送
            ds.send(sendDp);

            //初始化接收数据
            byte[] b = new byte[1024];
            receiveDp = new DatagramPacket(b, b.length);

            //接收
            ds.receive(receiveDp);

            //读取反馈内容，并输出
            byte[] response = receiveDp.getData();
            int len = receiveDp.getLength();
            String s = new String(response, 0, len);
            System.out.println("服务器端反馈为：" + s);
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