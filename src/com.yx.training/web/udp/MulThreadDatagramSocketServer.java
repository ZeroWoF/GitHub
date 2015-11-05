package com.yx.training.web.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by yangxin on 2015/11/5 0005.
 */
public class MulThreadDatagramSocketServer {
    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(10000);
            System.out.println("服务端已启动...");
            while (true){
                DatagramPacket receipt = new DatagramPacket(new byte[1024], 1024);
                server.receive(receipt);
                System.out.println("---------------------------------------------");
                System.out.println("服务端已接收消息...");
                new MulThreadDatagramThread(server, receipt);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
