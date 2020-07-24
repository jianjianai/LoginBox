package cn.jji8.GUIxzdr.shijian;

import cn.jji8.GUIxzdr.main;
import cn.jji8.GUIxzdr.peizi;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class bc extends Event implements Cancellable {//保存配置
    private static final HandlerList handlers = new HandlerList();
    boolean isCancelled = false;
    public peizi getpeizi(){//获取即将保存的配置
        return main.peizi;
    }
    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        isCancelled = b;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList(){
        return handlers;
    }
}

