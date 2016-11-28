package com.yf.ihook.utils;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.List;
/**
 * Created by Administrator on 2016/11/25.
 */
public class WeChatUtils {

    private  static WeChatUtils mWeChatUtils;

    private  WeChatUtils(){

    }

    // synchronized  防止多线程调用
    public  synchronized static  WeChatUtils getInstance(){
        if(mWeChatUtils==null){
            mWeChatUtils=new WeChatUtils();
        }
        return  mWeChatUtils;
    }

    /**
     * @param context
     *@param packageName  应用程序包名
     *@param mainClassName  应用程序主activity
     *  打开应用程序
     */
    public  void  openWeChat(Context context,String packageName,String mainClassName){
        Intent intent=new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setComponent(new ComponentName(packageName,mainClassName));
        context.startActivity(intent);
    }


    /**
     * @param context
     * @param tagName  目标程序包名
     * @return   判断应用程序是否安装
     */
    public boolean isInstall(Context context,String tagName){
        PackageManager pm=context.getPackageManager();
        List<PackageInfo> packageInfos = pm.getInstalledPackages(0);
        for(PackageInfo info : packageInfos){
            String packageName = info.packageName;
            ApplicationInfo application = info.applicationInfo;
            String name = application.name;
            int icon = application.icon;
            if(packageName.equals(tagName)){
                return true;
            }
        }
        return  false;
    }

    /**
     * @param context
     * @return 分享到微信好友
     */
    public  void shareToWeChatFriends(Context context){

    }

    /**
     * @param context
     * @return 分享到微信朋友圈
     */
    public void shareToWeChat(Context context){

    }

    /**
     * @param context
     * @retuen 收藏到微信
     */
    public void collectToWeChat(Context context){

    }

    /**
     * @param nickName
     * @param context
     * @return 和微信好友交流
     */
    public void talkToFriends(String nickName,Context context){

    }





}
