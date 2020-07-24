package cn.jji8.GUIxzdr.chaoshiticu;

import cn.jji8.GUIxzdr.main;
import cn.jji8.GUIxzdr.peizi;
import cn.jji8.GUIxzdr.shijian.drcg;
import cn.jji8.GUIxzdr.shijian.zccg;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class chaoshiticu implements Listener {
    ArrayList biao =new ArrayList();
    peizi peizi;
    public chaoshiticu(){
        peizi = main.peizi;
    }
    @EventHandler
    public void wanjiajingrufuwuqi(PlayerJoinEvent dj){//玩家进入服务器时
        biao.add(dj.getPlayer());
        BukkitRunnable BukkitRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                if(biao.remove(dj.getPlayer())){
                    dj.getPlayer().kickPlayer(peizi.登入超时踢出玩家提示消息);
                }
            }
        };
        BukkitRunnable.runTaskLater(main.i,peizi.登入超时时间*20);
    }
    @EventHandler
    public void wanjiazccg(zccg a){//玩家注册成功时
        biao.remove(a.getPlayer());
    }
    @EventHandler
    public void wanjiadengruchenggong(drcg a){//玩家登入成功时
        biao.remove(a.getPlayer());
    }
}
