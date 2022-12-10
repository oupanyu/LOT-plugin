package com.gl18.listener;

import com.gl18.Gl18;
import com.gl18.messagesender.MessageSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        if (Gl18.isConnected){
            MessageSender.send(String.format("%s进入了服务器.",event.getPlayer().getName()));
            //Bukkit.broadcastMessage("Welcome " + event.getPlayer().getName() + "!");
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        if (Gl18.isConnected) {
            MessageSender.send(String.format("%s离开了服务器.", event.getPlayer().getName()));
            //Bukkit.broadcastMessage("Welcome " + event.getPlayer().getName() + "!");
        }
    }

    @EventHandler
    public void PlayerChatEvent(PlayerChatEvent event){
        MessageSender.send(event.getPlayer().getName() + ":" + event.getMessage());
    }
}
