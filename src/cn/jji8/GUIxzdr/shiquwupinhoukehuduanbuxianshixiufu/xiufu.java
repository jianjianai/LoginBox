package cn.jji8.GUIxzdr.shiquwupinhoukehuduanbuxianshixiufu;

import cn.jji8.GUIxzdr.main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;


public class xiufu implements Listener {
    ArrayList biao = new ArrayList();
    @EventHandler
    public void WanJiaShiQuWuPing(PlayerMoveEvent dj){//拾取物品
        if(biao.contains(dj.getPlayer())){
            return;
        }
        Thread Thread = new Thread() {
            @Override
            public void run() {
                biao.add(dj.getPlayer());
                try {
                    sleep(main.peizi.拾取物品GUG背包刷新速度);
                } catch (InterruptedException e) {
                }
                dj.getPlayer().updateInventory();
                biao.remove(dj.getPlayer());
            }
        };
        Thread.start();
    }
}

