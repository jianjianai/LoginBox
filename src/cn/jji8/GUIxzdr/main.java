package cn.jji8.GUIxzdr;

import cn.jji8.GUIxzdr.chaoshiticu.chaoshiticu;
import cn.jji8.GUIxzdr.ip.ipxianzi;
import cn.jji8.GUIxzdr.ml.czpz;
import cn.jji8.GUIxzdr.ml.qxcxzc;
import cn.jji8.GUIxzdr.ml.xgmm;
import cn.jji8.GUIxzdr.shiquwupinhoukehuduanbuxianshixiufu.xiufu;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


import java.io.File;

public class main extends JavaPlugin{
    public static main i;
    public static peizi peizi;
    public static dengrukongzhiqi dengrukongzhiqi;
    public void onEnable(){
        i=this;
        System.out.println("[箱子登入]:作者:简简爱");
        System.out.println("[箱子登入]:开始初始化");

        this.saveResource("peizi.yml",false);
        peizi = new peizi();

        dengrukongzhiqi = new dengrukongzhiqi();
        Bukkit.getPluginManager().registerEvents(dengrukongzhiqi,this);

        this.saveResource("ipguanli.yml",false);
        ipxianzi ipxianzi = new ipxianzi(new File(this.getDataFolder(), "ipguanli.yml"),new File(this.getDataFolder(), "玩家ip.yml"));
        Bukkit.getPluginManager().registerEvents(ipxianzi,this);

        if(peizi.登入超时踢出玩家){
            System.out.println("[箱子登入]:登入超时踢出玩家：开启");
            chaoshiticu chaoshiticu = new chaoshiticu();
            Bukkit.getPluginManager().registerEvents(chaoshiticu,this);
        }

        xgmm xgmm =new xgmm();
        Bukkit.getPluginCommand("修改密码").setExecutor(xgmm);
        Bukkit.getPluginManager().registerEvents(xgmm,this);
        Bukkit.getPluginCommand("箱子登入重载配置").setExecutor(new czpz());
        Bukkit.getPluginCommand("强制玩家重新注册").setExecutor(new qxcxzc());

        if(peizi.拾取物品GUG后客户端不显示修复){
            System.out.println("[箱子登入]:拾取物品GUG后客户端不显示修复：开启");
            xiufu xiufu = new xiufu();
            Bukkit.getPluginManager().registerEvents(xiufu,this);
        }
        System.out.println("[箱子登入]:初始化完成");
    }
}
