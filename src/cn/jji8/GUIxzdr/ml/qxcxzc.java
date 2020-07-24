package cn.jji8.GUIxzdr.ml;

import cn.jji8.GUIxzdr.main;
import cn.jji8.GUIxzdr.shijian.cz;
import cn.jji8.GUIxzdr.shijian.drcg;
import cn.jji8.GUIxzdr.wanjia;
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

public class qxcxzc implements CommandExecutor, Listener {//修改密码

    ArrayList biao = new ArrayList();
    ArrayList biao2 = new ArrayList();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        String mz;
        try {
            mz = strings[0];
        }catch (Throwable a){
            commandSender.sendMessage("请输入玩家");
            return false;
        }
        Player wj = getPlayer(mz);
        if(wj==null){
            commandSender.sendMessage("玩家名字错误");
            return false;
        }
        main.dengrukongzhiqi.tianjiawanjia(wj);
        wanjia wanjia = main.dengrukongzhiqi.getwanjia(wj);
        wanjia.zhuangtai=2;
        wanjia.chongzimima();
        wanjia.chongzixiangzi();
        wanjia.dakaixiangzi();
        return true;
    }
}
