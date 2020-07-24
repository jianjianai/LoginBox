package cn.jji8.GUIxzdr.ml;

import cn.jji8.GUIxzdr.main;
import cn.jji8.GUIxzdr.shijian.cz;
import cn.jji8.GUIxzdr.shijian.drcg;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getPlayer;

public class xgmm implements CommandExecutor, Listener {//修改密码

    ArrayList biao = new ArrayList();
    ArrayList biao2 = new ArrayList();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("此命令只有玩家可以使用");
            return true;
        }
        main.dengrukongzhiqi.tianjiawanjia((Player)commandSender);
        if(main.peizi.修改密码箱子标题==null){
            main.dengrukongzhiqi.getwanjia((Player)commandSender).xiangzi.chuangjianxiangzi("配置文件修改密码标题错误，请联系管理员");
        }else {
            main.dengrukongzhiqi.getwanjia((Player)commandSender).xiangzi.chuangjianxiangzi(main.peizi.修改密码箱子标题.replaceAll("%玩家%",commandSender.getName()));
        }
        main.dengrukongzhiqi.getwanjia((Player)commandSender).dakaixiangzi();
        Thread Thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("[箱子登入：命令]休眠的线程被强行唤醒了！");
                }
                biao.add(commandSender.getName());
                super.run();
            }
        };
        Thread.start();
        return true;
    }

    @EventHandler
    public void wanjiadenru(drcg a){
        if(biao.remove(a.getPlayer().getName())){
            biao2.add(a.getPlayer().getName());
            a.setCancelled(true);
            a.getWanjia().zhuangtai=2;
            a.getWanjia().chongzimima();
            a.getWanjia().xiangzi.chuangjianxiangzi(main.peizi.输入你想修改的密码.replaceAll("%玩家%",a.getPlayer().getName()));
            a.getWanjia().dakaixiangzi();
        }
    }

    @EventHandler
    public void WanJiaYiDong(cz a){//重置时
        if(biao.contains(a.getPlayer().getName())){
            a.setCancelled(true);
            a.getWanjia().chongzimima();
            a.getWanjia().xiangzi.chuangjianxiangzi(main.peizi.修改密码箱子标题.replaceAll("%玩家%",a.getPlayer().getName()));
            a.getWanjia().dakaixiangzi();
            if(main.peizi.声音){
                a.getPlayer().playSound(a.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,3);
            }
        }else if(biao2.contains(a.getPlayer().getName())){
            a.setCancelled(true);
            a.getWanjia().chongzimima();
            a.getWanjia().zhuangtai=2;
            a.getWanjia().xiangzi.chuangjianxiangzi(main.peizi.输入你想修改的密码.replaceAll("%玩家%",a.getPlayer().getName()));
            a.getWanjia().dakaixiangzi();
            if(main.peizi.声音){
                a.getPlayer().playSound(a.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,3);
            }
        }


    }
    @EventHandler
    public void WanJiaYiDong(PlayerMoveEvent a){//玩家移动时
        if(biao.remove(a.getPlayer().getName())){
            a.getPlayer().closeInventory();
            main.dengrukongzhiqi.sanchuwanjia(a.getPlayer().getName());
            a.getPlayer().setGameMode(main.peizi.服务器游戏模式);
            getPlayer(a.getPlayer().getName()).sendTitle(main.peizi.取消修改密码1.replaceAll("%玩家%",a.getPlayer().getName()),main.peizi.取消修改密码2.replaceAll("%玩家%",a.getPlayer().getName()),10,40,10);
        }
    }
}
