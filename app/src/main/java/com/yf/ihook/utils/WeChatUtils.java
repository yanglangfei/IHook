package com.yf.ihook.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2016/11/25.
 */

public class WeChatUtils {

    private  static WeChatUtils mWeChatUtils=new WeChatUtils();

    public  static  WeChatUtils getInstance(){
        if(mWeChatUtils==null){
            mWeChatUtils=new WeChatUtils();
        }
        return  mWeChatUtils;
    }

    /**
     * @param context
     *
     *  打开微信
     */
    public  void  openWeChat(Context context){
        Intent intent=new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setComponent(new ComponentName(Constance.WECHAT_PACKAGENAME,Constance.WECHAT_MAINCLASS_NAME));
        context.startActivity(intent);
    }


}
