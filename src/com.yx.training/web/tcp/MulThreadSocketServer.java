package com.yx.training.web.tcp;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yangxin on 2015/11/4 0004.
 */
public class MulThreadSocketServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        //监听端口号
        int port = 10000;
        try {
            //建立连接
            serverSocket = new ServerSocket(port);
            System.out.println("服务器已启动：");
            while (true) {
                //获得连接
                socket = serverSocket.accept();
                //启动线程
                new MulThreadSocketServerThread(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭连接
                serverSocket.close();
            } catch (Exception e) {
            }
        }
    }
}
