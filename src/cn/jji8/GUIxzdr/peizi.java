package cn.jji8.GUIxzdr;

import cn.jji8.GUIxzdr.shijian.bc;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class peizi {

    public int 登入超时时间,拾取物品GUG背包刷新速度;

    public String 登入;
    public String 登入超时踢出玩家提示消息;
    public String 注册;
    public String 重复;
    public String 密码错误;
    public String 两次密码不一致;
    public String 取消 ;
    public String 登入成功1,登入成功2,登入成功后台执行命令,注册成功1,注册成功2,注册成功后台执行命令,修改密码箱子标题;

    public String 分割线;
    public String 确定,取消修改密码1,取消修改密码2,输入你想修改的密码;


    public List 物品列表;

    public boolean 登入时旁观者模式;
    public boolean 声音;
    public boolean 登入超时踢出玩家,拾取物品GUG后客户端不显示修复;

    public GameMode 服务器游戏模式;

    public YamlConfiguration wanjiamima;


    public File wanjiamimapeizi;

    public ItemStack 分割线物品,确定按钮物品,重新输入按钮物品;

    public peizi(){
        YamlConfiguration a = YamlConfiguration.loadConfiguration(new File(main.i.getDataFolder(),"peizi.yml"));
        wanjiamima = YamlConfiguration.loadConfiguration(wanjiamimapeizi = new File(main.i.getDataFolder(),"玩家密码.yml"));
        System.out.println("[箱子登入]：§a开始加载配置");
        //string
        if(a.contains("输入你想修改的密码")){ 输入你想修改的密码 = a.getString("输入你想修改的密码");}else{System.out.println("[箱子登入]：§c输入你想修改的密码置文件错误，请检查配置文件");}
        if(a.contains("取消修改密码1")){取消修改密码1 = a.getString("取消修改密码1");}else{System.out.println("[箱子登入]：§c取消修改密码1置文件错误，请检查配置文件");}
        if(a.contains("取消修改密码2")){取消修改密码2 = a.getString("取消修改密码2");}else{System.out.println("[箱子登入]：§c取消修改密码2配置文件错误，请检查配置文件");}
        if(a.contains("修改密码箱子标题")){修改密码箱子标题 = a.getString("修改密码箱子标题");}else{System.out.println("[箱子登入]：§c修改密码箱子标题配置文件错误，请检查配置文件");}
        if(a.contains("密码错误")){ 密码错误 = a.getString("密码错误");}else{System.out.println("[箱子登入]：§c密码错误配置文件错误，请检查配置文件");}
        if(a.contains("两次密码不一致")){两次密码不一致 = a.getString("两次密码不一致");}else{System.out.println("[箱子登入]：§c两次密码不一致配置文件错误，请检查配置文件");}
        if(a.contains("注册")){ 注册 = a.getString("注册");}else{ System.out.println("[箱子登入]：§c注册配置文件错误，请检查配置文件"); }
        if(a.contains("分割线")){ 分割线 = a.getString("分割线");}else{System.out.println("[箱子登入]：§c分割线配置文件错误，请检查配置文件"); }
        if(a.contains("登入")){ 登入 = a.getString("登入");}else{System.out.println("[箱子登入]：§c登入配置文件错误，请检查配置文件");}
        if(a.contains("确定")){ 确定 = a.getString("确定");}else{ System.out.println("[箱子登入]：§c确定配置文件错误，请检查配置文件");}
        if(a.contains("重复")){ 重复 = a.getString("重复");}else{System.out.println("[箱子登入]：§c重复配置文件错误，请检查配置文件");}
        if(a.contains("取消")){取消 = a.getString("取消");}else{ System.out.println("[箱子登入]：§c取消配置文件错误，请检查配置文件"); }
        if(a.contains("登入成功1")){  登入成功1 = a.getString("登入成功1");}else{ System.out.println("[箱子登入]：§c登入成功1配置文件错误，请检查配置文件"); }
        if(a.contains("登入成功2")){  登入成功2 = a.getString("登入成功2");}else{ System.out.println("[箱子登入]：§c登入成功2配置文件错误，请检查配置文件"); }
        if(a.contains("登入成功后台执行命令")){  登入成功后台执行命令 = a.getString("登入成功后台执行命令");}else{System.out.println("[箱子登入]：§c登入成功后台执行命令配置文件错误，请检查配置文件"); }
        if(a.contains("注册成功1")){ 注册成功1 = a.getString("注册成功1");}else{System.out.println("[箱子登入]：§c注册成功1配置文件错误，请检查配置文件");}
        if(a.contains("注册成功2")){ 注册成功2 = a.getString("注册成功2");}else{System.out.println("[箱子登入]：§c注册成功2配置文件错误，请检查配置文件");}
        if(a.contains("注册成功后台执行命令")){ 注册成功后台执行命令 = a.getString("注册成功后台执行命令");}else{System.out.println("[箱子登入]：§c注册成功后台执行命令配置文件错误，请检查配置文件"); }
        if(a.contains("登入超时踢出玩家提示消息")){ 登入超时踢出玩家提示消息 = a.getString("登入超时踢出玩家提示消息");}else{ System.out.println("[箱子登入]：§c登入超时踢出玩家提示消息配置文件错误，请检查配置文件"); }
        //list
       物品列表 = new ArrayList();
        //ItemStack
        try {  分割线物品 = new ItemStack(Material.getMaterial(a.getString("分割线物品")));}catch (Throwable ssss){ System.out.println("[箱子登入]：§c分割线物品配置文件错误，已替换为基岩，请检查配置文件");分割线物品 = new ItemStack(Material.BEDROCK);}
        try {  确定按钮物品 = new ItemStack(Material.getMaterial(a.getString("确定按钮物品")));}catch (Throwable ssss){ System.out.println("[箱子登入]：§c确定按钮物品配置文件错误，已替换为基岩，请检查配置文件"); 确定按钮物品 = new ItemStack(Material.BEDROCK);}
        try { 重新输入按钮物品 = new ItemStack(Material.getMaterial(a.getString("重新输入按钮物品")));}catch (Throwable ssss){ System.out.println("[箱子登入]：§c重新输入按钮物品配置文件错误，已替换为基岩，请检查配置文件"); 重新输入按钮物品 = new ItemStack(Material.BEDROCK);}
        //booble
        if(a.contains("拾取物品GUG后客户端不显示修复")){ 拾取物品GUG后客户端不显示修复=a.getBoolean("拾取物品GUG后客户端不显示修复");}else{System.out.println("[箱子登入]：§c拾取物品GUG后客户端不显示修复配置文件错误，请检查配置文件");}
        if(a.contains("登入时旁观者模式")){ 登入时旁观者模式=a.getBoolean("登入时旁观者模式");}else{System.out.println("[箱子登入]：§c登入时旁观者模式配置文件错误，请检查配置文件");}
        if(a.contains("登入超时踢出玩家")){  登入超时踢出玩家=a.getBoolean("登入超时踢出玩家");}else{System.out.println("[箱子登入]：§c登入超时踢出玩家配置文件错误，请检查配置文件"); }
        if(a.contains("声音")){  声音=a.getBoolean("声音");}else{System.out.println("[箱子登入]：§c声音配置文件错误，请检查配置文件"); }
        //gamemode
        try {  服务器游戏模式 = GameMode.valueOf(a.getString("服务器游戏模式"));}catch (Throwable ssss){ System.out.println("[箱子登入]：§c服务器游戏模式配置文件错误已自动设置为生存，请检查配置文件"); 服务器游戏模式 = GameMode.SURVIVAL;}
        //int
        if(a.contains("登入超时时间")){  登入超时时间 = a.getInt("登入超时时间");}else{System.out.println("[箱子登入]：§c登入超时时间配置文件错误，请检查配置文件");}
        if(a.contains("拾取物品GUG背包刷新速度")){  拾取物品GUG背包刷新速度= a.getInt("拾取物品GUG背包刷新速度");}else{System.out.println("[箱子登入]：§c拾取物品GUG背包刷新速度配置文件错误，请检查配置文件");}
        //list
        List wp = a.getStringList("选择物品");
        List mz = a.getStringList("名字");
        List lo = a.getList("lore");

        for(int i = 0;i<=35;i++){
            ItemStack WPD;
            try {
                WPD = new ItemStack(Material.getMaterial((String) wp.get(i)));
            }catch (Throwable ssss){
                WPD = new ItemStack(Material.BEDROCK);
                try {
                    System.out.println("[箱子登入]：§c第"+i+"个物品"+wp.get(i)+"错误已替换成基岩");
                }catch (Throwable sssss){
                    System.out.println("[箱子登入]：§c第"+i+"个物品NULL错误已替换成基岩");
                }
            }
            ItemMeta we = WPD.getItemMeta();
            try {
                we.setDisplayName((String) mz.get(i));
            }catch (Throwable ssss){
                System.out.println("[箱子登入]：§c第"+i+"个物品名字错误");
            }
            try {
                we.setLore((List<String>) lo.get(i));
            }catch (Throwable ssss){
                System.out.println("[箱子登入]：§c第"+i+"个物品lore错误");
            }
            WPD.setItemMeta(we);
            物品列表.add(WPD);
        }
        System.out.println("[箱子登入]：§a配置加载完成");
    }

    public void wanjiamimabaoc() {//异步保存玩家密码

        bc bc = new bc();//处理事件
        Bukkit.getServer().getPluginManager().callEvent(bc);
        if(bc.isCancelled()) {
            return; //事件被取消, 终止事件的处理
        }

        Thread T = new Thread(){
            @Override
            public void run() {
                System.out.println("[箱子登入]:异步玩家密码保存中");
                try {
                    wanjiamima.save(wanjiamimapeizi);
                }catch (IOException a){
//                    System.out.println(a);
                    Bukkit.getLogger().warning("[箱子登入]:玩家密码保存失败！请检查磁盘空间，和文件权限");
                }
                System.out.println("[箱子登入]:保存完毕！");
                super.run();
            }
        };
        T.start();
    }
}
