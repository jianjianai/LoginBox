package cn.jji8.GUIxzdr;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class xiangzi implements Listener {

    Inventory xiagnzi;
    peizi peizi;
    wanjia wanjia;

    xiangzi(peizi b,wanjia x){
        peizi = b;
        wanjia = x;
    }
    public void xianshimima(int[] wupin, int[] shulian){//用于显示玩家的密码
        for(int i=0;i<=8;i++){
            if(wupin[i]!=-1){
                ItemStack a = (ItemStack) peizi.物品列表.get(wupin[i]);
                ItemStack b = new ItemStack(a);
                b.setAmount(shulian[i]);
                xiagnzi.setItem(i+45,b);
            }
        }
    }

    public void chuangjianxiangzi(String a){
        Inventory xz1;
        xz1 = Bukkit.createInventory(null,6*9,a);
        chuangjianxiangzi(xz1);
    }

    public void chuangjianxiangzi(){//创建一个箱子的方法
        Inventory xz1;
        try {
            if(wanjia.zhuangtai==1){
                xz1 = Bukkit.createInventory(null,6*9,peizi.登入.replaceAll("%玩家%",wanjia.wanjia.getName()));
            }else if(wanjia.zhuangtai==2){
                xz1 = Bukkit.createInventory(null,6*9,peizi.注册.replaceAll("%玩家%",wanjia.wanjia.getName()));
            }else if(wanjia.zhuangtai==3){
                xz1 = Bukkit.createInventory(null,6*9,peizi.重复.replaceAll("%玩家%",wanjia.wanjia.getName()));
            }else if(wanjia.zhuangtai==4){
                xz1 = Bukkit.createInventory(null,6*9,peizi.密码错误.replaceAll("%玩家%",wanjia.wanjia.getName()));
            }else if(wanjia.zhuangtai==5){
                xz1 = Bukkit.createInventory(null,6*9,peizi.两次密码不一致.replaceAll("%玩家%",wanjia.wanjia.getName()));
            }else {
                xz1 = Bukkit.createInventory(null,6*9,"错误，请联系管理员");
            }
        }catch (Throwable sss){
            xz1 = Bukkit.createInventory(null,6*9,"配置文件错误，请联系管理员");
        }
        chuangjianxiangzi(xz1);
    }

    public void chuangjianxiangzi(Inventory xz1){
        ItemStack WPD;
        WPD = new ItemStack(peizi.分割线物品);
        ItemMeta wp = WPD.getItemMeta();
        try {
            wp.setDisplayName(peizi.分割线.replaceAll("%玩家%",wanjia.wanjia.getName()));
        }catch (Throwable sss){
            wp.setDisplayName("错误，请联系管理员");
        }
        WPD.setItemMeta(wp);
        for(int i=36;i<=44;i++){
            xz1.setItem(i, WPD);
        }
        WPD = new ItemStack(peizi.重新输入按钮物品);
        wp = WPD.getItemMeta();
        try {
            wp.setDisplayName(peizi.取消.replaceAll("%玩家%",wanjia.wanjia.getName()));
        }catch (Throwable sss){
            wp.setDisplayName("错误，请联系管理员");
        }
        WPD.setItemMeta(wp);
        xz1.setItem(36, WPD);
        WPD = new ItemStack(peizi.确定按钮物品);
        wp = WPD.getItemMeta();
        try {
            wp.setDisplayName(peizi.确定.replaceAll("%玩家%",wanjia.wanjia.getName()));
        }catch (Throwable sss){
            wp.setDisplayName("错误，请联系管理员");
        }
        WPD.setItemMeta(wp);
        xz1.setItem(44, WPD);
        xiagnzi = xz1;

        for(int i=0;i<=35;i++){
            xz1.setItem(i, (ItemStack) peizi.物品列表.get(i));
        }
    }

    public Inventory getXiagnzi(){//获取箱子
        return xiagnzi;
    }

}
