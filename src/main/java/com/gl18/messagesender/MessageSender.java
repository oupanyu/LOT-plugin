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
        InetAddress address = null; // 1.����������ĵ�ַ���˿ںš����� 
        try {
            //address = QQMessageThread.address;

            //int port = QQMessageThread.port;//����˿�����


            byte[] data = datastr.getBytes();//�����յ������ݱ���ֽ�����
            DatagramPacket packet = new DatagramPacket(data, data.length, QQMessageThread.address, QQMessageThread.port);//2.�������ݱ����������͵�������Ϣ
            DatagramSocket socket = new DatagramSocket(); // 3.����DatagramSocket����
            socket.send(packet);// 4.��������˷������ݱ�
            socket.close();//4.�ر���Դ


        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }*/
        if (Gl18.isConnected) {
            try {

                DataOutputStream out = new DataOutputStream(socket
                        .getOutputStream());// ��ͻ��˷�����Ϣ��DataOutputStream
                //Scanner scanner = new Scanner(System.in);//�Ӽ��̽�������
                    //String send = scanner.nextLine();//nextLine��ʽ�����ַ���
                //System.out.println("��������" + datastr);//�����ʾ��Ϣ

                //out.writeUTF("��������" + datastr);//�ѷ������˵����뷢���ͻ���
                out.writeUTF(datastr);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
