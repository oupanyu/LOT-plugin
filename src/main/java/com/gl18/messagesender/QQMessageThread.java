package com.gl18.messagesender;

import com.gl18.Gl18;
import com.google.gson.Gson;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import static com.gl18.Gl18.socket;
import static org.bukkit.Bukkit.getServer;
import static org.bukkit.Bukkit.unloadWorld;

public class QQMessageThread extends Thread{

    //public boolean isConnected = false;

    //public static DatagramSocket socket;

    //public static Socket client;
   // public static InetAddress address;
    //public static Integer port;

    @Override
    public void run() {


        /*
        try {
            socket = new ServerSocket(25566);
        } catch (IOException e) {
            getServer().getLogger().warning("端口打开失败！请查看25566端口是否被占用");
            e.printStackTrace();
        }

        while (!isConnected){

            try {
                client = socket.accept();
                //获取Socket的输出流，用来向客户端发送数据
                PrintStream out = new PrintStream(client.getOutputStream());
                //获取Socket的输入流，用来接收从客户端发送过来的数据
                BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String StringFromClient = buf.readLine();
                if (StringFromClient.equals("/*-+bye")){
                    getServer().getLogger().warning("Socket closed. Use /reload to open socket.");
                    socket.close();
                    break;
                }else {
                    getServer().broadcastMessage("§c" + StringFromClient);
                    //System.out.println(StringFromClient);
                }

                }catch (IOException e){
                     e.printStackTrace();
                }

        }
         */
        /*
        try {
            socket = new DatagramSocket(25565);  // 1.创建服务器端DatagramSocket，指定端口
            // 2.创建数据报，用于接收客户端发送的数据
            byte[] data = new byte[1024];//创建字节数组，指定接收的数据包的大小
            DatagramPacket packet = new DatagramPacket(data, data.length);

            // 3.接收客户端发送的数据
            //System.out.println("****服务器端已经启动，等待客户端发送数据");//输出提示信息
            while(true) {//通过循环不停的向客户端发送数据和接收数据
                socket.receive(packet);// 此方法在接收到数据报之前会一直阻塞
                // 4.读取数据
                String info = new String(data, 0, packet.getLength());//创建字符串对象
                //System.out.println("我是服务器，客户端说：" + info);//输出提示信息

                if (info.equals("&hpkt")){
                    address = packet.getAddress();//获取发送端的地址
                    port = packet.getPort();//获取 发送端进程所绑定的端口
                    MessageSender.isConnected = true;
                    continue;
                }
                //address = packet.getAddress();//获取发送端的地址
                //port = packet.getPort();//获取 发送端进程所绑定的端口
                MessageSender.isConnected = true;
                getServer().broadcastMessage(info);

                 //向客户端响应数据

                // 1.定义客户端的地址、端口号、数据

                //byte[] data2 = send.getBytes();//将接收到的数据转换为字节数组
                //DatagramPacket packet2 = new DatagramPacket(data2, data2.length,address,port);// 2.创建数据报，包含响应的数据信息
                //socket.send(packet2); // 3.响应客户端
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */

            DataInputStream in = null;// 读取客户端传过来信息的DataInputStream
            try {
                in = new DataInputStream(socket
                        .getInputStream());
             } catch (IOException e) {
            throw new RuntimeException(e);
            }
            while (true) {
                if (Gl18.isConnected) {
                    String accpet = null;// 读取来自客户端的信息
                    try {
                        accpet = in.readUTF();
                        getServer().broadcastMessage(accpet);
                        //System.out.println(accpet);//输出来自客户端的信息
                    } catch (IOException e) {
                        //e.printStackTrace();
                        try {
                            socket.close();
                            break;
                            //throw new RuntimeException(e);
                        }catch (IOException ioException){
                            throw new RuntimeException(ioException);
                        }


                    }

            }
        }
    }
}
