package cn.jji8.GUIxzdr;

import cn.jji8.GUIxzdr.shijian.cz;
import cn.jji8.GUIxzdr.shijian.drcg;
import cn.jji8.GUIxzdr.shijian.wjjz;
import cn.jji8.GUIxzdr.shijian.zccg;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class wanjia {

    Player wanjia;
    public xiangzi xiangzi;
    peizi peizi;
    int wuping[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int shuliang[] = {1,1,1,1,1,1,1,1,1};
    int zhizheng=0;

    /*
     * 1.登入
     * 2.注册
     * 3.重复密码
     * 4.密码错误
     * 5.两次密码不一致
     */
    public int zhuangtai=0;

    String mima;


    wanjia(Player wanjia1,peizi peizi1){
        peizi = peizi1;
        wanjia = wanjia1;
        wjjz wjjz = new wjjz(wanjia,this);//处理事件
        Bukkit.getServer().getPluginManager().callEvent(wjjz);
        if(wjjz.isCancelled()) {
            dakaixiangzi();
            return; //事件被取消, 终止事件的处理
        }
        if(peizi.wanjiamima.contains(wanjia.getName())){
            zhuangtai=1;
            mima = peizi.wanjiamima.getString(wanjia.getName());
        }else{
            zhuangtai=2;
        }
        xiangzi = new xiangzi(peizi,this);
        xiangzi.chuangjianxiangzi();
        dakaixiangzi();
    }
    public void quanding(){
        if(zhuangtai==1|zhuangtai==4){
            if(mima.equals(toString())){

                drcg drcg = new drcg(wanjia,this);//处理事件
                Bukkit.getServer().getPluginManager().callEvent(drcg);
                if(drcg.isCancelled()) {
                    return; //事件被取消, 终止事件的处理
                }

            }else {
                zhuangtai = 4;
                xiangzi.chuangjianxiangzi();
                dakaixiangzi();
                shuanxingmima();
            }
        }else if(zhuangtai==2){
            mima=toString();
            wuping = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
            shuliang = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1};
            zhizheng=0;
            zhuangtai=3;
            chongxingjiazaixiangzi();
            dakaixiangzi();
            shuanxingmima();
        }else if(zhuangtai==3){
            if(mima.equals(toString())){

                zccg zccg = new zccg(wanjia,this);//处理事件
                Bukkit.getServer().getPluginManager().callEvent(zccg);
                if(zccg.isCancelled()) {
                    return; //事件被取消, 终止事件的处理
                }

                peizi.wanjiamima.set(wanjia.getName(),mima);
                peizi.wanjiamimabaoc();
            }else {
                zhuangtai=5;
                xiangzi.chuangjianxiangzi();
                dakaixiangzi();
                shuanxingmima();
            }
        }
        if(peizi.声音){
            wanjia.playSound(wanjia.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,3);
        }
    }
    public void chongzixiangzi(){//重置箱子
        xiangzi.chuangjianxiangzi();
    }
    public void chongzizhuantai(){//重置状态
        if(zhuangtai==4){
            zhuangtai=1;
        }else if(zhuangtai==5|zhuangtai==3){
            zhuangtai=2;
        }
    }
    public void chongzimima(){//重置密码
        wuping = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
        shuliang = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1};
        zhizheng=0;
    }
    public void congzhi(){//全部重置
        cz cz = new cz(wanjia,this);//处理事件
        Bukkit.getServer().getPluginManager().callEvent(cz);
        if(cz.isCancelled()) {
            return; //事件被取消, 终止事件的处理
        }
        chongzimima();
        chongzizhuantai();
        chongzixiangzi();
        dakaixiangzi();
        shuanxingmima();
        if(peizi.声音){
            wanjia.playSound(wanjia.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,3);
        }
    }

    public void dianjiwup(int i){//点击时调用
        boolean sss = true;
        if(zhizheng-1>=0){
            if(wuping[zhizheng-1]==i){
                if(shuliang[zhizheng-1]<64){
                    sss = false;
                    shuliang[zhizheng-1] = shuliang[zhizheng-1]+1;
                    if(peizi.声音){
                        wanjia.playSound(wanjia.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,0);
                    }
                }
            }
        }
        if(sss){
            if(zhizheng<=8){
                wuping[zhizheng]=i;
                zhizheng = zhizheng+1;
                if(peizi.声音){
                    wanjia.playSound(wanjia.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,30,1);
                }
            }
        }
        shuanxingmima();
    }

    public void shuanxingmima(){//用于刷新玩家看到的密码
        xiangzi.xianshimima(wuping,shuliang);
    }

    public void chongxingjiazaixiangzi(){
        xiangzi.chuangjianxiangzi();
    }

    public void dakaixiangzi(){
        wanjia.openInventory(xiangzi.getXiagnzi());
    }
    @Override
    public String toString() {
        String to = "";
        for(int i =0;i<=8;i++){
            to = to+shuliang[i];
        }
        for(int i =0;i<=8;i++){
            to = to+wuping[i];
        }
        return to;
    }
    public void setwanjiamima(String mima1){//设置玩家密码，用来判断玩家输入的密码是否正确
        mima = mima1;
    }
    public String getMima(){//获取玩家密码
        return mima;
    }
}
