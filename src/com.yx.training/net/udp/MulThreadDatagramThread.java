package com.yx.training.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
/**
 * Created by yangxin on 2015/11/5 0005.
 */
public class MulThreadDatagramThread extends Thread {

    private DatagramSocket server;

    private DatagramPacket receipt;

    public MulThreadDatagramThread(DatagramSocket server, DatagramPacket receipt){
        System.out.println("服务端启动线程处理请求...");
        this.server = server;
        this.receipt = receipt;
        start();
    }
    @Override
    public void run() {
        // 打印接收数据
        System.out.println("服务端接收数据：" + new String(receipt.getData()));
        DatagramPacket sendData = new DatagramPacket(new byte[1024], 1024, receipt.getAddress(), receipt.getPort());
        sendData.setData("OK".getBytes());
        try {
            server.send(sendData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
