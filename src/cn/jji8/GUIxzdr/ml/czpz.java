package cn.jji8.GUIxzdr.ml;

import cn.jji8.GUIxzdr.main;
import cn.jji8.GUIxzdr.peizi;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class czpz implements CommandExecutor {//重载配置
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage("[箱子登入：命令]正在重载插件配置！");
        main.peizi = new peizi();
        commandSender.sendMessage("[箱子登入：命令]配置重载完成！");
        return true;
    }
}
