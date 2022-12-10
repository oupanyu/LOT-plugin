package com.gl18;

import com.gl18.listener.PlayerListener;
import com.gl18.messagesender.QQMessageThread;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.bukkit.Bukkit.getServer;

public final class Gl18 extends JavaPlugin {

    public Thread thread;

    public static ServerSocket server;

    public static Socket socket;
    public static Boolean isConnected = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
        //System.setProperty("file.encoding","UTF-8");
        try {
            server = new ServerSocket(25570);//创建  ServerSocket class
            thread = new Thread(new ConnectionListener());
            thread.start();
            //socket = server.accept();// 等待客户连接
        } catch (IOException e) {
            e.printStackTrace();
        }

        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        //QQMessageThread.socket.close();
        try {
            server.close();
            socket.close();
        } catch (IOException | NullPointerException ignored) {

        }
        thread.stop();

    }
}
class ConnectionListener extends Thread{
    @Override
    public void run(){
        try {
            getServer().getLogger().info("Waiting for connection...");
            Gl18.socket = Gl18.server.accept();
            System.out.println("Connected!");
            Gl18.isConnected = true;
            new Thread(new QQMessageThread()).start();
            this.stop();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
