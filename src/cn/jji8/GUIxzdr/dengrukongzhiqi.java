package cn.jji8.GUIxzdr;

import cn.jji8.GUIxzdr.shijian.drcg;
import cn.jji8.GUIxzdr.shijian.zccg;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;

import java.util.HashMap;

public class dengrukongzhiqi implements Listener {//我是一个监听器,用来监听事件啦啦啦啦

    peizi peizi = main.peizi;;
    HashMap biao = new HashMap();

    public void sanchuwanjia(String wanjianame){//删除一个未登入的玩家
        biao.remove(wanjianame);
    }
    public void tianjiawanjia(Player a){
        if(peizi.登入时旁观者模式){
            a.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
        wanjia wanjia = new wanjia(a.getPlayer(),peizi);
        biao.put(a.getPlayer().getName(),wanjia);
    }
    public wanjia getwanjia(Player a){//有这个玩家就返回玩家，没有返回null
        if(biao.containsKey(a.getName())){
            return (wanjia) biao.get(a.getName());
        }
        return null;
    }

    @EventHandler
    public void wanjiadianji(InventoryClickEvent a){//玩家点击时触发
        if(biao.containsKey(a.getWhoClicked().getName())){
            a.setCancelled(true);
            wanjia wanjia = (wanjia) biao.get(a.getWhoClicked().getName());
            if(a.getRawSlot()>=0&a.getRawSlot()<=35){
                wanjia.dianjiwup(a.getRawSlot());
            }else if(a.getRawSlot()==36){
                wanjia.congzhi();
            }else if(a.getRawSlot()==44){
                wanjia.quanding();
            }
        }
    }
    @EventHandler(priority= EventPriority.MONITOR)
    public void wanjianjingru(drcg a){
        if(a.isCancelled()){
            a.getPlayer().closeInventory();
            return;
        }
        a.getPlayer().closeInventory();
        biao.remove(a.getPlayer().getName());
        a.getPlayer().sendTitle(peizi.登入成功1.replaceAll("%玩家%",a.getPlayer().getName()),peizi.登入成功2.replaceAll("%玩家%",a.getPlayer().getName()),10,40,10);
        a.getPlayer().setGameMode(peizi.服务器游戏模式);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),peizi.登入成功后台执行命令.replaceAll("%玩家%",a.getPlayer().getName()));
    }
    @EventHandler(priority= EventPriority.MONITOR)
    public void wanjianjingru(zccg a){
        if(a.isCancelled()){
            a.getPlayer().closeInventory();
            return;
        }
        a.getPlayer().closeInventory();
        biao.remove(a.getPlayer().getName());
        a.getPlayer().sendTitle(peizi.注册成功1.replaceAll("%玩家%",a.getPlayer().getName()),peizi.注册成功2.replaceAll("%玩家%",a.getPlayer().getName()),10,40,10);
        a.getPlayer().setGameMode(peizi.服务器游戏模式);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),peizi.注册成功后台执行命令.replaceAll("%玩家%",a.getPlayer().getName()));
    }
    @EventHandler
    public void wanjianjingru(PlayerJoinEvent a){//玩家进入时创建一个wanjia对象
        if(peizi.登入时旁观者模式){
            a.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
        wanjia wanjia = new wanjia(a.getPlayer(),peizi);
        biao.put(a.getPlayer().getName(),wanjia);
    }
    @EventHandler
    public void wanjialikai(PlayerQuitEvent a){//玩家离开时删掉，节约内存
        if(peizi.登入时旁观者模式){
            a.getPlayer().setGameMode(peizi.服务器游戏模式);
        }
        biao.remove(a.getPlayer().getName());
    }
    @EventHandler
    public void WanJiaYiDong(PlayerMoveEvent dj){//玩家移动时
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
            wanjia wanjia = (wanjia) biao.get(dj.getPlayer().getName());
            wanjia.dakaixiangzi();
        }
    }




    @EventHandler
    public void WanJiaPoHuaiFangKuai(BlockBreakEvent dj){//玩家破坏方块
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJiaFangZhiFangKuai(BlockPlaceEvent dj){//玩家放置方块
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }

  //下方是没用的，限制没登入玩家的
    @EventHandler
    public void WanJianLiaoTian(AsyncPlayerChatEvent dj){//玩家聊天
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJiaMlingLi(PlayerCommandPreprocessEvent dj){//玩家命令
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJiaDiuWuPing(PlayerDropItemEvent dj){//玩家丢物品
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJiaBeiDiYuMengChuanSong(PlayerPortalEvent dj){//玩家被地狱们传送
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJiaChuanSong(PlayerTeleportEvent dj){//玩家传送
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJIaQieHuanFuSou(PlayerSwapHandItemsEvent dj){//玩家切换副手
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void  WanJiaJiaoHu(PlayerInteractEvent dj){//玩家与空气方块交互时
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }
    @EventHandler
    public void WanJIaDianJiShiTi(PlayerInteractEntityEvent dj){//玩家点击实体时
        if(biao.containsKey(dj.getPlayer().getName())){
            dj.setCancelled(true);
        }
    }
}
