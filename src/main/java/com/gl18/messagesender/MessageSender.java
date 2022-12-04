package com.gl18.messagesender;

import com.gl18.Gl18;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerEvent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

import static com.gl18.Gl18.server;
import static com.gl18.Gl18.socket;
import static org.bukkit.Bukkit.getServer;

public class MessageSender {

    //public static boolean isConnected = false;

    public static void send(String datastr){
        /*
        InetAddress address = null; // 1.定义服务器的地址、端口号、数据 
        try {
            //address = QQMessageThread.address;

            //int port = QQMessageThread.port;//定义端口类型


            byte[] data = datastr.getBytes();//将接收到的数据变成字节数组
            DatagramPacket packet = new DatagramPacket(data, data.length, QQMessageThread.address, QQMessageThread.port);//2.创建数据报，包含发送的数据信息
            DatagramSocket socket = new DatagramSocket(); // 3.创建DatagramSocket对象
            socket.send(packet);// 4.向服务器端发送数据报
            socket.close();//4.关闭资源


        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }*/
        if (Gl18.isConnected) {
            try {

                DataOutputStream out = new DataOutputStream(socket
                        .getOutputStream());// 向客户端发送信息的DataOutputStream
                //Scanner scanner = new Scanner(System.in);//从键盘接受数据
                    //String send = scanner.nextLine();//nextLine方式接受字符串
                //System.out.println("服务器：" + datastr);//输出提示信息

                out.writeUTF("服务器：" + datastr);//把服务器端的输入发给客户端
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
